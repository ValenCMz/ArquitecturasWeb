package main.Ejercicio1;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class SelectPersona {

    public SelectPersona() {
        // TODO Auto-generated constructor stub
    }

    public static void main(String[] args) {

        String driver = "com.mysql.cj.jdbc.Driver";
        try {
            Class.forName(driver).getDeclaredConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
                 | NoSuchMethodException | SecurityException | ClassNotFoundException e) {
            e.printStackTrace();
            System.exit(1);
        }

        String uri = "jdbc:mysql://localhost:3306/BaseDeDatosArquitectura";
        try {
            //Creo la coneccion
            Connection conn = DriverManager.getConnection(uri, "admin","admin");
            conn.setAutoCommit(false);

            String select = "SELECT * FROM persona";

            //traigo el estado de preparacion
            PreparedStatement ps = conn.prepareStatement(select);
            //Resultado de ejecutar la query, a esto puedo acceder para imprimir los dato
            ResultSet rs = ps.executeQuery();

            //Imprimo los datos de la consulta
            while(rs.next()) {
                System.out.println(rs.getInt(1)+", " + rs.getString(2) + ", " + rs.getInt(3));
            }

            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return;
    }

}
