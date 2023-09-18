package main.TrabajoPractico2_AnotacionesJPA_Y_JPQL.Ejercicio3.DTO;

public class TorneoDTO {

    private int id;

    private String nombre;

    public TorneoDTO(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
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
}
