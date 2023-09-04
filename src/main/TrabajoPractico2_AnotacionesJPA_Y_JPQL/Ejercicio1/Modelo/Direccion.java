package main.TrabajoPractico2_AnotacionesJPA_Y_JPQL.Ejercicio1.Modelo;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Direccion {

    @Id
    @GeneratedValue(Strategy = GenerationType.AUTO)
    private int id;
    @Column(length = 255)
    private String calle;
    @Column(length = 255)
    private String ciudad;

    //Una direccion puede ir a muchas personas, se necesita si o si una coleccion
    @OneToMany(mappedBy="domicilio", fetch = FetchType.LAZY)
    private List<Persona> habitante;

    public Direccion(String calle, String ciudad) {
        this.calle = calle;
        this.ciudad = ciudad;
        this.habitante = new ArrayList<>();
    }

    public Direccion() {
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


}

