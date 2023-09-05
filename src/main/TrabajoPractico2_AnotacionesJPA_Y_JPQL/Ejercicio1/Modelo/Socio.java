package main.TrabajoPractico2_AnotacionesJPA_Y_JPQL.Ejercicio1.Modelo;

import javax.persistence.*;

@Entity
public class Socio {

    //Esto va a ser un id y a la vez una fk, por el @MapsId
    @Id
    private int id;

    @Column(length = 255)
    private String tipo;

    @OneToOne
    @MapsId
    private Persona persona;

    public Socio(int id, String tipo, Persona persona) {
        this.id = id;
        this.tipo = tipo;
        this.persona = persona;
    }

    public Socio() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    @Override
    public String toString() {
        return "Socio{" +
                "id=" + id +
                ", tipo='" + tipo + '\'' +
                ", persona=" + persona +
                '}' + "\n";
    }
}
