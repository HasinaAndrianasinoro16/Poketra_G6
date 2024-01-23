/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package ctrl;

import java.time.*;
import Model.*;
import java.sql.*;
import java.util.*;
import Bdd.*;
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
@WebServlet(name = "FormFabrication", urlPatterns = {"/FormFabrication"})
public class FormFabrication extends HttpServlet {

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
        String sac = request.getParameter("sac");
        String taille = request.getParameter("tl");
        String qte = request.getParameter("qte");
        double quantire = Double.valueOf(qte);
        Connexion co = new Connexion();
        Reste r = new Reste();
        Historique h = new Historique();
        LocalDate day = LocalDate.now();
        String today = String.valueOf(day);
        try {
            Connection c = co.connecte();
            ArrayList<Reste> rs = r.getReste(c, sac, taille, quantire);
//            if(rs != null){
            for(int i =0; i < rs.size(); i++){
                h.Save(c, today, rs.get(i).getCodeMatiere(), rs.get(i).getQte());
            }
//            }
            request.setAttribute("reste", rs);
            RequestDispatcher dis = request.getRequestDispatcher("Resultat4.jsp");
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
