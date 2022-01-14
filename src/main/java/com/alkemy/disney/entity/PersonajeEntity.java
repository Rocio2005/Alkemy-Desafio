package com.alkemy.disney.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name= "personaje")
@Getter
@Setter
public class PersonajeEntity {






    @ManyToMany(mappedBy = "personajes",cascade = CascadeType.ALL)
    private List<PeliculaEntity> peliculas=new ArrayList<>();

    //add and remove paises
    public void addPais(PeliculaEntity pelicula) { this.peliculas.add(pelicula);}

    public void removePais(PeliculaEntity pelicula){ this.peliculas.remove(pelicula);}
}
