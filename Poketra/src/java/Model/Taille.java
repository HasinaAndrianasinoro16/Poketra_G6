/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
import java.sql.*;
import java.util.*;
import Bdd.*;
/**
 *
 * @author toxic
 */
public class Taille {
    int idTaille;
    String taille;

    public Taille() {
    }

    public Taille(int idTaille, String taille) {
        this.idTaille = idTaille;
        this.taille = taille;
    }

    public int getIdTaille() {
        return idTaille;
    }

    public void setIdTaille(int idTaille) {
        this.idTaille = idTaille;
    }

    public String getTaille() {
        return taille;
    }

    public void setTaille(String taille) {
        this.taille = taille;
    }
    
    public  ArrayList<Taille> getTailles(Connection c) throws Exception{
        String sql = "select * from taille";
        PreparedStatement ps = c.prepareStatement(sql);
        ResultSet res = ps.executeQuery();
        ArrayList<Taille> liste = new ArrayList<>();
        while(res.next()){
            Taille t = new Taille(res.getInt(1), res.getString(2));
            liste.add(t);
        }
        return  liste;
    }
}
