package main.Integrador.Main;

import main.Integrador.DAO.DAOFactory;
import main.Integrador.MySQL_DAO.MySQLManagerDAO;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.IOException;

public class main {
    public static void main(String[]args)
    {
        DAOFactory df = DAOFactory.getDAOManagerMYSQL();
        df.getClienteDAO().crearTabla();
        df.getProductoDAO().crearTabla();
        df.getFacturaDAO().crearTabla();
        df.getFacturaProductoDAO().crearTabla();


        CSVParser parser = null;
        try {
            parser = CSVFormat.DEFAULT.withHeader().parse(new
                    FileReader("src/main/Integrador/productos.csv"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        for(CSVRecord row: parser) {
            System.out.println(row.get("idProducto"));
            System.out.println(row.get("nombre"));
            System.out.println(row.get("valor"));
        }
    }
}
