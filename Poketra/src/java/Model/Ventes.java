/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
import java.sql.*;
import java.util.*;
import java.time.*;
/**
 *
 * @author toxic
 */
public class Ventes {
    private int idClient;
    private String nom;
    private String prenom;
    private int genre;
    private int idVente;
    private String idSac;
    private String nomSac;
    private int nombre;
    private String dateAchat;

    public Ventes() {
    }

    public Ventes(int idClient, String nom, String prenom, int genre, int idVente, String idSac, String nomSac, int nombre, String dateAchat) {
        this.idClient = idClient;
        this.nom = nom;
        this.prenom = prenom;
        this.genre = genre;
        this.idVente = idVente;
        this.idSac = idSac;
        this.nomSac = nomSac;
        this.nombre = nombre;
        this.dateAchat = dateAchat;
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

    public int getIdVente() {
        return idVente;
    }

    public void setIdVente(int idVente) {
        this.idVente = idVente;
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

    public int getNombre() {
        return nombre;
    }

    public void setNombre(int nombre) {
        this.nombre = nombre;
    }

    public String getDateAchat() {
        return dateAchat;
    }

    public void setDateAchat(String dateAchat) {
        this.dateAchat = dateAchat;
    }
    
    public  void Save (Connection c, int idClient, String idSac, int nombre) throws Exception{
        LocalDate today = LocalDate.now();
        String now = today.toString();
        String sql = "INSERT INTO vente (idClient, idSac, nombre, dateAchat) VALUES  ("+idClient+",'"+idSac+"',"+nombre+",'"+now+"')";
        PreparedStatement ps = c.prepareStatement(sql);
        int exec = ps.executeUpdate();
    }
    
    public ArrayList<Ventes> getVentes (Connection c) throws Exception{
        String sql = "select * from ventes";
        PreparedStatement ps = c.prepareStatement(sql);
        ArrayList<Ventes> liste = new ArrayList<>();
        ResultSet res = ps.executeQuery();
        while(res.next()){
            Ventes v = new Ventes(res.getInt(1), res.getString(2), res.getString(3), res.getInt(4), res.getInt(5), res.getString(6), res.getString(7), res.getInt(8), res.getString(9));
            liste.add(v);
        }
        return liste;
    }
    
    //total de vente par sac
    public int TotalVenteSac (Connection c, String idSac) throws Exception{
        String sql = "select sum(nombre) from vente where idsac='"+idSac+"'";
        PreparedStatement ps = c.prepareStatement(sql);
        int count = 0;
        ResultSet res = ps.executeQuery();
        while(res.next()){
            count = res.getInt(1);
        }
        return count;
    }
    
    //total vente en general
    public int TotalVente (Connection c) throws Exception{
        String sql = "select sum(nombre) from vente";
        PreparedStatement ps = c.prepareStatement(sql);
        int count = 0;
        ResultSet res = ps.executeQuery();
        while(res.next()){
            count = res.getInt(1);
        }
        return count;
    }
    
    public int TotalVenteGenre (Connection c, String idSac, int genre) throws Exception{
        String sql = "select sum(nombre) from ventes where idsac ='"+idSac+"' and genre ="+genre;
        PreparedStatement ps = c.prepareStatement(sql);
        ResultSet res = ps.executeQuery();
        int total = 0;
        while(res.next()){
            total = res.getInt(1);
        }
        return total;
    }
    
    public int TotalityVenteGenre (Connection c, int genre) throws Exception{
        String sql = "select sum(nombre) from ventes where genre ="+genre;
        PreparedStatement ps = c.prepareStatement(sql);
        ResultSet res = ps.executeQuery();
        int total = 0;
        while(res.next()){
            total = res.getInt(1);
        }
        return total;
    }
    
    //pourcentage par sac par genre
    public int pourcentage (Connection c, String idSac, int genre) throws Exception{
        int totalVente = this.TotalVenteSac(c, idSac);
        int totalVenteGenre = this.TotalVenteGenre(c, idSac, genre);
        int pourcentage = (totalVenteGenre * 100) / totalVente;
        return pourcentage;
    }
    
    
    //pourcentage total par genre
    public int AllPourcentage (Connection c,int genre) throws Exception{
        int totalVente = this.TotalVente(c);
        int totalVenteGenre = this.TotalityVenteGenre(c, genre);
        int pourcentage = (totalVenteGenre * 100) / totalVente;
        return pourcentage;
    }
}
