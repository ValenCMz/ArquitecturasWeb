package main.Integrador.DAO;

import java.util.ArrayList;

public interface DAO<T>{
    //	CRUD
    void insert(T d);
    void update(T d);
    void delete(T d);
    ArrayList getAll();
    void crearTabla();

}
