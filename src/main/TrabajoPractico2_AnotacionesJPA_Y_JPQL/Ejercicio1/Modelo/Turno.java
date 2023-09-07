package main.TrabajoPractico2_AnotacionesJPA_Y_JPQL.Ejercicio1.Modelo;

import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Turno {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    private Timestamp fecha;

    @ManyToMany(fetch = FetchType.LAZY)
    private List<Persona>jugadores;

    public Turno( Timestamp fecha) {
        this.fecha = fecha;
        this.jugadores = new ArrayList<>();
    }

    public Turno(){

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

    public List<Persona> getJugadores() {
        return jugadores;
    }

    public void setJugadores(List<Persona> jugadores) {
        this.jugadores = jugadores;
    }

    @Override
    public String toString() {
        return "Turno{" +
                "id=" + id +
                ", fecha=" + fecha +
                ", jugadores=" + jugadores +
                '}' + "\n";
    }
}
