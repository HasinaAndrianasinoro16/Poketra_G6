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
public class TypeMatiere {
    int idMatiere_look;
    String IdLook;
    String Look;
     String IdMatiere;
    String matiere;

    public TypeMatiere() {
    }

    public TypeMatiere(int idMatiere_look, String IdLook, String Look, String IdMatiere, String matiere) {
        this.idMatiere_look = idMatiere_look;
        this.IdLook = IdLook;
        this.Look = Look;
        this.IdMatiere = IdMatiere;
        this.matiere = matiere;
    }

    public int getIdMatiere_look() {
        return idMatiere_look;
    }

    public void setIdMatiere_look(int idMatiere_look) {
        this.idMatiere_look = idMatiere_look;
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
    
    public ArrayList<TypeMatiere> getTypeMatiereByLook(Connection c, String look) throws Exception{
        String sql ="select * from type_matiere where idlook = '"+look+"'";
        PreparedStatement ps = c.prepareStatement(sql);
        ArrayList<TypeMatiere> liste = new ArrayList<>();
        ResultSet res = ps.executeQuery();
        while(res.next()){
            TypeMatiere tm = new TypeMatiere(res.getInt(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5));
            liste.add(tm);
        }
        return liste;
     }
}
