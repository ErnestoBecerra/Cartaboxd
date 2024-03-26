package com.cartaboxd.project.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cartaboxd.project.modelos.Administrador;
import com.cartaboxd.project.modelos.ListaPelicula;
import com.cartaboxd.project.modelos.Usuario;
import com.cartaboxd.project.servicios.Servicios;

import jakarta.validation.Valid;

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
	 public String inicioAdmin() {
		 return "dashboard-administrador.jsp";
	 }
}
