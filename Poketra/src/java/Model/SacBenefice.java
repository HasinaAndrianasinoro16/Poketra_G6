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
public class SacBenefice {
    private String idSac;
    private String nomSac;
    private  String taille;
    private double benefice;

    public SacBenefice() {
    }

    public SacBenefice(String idSac, String nomSac, String taille, double benefice) {
        this.idSac = idSac;
        this.nomSac = nomSac;
        this.taille = taille;
        this.benefice = benefice;
    }
    
    

    public SacBenefice(String idSac, String nomSac, double benefice) {
        this.idSac = idSac;
        this.nomSac = nomSac;
        this.benefice = benefice;
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

    public double getBenefice() {
        return benefice;
    }

    public void setBenefice(double benefice) {
        this.benefice = benefice;
    }
   
    public ArrayList<SacBenefice> getSacBenefice (Connection c, double min, double max) throws Exception{
        String sql = "select * from sacbenefice where benefice between "+min+" and "+max;
        PreparedStatement ps = c.prepareStatement(sql);
        ResultSet res = ps.executeQuery();
        ArrayList<SacBenefice> liste = new ArrayList<>();
        while(res.next()){
            SacBenefice sb = new SacBenefice(res.getString(1), res.getString(2), res.getDouble(3));
            liste.add(sb);
        }
        return liste;
    }
    public ArrayList<SacBenefice> getSacBenefices (Connection c, double min, double max) throws Exception{
        String sql = "select * from sacbenefice where benefice between "+min+" and "+max;
        PreparedStatement ps = c.prepareStatement(sql);
        ResultSet res = ps.executeQuery();
        ArrayList<SacBenefice> liste = new ArrayList<>();
        while(res.next()){
            SacBenefice sb = new SacBenefice(res.getString(1), res.getString(2), res.getString(3), res.getDouble(4));
            liste.add(sb);
        }
        return liste;
    }

    public String getTaille() {
        return taille;
    }

    public void setTaille(String taille) {
        this.taille = taille;
    }
    
}
