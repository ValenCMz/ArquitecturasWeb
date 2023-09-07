package main.TrabajoPractico2_AnotacionesJPA_Y_JPQL.Ejercicio1.Repositorios;

import main.TrabajoPractico2_AnotacionesJPA_Y_JPQL.Ejercicio1.DTO.PersonaDTO;
import main.TrabajoPractico2_AnotacionesJPA_Y_JPQL.Ejercicio1.Modelo.Persona;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


public interface PersonaRepositorio {

    public void insert(Persona p);
    public PersonaDTO getPersonaById(int id);

    public List<PersonaDTO> getPersonas();

    public void delete(int id);

    public List<PersonaDTO> getPersonasAsignadasAUnTurno();
    public List<PersonaDTO> getPersonasAsignadasAUnTurnoSocio();
}
