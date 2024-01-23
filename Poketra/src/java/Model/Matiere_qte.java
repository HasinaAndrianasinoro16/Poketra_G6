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
public class Matiere_qte {
    private int idMateriel_qte;
    private String idMatiere;
    private double qte;
    private String achat;

    public Matiere_qte() {
    }

    public Matiere_qte(int idMateriel_qte, String idMatiere, double qte, String achat) {
        this.idMateriel_qte = idMateriel_qte;
        this.idMatiere = idMatiere;
        this.qte = qte;
        this.achat = achat;
    }

    public int getIdMateriel_qte() {
        return idMateriel_qte;
    }

    public void setIdMateriel_qte(int idMateriel_qte) {
        this.idMateriel_qte = idMateriel_qte;
    }

    public String getIdMatiere() {
        return idMatiere;
    }

    public void setIdMatiere(String idMatiere) {
        this.idMatiere = idMatiere;
    }

    public double getQte() {
        return qte;
    }

    public void setQte(double qte) {
        this.qte = qte;
    }

    public String getAchat() {
        return achat;
    }

    public void setAchat(String achat) {
        this.achat = achat;
    }
    
    public void Save (Connection c, String idMatiere,double qte,String dateAchat) throws Exception{
        String sql = "insert into matiere_qte (idMatiere,qte,achat) values ('"+idMatiere+"',"+qte+",'"+dateAchat+"')";
        PreparedStatement ps = c.prepareStatement(sql);
        int exec = ps.executeUpdate();
    }
    
    public ArrayList<Matiere_qte> getMatiereQte(Connection c, String idMatiere) throws Exception{
        String sql = "select * from matiere_qte where idMatiere ='"+idMatiere+"'";
        ArrayList<Matiere_qte> liste = new ArrayList<>();
        PreparedStatement ps = c.prepareStatement(sql);
        ResultSet res = ps.executeQuery();
        while(res.next()){
            Matiere_qte mq = new Matiere_qte(res.getInt(1), res.getString(2), res.getDouble(3), res.getString(4));
            liste.add(mq);
        }
        return liste;
    }
    
    public ArrayList<Matiere_qte> getMatiereQte(Connection c) throws Exception{
        String sql = "select * from matiere_qte";
        ArrayList<Matiere_qte> liste = new ArrayList<>();
        PreparedStatement ps = c.prepareStatement(sql);
        ResultSet res = ps.executeQuery();
        while(res.next()){
            Matiere_qte mq = new Matiere_qte(res.getInt(1), res.getString(2), res.getDouble(3), res.getString(4));
            liste.add(mq);
        }
        return liste;
    }
}
