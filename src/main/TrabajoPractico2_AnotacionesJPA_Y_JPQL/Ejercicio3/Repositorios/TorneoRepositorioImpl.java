package main.TrabajoPractico2_AnotacionesJPA_Y_JPQL.Ejercicio3.Repositorios;

import main.TrabajoPractico2_AnotacionesJPA_Y_JPQL.Ejercicio3.DTO.TorneoDTO;
import main.TrabajoPractico2_AnotacionesJPA_Y_JPQL.Ejercicio3.Entidades.Equipo;
import main.TrabajoPractico2_AnotacionesJPA_Y_JPQL.Ejercicio3.Entidades.Torneo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class TorneoRepositorioImpl implements TorneoRepositorio {

    private EntityManager em;

    public TorneoRepositorioImpl(EntityManager em){
        this.em = em;
    }

    @Override
    public void insert(Torneo e) {
        em.persist(e);
    }

    @Override
    public List<TorneoDTO> getTorneos() {
        return em.createQuery("SELECT TorneoDTO(t.id,t.nombre) FROM Torneo t",TorneoDTO.class).getResultList();
    }

    @Override
    public TorneoDTO getTorneoDTOById(int id) {
        Torneo t = em.find(Torneo.class,id);
        return new TorneoDTO(t.getId(),t.getNombre());
    }

    private Torneo getTorneoById(int id){
        return em.find(Torneo.class,id);
    }

    @Override
    public void delete(int id) {
        Torneo t = this.getTorneoById(id);
        if(t!=null){
            em.remove(t);
        }
    }

    @Override
    public void addEquipoATorneo(int equipoId, int torneoId) {
        Equipo equipo = em.find(Equipo.class,equipoId);
        Torneo torneo = this.getTorneoById(torneoId);
        if(equipo!=null&&torneo!=null){
            equipo.setTorneo(torneo);
            torneo.getEquipos().add(equipo);

            em.persist(equipo);
            this.insert(torneo);
        }
    }
}
