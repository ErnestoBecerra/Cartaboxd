package com.cartaboxd.project.repositorios;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cartaboxd.project.modelos.ResenaPelicula;

@Repository
public interface RepositorioResena extends CrudRepository<ResenaPelicula,Long> {
    List<ResenaPelicula> findAll();
    ResenaPelicula save(ResenaPelicula nuevaResenaPelicula);

    List<ResenaPelicula> findByPeliculaId(Long peliculaId);
}
