package main.TrabajoPractico2_AnotacionesJPA_Y_JPQL.Ejercicio1.DTO;

import java.util.ArrayList;
import java.util.List;

public class DireccionDTO {
    private int id;
    private String calle;
    private String ciudad;

    private List<PersonaDTO> habitante;

    public DireccionDTO(int id, String calle, String ciudad) {
        this.id = id;
        this.calle = calle;
        this.ciudad = ciudad;
        this.habitante = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public List<PersonaDTO> getHabitante() {
        return habitante;
    }

    public void setHabitante(List<PersonaDTO> habitante) {
        this.habitante = habitante;
    }

    @Override
    public String toString() {
        return "DireccionDTO{" +
                "id=" + id +
                ", calle='" + calle + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", habitante=" + habitante +
                '}';
    }
}
