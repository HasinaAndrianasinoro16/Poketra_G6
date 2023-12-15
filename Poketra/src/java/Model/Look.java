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
public class Look extends ObjectBdd{
    String IdLook;
    String Look;

    public Look() {
    }

    public Look(String IdLook, String Look) {
        this.IdLook = IdLook;
        this.Look = Look;
    }

    public String getIdLook() {
        return IdLook;
    }

    public void setIdLook(String IdLook) {
        this.IdLook = IdLook;
    }

    public String getLook() {
        return Look;
    }

    public void setLook(String Look) {
        this.Look = Look;
    }
    
    public ArrayList<Look> getLook (Connection c) throws Exception{
        String sql = " select * from look";
        PreparedStatement ps = c.prepareStatement(sql);
        ArrayList<Look> liste = new ArrayList<>();
        ResultSet res = ps.executeQuery();
        while(res.next()){
            Look l = new Look(res.getString(1), res.getString(2));
            liste.add(l);
        }
        return liste;
    }
    public ArrayList<Look> getLookByID (Connection c, String look)throws Exception{
        String sql = " select * from look where idLook ='"+look+"'";
        PreparedStatement ps = c.prepareStatement(sql);
        ArrayList<Look> liste = new ArrayList<>();
        ResultSet res = ps.executeQuery();
        while(res.next()){
            Look l = new Look(res.getString(1), res.getString(2));
            liste.add(l);
        }
        return liste;
    }
}
