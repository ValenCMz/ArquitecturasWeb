package main.TrabajoPractico2_AnotacionesJPA_Y_JPQL.Ejercicio1.DTO;

import main.TrabajoPractico2_AnotacionesJPA_Y_JPQL.Ejercicio1.Modelo.Persona;

import java.sql.Timestamp;
import java.util.List;

public class TurnoDTO {
    private int id;
    private Timestamp fecha;

    public TurnoDTO(int id, Timestamp fecha){
        this.id = id;
        this.fecha = fecha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }


}
