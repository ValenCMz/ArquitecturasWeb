package main.TrabajoPractico2_AnotacionesJPA_Y_JPQL.Ejercicio1.Repositorios;

import main.TrabajoPractico2_AnotacionesJPA_Y_JPQL.Ejercicio1.DTO.DireccionDTO;
import main.TrabajoPractico2_AnotacionesJPA_Y_JPQL.Ejercicio1.DTO.SocioDTO;
import main.TrabajoPractico2_AnotacionesJPA_Y_JPQL.Ejercicio1.Modelo.Direccion;
import main.TrabajoPractico2_AnotacionesJPA_Y_JPQL.Ejercicio1.Modelo.Socio;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Repository
public class SocioRepositorioImpl implements SocioRepositorio{
    @PersistenceContext
    private EntityManager em;

    public SocioRepositorioImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    @Transactional
    public void insert(Socio s) {
        em.persist(s);
    }

    @Override
    public SocioDTO getSocioDtoById(int id) {
        Socio s = em.find(Socio.class,id);
        return new SocioDTO(s.getTipo(),s.getPersona().getId());
    }

    private Socio getSocioById(int id){
        return em.find(Socio.class,id);
    }

    @Override
    public List<SocioDTO> getSocios() {
        List<SocioDTO>toReturn = new ArrayList<>();
        List<Socio> d = em.createQuery("SELECT s FROM Socio s", Socio.class).getResultList();
        for (Socio d1:d) {
            SocioDTO n = new SocioDTO(d1.getTipo(),d1.getPersona().getId());
            toReturn.add(n);
        }
        return toReturn;
    }

    @Override
    public void delete(int id) {
        Socio s = this.getSocioById(id);
        if(s!=null){
            em.remove(s);
        }
    }
}
