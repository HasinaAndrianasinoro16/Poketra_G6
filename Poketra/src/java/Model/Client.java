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
public class Client {
    private int idClient;
    private String nom;
    private String prenom;
    private int genre;

    public Client() {
    }

    public Client(int idClient, String nom, String prenom, int genre) {
        this.idClient = idClient;
        this.nom = nom;
        this.prenom = prenom;
        this.genre = genre;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public int getGenre() {
        return genre;
    }

    public void setGenre(int genre) {
        this.genre = genre;
    }
    
    public void Save (Connection c,String nom, String prenom, int genre) throws Exception{
        String sql = "insert into Client (nom,prenom,genre) values('"+nom+"','"+prenom+"',"+genre+")";
        PreparedStatement ps = c.prepareStatement(sql);
        int exec = ps.executeUpdate();
    }
    
    public ArrayList<Client> getClient (Connection c) throws Exception{
        String sql = "select * from client";
        PreparedStatement ps = c.prepareStatement(sql);
        ArrayList<Client> liste = new ArrayList<>();
        ResultSet res = ps.executeQuery();
        while(res.next()){
            Client cl = new Client(res.getInt(1), res.getString(2), res.getString(3), res.getInt(4));
            liste.add(cl);
        }
        return liste;
    }
    
    public int TotalVenteSac (Connection c, String idSac) throws Exception{
        String sql = "select sum(nombre) from vente where idsac='"+idSac+"'";
        PreparedStatement ps = c.prepareStatement(sql);
        int count = 0;
        ResultSet res = ps.executeQuery();
        while(res.next()){
            count = res.getInt(0);
        }
        return count;
    }
    
    public int TotalVenteGenre (Connection c, String idSac, int genre) throws Exception{
        String sql = "select sum(nombre) from ventes where idsac ='"+idSac+"' and genre ="+genre;
        PreparedStatement ps = c.prepareStatement(sql);
        ResultSet res = ps.executeQuery();
        int total = 0;
        while(res.next()){
            total = res.getInt(0);
        }
        return total;
    }
    
    public int pourcentage (Connection c, String idSac, int genre) throws Exception{
        int totalVente = this.TotalVenteSac(c, idSac);
        int totalVenteGenre = this.TotalVenteGenre(c, idSac, genre);
        int pourcentage = (totalVenteGenre * 100) / totalVente;
        return pourcentage;
    }
    
}
