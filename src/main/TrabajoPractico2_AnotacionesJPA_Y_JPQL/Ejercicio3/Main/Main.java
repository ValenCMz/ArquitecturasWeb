package main.TrabajoPractico2_AnotacionesJPA_Y_JPQL.Ejercicio3.Main;

import main.TrabajoPractico2_AnotacionesJPA_Y_JPQL.Ejercicio3.Entidades.Equipo;
import main.TrabajoPractico2_AnotacionesJPA_Y_JPQL.Ejercicio3.Entidades.Jugador;
import main.TrabajoPractico2_AnotacionesJPA_Y_JPQL.Ejercicio3.Entidades.Torneo;
import main.TrabajoPractico2_AnotacionesJPA_Y_JPQL.Ejercicio3.Repositorios.EquipoRepositorioImpl;
import main.TrabajoPractico2_AnotacionesJPA_Y_JPQL.Ejercicio3.Repositorios.JugadorRepositorioImpl;
import main.TrabajoPractico2_AnotacionesJPA_Y_JPQL.Ejercicio3.Repositorios.TorneoRepositorioImpl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[]args){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Example");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        EquipoRepositorioImpl equipoRepositorio = new EquipoRepositorioImpl(em);
        JugadorRepositorioImpl jugadorRepositorio = new JugadorRepositorioImpl(em);
        TorneoRepositorioImpl torneoRepositorio = new TorneoRepositorioImpl(em);

        Equipo e1 = new Equipo("River");
        Equipo e2 = new Equipo("Boca");

        equipoRepositorio.insert(e1);
        equipoRepositorio.insert(e2);


        Jugador j1R = new Jugador("Franco Armani", "Arquero",e1);
        Jugador j2R = new Jugador("Ramiro Funes Mori","Defensor",e1);
        Jugador j3R = new Jugador("Brun Zuculini", "Mediocampista",e1);

        Jugador  j1B = new Jugador("Sergio Romero","Arquero",e2);
        Jugador  j2B = new Jugador("Facundo Roncaglia","Defensor",e2);
        Jugador  j3B = new Jugador("Ezequiel Bullaude","Mediocampista",e2);

        jugadorRepositorio.insert(j1R);
        jugadorRepositorio.insert(j2R);
        jugadorRepositorio.insert(j3R);
        jugadorRepositorio.insert(j1B);
        jugadorRepositorio.insert(j2B);
        jugadorRepositorio.insert(j3B);

        Torneo torneo = new Torneo("Copa libertadores");

        torneoRepositorio.insert(torneo);

        equipoRepositorio.agregarJugadorAEquipo(j1R.getId(), e1.getId());
        equipoRepositorio.agregarJugadorAEquipo(j2R.getId(), e1.getId());
        equipoRepositorio.agregarJugadorAEquipo(j3R.getId(), e1.getId());

        equipoRepositorio.agregarJugadorAEquipo(j1B.getId(), e2.getId());
        equipoRepositorio.agregarJugadorAEquipo(j2B.getId(), e2.getId());
        equipoRepositorio.agregarJugadorAEquipo(j3B.getId(), e2.getId());

        torneoRepositorio.addEquipoATorneo(e1.getId(), torneo.getId());
        torneoRepositorio.addEquipoATorneo(e2.getId(), torneo.getId());

        System.out.println(jugadorRepositorio.getJugadoresPorEquipo(e1.getId()));
        System.out.println(jugadorRepositorio.getJugadoresPorTorneo(torneo.getId()));

        em.getTransaction().commit();
        em.close();
        em.close();
    }
}
