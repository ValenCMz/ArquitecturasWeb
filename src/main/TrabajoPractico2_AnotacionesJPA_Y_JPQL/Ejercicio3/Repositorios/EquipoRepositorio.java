package main.TrabajoPractico2_AnotacionesJPA_Y_JPQL.Ejercicio3.Repositorios;

import main.TrabajoPractico2_AnotacionesJPA_Y_JPQL.Ejercicio3.DTO.EquipoDTO;
import main.TrabajoPractico2_AnotacionesJPA_Y_JPQL.Ejercicio3.DTO.JugadorDTO;
import main.TrabajoPractico2_AnotacionesJPA_Y_JPQL.Ejercicio3.Entidades.Equipo;

import java.util.List;

public interface EquipoRepositorio {
    public void insert(Equipo e);
    public List<EquipoDTO> getEquipos();
    public EquipoDTO getEquipoDTOById(int id);
    public void delete(int id);
}
