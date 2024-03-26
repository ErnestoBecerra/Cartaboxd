package com.cartaboxd.project.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.cartaboxd.project.modelos.Administrador;
import com.cartaboxd.project.modelos.ListaPelicula;
import com.cartaboxd.project.modelos.Pelicula;
import com.cartaboxd.project.modelos.Usuario;
import com.cartaboxd.project.servicios.Servicios;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;



@Controller
public class ControladorAdmin {
	@Autowired
	private Servicios s;
	
	@GetMapping("/inicio")
	public String muestraInicio() {
		return "welcome.jsp";
	}
	
	@GetMapping("/nuevo-admin")
	public String nuevoAdmin(@ModelAttribute("administrador") Administrador administrador) {
		return "create-admin.jsp";
	}
	
	@PostMapping("/registrar-admin")
	public String crearAdmin(@Valid @ModelAttribute("administrador") Administrador administrador,
							BindingResult result) {
		if(result.hasErrors()) {
			return "create-admin.jsp";
		}else {
			s.guardarAdminFormulario(administrador);
			return "redirect:/nuevo-admin";
		}
	}
	
	//Peliculas
	@GetMapping("/peliculas")
	public List<Pelicula> muestraPeliculas() {
		return s.todasPeliculas();
	}

	@PostMapping("/peliculas")
	public Pelicula registrarPelicula(@RequestParam("nombre") String nombre,
										@RequestParam("descripcion")String descripcion,
										@RequestParam("calificacion")float calificacion) {
		if (s.existePelicula(nombre)) {
			Pelicula falsa = new Pelicula();
			return s.guardarPelicula(falsa);
		} else {
			Pelicula nueva = new Pelicula(nombre, descripcion, calificacion);
			return s.guardarPelicula(nueva);
		}
		
	}

	@PutMapping("/peliculas/{id}")
	public Pelicula editarPelicula(@PathVariable long id,
									@RequestParam("nombre") String nombre,
									@RequestParam("descripcion")String descripcion,
									@RequestParam("calificacion")float calificacion) {

		Pelicula actualizada = new Pelicula(id, nombre, descripcion, calificacion);	
		return s.guardarPelicula(actualizada);
	}

	@DeleteMapping("/peliculas/{id}")
	public void borrarPelicula(@PathVariable("id") long id){
		s.borrarPelicula(id);
	}
	
	@GetMapping("/nuevo-usuario")
	public String nuevoUsuario(@ModelAttribute("usuario") Usuario usuario) {
		return "create-visitante.jsp";
	}
	
	@PostMapping("/registrar-usuario")
	public String crearUsuario(@Valid @ModelAttribute("usuario") Usuario usuario,
								BindingResult result) {
		if(result.hasErrors()) {
			return "create-visitante.jsp";
		} else {
			s.guardarUsuarioFormulario(usuario);
			return "redirect:/inicio-usuario";
		}
	}
	
	@GetMapping("/nueva-lista")
	public String nuevaLista(@ModelAttribute("lista") ListaPelicula lista) {
		return "create-lista.jsp";
	}
	
	@PostMapping("/registrar-lista")
	public String crearLista(@Valid @ModelAttribute("lista") ListaPelicula lista,
							  BindingResult result) {
		if(result.hasErrors()) {
			return "create-lista.jsp";
		} else {
			s.guardarListaFormulario(lista);
			return "redirect:/inicio-usuario";
		}
	}
	
	@GetMapping("/inicio-usuario")
	public String inicioUsuarios(Model model) {
		List<ListaPelicula> listas = s.todoListas();
		model.addAttribute("listas",listas);
		return "dashboard-usuario.jsp";
	}
	
	
	 @GetMapping("/iniciar-sesion")
	 public String mostrarFormularioInicioSesion(@ModelAttribute("usuario") Usuario usuario) {
		 return "login-usuario.jsp";
	 }

	 
}
