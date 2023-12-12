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
public class Matiere extends ObjectBdd {
    String IdMatiere;
    String matiere;

    public Matiere() {
    }

    public String getIdMatiere() {
        return IdMatiere;
    }

    public void setIdMatiere(String IdMatiere) {
        this.IdMatiere = IdMatiere;
    }

    public String getMatiere() {
        return matiere;
    }

    public void setMatiere(String matiere) {
        this.matiere = matiere;
    }

    public Matiere(String IdMatiere, String matiere) {
        this.IdMatiere = IdMatiere;
        this.matiere = matiere;
    }
    
    public ArrayList<Matiere> getMatiere (Connection c ) throws Exception{
        String sql = "select * from matiere";
        PreparedStatement ps = c.prepareStatement(sql);
        ArrayList<Matiere> liste = new ArrayList<>();
        ResultSet res = ps.executeQuery();
        while(res.next()){
            Matiere m = new Matiere(res.getString(1),res.getString(2));
            liste.add(m);
        }
        return liste;
    }
}
