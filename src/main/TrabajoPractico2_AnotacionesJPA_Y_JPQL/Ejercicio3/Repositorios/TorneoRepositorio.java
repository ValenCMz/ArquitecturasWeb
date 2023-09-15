package main.TrabajoPractico2_AnotacionesJPA_Y_JPQL.Ejercicio3.Repositorios;

import main.TrabajoPractico2_AnotacionesJPA_Y_JPQL.Ejercicio3.DTO.TorneoDTO;
import main.TrabajoPractico2_AnotacionesJPA_Y_JPQL.Ejercicio3.Entidades.Torneo;

import java.util.List;

public interface TorneoRepositorio {
    public void insert(Torneo e);
    public List<TorneoDTO> getTorneos();
    public TorneoDTO getTorneoDTOById(int id);
    public void delete(int id);

    public void addEquipoATorneo(int equipoId, int torneoId);

}
