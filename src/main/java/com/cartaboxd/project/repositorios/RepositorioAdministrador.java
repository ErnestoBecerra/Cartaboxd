package com.cartaboxd.project.repositorios;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cartaboxd.project.modelos.Administrador;
import com.cartaboxd.project.modelos.Usuario;

@Repository
public interface RepositorioAdministrador extends CrudRepository<Administrador,Long>{
	List<Administrador> findAll();
	Administrador findByEmail(String email);
}
