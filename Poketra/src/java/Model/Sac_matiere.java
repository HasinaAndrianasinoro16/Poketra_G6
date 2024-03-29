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
public class Sac_matiere {
    String idSac;
    String nomSac;
    String matiere;
    String idMatiere;
    String Taille;
    double quantite;

    public Sac_matiere() {
    }

    public Sac_matiere(String idSac, String nomSac, String matiere, String idMatiere, String Taille, double quantite) {
        this.idSac = idSac;
        this.nomSac = nomSac;
        this.matiere = matiere;
        this.idMatiere = idMatiere;
        this.Taille = Taille;
        this.quantite = quantite;
    }

    public String getIdSac() {
        return idSac;
    }

    public void setIdSac(String idSac) {
        this.idSac = idSac;
    }

    public String getNomSac() {
        return nomSac;
    }

    public void setNomSac(String nomSac) {
        this.nomSac = nomSac;
    }

    public String getMatiere() {
        return matiere;
    }

    public void setMatiere(String matiere) {
        this.matiere = matiere;
    }

    public String getIdMatiere() {
        return idMatiere;
    }

    public void setIdMatiere(String idMatiere) {
        this.idMatiere = idMatiere;
    }

    public String getTaille() {
        return Taille;
    }

    public void setTaille(String Taille) {
        this.Taille = Taille;
    }

    public double getQuantite() {
        return quantite;
    }

    public void setQuantite(double quantite) {
        this.quantite = quantite;
    }
    
    public ArrayList<Sac_matiere> getSacMatiere (Connection c) throws Exception{
        String sql = "select * from sac_matiere";
        PreparedStatement ps = c.prepareStatement(sql);
        ResultSet res = ps.executeQuery();
        ArrayList<Sac_matiere> liste = new ArrayList<>();
        while(res.next()){
            Sac_matiere sm = new Sac_matiere(res.getString(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5), res.getDouble(6));
            liste.add(sm);
        }
        return liste;
    }
    public ArrayList<Sac_matiere> getSacMatiereByMatiere (Connection c, String matiere) throws Exception{
        String sql = "select * from sac_matiere where idMatiere = '"+matiere+"'";
        PreparedStatement ps = c.prepareStatement(sql);
        ResultSet res = ps.executeQuery();
        ArrayList<Sac_matiere> liste = new ArrayList<>();
        while(res.next()){
            Sac_matiere sm = new Sac_matiere(res.getString(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5), res.getDouble(6));
            liste.add(sm);
        }
        return liste;
    }
    
    public ArrayList<Sac_matiere> getSacMatiere(Connection c, String idSac) throws Exception{
        String sql ="select * from sac_matiere where idSac = '"+idSac+"'";
        PreparedStatement ps = c.prepareStatement(sql);
        ResultSet res = ps.executeQuery();
        ArrayList<Sac_matiere> liste = new ArrayList<>();
        while(res.next()){
            Sac_matiere sm = new Sac_matiere(res.getString(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5), res.getDouble(6));
            liste.add(sm);
        }
        return liste;
    }
    
    public ArrayList<Sac_matiere> getSacMatiere(Connection c, String idSac, String taille) throws Exception{
        String sql ="select * from sac_matiere where idSac = '"+idSac+"' and taille='"+taille+"'";
        PreparedStatement ps = c.prepareStatement(sql);
        ResultSet res = ps.executeQuery();
        ArrayList<Sac_matiere> liste = new ArrayList<>();
        while(res.next()){
            Sac_matiere sm = new Sac_matiere(res.getString(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5), res.getDouble(6));
            liste.add(sm);
        }
        return liste;
    }
    
 public double getPrixSac(Connection c, String idSac, String Taille) throws Exception {
    PrixMatiere pm = new PrixMatiere();
    double prix = 0.0;
    ArrayList<Sac_matiere> listesac = this.getSacMatiere(c, idSac, Taille);
    double totalPrixMatiere = 0.0; 
    for (int i = 0; i < listesac.size(); i++) {
        
        ArrayList<PrixMatiere> listePrix = pm.getPrixMatiere(c, listesac.get(i).getIdMatiere());

        for (int j = 0; j < listePrix.size(); j++) {
//            System.out.println(listePrix.get(j).getPrix());
            totalPrixMatiere += listePrix.get(j).getPrix();
        }

        double resultat = totalPrixMatiere * listesac.get(i).getQuantite();
        prix += resultat;
    }

    return prix;
}



    
 
}

