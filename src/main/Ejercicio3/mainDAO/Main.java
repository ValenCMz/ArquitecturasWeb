package main.Ejercicio3.mainDAO;


import main.Ejercicio3.DAO.DAOManager;
import main.Ejercicio3.Modelo.Persona;
import main.Ejercicio3.MySQL_DAO.MySQLManagerDAO;

import java.util.ArrayList;


public class Main {

    public Main() {
        // TODO Auto-generated constructor stub
    }
    public static void main(String[]args) {
        DAOManager dao = DAOManager.getDAOManagerMYSQL();
        System.out.println(dao.getPersonaDao().getAll());

        Persona p = new Persona();
        p.setId(1);
        p.setNombre("Alan");
        p.setEdad(44);
    }

}