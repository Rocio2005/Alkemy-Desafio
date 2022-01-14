package com.alkemy.disney.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name= "pelicula")
@Getter
@Setter
public class PeliculaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String imagen;

    private String titulo;

    @Column(name="fecha_creacion")
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private LocalDate fechaCreacion;

    private Short calificacion;

    /*relacion pelicula-genero*/ /*muchas peliculas para un genero, o una pelicula un genero y un genero muchas peliculas*/
    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name="genero_id", insertable=false,updatable = false)/*no puedo insertar ni actualizar pues es solo para obtener informacion*/
    private GeneroEntity genero;

    @Column(name="genero_id",nullable = false)
    private Long generoId;

    /*relacion pelicula-personaje*/
    @ManyToMany(
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(
            name = "personaje_pelicula",
            joinColumns = @JoinColumn(name = "pelicula_id"),/*donde estoy parada, en este caso pais*/
            inverseJoinColumns = @JoinColumn(name = "personaje_id"))/*la relacion con la otra columna en otro lado, en este caso icon*/
    private Set<PersonajeEntity> personajes= new HashSet<>();






}


