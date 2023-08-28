package main.Integrador.Main;

import main.Integrador.DAO.DAOFactory;
import main.Integrador.MySQL_DAO.MySQLManagerDAO;

public class main {
    public static void main(String[]args)
    {
        DAOFactory df = DAOFactory.getDAOManagerMYSQL();
        df.getClienteDAO().crearTabla();
        df.getProductoDAO().crearTabla();
        df.getFacturaDAO().crearTabla();
        df.getFacturaProductoDAO().crearTabla();
    }
}
