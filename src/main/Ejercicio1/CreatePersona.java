package main.Ejercicio1;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CreatePersona {

    public static void main(String[] args) {
        //Registramos el driver

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
        //Orden: protocolo, nombre de la bd
        String uri = "jdbc:mysql://localhost:3306/BaseDeDatosArquitectura";
        try {
            //Creo la coneccion
            Connection conn = DriverManager.getConnection(uri, "admin","admin");
            conn.setAutoCommit(false);

            String table = "CREATE TABLE persona(" + "id INT, "
                    + "nombre VARCHAR(500),"
                    + "edad INT, "
                    + "PRIMARY KEY(id))";

            conn.prepareStatement(table).execute();
            //refleja en la base de datos los cambios
            conn.commit();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return;
    }

}
