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
public class Poste {
    private int idPoste;
    private String idOuvrier;
    private String idEmploye;

    public Poste() {
    }

    public Poste(int idPoste, String idOuvrier, String idEmploye) {
        this.idPoste = idPoste;
        this.idOuvrier = idOuvrier;
        this.idEmploye = idEmploye;
    }

    public int getIdPoste() {
        return idPoste;
    }

    public void setIdPoste(int idPoste) {
        this.idPoste = idPoste;
    }

    public String getIdOuvrier() {
        return idOuvrier;
    }

    public void setIdOuvrier(String idOuvrier) {
        this.idOuvrier = idOuvrier;
    }

    public String getIdEmploye() {
        return idEmploye;
    }

    public void setIdEmploye(String idEmploye) {
        this.idEmploye = idEmploye;
    }
    
    public void Save (Connection c, String idOuvrier, String idEmploye) throws Exception{
        String sql = "INSERT INTO poste (idOuvrier, idEmploye) VALUES ('"+idOuvrier+"','"+idEmploye+"')";
        PreparedStatement ps = c.prepareStatement(sql);
        int exec = ps.executeUpdate();
    }
    
    public void Update (Connection c, String idEmploye, String idOuvrier, String dateEmbauche) throws Exception{
        String sql ="update poste set idOuvrier ='"+idOuvrier+"', dateEmbauche ='"+dateEmbauche+"' where idemploye= '"+idEmploye+"'";
        PreparedStatement ps = c.prepareStatement(sql);
        int exec = ps.executeUpdate();
    }
    
    public ArrayList<Poste> getPoste (Connection c) throws Exception{
        String sql ="select * from poste";
        PreparedStatement ps = c.prepareStatement(sql);
        ResultSet res = ps.executeQuery();
        ArrayList<Poste> liste = new ArrayList<>();
        while(res.next()){
            Poste p = new Poste(res.getInt(1), res.getString(2), res.getString(3));
            liste.add(p);
    }
        return liste;
    }
}
