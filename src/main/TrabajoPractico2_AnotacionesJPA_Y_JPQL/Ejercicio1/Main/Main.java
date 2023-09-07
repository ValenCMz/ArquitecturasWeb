package main.TrabajoPractico2_AnotacionesJPA_Y_JPQL.Ejercicio1.Main;

import main.TrabajoPractico2_AnotacionesJPA_Y_JPQL.Ejercicio1.Modelo.Direccion;
import main.TrabajoPractico2_AnotacionesJPA_Y_JPQL.Ejercicio1.Modelo.Persona;
import main.TrabajoPractico2_AnotacionesJPA_Y_JPQL.Ejercicio1.Modelo.Socio;
import main.TrabajoPractico2_AnotacionesJPA_Y_JPQL.Ejercicio1.Modelo.Turno;
import main.TrabajoPractico2_AnotacionesJPA_Y_JPQL.Ejercicio1.Repositorios.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.Timestamp;

public class Main {

    public static void main(String[]args){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Example");
        EntityManager em = emf.createEntityManager();
        PersonaRepositorio personaRepositorio = new PersonaRepositorioImpl(em);
        DireccionRepositorio direccionRepositorio = new DireccionRepositorioImpl(em);
        TurnoRepositorio turnoRepositorio = new TurnoRepositorioImpl(em);
        SocioRepositorio socioRepositorio = new SocioRepositorioImpl(em);
        em.getTransaction().begin();
        Direccion d1 =  new Direccion("Olavarria","asasa");
        Direccion d2 = new Direccion("Azul","asda");
        Direccion d3 = new Direccion("Tandil","asda");
        Direccion d4 = new Direccion("Rauch","asda");
        Direccion d5 = new Direccion("Montenegro","asda");
        Direccion d6 = new Direccion("Uruguay","asda");

        Persona p1 = new Persona(1,33,"Juan",d1);
        Persona p2 = new Persona(2,44,"Jose",d1);
        Persona p3 = new Persona(3,55,"Anuel",d2);

        Timestamp ts = new Timestamp(2000);
        Turno t1 = new Turno(ts);
        Turno t2 = new Turno(ts);

        Socio s1 = new Socio("A",p1);
        Socio s2 = new Socio("B",p2);



     /*   direccionRepositorio.insert(d1);
        direccionRepositorio.insert(d2);

        personaRepositorio.insert(p1);
        personaRepositorio.insert(p2);
        personaRepositorio.insert(p3);

        t1.getJugadores().add(p1);
        t2.getJugadores().add(p2);

        turnoRepositorio.insert(t1);
        turnoRepositorio.insert(t2);

        socioRepositorio.insert(s1);
        socioRepositorio.insert(s2);


      */

      System.out.println(personaRepositorio.getPersonasAsignadasAUnTurnoSocio());

        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
