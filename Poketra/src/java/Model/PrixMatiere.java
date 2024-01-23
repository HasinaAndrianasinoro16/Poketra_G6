/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
import java.sql.*;
import java.util.*;
/**
 *
 * @author toxic
 */
public class PrixMatiere {
    String idMatiere;
    double prix;

    public PrixMatiere() {
    }

    public PrixMatiere(String idMatiere, double prix) {
        this.idMatiere = idMatiere;
        this.prix = prix;
    }

    public String getIdMatiere() {
        return idMatiere;
    }

    public void setIdMatiere(String idMatiere) {
        this.idMatiere = idMatiere;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }
    
    public ArrayList<PrixMatiere> getPrixMatiere (Connection c, String idMatiere)throws Exception{
        String sql = "select * from prixMatiere where idMatiere ='"+idMatiere+"'";
        PreparedStatement ps = c.prepareStatement(sql);
        ArrayList<PrixMatiere> liste = new ArrayList<>();
        ResultSet res = ps.executeQuery();
        while(res.next()){
            PrixMatiere pm = new PrixMatiere(res.getString(1),res.getDouble(2));
            liste.add(pm);
        }
        return liste;
    }
}
