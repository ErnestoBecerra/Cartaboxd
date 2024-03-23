package com.cartaboxd.project.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cartaboxd.project.modelos.Administrador;
import com.cartaboxd.project.servicios.Servicios;

@RestController
@RequestMapping("/api")
public class ControladorAPI {
	@Autowired
	private Servicios s;
	
	@GetMapping("/admins")
	public List<Administrador> apiMuestraAdmins(){
		return s.todosAdmins();
	}
}
