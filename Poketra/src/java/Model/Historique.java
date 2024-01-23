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
public class Historique {
    private int idHistorique;
    private String dateh;
    private String idMatiere;
    private double reste;

    public Historique() {
    }

    public Historique(int idHistorique, String dateh, String idMatiere, double reste) {
        this.idHistorique = idHistorique;
        this.dateh = dateh;
        this.idMatiere = idMatiere;
        this.reste = reste;
    }

    public int getIdHistorique() {
        return idHistorique;
    }

    public void setIdHistorique(int idHistorique) {
        this.idHistorique = idHistorique;
    }

    public String getDateh() {
        return dateh;
    }

    public void setDateh(String dateh) {
        this.dateh = dateh;
    }

    public String getIdMatiere() {
        return idMatiere;
    }

    public void setIdMatiere(String idMatiere) {
        this.idMatiere = idMatiere;
    }

    public double getReste() {
        return reste;
    }

    public void setReste(double reste) {
        this.reste = reste;
    }
    
    public void Save (Connection c, String dateh, String idMatiere, double reste) throws Exception{
        String sql = "insert into historique (dateh,idMatiere,reste) values('"+dateh+"','"+idMatiere+"',"+reste+")";
        PreparedStatement ps = c.prepareStatement(sql);
        int exec = ps.executeUpdate();
    }
    
    public ArrayList<Historique> getHistorique (Connection c, String idMatiere) throws Exception{
        String sql ="select * from historique where idMatiere = '"+idMatiere+"'";
        PreparedStatement ps = c.prepareStatement(sql);
        ArrayList<Historique> liste = new ArrayList<>();
        ResultSet res = ps.executeQuery();
        while(res.next()){
            Historique h = new Historique(res.getInt(1), res.getString(2), res.getString(3), res.getDouble(4));
            liste.add(h);
        }
        return liste;
    }
    
    public ArrayList<Historique> getHistorique (Connection c) throws Exception{
        String sql ="select * from historique";
        PreparedStatement ps = c.prepareStatement(sql);
        ArrayList<Historique> liste = new ArrayList<>();
        ResultSet res = ps.executeQuery();
        while(res.next()){
            Historique h = new Historique(res.getInt(1), res.getString(2), res.getString(3), res.getDouble(4));
            liste.add(h);
        }
        return liste;
    }
    
}
