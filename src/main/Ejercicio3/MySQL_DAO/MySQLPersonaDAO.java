package main.Ejercicio3.MySQL_DAO;


import main.Ejercicio3.DAO.PersonaDAO;
import main.Ejercicio3.Modelo.Persona;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MySQLPersonaDAO implements PersonaDAO {

    private Connection conn;

    public MySQLPersonaDAO(Connection conn) {
        this.conn = conn;
    }


    @Override
    public void insert(Persona p) {
        PreparedStatement ps = null;
        String insert = "INSERT INTO persona(id,nombre,edad) VALUES (?,?,?)";
        try {
            ps = conn.prepareStatement(insert);
            ps.setInt(1, p.getId());
            ps.setString(2, p.getNombre());
            ps.setInt(3, p.getEdad());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Persona p) {
        PreparedStatement ps = null;
        String update = "UPDATE persona SET nombre=?,edad=? WHERE id = ?";
        try {
            ps = conn.prepareStatement(update);
            ps.setString(1, p.getNombre());
            ps.setInt(2, p.getEdad());
            ps.setInt(3, p.getId());
            ps.executeUpdate();

        }catch(SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Persona p) {
        String delete ="DELETE FROM persona WHERE id = ?";
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(delete);
            ps.setInt(1, p.getId());
            ps.executeUpdate();
        }catch(SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<Persona> getAll() {
        String getAll = "SELECT * FROM persona";
        ArrayList<Persona>toReturn = new ArrayList<>();
        try {
            PreparedStatement ps = conn.prepareStatement(getAll);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                Persona p = new Persona(rs.getInt(1),rs.getString(2),rs.getInt(3));
                toReturn.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return toReturn;
    }

    @Override
    public Persona get(Integer id) {
        String get = "SELECT * FROM persona WHERE id = ?";
        Persona toReturn = null;
        try {
            PreparedStatement ps = conn.prepareStatement(get);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                Persona p = new Persona(rs.getInt(1),rs.getString(2),rs.getInt(3));
                toReturn = p;
            }
        }catch(SQLException e) {
            e.printStackTrace();
        }
        return toReturn;
    }

}
