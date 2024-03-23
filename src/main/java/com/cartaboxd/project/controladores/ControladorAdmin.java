package com.cartaboxd.project.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.cartaboxd.project.modelos.Administrador;
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
}
