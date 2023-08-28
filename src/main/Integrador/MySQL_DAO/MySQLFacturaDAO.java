package main.Integrador.MySQL_DAO;

import main.Integrador.DAO.DAO;
import main.Integrador.DAO.FacturaDAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class MySQLFacturaDAO implements FacturaDAO {
    private Connection conn;

    public MySQLFacturaDAO(Connection conn) {
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

        String create =
               " CREATE TABLE IF NOT EXISTS factura(" + "idFactura INT,"+
                "idCLiente int,"+
                "PRIMARY KEY(idFactura),"+
                "FOREIGN KEY (idCliente) REFERENCES cliente(idCliente))";
        try {
            conn.setAutoCommit(false);
            conn.prepareStatement(create).execute();
            conn.commit();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
