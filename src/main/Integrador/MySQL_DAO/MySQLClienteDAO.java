package main.Integrador.MySQL_DAO;

import main.Integrador.DAO.ClienteDAO;
import main.Integrador.DAO.DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class MySQLClienteDAO implements ClienteDAO {

    private Connection conn;

    public MySQLClienteDAO(Connection conn) {
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

        String create = "CREATE TABLE IF NOT EXISTS cliente("+ "idCliente INT,"
                + "nombre VARCHAR(500),"+ "email VARCHAR(150)," +
                "PRIMARY KEY(idCliente))";
        try {
            conn.setAutoCommit(false);
            conn.prepareStatement(create).execute();
            conn.commit();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
