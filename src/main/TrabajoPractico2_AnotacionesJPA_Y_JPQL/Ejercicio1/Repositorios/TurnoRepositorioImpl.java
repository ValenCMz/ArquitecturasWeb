package main.TrabajoPractico2_AnotacionesJPA_Y_JPQL.Ejercicio1.Repositorios;

import main.TrabajoPractico2_AnotacionesJPA_Y_JPQL.Ejercicio1.DTO.TurnoDTO;
import main.TrabajoPractico2_AnotacionesJPA_Y_JPQL.Ejercicio1.Modelo.Turno;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TurnoRepositorioImpl implements TurnoRepositorio {

    @PersistenceContext
    private EntityManager em;

    public TurnoRepositorioImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public void insert(Turno d) {
        em.persist(d);
    }

    @Override
    public TurnoDTO getTurnoDTOById(int id) {
        Turno t = em.find(Turno.class,id);
        TurnoDTO toReturn = new TurnoDTO(t.getId(),t.getFecha());
        return toReturn;
    }


    private Turno getTurnoById(int id){
        return em.find(Turno.class,id);
    }

    @Override
    public List<TurnoDTO> getTurnos() {
        List<TurnoDTO>toReturn = new ArrayList<>();
        List<Turno>turnos = em.createQuery("SELECT t from Turno t",Turno.class).getResultList();
        for(Turno t: turnos){
            toReturn.add(new TurnoDTO(t.getId(),t.getFecha()));
        }
        return toReturn;
    }

    @Override
    public void delete(int id) {
        Turno t = this.getTurnoById(id);
        if(t!=null){
            em.remove(t);
        }
    }
}
