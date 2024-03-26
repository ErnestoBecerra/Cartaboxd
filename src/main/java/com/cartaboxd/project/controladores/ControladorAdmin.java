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
import org.springframework.web.bind.annotation.RequestParam;

import com.cartaboxd.project.modelos.Administrador;
import com.cartaboxd.project.modelos.ListaPelicula;
import com.cartaboxd.project.modelos.Pelicula;
import com.cartaboxd.project.modelos.ResenaPelicula;
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
	public String muestraInicio(Model model) {
		List<Pelicula> peliculas = s.mejoresPeliculas();
		model.addAttribute("peliculas",peliculas);
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

	@PostMapping("/registrar-pelicula")
	public String crearPelicula(@Valid @ModelAttribute("pelicula") Pelicula pelicula,
                            BindingResult result,
                            Model model) {
    if (result.hasErrors()) {
        return "create-pelicula.jsp";
    } else {
        // Validar si la película ya existe
        boolean existePelicula = s.existePelicula(pelicula.getNombre());
        
        if (existePelicula) {
            model.addAttribute("error", "La película ya existe");
            return "create-pelicula.jsp";
        } else {
            s.guardarPelicula(pelicula);
            return "redirect:/inicio-admin";
        }
    }
}
	
	@GetMapping("/nueva-pelicula")
	public String nuevaPelicula(@ModelAttribute("pelicula") Pelicula pelicula) {
		return "create-pelicula.jsp";
	}

	@GetMapping("/buscar-peliculas")
	public String buscarPeliculas(@RequestParam("nombre") String nombre, Model model){
		List<Pelicula> peliculas = s.peliculasPorNombre(nombre);
		model.addAttribute("peliculas", peliculas);
		return "search.jsp";
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

	@GetMapping("/editar-pelicula/{id}")
	public String mostrarFormularioEdicion(@PathVariable Long id, Model model) {
		// Obtener la película a editar
		Pelicula pelicula = s.peliculaPorId(id);
		
		// Agregar la película al modelo
		model.addAttribute("pelicula", pelicula);
		
		return "edit-pelicula.jsp";
	}

	@PutMapping("/peliculas/{id}")
	public String editarPelicula(@PathVariable long id,
                              @RequestParam("nombre") String nombre,
                              @RequestParam("descripcion") String descripcion,
                              @RequestParam("calificacion") float calificacion) {

    Pelicula actualizada = new Pelicula(id, nombre, descripcion, calificacion); 
    s.guardarPelicula(actualizada);
    
    // Redireccionar a la página "inicio-admin"
    return "redirect:/inicio-admin";
}


	@DeleteMapping("/peliculas/{id}")
	public String borrarPelicula(@PathVariable("id") long id){
		s.borrarPelicula(id);
		return "redirect:/inicio-admin";
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
	public String inicioUsuarios(Model model, Model model2) {
		List<Pelicula> peliculas = s.todasPeliculas();
		List<ListaPelicula> listas = s.todoListas();
		model2.addAttribute("peliculas", peliculas);
		model.addAttribute("listas",listas);
		return "dashboard-usuario.jsp";
	}
	
	
	
	@GetMapping("/login-usuario")
	public String loginUsuario() {
		return "login-usuario.jsp";
	}
	
	 @PostMapping("/iniciar-sesion")
	 public String login(@RequestParam("email") String email,
			 			 @RequestParam("password") String password) {
		 Usuario usuarioLogin = s.login(email,password);
		 if(usuarioLogin == null) {
			 return "redirect:/inicio";
		 }else {
			 return "redirect:/inicio-usuario";
		 }
	 }

	 @GetMapping("/login-admin")
	 public String loginAdministrador() {
		 return "login-admin.jsp";
	 }
	 
	 @PostMapping("/iniciar-admin")
	 public String loginAdmin(@RequestParam("email") String email,
			 				  @RequestParam("password") String password) {
		 Administrador adminLogin = s.loginParaAdmin(email,password);
		 if(adminLogin == null) {
			 return "redirect:/inicio";
		 }else {
			 return "redirect:/inicio-admin";
		 }
	 }
	
	 @GetMapping("/inicio-admin")
	 public String inicioAdmin(Model model) {
		List<Pelicula> peliculas = s.todasPeliculas();
		model.addAttribute("peliculas",peliculas);
		 return "dashboard-administrador.jsp";
	 }


	 //Reseñas
	 @GetMapping("/nueva-resena")
	 public String nuevaResena(@ModelAttribute("resenia") ResenaPelicula resenia,
								@RequestParam("peliculaId") Long peliculaId,
								Model model) {
		 // Aquí deberías tener la lógica para obtener la película en función del ID
		 Pelicula pelicula = s.peliculaPorId(peliculaId);
		 model.addAttribute("pelicula", pelicula);
		 return "create-resena.jsp";
	 }
	 
	 

	 @PostMapping("/registrar-resena")
	 public String crearResena(@Valid @ModelAttribute("resenia") ResenaPelicula resenia,
							   @RequestParam("peliculaId") Long peliculaId,
							   BindingResult result) {
		 if(result.hasErrors()) {
			 return "create-resena.jsp";
		 } else {
			 // Llama al servicio para guardar la reseña, pasando el ID de la película
			 s.guardarResena(resenia, peliculaId);
			 return "redirect:/inicio-usuario";
		 }
	 }
	 
	 
	

}
