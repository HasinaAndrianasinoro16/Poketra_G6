<%-- 
    Document   : index
    Created on : 12 déc. 2023, 15:52:39
    Author     : toxic
--%>

<%@page import="Model.Matiere"%>
<%@page import="Model.Taille"%>
<%@page import="Model.Sac"%>
<%--<%@page import="Model.Look"%>--%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="dashboard.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
          <link rel="stylesheet" href="./assets/fontawesome-5/css/all.min.css">
    <link rel="stylesheet" href="./assets/fontawesome-5/css/all.css">
    <link rel="stylesheet" href="./assets/style/title.css">
    <link rel="stylesheet" href="./assets/dist/css/bootstrap.min.css">
    </head>
    <%
        ArrayList<Sac>  sac = (ArrayList<Sac>) request.getAttribute("sac");
        ArrayList<Taille>  taille = (ArrayList<Taille>) request.getAttribute("taille");
        ArrayList<Matiere>  matiere = (ArrayList<Matiere>) request.getAttribute("matiere");
    %>
    <body class="container-fluid bg-dark text-start text-light" >
        <div class="py-4"></div>
        <h1 class="text-center" >Insertion d'une nouvelle matiere</h1>
        <div class="py-4"></div>
<!--        <h5  class="text-center">insertion d'une nouvelle matiere</h5>-->
        <form action="Forminsertionmatiere" method="post" class="needs-validation" novalidate>
            <div class="row g-3 justify-content-center">
                <div class="my-3"></div>
               <div class="col-sm-7">
                    <label for="alrg" class="form-label h5">Choisir le Sac</label>
                    <select class="form-select" id="art" name="sac" required style="height: 55px;">
                      <option value="">Sac...</option>
                      <% for(int i =0; i < sac.size(); i++ ){ %>
                      <option value="<%= sac.get(i).getIdSac() %>"><%= sac.get(i).getNomSac() %></option>
                      <% } %>
                    </select>
                    <div class="invalid-feedback">
                      Veuiller choisir un sac.
                    </div>
                </div>
                
                <div class="col-sm-7">
                    <label for="alrg" class="form-label h5">Choisir la matiere</label>
                    <select class="form-select" id="art" name="matiere" required style="height: 55px;">
                      <option value="">matiere...</option>
                      <% for(int j =0; j < matiere.size(); j++){ %>
                      <option value="<%= matiere.get(j).getIdMatiere() %>"><%= matiere.get(j).getMatiere() %></option>
                      <% } %>
                    </select>
                    <div class="invalid-feedback">
                      Veuiller choisir une matiere.
                    </div>
                </div>
                
                <div class="col-sm-7">
                    <label for="alrg" class="form-label h5">Choisir le Taille</label>
                    <select class="form-select" id="art" name="taille" required style="height: 55px;">
                      <option value="">taille...</option>
                      <% for(int k = 0; k < taille.size(); k++){ %>
                      <option value="<%= taille.get(k).getIdTaille() %>"><%= taille.get(k).getTaille() %></option>
                      <% } %>
                    </select>
                    <div class="invalid-feedback">
                      Veuiller choisir une taille.
                    </div>
                </div>
                
                <div class="col-sm-7">
                <label for="mt" class="form-label h5">quantite de matiere (Kg):</label>
                <input type="number" min="0" step="0.1" class="form-control" id="mt" name="qte" style="height: 55px;" placeholder="entrer une matiere" required>
                <div class="invalid-feedback">
                  Veuillez inserez une quantite.
                </div>
              </div>
                
            </div>
            <div class="my-4"></div>
            <center>
                <input type="submit" class="text-center btn btn-warning btn-lg w-25" name="name" value="Inserer la matiere">
            </center>
        </form>
    </body>
     <script src="./assets/js/form-validation.js"></script>
</html>
