/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
import Bdd.*;
import java.sql.*;
import java.util.*;
/**
 *
 * @author toxic
 */
public class Ouvrier extends ObjectBdd{
    private String idOuvrier;
    private String ouvrier;

    public Ouvrier() {
    }

    public Ouvrier(String idOuvrier, String ouvrier) {
        this.idOuvrier = idOuvrier;
        this.ouvrier = ouvrier;
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
    
    public void Save (Connection c, String idOuvrier, String ouvrier) throws Exception{
        String sql = "insert into ouvrier (idouvrier,ouvrier) values('"+idOuvrier+"','"+ouvrier+"')";
        PreparedStatement ps = c.prepareStatement(sql);
        int exec = ps.executeUpdate();
    }
    
    public ArrayList<Ouvrier> getWorker(Connection c)throws Exception{
        String sql = "select * from ouvrier";
        PreparedStatement ps = c.prepareStatement(sql);
        ResultSet res = ps.executeQuery();
        ArrayList<Ouvrier> liste = new ArrayList<>();
        while(res.next()){
            Ouvrier o = new Ouvrier(res.getString(1), res.getString(2));
            liste.add(o);
        }
        return liste;
    }
    
     public ArrayList<Ouvrier> getWorker(Connection c,String idOuvrier)throws Exception{
        String sql = "select * from ouvrier where idOuvrier ='"+idOuvrier+"'";
        PreparedStatement ps = c.prepareStatement(sql);
        ResultSet res = ps.executeQuery();
        ArrayList<Ouvrier> liste = new ArrayList<>();
        while(res.next()){
            Ouvrier o = new Ouvrier(res.getString(1), res.getString(2));
            liste.add(o);
        }
        return liste;
    }
}
