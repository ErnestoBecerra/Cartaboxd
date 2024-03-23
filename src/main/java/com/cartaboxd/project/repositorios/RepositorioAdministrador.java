package com.cartaboxd.project.repositorios;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cartaboxd.project.modelos.Administrador;

@Repository
public interface RepositorioAdministrador extends CrudRepository<Administrador,Long>{
	List<Administrador> findAll();
}
