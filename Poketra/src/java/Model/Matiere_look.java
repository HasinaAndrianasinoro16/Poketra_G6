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
public class Matiere_look extends ObjectBdd{
    String idLook;
    String idMatiere;

    public Matiere_look() {
    }

    public Matiere_look(String idLook, String idMatiere) {
        this.idLook = idLook;
        this.idMatiere = idMatiere;
    }

    public String getIdLook() {
        return idLook;
    }

    public void setIdLook(String idLook) {
        this.idLook = idLook;
    }

    public String getIdMatiere() {
        return idMatiere;
    }

    public void setIdMatiere(String idMatiere) {
        this.idMatiere = idMatiere;
    }
    
    
}
