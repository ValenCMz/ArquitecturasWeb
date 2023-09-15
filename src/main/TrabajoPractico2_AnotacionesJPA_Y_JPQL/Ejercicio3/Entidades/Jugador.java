package main.TrabajoPractico2_AnotacionesJPA_Y_JPQL.Ejercicio3.Entidades;

import javax.persistence.*;

@Entity
public class Jugador {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column
    private String nombre;

    @Column
    private String posicion;

    @ManyToOne //muchos jugadores pueden estan solo en un equipo
    private Equipo equipo;

    public Jugador() {

    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }


    public String getPosicion() {
        return posicion;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo e){
        this.equipo = e;
    }

    public Jugador(String nombre, String posicion, Equipo equipo) {
        this.nombre = nombre;
        this.posicion = posicion;
        this.equipo = equipo;
    }
}
