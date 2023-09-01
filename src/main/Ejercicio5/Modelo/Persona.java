package main.Ejercicio5.Modelo;

import javax.persistence.*;

//Le decimos q la clase persona es una tabla en la base de datos
@Entity
public class Persona {
    //Definimos a q dato en la base de datos representa, por ejemplo el id es de tipo @Id y el nombre es una columna
    @Id
    private int id;
    @Column
    private String nombre;
    @Column
    private int edad;
    @ManyToOne //Muchas personas pueden vivir en un mismo domicilio, pero una persona no puede tener muchas direcciones
    private Direccion domicilio;

    public Persona(int id, String nombre, int edad, Direccion domicilio) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.domicilio = domicilio;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
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
                ", nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", domicilio=" + domicilio +
                '}';
    }
}
