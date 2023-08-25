package main.Ejercicio1;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertPersona {

    public static void main(String[] args) {

        String driver = "com.mysql.cj.jdbc.Driver";
        try {
            Class.forName(driver).getDeclaredConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
                 | NoSuchMethodException | SecurityException | ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.exit(1);
        }

        //configuramos la direccion donde esta la base de datos
        //Orden: protocolo, nombre de la bd y una parametro por si no existe que la cree
        String uri = "jdbc:mysql://localhost:3306/BaseDeDatosArquitectura";
        try {
            //Creo la coneccion
            Connection conn = DriverManager.getConnection(uri, "admin","admin");
            conn.setAutoCommit(false);

            addPerson(conn, 2,"Juan",22);
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return;
    }


    private static void addPerson(Connection conn, int id, String name, int years) throws SQLException{
        String insert = "INSERT INTO persona (id,nombre,edad) VALUES(?,?,?)";

        PreparedStatement ps = conn.prepareStatement(insert);
        //Seteamos los parametros
        ps.setInt(1, id);
        ps.setString(2, name);
        ps.setInt(3, years);
        ps.executeUpdate();
        ps.close();
        conn.commit();



    }
}

