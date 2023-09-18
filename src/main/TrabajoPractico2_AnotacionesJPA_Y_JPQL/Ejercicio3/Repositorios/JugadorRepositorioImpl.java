package main.TrabajoPractico2_AnotacionesJPA_Y_JPQL.Ejercicio3.Repositorios;

import main.TrabajoPractico2_AnotacionesJPA_Y_JPQL.Ejercicio3.DTO.JugadorDTO;
import main.TrabajoPractico2_AnotacionesJPA_Y_JPQL.Ejercicio3.Entidades.Jugador;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Repository
public class JugadorRepositorioImpl implements JugadorRepositorio{

    @PersistenceContext
    private EntityManager em;

    public JugadorRepositorioImpl(EntityManager em){
        this.em = em;
    }

    @Override
    @Transactional
    public void insert(Jugador j) {
        em.persist(j);
    }

    @Override
    public List<JugadorDTO> getJugadores() {
        return em.createQuery("SELECT JugadorDTO(j.id,j.nombre,j.posicion,j.equipo.id) FROM Jugador j",JugadorDTO.class).getResultList();
    }

    @Override
    public JugadorDTO getJugadorDTOById(int id) {
        return em.find(JugadorDTO.class,id);
    }

    private Jugador getJugadorById(int id){
        return em.find(Jugador.class,id);
    }

    @Override
    @Transactional
    public void delete(int id) {
        Jugador j = this.getJugadorById(id);
        if(j!=null){
            em.remove(j);
        }
    }

    @Override
    public List<JugadorDTO> getJugadoresPorEquipo(int id_equipo) {
        List<Jugador>jugadores = em.createQuery("SELECT  j FROM Jugador j WHERE j.equipo.id =  :equipo",Jugador.class).setParameter("equipo",id_equipo).getResultList();
        List<JugadorDTO>toReturn = new ArrayList<>();
        for(Jugador j : jugadores){
            toReturn.add(new JugadorDTO(j.getId(),j.getNombre(),j.getPosicion(),j.getEquipo().getId()));
        }
        return toReturn;
    }

    @Override
    public List<JugadorDTO> getJugadoresPorTorneo(int id_torneo) {
        List<Jugador>jugadores = em.createQuery("SELECT  j FROM Jugador j join Equipo e ON j.equipo.id = e.id WHERE e.torneo.id = :torneo ",Jugador.class).setParameter("torneo",id_torneo).getResultList();
        List<JugadorDTO>toReturn = new ArrayList<>();
        for(Jugador j : jugadores){
            toReturn.add(new JugadorDTO(j.getId(),j.getNombre(),j.getPosicion(),j.getEquipo().getId()));
        }
        return toReturn;
    }
}
