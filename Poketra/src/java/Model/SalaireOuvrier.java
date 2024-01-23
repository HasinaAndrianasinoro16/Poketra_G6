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
public class SalaireOuvrier {
    private int idSalaireOuvrier;
    private String idOuvrier;
    private double salaire;

    public SalaireOuvrier() {
    }

    public SalaireOuvrier(int idSalaireOuvrier, String idOuvrier, double salaire) {
        this.idSalaireOuvrier = idSalaireOuvrier;
        this.idOuvrier = idOuvrier;
        this.salaire = salaire;
    }

    public int getIdSalaireOuvrier() {
        return idSalaireOuvrier;
    }

    public void setIdSalaireOuvrier(int idSalaireOuvrier) {
        this.idSalaireOuvrier = idSalaireOuvrier;
    }

    public String getIdOuvrier() {
        return idOuvrier;
    }

    public void setIdOuvrier(String idOuvrier) {
        this.idOuvrier = idOuvrier;
    }

    public double getSalaire() {
        return salaire;
    }

    public void setSalaire(double salaire) {
        this.salaire = salaire;
    }
    
    public void Save(Connection c, String idOuvrier, double Salaire) throws Exception{
        String sql ="insert into salaireOuvrier (idOuvrier,salaire) values ('"+idOuvrier+"',"+Salaire+")";
        PreparedStatement ps = c.prepareStatement(sql);
        int exec = ps.executeUpdate();
    }
    
    public ArrayList<SalaireOuvrier> getSalaireOuvrier(Connection c, String idOuvrier) throws Exception{
        String sql ="select * from salaireOuvrier where idouvrier ='"+idOuvrier+"'";
        PreparedStatement ps = c.prepareStatement(sql);
        ResultSet res = ps.executeQuery();
        ArrayList<SalaireOuvrier> liste = new ArrayList<>();
        while(res.next()){
            SalaireOuvrier so = new SalaireOuvrier(res.getInt(1), res.getString(2), res.getDouble(3));
            liste.add(so);
        }
        return liste;
    }
}
