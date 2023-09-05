package main.TrabajoPractico2_AnotacionesJPA_Y_JPQL.Ejercicio1.DTO;

import main.TrabajoPractico2_AnotacionesJPA_Y_JPQL.Ejercicio1.Modelo.Persona;

public class SocioDTO {
    private String tipo;
    private int persona_id;

    public SocioDTO(String tipo, int persona_id) {
        this.tipo = tipo;
        this.persona_id = persona_id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getPersona_id() {
        return persona_id;
    }

    @Override
    public String toString() {
        return "SocioDTO{" +
                "tipo='" + tipo + '\'' +
                ", persona_id=" + persona_id +
                '}';
    }
}
