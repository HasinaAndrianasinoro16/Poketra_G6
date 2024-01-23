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
public class SacOuvrier {
    int idSacOuvrier;
    String idSac;
    String idOuvrier;
    int nombre;
    double temp;

    public SacOuvrier() {
    }

    public SacOuvrier(int idSacOuvrier, String idSac, String idOuvrier, int nombre, double temp) {
        this.idSacOuvrier = idSacOuvrier;
        this.idSac = idSac;
        this.idOuvrier = idOuvrier;
        this.nombre = nombre;
        this.temp = temp;
    }

    public int getIdSacOuvrier() {
        return idSacOuvrier;
    }

    public void setIdSacOuvrier(int idSacOuvrier) {
        this.idSacOuvrier = idSacOuvrier;
    }

   

    public String getIdSac() {
        return idSac;
    }

    public void setIdSac(String idSac) {
        this.idSac = idSac;
    }

    public String getIdOuvrier() {
        return idOuvrier;
    }

    public void setIdOuvrier(String idOuvrier) {
        this.idOuvrier = idOuvrier;
    }

    public int getNombre() {
        return nombre;
    }

    public void setNombre(int nombre) {
        this.nombre = nombre;
    }

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }
    
    public void Save (Connection c , String idSac, String idOuvrier,int nombre, double temp) throws Exception{
        String sql = "insert into sacOuvrier (idsac,idouvrier,nombre,temp) values('"+idSac+"','"+idOuvrier+"',"+nombre+","+temp+")";
        PreparedStatement ps = c.prepareStatement(sql);
        int exec = ps.executeUpdate();
    }
    
//    public ArrayList<SacOuvrier> getSacOuvrier(Connection c, String idOuvrier) throws Exception{
//        String sql = "select * from sacouvrier where idouvrier ='"+idOuvrier+"'";
//        PreparedStatement ps = c.prepareStatement(sql);
//        ResultSet res = ps.executeQuery();
//        ArrayList<SacOuvrier> liste = new ArrayList<>();
//        while(res.next()){
//            SacOuvrier sco = new SacOuvrier(res.getInt(1), res.getString(2), res.getString(3), res.getInt(4), res.getDouble(5));
//            liste.add(sco);
//        }
//        return liste;
//    }
    
   public ArrayList<SacOuvrier> getSacOuvrier (Connection c, String sac) throws Exception{
        String sql = "select * from sacouvrier where idouvrier ='"+idOuvrier+"'";
        PreparedStatement ps = c.prepareStatement(sql);
        ResultSet res = ps.executeQuery();
        ArrayList<SacOuvrier> liste = new ArrayList<>();
        while(res.next()){
            SacOuvrier sco = new SacOuvrier(res.getInt(1), res.getString(2), res.getString(3), res.getInt(4), res.getDouble(5));
            liste.add(sco);
        }
        return liste;
   }
}
