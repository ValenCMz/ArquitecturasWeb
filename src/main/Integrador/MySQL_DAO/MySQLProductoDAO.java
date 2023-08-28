package main.Integrador.MySQL_DAO;

import main.Integrador.DAO.DAO;
import main.Integrador.DAO.ProductoDAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class MySQLProductoDAO implements ProductoDAO {
    private Connection conn;

    public MySQLProductoDAO(Connection conn) {
        this.conn = conn;
    }
    @Override
    public void insert(DAO d) {

    }

    @Override
    public void update(DAO d) {

    }

    @Override
    public void delete(DAO d) {

    }

    @Override
    public ArrayList getAll() {
        return null;
    }

    @Override
    public DAO get(int id) {
        return null;
    }

    @Override
    public void crearTabla() {

        String create = "CREATE TABLE IF NOT EXISTS producto("+ "idProducto INT,"
                + "nombre VARCHAR(45),"+ "valor float," +
                "PRIMARY KEY(idProducto))";
        try {
            conn.setAutoCommit(false);
            conn.prepareStatement(create).execute();
            conn.commit();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
