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
public class Employe extends ObjectBdd{
    private String idEmploye;
    private String nom;
    private String prenom;
    private String dtn;
    private String dateEmbauche;

    public Employe() {
    }

    public Employe(String idEmploye, String nom, String prenom, String dtn, String dateEmbauche) {
        this.idEmploye = idEmploye;
        this.nom = nom;
        this.prenom = prenom;
        this.dtn = dtn;
        this.dateEmbauche = dateEmbauche;
    }

    public String getIdEmploye() {
        return idEmploye;
    }

    public void setIdEmploye(String idEmploye) {
        this.idEmploye = idEmploye;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getDtn() {
        return dtn;
    }

    public void setDtn(String dtn) {
        this.dtn = dtn;
    }

    public String getDateEmbauche() {
        return dateEmbauche;
    }

    public void setDateEmbauche(String dateEmbauche) {
        this.dateEmbauche = dateEmbauche;
    }
    
    public void Save (Connection c,String id, String nom, String prenom, String date, String embauche) throws Exception{
        String sql = "insert into employe (idemploye, nom, prenom, dtn, dateembauche) values(' "+id+"','"+nom+"','"+prenom+"','"+date+"','"+embauche+"')";
        PreparedStatement ps = c.prepareStatement(sql);
        int exec = ps.executeUpdate();
    }
    
    public ArrayList<Employe> getEmploye (Connection c ) throws Exception{
        String sql = "select * from employe";
        PreparedStatement ps = c.prepareStatement(sql);
        ResultSet res = ps.executeQuery();
        ArrayList<Employe> liste = new ArrayList<>();
        while(res.next()){
            Employe e = new Employe(res.getString(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5));
            liste.add(e);
        }
        return liste;
    }
    public ArrayList<Employe> getEmploye (Connection c, String idEmploye ) throws Exception{
        String sql = "select * from employe where idEmploye ='"+idEmploye+"'";
        PreparedStatement ps = c.prepareStatement(sql);
        ResultSet res = ps.executeQuery();
        ArrayList<Employe> liste = new ArrayList<>();
        while(res.next()){
            Employe e = new Employe(res.getString(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5));
            liste.add(e);
        }
        return liste;
    }
}
