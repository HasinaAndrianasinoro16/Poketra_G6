/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package ctrl;

import java.sql.*;
import java.util.*;
import Bdd.*;
import Model.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author toxic
 */
@WebServlet(name = "FormPrixRevient", urlPatterns = {"/FormPrixRevient"})
public class FormPrixRevient extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       PrintWriter out = response.getWriter();
       String taille = request.getParameter("tl");
//int nombre = Integer.parseInt(taille);
String idSac = request.getParameter("sac");
PrixSac ps = new PrixSac();
PrixMatiere pm = new PrixMatiere();
Sac_matiere sm = new Sac_matiere();
SacOuvrier so = new SacOuvrier();
SalaireOuvrier sco = new SalaireOuvrier();
Connexion co = new Connexion();

try {
    Connection c = co.connecte();
    ArrayList<Sac_matiere> lsm = sm.getSacMatiere(c, idSac, taille);
    ArrayList<SacOuvrier> lso = so.getSacOuvrier(c, idSac);

    int nombre = 1;
    if (taille.equalsIgnoreCase("MM")) {
        nombre = 2;
    } else if (taille.equalsIgnoreCase("GM")) {
        nombre = 3;
    }

    double prixVente = ps.getPrixSac(c, taille).get(0).getPrixSac();
    double prixmatieresac = 0.0;

    for (int i = 0; i < lsm.size(); i++) {
        ArrayList<PrixMatiere> lpm = pm.getPrixMatiere(c, lsm.get(i).getIdMatiere());
        prixmatieresac += lpm.get(0).getPrix();
    }

    double maindeuvre = 0.0;

    for (int j = 0; j < lso.size(); j++) {
        ArrayList<SalaireOuvrier> lslo = sco.getSalaireOuvrier(c, lso.get(j).getIdOuvrier());
        maindeuvre += lslo.get(0).getSalaire() * lso.get(j).getNombre() * lso.get(j).getTemp()*nombre;
    }

    Benefice bf = new Benefice();
    double prixrevient = maindeuvre + prixmatieresac;
    double benefice = prixVente - prixrevient;
    if(benefice < 0){
        benefice = Math.abs(benefice);
    }
    bf.Save(c, idSac,taille, benefice);

    RequestDispatcher dis = request.getRequestDispatcher("PrixRevient");
    dis.forward(request, response); 
} catch (Exception e) {
    e.printStackTrace(out);
}

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
