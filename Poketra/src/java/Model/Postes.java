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
public class Postes {
    private int IdPoste;
    private String idOuvrier;
    private String ouvrier;
    private String idEmploye;
    private String nom;
    private String prenom;
    private String dateEmbauche;
    private String dtn;

    public Postes() {
    }

    public Postes(int IdPoste, String idOuvrier, String ouvrier, String idEmploye, String nom, String prenom, String dateEmbauche, String dtn) {
        this.IdPoste = IdPoste;
        this.idOuvrier = idOuvrier;
        this.ouvrier = ouvrier;
        this.idEmploye = idEmploye;
        this.nom = nom;
        this.prenom = prenom;
        this.dateEmbauche = dateEmbauche;
        this.dtn = dtn;
    }

    public int getIdPoste() {
        return IdPoste;
    }

    public void setIdPoste(int IdPoste) {
        this.IdPoste = IdPoste;
    }

    public String getIdOuvrier() {
        return idOuvrier;
    }

    public void setIdOuvrier(String idOuvrier) {
        this.idOuvrier = idOuvrier;
    }

    public String getOuvrier() {
        return ouvrier;
    }

    public void setOuvrier(String ouvrier) {
        this.ouvrier = ouvrier;
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

    public String getDateEmbauche() {
        return dateEmbauche;
    }

    public void setDateEmbauche(String dateEmbauche) {
        this.dateEmbauche = dateEmbauche;
    }

    public String getDtn() {
        return dtn;
    }

    public void setDtn(String dtn) {
        this.dtn = dtn;
    }
    
    public ArrayList<Postes> getPostes (Connection c) throws Exception{
        String sql = "select * from postes";
        PreparedStatement ps = c.prepareStatement(sql);
        ResultSet res = ps.executeQuery();
        ArrayList<Postes> liste = new ArrayList<>();
        while(res.next()){
            Postes p = new Postes(res.getInt(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5), res.getString(6), res.getString(7), res.getString(8));
            liste.add(p);
        }
        return liste;
       }
}
