package main.Ejercicio3.MySQL_DAO;


import main.Ejercicio3.DAO.DAOManager;
import main.Ejercicio3.DAO.PersonaDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLManagerDAO extends DAOManager {

    private Connection conn;
    private PersonaDAO persona = null;

    //Con esto me conecto a la base de datos
    public MySQLManagerDAO(String host, String username, String password, String database) {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://" + host + "/" + database,username,password);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.exit(1);
        }
    }

    //Utilizo el patron singleton para crear solo una instancia de este objeto
    @Override
    public PersonaDAO getPersonaDao() {
        if(persona ==null) {
            persona = new MySQLPersonaDAO(conn);
        }
        return persona;
    }



}