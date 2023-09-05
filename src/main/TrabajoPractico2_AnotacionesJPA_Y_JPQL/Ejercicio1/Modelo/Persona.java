package main.TrabajoPractico2_AnotacionesJPA_Y_JPQL.Ejercicio1.Modelo;

import javax.persistence.*;
import java.util.List;

@Entity
public class Persona {
    @Id
    private int id;
    @Column
    private int anios;
    @Column(length = 255)
    private String nombre;

    //Muchas personas van a una direccion
    @ManyToOne(fetch = FetchType.LAZY)
    private Direccion domicilio;

    @ManyToMany(mappedBy = "jugadores", fetch = FetchType.LAZY)
    private List<Turno>turnos;

    public Persona(int id, int anios, String nombre, Direccion domicilio) {
        this.id = id;
        this.anios = anios;
        this.nombre = nombre;
        this.domicilio = domicilio;
    }

    public Persona() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAnios() {
        return anios;
    }

    public void setAnios(int anios) {
        this.anios = anios;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Direccion getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(Direccion domicilio) {
        this.domicilio = domicilio;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "id=" + id +
                ", anios=" + anios +
                ", nombre='" + nombre + '\'' +
                ", domicilio=" + domicilio +
                ", turnos=" + turnos +
                '}' + "\n";
    }
}
