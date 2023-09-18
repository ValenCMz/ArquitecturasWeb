package main.TrabajoPractico2_AnotacionesJPA_Y_JPQL.Ejercicio3.Repositorios;

import main.TrabajoPractico2_AnotacionesJPA_Y_JPQL.Ejercicio3.DTO.JugadorDTO;
import main.TrabajoPractico2_AnotacionesJPA_Y_JPQL.Ejercicio3.Entidades.Jugador;

import java.util.List;

public interface JugadorRepositorio {

    public void insert(Jugador j);
    public List<JugadorDTO> getJugadores();
    public JugadorDTO getJugadorDTOById(int id);
    public void delete(int id);
    public List<JugadorDTO> getJugadoresPorEquipo(int id_equipo);

    public List<JugadorDTO> getJugadoresPorTorneo(int id_torneo);
}
