package main.TrabajoPractico2_AnotacionesJPA_Y_JPQL.Ejercicio3.Repositorios;

import main.TrabajoPractico2_AnotacionesJPA_Y_JPQL.Ejercicio3.DTO.EquipoDTO;
import main.TrabajoPractico2_AnotacionesJPA_Y_JPQL.Ejercicio3.Entidades.Equipo;
import main.TrabajoPractico2_AnotacionesJPA_Y_JPQL.Ejercicio3.Entidades.Jugador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class EquipoRepositorioImpl implements EquipoRepositorio{

    private EntityManager em;

    public EquipoRepositorioImpl(EntityManager em){
        this.em = em;
    }

    @Override
    public void insert(Equipo e) {
        em.persist(e);
    }

    @Override
    public List<EquipoDTO> getEquipos() {
        return em.createQuery("SELECT EquipoDTO(e.id,e.nombre,e.jugadores,e.torneo)FROM Equipo e",EquipoDTO.class).getResultList();
    }

    @Override
    public EquipoDTO getEquipoDTOById(int id) {
        return em.find(EquipoDTO.class,id);
    }

    private Equipo getEquipoById(int id){
        return em.find(Equipo.class,id);
    }

    @Override
    public void delete(int id) {
        Equipo e = this.getEquipoById(id);
        if(e!=null){
            em.remove(e);
        }
    }

    @Override
    public void agregarJugadorAEquipo(int equipoId, int jugadorId) {
        Equipo equipo = this.getEquipoById(equipoId);
        Jugador jugador = em.find(Jugador.class,jugadorId);

        if(equipo!=null&&jugador!=null){
            equipo.getJugadores().add(jugador);
            jugador.setEquipo(equipo);

            this.insert(equipo);
            em.persist(jugador);
        }
    }


}
