package com.cartaboxd.project.repositorios;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cartaboxd.project.modelos.Usuario;

@Repository
public interface RepositorioUsuario extends CrudRepository<Usuario,Long>{
	List<Usuario> findAll();
	Usuario findByEmail(String email);
}
