package main.Ejercicio3.DAO;


import main.Ejercicio3.MySQL_DAO.MySQLManagerDAO;

public abstract class DAOManager {
    private static MySQLManagerDAO connMYSQL = null;
    public abstract PersonaDAO getPersonaDao();

    public static DAOManager getDAOManagerMYSQL(){
        if(connMYSQL==null){
            connMYSQL = new MySQLManagerDAO("localhost", "admin", "admin", "BaseDeDatosArquitectura");
        }
        return connMYSQL;
    }
}
