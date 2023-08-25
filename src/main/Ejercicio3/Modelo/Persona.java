package main.Ejercicio3.Modelo;

public class Persona {

    private int id;
    private String nombre;
    private int edad;

    public Persona(int id, String nombre, int edad) {
        this.id = id;
        this.nombre =nombre;
        this.edad = edad;
    }

    public Persona() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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


    @Override
    public String toString() {
        String toReturn = "";
        toReturn += "Id: " + this.getId() + " Nombre: " + this.getNombre() + " Edad: " + this.getEdad() + "\n";
        return toReturn;
    }


}
