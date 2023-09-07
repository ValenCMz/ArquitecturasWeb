package main.TrabajoPractico2_AnotacionesJPA_Y_JPQL.Ejercicio1.Repositorios;


import main.TrabajoPractico2_AnotacionesJPA_Y_JPQL.Ejercicio1.DTO.TurnoDTO;

import main.TrabajoPractico2_AnotacionesJPA_Y_JPQL.Ejercicio1.Modelo.Turno;

import java.util.List;

public interface TurnoRepositorio {

    public void insert(Turno d);
    public TurnoDTO getTurnoDTOById(int id);

    public List<TurnoDTO> getTurnos();

    public void delete(int id);
}
