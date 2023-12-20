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
public class Sac extends ObjectBdd{
    String IdSac;
    String NomSac;

    public Sac() {
    }

    public Sac(String IdSac, String NomSac) {
        this.IdSac = IdSac;
        this.NomSac = NomSac;
    }

    public String getIdSac() {
        return IdSac;
    }

    public void setIdSac(String IdSac) {
        this.IdSac = IdSac;
    }

    public String getNomSac() {
        return NomSac;
    }

    public void setNomSac(String NomSac) {
        this.NomSac = NomSac;
    }
    
    public ArrayList<Sac> getSac (Connection c) throws Exception{
        String sql = "select * from sac";
        PreparedStatement ps = c.prepareStatement(sql);
        ResultSet res = ps.executeQuery();
        ArrayList<Sac> liste = new ArrayList<>();
        while(res.next()){
            Sac s = new Sac(res.getString(1), res.getString(2));
            liste.add(s);
        }
        return liste;
    }
}
