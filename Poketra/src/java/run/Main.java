/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package run;
import Model.*;
import java.sql.*;
import Bdd.*;
/**
 *
 * @author toxic
 */
public class Main {
    public static void main(String[] args) throws Exception{
        Connexion co = new Connexion();
        Connection c = co.connecte();
        Sac_matiere sm =new Sac_matiere();
        System.out.println(sm.getPrixSac(c, "SC026", "PM"));
    }
}
