package main.Integrador.DAO;


import main.Integrador.MySQL_DAO.MySQLManagerDAO;

public abstract class DAOFactory {
    private static MySQLManagerDAO connMYSQL = null;

    public abstract ClienteDAO getClienteDAO();
    public abstract FacturaDAO getFacturaDAO();
    public abstract FacturaProductoDAO getFacturaProductoDAO();
    public abstract ProductoDAO getProductoDAO();

    public static DAOFactory getDAOManagerMYSQL(){
        if(connMYSQL==null){
            connMYSQL = new MySQLManagerDAO("localhost", "admin", "admin", "BaseDeDatosArquitectura");
        }
        return connMYSQL;
    }
}
