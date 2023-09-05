package main.TrabajoPractico2_AnotacionesJPA_Y_JPQL.Ejercicio1.Repositorios;

import main.TrabajoPractico2_AnotacionesJPA_Y_JPQL.Ejercicio1.DTO.DireccionDTO;
import main.TrabajoPractico2_AnotacionesJPA_Y_JPQL.Ejercicio1.Modelo.Direccion;

import java.util.List;

public interface DireccionRepositorio {

    public void insert(Direccion d);
    public DireccionDTO getDireccionDtoById(int id);

    public List<DireccionDTO> getDirecciones();

    public void delete(int id);
}
