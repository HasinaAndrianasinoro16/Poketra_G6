/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
import java.sql.*;
import java.util.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
/**
 *
 * @author toxic
 */
public class ListeEmploye {
    private String idEmploye;
    private String employe;
    private String poste;
    private int duree;
    private double TauxHoraire;

    public ListeEmploye() {
    }

    public ListeEmploye(String idEmploye, String employe, String poste, int duree, double TauxHoraire) {
        this.idEmploye = idEmploye;
        this.employe = employe;
        this.poste = poste;
        this.duree = duree;
        this.TauxHoraire = TauxHoraire;
    }

    public String getIdEmploye() {
        return idEmploye;
    }

    public void setIdEmploye(String idEmploye) {
        this.idEmploye = idEmploye;
    }

    public String getEmploye() {
        return employe;
    }

    public void setEmploye(String employe) {
        this.employe = employe;
    }

    public String getPoste() {
        return poste;
    }

    public void setPoste(String poste) {
        this.poste = poste;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public double getTauxHoraire() {
        return TauxHoraire;
    }

    public void setTauxHoraire(double TauxHoraire) {
        this.TauxHoraire = TauxHoraire;
    }
    
    public static int diff(String dte) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate dateNaissance = LocalDate.parse(dte, formatter);
        LocalDate aujourdHui = LocalDate.now();
        long differenceAnnees = ChronoUnit.YEARS.between(dateNaissance, aujourdHui);
        int differenceAge = (int) differenceAnnees;
        return differenceAge;
    }
    
    public ArrayList<ListeEmploye> getListe (Connection c) throws Exception{
        Postes ps = new Postes();
        Poste po = new Poste();
        SalaireOuvrier so = new SalaireOuvrier();
        LocalDate today = LocalDate.now();
        ArrayList<ListeEmploye> liste = new ArrayList<>();
        ArrayList<SalaireOuvrier> listeSalaire = so.getSalaireOuvrier(c, "VRR006");
        
        ArrayList<Postes> postes = ps.getPostes(c);
        for(Postes pes : postes){
            ListeEmploye le = new ListeEmploye();
            le.setIdEmploye(pes.getIdEmploye());
            le.setEmploye(pes.getNom().toUpperCase() +" "+ pes.getPrenom());
            le.setPoste(pes.getOuvrier());
            int multiple = 1;
            le.setDuree(diff(pes.getDateEmbauche()));
            le.setTauxHoraire(multiple * listeSalaire.get(0).getSalaire());
            if(pes.getIdOuvrier().equalsIgnoreCase("VRR006") && diff(pes.getDateEmbauche()) == 2){
                le.setPoste("Ouvrier");
                multiple = 2;
                po.Update(c, pes.getIdEmploye(), "VR006", today.toString());
                le.setTauxHoraire(multiple * listeSalaire.get(0).getSalaire() * diff(pes.getDateEmbauche()));
                le.setDuree(diff(pes.getDateEmbauche()));
            }else if(pes.getIdOuvrier().equalsIgnoreCase("VRR004") && diff(pes.getDateEmbauche()) >= 3){
                le.setPoste("Expert");
                multiple = 3;
                po.Update(c, pes.getIdEmploye(), "VR004", today.toString());
                le.setTauxHoraire(multiple * listeSalaire.get(0).getSalaire() * diff(pes.getDateEmbauche()));
                le.setDuree(diff(pes.getDateEmbauche()));
            }
            liste.add(le);
        } 
        return liste;
    }
}
