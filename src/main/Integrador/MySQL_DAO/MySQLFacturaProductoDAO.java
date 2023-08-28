package main.Integrador.MySQL_DAO;

import main.Integrador.DAO.DAO;
import main.Integrador.DAO.FacturaProductoDAO;
import main.Integrador.Modelo.Factura_Producto;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class MySQLFacturaProductoDAO implements FacturaProductoDAO {

    private Connection conn;

    public MySQLFacturaProductoDAO(Connection conn) {
        this.conn = conn;
    }



    @Override
    public void insert(Factura_Producto d) {

    }

    @Override
    public void update(Factura_Producto d) {

    }

    @Override
    public void delete(Factura_Producto d) {

    }

    @Override
    public ArrayList getAll() {
        return null;
    }

    @Override
    public void crearTabla() {
        String create = "CREATE TABLE IF NOT EXISTS factura_producto("+ "idFactura INT,"
                + "idProducto int,"+ "cantidad int," +
                "PRIMARY KEY(idFactura,idProducto),"+
        "FOREIGN KEY(idFactura) REFERENCES factura(idFactura),"+
        "FOREIGN KEY(idProducto)REFERENCES producto(idProducto))";
        try {
            conn.setAutoCommit(false);
            conn.prepareStatement(create).execute();
            conn.commit();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
