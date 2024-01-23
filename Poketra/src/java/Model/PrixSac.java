/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
import java.sql.*;
import Bdd.*;
import java.util.*;
/**
 *
 * @author toxic
 */
public class PrixSac {
    int idPrixSac;
    String idsac ;
    String nomSac;
    String taille;
    double PrixSac;

    public PrixSac() {
    }

    public PrixSac(int idPrixSac, String idsac, String nomSac, String taille, double PrixSac) {
        this.idPrixSac = idPrixSac;
        this.idsac = idsac;
        this.nomSac = nomSac;
        this.taille = taille;
        this.PrixSac = PrixSac;
    }

    public int getIdPrixSac() {
        return idPrixSac;
    }

    public void setIdPrixSac(int idPrixSac) {
        this.idPrixSac = idPrixSac;
    }

    public String getIdsac() {
        return idsac;
    }

    public void setIdsac(String idsac) {
        this.idsac = idsac;
    }

    public String getNomSac() {
        return nomSac;
    }

    public void setNomSac(String nomSac) {
        this.nomSac = nomSac;
    }

    public String getTaille() {
        return taille;
    }

    public void setTaille(String taille) {
        this.taille = taille;
    }

    public double getPrixSac() {
        return PrixSac;
    }

    public void setPrixSac(double PrixSac) {
        this.PrixSac = PrixSac;
    }
    
    public void save(Connection connection, String idSac, String nomSac, String taille, double prixSac) throws SQLException {
        String query = "INSERT INTO PrixSac (idsac, nomsac, taille, prixsac) VALUES (?, ?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, idSac);
            preparedStatement.setString(2, nomSac);
            preparedStatement.setString(3, taille);
            preparedStatement.setDouble(4, prixSac);

            // Exécution de la requête d'insertion
            preparedStatement.executeUpdate();
        }
    }
    
    public void SaveSac (Connection c, String idSac, String Taille) throws Exception{
        Sac_matiere sm = new Sac_matiere();
        ArrayList<Sac_matiere> liste =sm.getSacMatiere(c, idSac, Taille);
        this.save(c,liste.get(0).getIdSac() , liste.get(0).getNomSac(),liste.get(0).getTaille(), sm.getPrixSac(c, idSac, Taille));
    }
    
    public ArrayList<PrixSac> getPrixSac(Connection c, String taille) throws Exception{
        String sql = "select * from prixsac where taille = '"+taille+"'";
        PreparedStatement ps = c.prepareStatement(sql);
        ArrayList<PrixSac> liste = new ArrayList<>();
        ResultSet res = ps.executeQuery();
        while(res.next()){
            PrixSac pss = new PrixSac(res.getInt(1), res.getString(2), res.getString(3), res.getString(4), res.getDouble(5));
            liste.add(pss);
        }
        return liste;
    }
    
    public ArrayList<PrixSac> getPrixSacsBetween(Connection connection, double prixMin, double prixMax) throws SQLException {
        ArrayList<PrixSac> result = new ArrayList<>();
        String query = "SELECT * FROM PrixSac WHERE prixsac BETWEEN ? AND ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setDouble(1, prixMin);
            preparedStatement.setDouble(2, prixMax);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    PrixSac prixSac = new PrixSac();
                    prixSac.setIdPrixSac(resultSet.getInt(1));
                    prixSac.setIdsac(resultSet.getString(2));
                    prixSac.setNomSac(resultSet.getString(3));
                    prixSac.setTaille(resultSet.getString(4));
                    prixSac.setPrixSac(resultSet.getDouble(5));

                    result.add(prixSac);
                }
            }
        }

        return result;
    }
}
