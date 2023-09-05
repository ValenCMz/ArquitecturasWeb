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
public class DireccionRepositorioImpl implements DireccionRepositorio {

    @PersistenceContext
    private EntityManager em;

    public DireccionRepositorioImpl(EntityManager em){
        this.em = em;
    }

    @Override
    @Transactional
    public void insert(Direccion d) {
        em.persist(d);
    }

    @Override
    public DireccionDTO getDireccionDtoById(int id) {
        Direccion d =em.find(Direccion.class,id);
        DireccionDTO dt = new DireccionDTO(d.getId(),d.getCalle(),d.getCiudad());
        return dt;
    }

    private Direccion getDireccionById(int id){
        return em.find(Direccion.class,id);
    }

    @Override
    public List<DireccionDTO> getDirecciones() {
        List<DireccionDTO>toReturn = new ArrayList<>();
        List<Direccion> d = em.createQuery("SELECT d FROM Direccion d", Direccion.class).getResultList();
        for (Direccion d1:d) {
           DireccionDTO n = new DireccionDTO(d1.getId(),d1.getCalle(), d1.getCiudad());
           toReturn.add(n);
        }
        return toReturn;
    }

    @Override
    @Transactional
    public void delete(int id) {
        Direccion d = this.getDireccionById(id);
        if(d!=null){
            em.remove(d);
        }
    }
}
