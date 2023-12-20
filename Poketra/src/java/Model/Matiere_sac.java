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
public class Matiere_sac {
    int idMatiere_sac;
    String IdSac;
    String idMatiere;
    int idTaille;
    double quantite;

    public Matiere_sac() {
    }

    public Matiere_sac(int idMatiere_sac, String IdSac, String idMatiere, int idTaille, double quantite) {
        this.idMatiere_sac = idMatiere_sac;
        this.IdSac = IdSac;
        this.idMatiere = idMatiere;
        this.idTaille = idTaille;
        this.quantite = quantite;
    }

    public int getIdMatiere_sac() {
        return idMatiere_sac;
    }

    public void setIdMatiere_sac(int idMatiere_sac) {
        this.idMatiere_sac = idMatiere_sac;
    }

    public String getIdSac() {
        return IdSac;
    }

    public void setIdSac(String IdSac) {
        this.IdSac = IdSac;
    }

    public String getIdMatiere() {
        return idMatiere;
    }

    public void setIdMatiere(String idMatiere) {
        this.idMatiere = idMatiere;
    }

    public int getIdTaille() {
        return idTaille;
    }

    public void setIdTaille(int idTaille) {
        this.idTaille = idTaille;
    }

    public double getQuantite() {
        return quantite;
    }

    public void setQuantite(double quantite) {
        this.quantite = quantite;
    }
    
    public  ArrayList<Matiere_sac> getMatiereSac (Connection c) throws Exception{
        String sql = "select * from matiere_sac";
        PreparedStatement ps = c.prepareStatement(sql);
        ResultSet res = ps.executeQuery();
        ArrayList<Matiere_sac> liste = new ArrayList<>();
        while(res.next()){
            Matiere_sac ms = new Matiere_sac(res.getInt(1), res.getString(2), res.getString(3), res.getInt(4), res.getDouble(5));
            liste.add(ms);
        }
        return liste;
    }
    
}
