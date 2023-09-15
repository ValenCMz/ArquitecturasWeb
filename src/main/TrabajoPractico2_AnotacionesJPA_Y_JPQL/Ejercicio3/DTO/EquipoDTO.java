package main.TrabajoPractico2_AnotacionesJPA_Y_JPQL.Ejercicio3.DTO;

import java.util.List;

public class EquipoDTO {

    private int id;
    private String nombre;
    private List<JugadorDTO> jugadores;

    private int id_torneo;

    public EquipoDTO(int id, String nombre, List<JugadorDTO> jugadores, int id_torneo) {
        this.id = id;
        this.nombre = nombre;
        this.jugadores = jugadores;
        this.id_torneo = id_torneo;
    }
}


