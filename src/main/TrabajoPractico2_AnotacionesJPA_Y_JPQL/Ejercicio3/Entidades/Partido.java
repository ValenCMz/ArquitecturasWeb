package main.TrabajoPractico2_AnotacionesJPA_Y_JPQL.Ejercicio3.Entidades;

import javax.persistence.*;

@Entity
public class Partido {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idEncuentro;
    @Column
    private int resultado;

    /*
    Un equipo puede jugar en varios encuentros
     */

    @ManyToOne
    private Equipo equipoLocal;

    @ManyToOne
    private Equipo equipoVisitante;

    @Column
    private int golesEquipoLocal;

    @Column
    private int golesEquipoVisitante;

    @ManyToOne
    private Torneo torneo;

}
