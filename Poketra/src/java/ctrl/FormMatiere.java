/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package ctrl;

import Bdd.*;
import Model.Look;
import Model.Matiere;
import java.sql.*;
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
@WebServlet(name = "FormMatiere", urlPatterns = {"/FormMatiere"})
public class FormMatiere extends HttpServlet {

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
        Connexion co = new Connexion();
        Matiere m = new Matiere();
//        ObjectBdd om = new Matiere();
        String matiere = request.getParameter("mt");
        String [] look = request.getParameterValues("lk");
        try {
            Connection c = co.connecte();
            String id = "M00"+m.getSequence(c);
            ObjectBdd matire = new Matiere(id, matiere);
            matire.insert(c);
//            String sqil = " insert into matiere(idmatiere, matiere) values ('"+id+"','"+matiere+"') ";
//            PreparedStatement psi = c.prepareStatement(sqil);
//            int resi = psi.executeUpdate();
//            om.insert(c);
            for(int i = 0; i < look.length; i++){
                String sql = "INSERT INTO matiere_look (idlook, idmatiere) VALUES ('"+look[i]+"', '"+id+"')";
                PreparedStatement ps = c.prepareStatement(sql);
                int res = ps.executeUpdate();
            }
        RequestDispatcher dispatch = request.getRequestDispatcher("insertMatierectrl");
        dispatch.forward(request, response);
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
