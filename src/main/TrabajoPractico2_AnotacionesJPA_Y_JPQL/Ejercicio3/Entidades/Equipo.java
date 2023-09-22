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

    @ManyToOne
    private Torneo torneo;

    /*
    Un equipo puede estar en varios partidos a lo largo del torneo
     */
    @OneToMany(mappedBy = "equipoLocal")
    private List<Partido> partidosLocales;

    @OneToMany(mappedBy = "equipoVisitante")
    private List<Partido> partidosVisitantes;

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
