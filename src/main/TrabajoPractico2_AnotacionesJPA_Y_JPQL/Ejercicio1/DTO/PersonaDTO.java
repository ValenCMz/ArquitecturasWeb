package main.TrabajoPractico2_AnotacionesJPA_Y_JPQL.Ejercicio1.DTO;

public class PersonaDTO {

    private int id;
    private int anios;

    private String nombre;

    private int domicilio_id;

    public PersonaDTO(int id, int anios, String nombre, int domicilio_id) {
        this.id = id;
        this.anios = anios;
        this.nombre = nombre;
        this.domicilio_id = domicilio_id;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "id=" + id +
                ", anios=" + anios +
                ", nombre='" + nombre + '\'' +
                ", domicilio_id=" + domicilio_id +
                '}';
    }
}
