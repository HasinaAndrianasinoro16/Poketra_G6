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
public class Benefice {
    private int idBenefice;
    private String idSac;
    private String taille;
    private double benefice;

    public Benefice() {
    }

    public Benefice(int idBenefice, String idSac, double benefice) {
        this.idBenefice = idBenefice;
        this.idSac = idSac;
        this.benefice = benefice;
    }

    public Benefice(int idBenefice, String idSac, String taille, double benefice) {
        this.idBenefice = idBenefice;
        this.idSac = idSac;
        this.taille = taille;
        this.benefice = benefice;
    }

    public String getTaille() {
        return taille;
    }

    public void setTaille(String taille) {
        this.taille = taille;
    }
    
    

    public int getIdBenefice() {
        return idBenefice;
    }

    public void setIdBenefice(int idBenefice) {
        this.idBenefice = idBenefice;
    }

    public String getIdSac() {
        return idSac;
    }

    public void setIdSac(String idSac) {
        this.idSac = idSac;
    }

    public double getBenefice() {
        return benefice;
    }

    public void setBenefice(double benefice) {
        this.benefice = benefice;
    }
    
    public void Save (Connection c, String idSac,String taille,double benefice) throws Exception{
        String sql = "insert into benefice (idsac, taille, benefice) values('"+idSac+"','"+taille+"',"+benefice+")";
        PreparedStatement ps = c.prepareStatement(sql);
        int exec = ps.executeUpdate();
    }
    
//    public ArrayList<Benefice> getBenefice (Connection c,)
}
