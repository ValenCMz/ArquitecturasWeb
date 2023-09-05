package main.TrabajoPractico2_AnotacionesJPA_Y_JPQL.Ejercicio1.Main;

import main.TrabajoPractico2_AnotacionesJPA_Y_JPQL.Ejercicio1.Modelo.Direccion;
import main.TrabajoPractico2_AnotacionesJPA_Y_JPQL.Ejercicio1.Modelo.Persona;
import main.TrabajoPractico2_AnotacionesJPA_Y_JPQL.Ejercicio1.Repositorios.DireccionRepositorio;
import main.TrabajoPractico2_AnotacionesJPA_Y_JPQL.Ejercicio1.Repositorios.DireccionRepositorioImpl;
import main.TrabajoPractico2_AnotacionesJPA_Y_JPQL.Ejercicio1.Repositorios.PersonaRepositorio;
import main.TrabajoPractico2_AnotacionesJPA_Y_JPQL.Ejercicio1.Repositorios.PersonaRepositorioImpl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

    public static void main(String[]args){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Example");
        EntityManager em = emf.createEntityManager();
        PersonaRepositorio personaRepositorio = new PersonaRepositorioImpl(em);
        DireccionRepositorio direccionRepositorio = new DireccionRepositorioImpl(em);

        em.getTransaction().begin();
        Direccion d1 =  new Direccion("Olavarria","asasa");
        Direccion d2 = new Direccion("Azul","asda");
        Direccion d3 = new Direccion("Tandil","asda");
        Direccion d4 = new Direccion("Rauch","asda");
        Direccion d5 = new Direccion("Montenegro","asda");
        Direccion d6 = new Direccion("Uruguay","asda");

        Persona p1 = new Persona(1,33,"Juan",d1);
        Persona p2 = new Persona(2,44,"Jose",d2);
        Persona p3 = new Persona(3,55,"Anuel",d3);
/*
        direccionRepositorio.insert(d1);
        personaRepositorio.insert(p1);
*/
      //  System.out.println(personaRepositorio.getPersonaById(1));
        direccionRepositorio.delete(1);
        personaRepositorio.delete(1);


        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
