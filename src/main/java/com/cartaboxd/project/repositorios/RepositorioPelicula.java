package com.cartaboxd.project.repositorios;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cartaboxd.project.modelos.Pelicula;

@Repository
public interface RepositorioPelicula extends CrudRepository<Pelicula,Long> {
    List<Pelicula> findAll();
    Pelicula save(Pelicula nuevaPelicula);

    boolean existsByNombre(String nombre);

    Pelicula findById(long id);

    List<Pelicula> findByNombre(String nombre);

    List<Pelicula> findByOrderByCalificacionDesc();
}
