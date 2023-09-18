package main.TrabajoPractico2_AnotacionesJPA_Y_JPQL.Ejercicio3.DTO;

public class JugadorDTO {

    private int id;
    private String nombre;
    private String posicion;

    private int id_equipo;

    public JugadorDTO(int id, String nombre, String posicion, int id_equipo) {
        this.id = id;
        this.nombre = nombre;
        this.posicion = posicion;
        this.id_equipo = id_equipo;
    }

    @Override
    public String toString() {
        return "JugadorDTO{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", posicion='" + posicion + '\'' +
                ", id_equipo=" + id_equipo +
                '}';
    }
}
