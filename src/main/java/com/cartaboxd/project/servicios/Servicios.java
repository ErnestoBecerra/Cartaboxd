package com.cartaboxd.project.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cartaboxd.project.modelos.Administrador;
import com.cartaboxd.project.repositorios.RepositorioAdministrador;

@Service
public class Servicios {
	@Autowired
	private RepositorioAdministrador repoAdministradores;
	
	public List<Administrador> todosAdmins(){
		return repoAdministradores.findAll();
	}
	
	//public Administrador guardarAdmin(Administrador nuevoAdmin, Long pelicula_id) {
	//	Pelicula peliculaAdmin = muestraPelicula(pelicula_id);
	//	nuevoAdmin.setPelicula(peliculaAdmin);
	//	return repoAdministradores.save(nuevoAdmin);
	//}
	
	public Administrador guardarAdminFormulario(Administrador nuevoAdmin) {
		return repoAdministradores.save(nuevoAdmin);
	}
	
	public Administrador buscarAdmin(Long id) {
		return repoAdministradores.findById(id).orElse(null);
	}
	
	public void borrarAdmin(Long id) {
		repoAdministradores.deleteById(id);
	}
}
