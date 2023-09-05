package main.TrabajoPractico2_AnotacionesJPA_Y_JPQL.Ejercicio1.Repositorios;

import main.TrabajoPractico2_AnotacionesJPA_Y_JPQL.Ejercicio1.DTO.DireccionDTO;
import main.TrabajoPractico2_AnotacionesJPA_Y_JPQL.Ejercicio1.DTO.PersonaDTO;
import main.TrabajoPractico2_AnotacionesJPA_Y_JPQL.Ejercicio1.Modelo.Direccion;
import main.TrabajoPractico2_AnotacionesJPA_Y_JPQL.Ejercicio1.Modelo.Persona;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;


@Repository
public class PersonaRepositorioImpl implements PersonaRepositorio{
    @PersistenceContext
    private EntityManager em;

    public PersonaRepositorioImpl(EntityManager em){
        this.em = em;
    }


    @Override
    @Transactional
    public void insert(Persona p) {
        em.persist(p);
    }

    @Override
    public PersonaDTO getPersonaById(int id) {
        Persona a = em.find(Persona.class,id);
        PersonaDTO persona =  new PersonaDTO(a.getId(),a.getAnios(),a.getNombre(),a.getDomicilio().getId());
        return persona;
    }

    private Persona getPersonaByIdPrivado(int id){
        return  em.find(Persona.class,id);
    }

    @Override
    public List<PersonaDTO> getPersonas() {

        List<PersonaDTO>toReturn = new ArrayList<>();
        List<Persona> p = em.createQuery("SELECT p FROM Persona p", Persona.class).getResultList();

        for (Persona p1 : p) {
            PersonaDTO n = new PersonaDTO(p1.getId(),p1.getAnios(), p1.getNombre(),p1.getDomicilio().getId());
            toReturn.add(n);
        }
        return toReturn;
    }

    @Override
    @Transactional
    public void delete(int id) {
        Persona p = this.getPersonaByIdPrivado(id);
        if(p!=null){
            em.remove(p);
        }

    }
}
