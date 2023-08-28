package main.Integrador.DAO;

import java.util.ArrayList;

public interface DAO{
    //	CRUD
    void insert(DAO d);
    void update(DAO d);
    void delete(DAO d);
    ArrayList getAll();
    DAO get(int id);
    void crearTabla();

}
