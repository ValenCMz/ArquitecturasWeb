package main.Ejercicio3.mainDAO;


import main.Ejercicio3.Modelo.Persona;
import main.Ejercicio3.MySQL_DAO.MySQLManagerDAO;

import java.util.ArrayList;


public class Main {

    public Main() {
        // TODO Auto-generated constructor stub
    }
    public static void main(String[]args) {
        MySQLManagerDAO man = new MySQLManagerDAO("localhost", "admin", "admin", "BaseDeDatosArquitectura");

        Persona p = new Persona();
        p.setId(1);
        p.setNombre("Alan");
        p.setEdad(44);

        //Tragio la instancia
        ArrayList<Persona> listp =  man.getPersonaDao().getAll();
        System.out.println(listp);


        Persona p1 = man.getPersonaDao().get(2);
        System.out.println(p1);
    }

}