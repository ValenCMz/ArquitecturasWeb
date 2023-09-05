package main.TrabajoPractico2_AnotacionesJPA_Y_JPQL.Ejercicio1.Repositorios;

import main.TrabajoPractico2_AnotacionesJPA_Y_JPQL.Ejercicio1.DTO.SocioDTO;
import main.TrabajoPractico2_AnotacionesJPA_Y_JPQL.Ejercicio1.Modelo.Socio;

import java.util.List;

public interface SocioRepositorio {
    public void insert(Socio s);
    public SocioDTO getSocioDtoById(int id);

    public List<SocioDTO> getSocios();

    public void delete(int id);
}
