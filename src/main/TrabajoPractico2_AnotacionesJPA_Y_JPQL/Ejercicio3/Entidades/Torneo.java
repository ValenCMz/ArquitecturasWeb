package main.TrabajoPractico2_AnotacionesJPA_Y_JPQL.Ejercicio3.Entidades;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Torneo {
    @Id
    private int id;

    @Column
    private String nombre;

    @OneToMany(mappedBy = "equipo",fetch = FetchType.LAZY)
    private List<Equipo>equipos;

    public Torneo(String nombre) {
        this.nombre = nombre;
        this.equipos = new ArrayList<>();
    }

    public Torneo() {

    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }



    public List<Equipo> getEquipos() {
        return equipos;
    }


}
