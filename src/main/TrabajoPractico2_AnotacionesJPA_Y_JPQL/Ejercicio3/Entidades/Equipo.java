package main.TrabajoPractico2_AnotacionesJPA_Y_JPQL.Ejercicio3.Entidades;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Equipo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    private String nombre;

    //relacion
    @OneToMany(mappedBy = "equipo", fetch = FetchType.LAZY )
    private List<Jugador>jugadores;

    @JoinColumn(name = "id_torneo")
    @ManyToOne
    private Torneo torneo;

    public Equipo(String nombre) {
        this.nombre = nombre;
        this.jugadores = new ArrayList<>();
    }

    public Equipo() {

    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public List<Jugador> getJugadores() {
        return jugadores;
    }

    public void setTorneo(Torneo t){
        this.torneo = t;
    }

}
