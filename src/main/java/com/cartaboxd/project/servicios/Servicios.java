package com.cartaboxd.project.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cartaboxd.project.modelos.Administrador;
import com.cartaboxd.project.modelos.ListaPelicula;
import com.cartaboxd.project.modelos.Pelicula;
import com.cartaboxd.project.modelos.Usuario;
import com.cartaboxd.project.repositorios.RepositorioAdministrador;
import com.cartaboxd.project.repositorios.RepositorioLista;
import com.cartaboxd.project.repositorios.RepositorioPelicula;
import com.cartaboxd.project.repositorios.RepositorioResena;
import com.cartaboxd.project.repositorios.RepositorioUsuario;

@Service
public class Servicios {
	@Autowired
	private RepositorioAdministrador repoAdministradores;
	
	@Autowired
	private RepositorioUsuario repoUsuarios;
	
	@Autowired
	private RepositorioLista repoListas; 
	
	@Autowired
	private RepositorioPelicula repoPelicula;

	@Autowired
	private RepositorioResena repoResena;

	// Servicios para administradores
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
	
	public List<Pelicula> todasPeliculas(){
		return repoPelicula.findAll();
	}//Muestra todas las peliculas

	public Pelicula guardarPelicula(Pelicula nuevaPelicula){
		return repoPelicula.save(nuevaPelicula);
	}//Guarda una pelicula nueva

	public void borrarPelicula(long id){
		repoPelicula.deleteById(id);
	}//Borra pelicula en base a su ID
	
	// Servicios para usuarios
	public List<Usuario> todosUsuarios(){
		return repoUsuarios.findAll();
	}
	
	public Usuario guardarUsuarioFormulario(Usuario nuevoUsuario) {
		return repoUsuarios.save(nuevoUsuario);
	}
	
	public Usuario buscarUsuario(Long id) {
		return repoUsuarios.findById(id).orElse(null);
	}
	
	public void borrarUsuario(Long id) {
		repoUsuarios.deleteById(id);
	}
	
	
	
	
	// Servicios para Lista de peliculas
	public List<ListaPelicula> todoListas(){
		return repoListas.findAll();
	}
	
	public ListaPelicula guardarListaFormulario(ListaPelicula nuevaLista) {
		return repoListas.save(nuevaLista);
	}
	
	public ListaPelicula muestraLista(Long id) {
		return repoListas.findById(id).orElse(null);
	}
	
	public void guardarUsuarioLista(Long usuario_id, Long lista_id) {
		Usuario miUsuario = buscarUsuario(usuario_id);
		ListaPelicula miLista = muestraLista(lista_id);
		
		miUsuario.getListas().add(miLista);
		repoUsuarios.save(miUsuario);
	}
	
	
	
}
