package com.cartaboxd.project.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cartaboxd.project.modelos.Administrador;
import com.cartaboxd.project.modelos.ListaPelicula;
import com.cartaboxd.project.modelos.Pelicula;
import com.cartaboxd.project.modelos.ResenaPelicula;
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
	
	
	public Administrador guardarAdminFormulario(Administrador nuevoAdmin) {
		return repoAdministradores.save(nuevoAdmin);
	}
	
	public Administrador buscarAdmin(Long id) {
		return repoAdministradores.findById(id).orElse(null);
	}
	
	public void borrarAdmin(Long id) {
		repoAdministradores.deleteById(id);
	}
	
	public Administrador loginParaAdmin(String email, String password) {
		Administrador adminInicioSesion = repoAdministradores.findByEmail(email);
		if(adminInicioSesion == null) {
			return null;
		}else {
			if(password.equals(adminInicioSesion.getContrasena())) {
				return adminInicioSesion;
			}else {
				return null;
			}
		}
	}
	
	
	// Servicios para peliculas 
	public List<Pelicula> todasPeliculas(){
		return repoPelicula.findAll();
	}//Muestra todas las peliculas

	public List<Pelicula> peliculasPorNombre(String nombre){
		return repoPelicula.findByNombre(nombre);
	}//Buscar por nombre

	public void actualizarCalificacionPromedio(){
		Iterable<Pelicula> peliculas = repoPelicula.findAll();
		for (Pelicula pelicula : peliculas) {
			List<ResenaPelicula> reseñas = repoResena.findByPeliculaId(pelicula.getId());
			float sum = 0;
            for (ResenaPelicula reseña : reseñas) {
                sum += reseña.getCalificacion();
            }
            if (!reseñas.isEmpty()) {
                float promedio = sum / reseñas.size();
                pelicula.setCalificacion(promedio);
                repoPelicula.save(pelicula);
            }
		}
	}

	public Pelicula guardarPelicula(Pelicula nuevaPelicula){
		return repoPelicula.save(nuevaPelicula);
	}//Guarda una pelicula nueva

	public void borrarPelicula(long id){
		repoPelicula.deleteById(id);
	}//Borra pelicula en base a su ID

	public boolean existePelicula(String nombre){
		return repoPelicula.existsByNombre(nombre);
	}
	
	public Pelicula peliculaPorId(long id){
		return repoPelicula.findById(id);
	}
	
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
	
	public Usuario login(String email, String password) {
		Usuario usuarioInicioSesion = repoUsuarios.findByEmail(email);
		
		if(usuarioInicioSesion == null) {
			return null;
		}else {
			if(password.equals(usuarioInicioSesion.getContrasena())) {
				return usuarioInicioSesion;
			}else {
				return null;
			}
		}
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
	

	// Servicios para Reseñas
public ResenaPelicula guardarResena(ResenaPelicula nuevaResena, Long peliculaId) {
    Pelicula peliculaResena = muestraPelicula(peliculaId);
    nuevaResena.setPeliculaId(peliculaId); // Establecer el ID de la película en la reseña
    return repoResena.save(nuevaResena);
}

public Pelicula muestraPelicula(Long id) {
    return repoPelicula.findById(id).orElse(null);
}

public List<Pelicula> mejoresPeliculas(){
	return repoPelicula.findByOrderByCalificacionDesc();
}

	
}
