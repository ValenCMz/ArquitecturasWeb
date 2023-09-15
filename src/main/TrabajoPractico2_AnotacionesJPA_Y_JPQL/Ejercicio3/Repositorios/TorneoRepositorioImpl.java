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

    @Override
    public void insert(Torneo e) {

    }

    @Override
    public List<TorneoDTO> getTorneos() {
        return null;
    }

    @Override
    public TorneoDTO getTorneoDTOById(int id) {
        return null;
    }

    private Torneo getTorneoById(int id){
        return null;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void addEquipoATorneo(int equipoId, int torneoId) {
        Equipo equipo = em.find(Equipo.class,equipoId);
        Torneo torneo = this.getTorneoById(torneoId);
        if(equipo!=null&&torneo!=null){
            equipo.setTorneo(torneo);
            torneo.getEquipos().add(equipo);
        }
    }
}
