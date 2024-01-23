/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
import java.util.*;
import java.sql.*;
/**
 *
 * @author toxic
 */
public class Reste {
    String codeMatiere;
    String matiere;
    double qte;

    public Reste() {
    }

    public Reste(String codeMatiere, String matiere, double qte) {
        this.codeMatiere = codeMatiere;
        this.matiere = matiere;
        this.qte = qte;
    }

    public String getCodeMatiere() {
        return codeMatiere;
    }

    public void setCodeMatiere(String codeMatiere) {
        this.codeMatiere = codeMatiere;
    }

    public String getMatiere() {
        return matiere;
    }

    public void setMatiere(String matiere) {
        this.matiere = matiere;
    }

    public double getQte() {
        return qte;
    }

    public void setQte(double qte) {
        this.qte = qte;
    }
    
    public ArrayList<Reste> getReste (Connection c, String sac,String taille, double qte) throws Exception{
        Matiere_qte mq = new Matiere_qte();
        Sac_matiere sm = new Sac_matiere();
        ArrayList<Reste> reste = new ArrayList<>();
        ArrayList<Sac_matiere> listesm = sm.getSacMatiere(c, sac, taille);
//        ArrayList<Matiere_qte> listemq = mq.getMatiereQte(c);
        for(int i = 0; i <listesm.size(); i++){
            Reste r = new Reste();
            double qteMatiere =0.0;
            for(int j = 0; j <mq.getMatiereQte(c, listesm.get(i).getIdMatiere()).size(); j++){
                qteMatiere = mq.getMatiereQte(c, listesm.get(i).getIdMatiere()).get(j).getQte();
                double qmatiere = listesm.get(i).getQuantite() *qte;
                if(qmatiere != 0.0 && qmatiere > qteMatiere){
                    r.setCodeMatiere(listesm.get(i).getIdMatiere());
                    r.setMatiere(listesm.get(i).getMatiere());
//                    double restes = Math.abs(qmatiere - qteMatiere);
                    double restes = qmatiere -qteMatiere;
                    r.setQte(restes);
                }else{
                    r.setCodeMatiere(listesm.get(i).getIdMatiere());
                    r.setMatiere(listesm.get(i).getMatiere());
//                    double restes = Math.abs(qmatiere - qteMatiere);
                    r.setQte(0.0);
                }
            }
            reste.add(r);
        }
        return reste;
    }
}
