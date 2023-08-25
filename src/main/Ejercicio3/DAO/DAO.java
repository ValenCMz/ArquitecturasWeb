package main.Ejercicio3.DAO;


import java.util.ArrayList;

public interface DAO<T,K> {

    //	CRUD
    void insert(T d);
    void update(T d);
    void delete(T d);
    ArrayList getAll();
    T get(K id);

}
