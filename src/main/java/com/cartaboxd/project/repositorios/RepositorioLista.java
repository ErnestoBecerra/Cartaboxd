package com.cartaboxd.project.repositorios;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cartaboxd.project.modelos.ListaPelicula;

@Repository
public interface RepositorioLista extends CrudRepository<ListaPelicula, Long>{
	List<ListaPelicula> findAll();
}
