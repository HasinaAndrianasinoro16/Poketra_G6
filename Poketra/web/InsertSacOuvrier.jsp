<%-- 
    Document   : index
    Created on : 12 déc. 2023, 15:52:39
    Author     : toxic
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="Model.*"%>
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
        ArrayList<Ouvrier> listeo = (ArrayList<Ouvrier>)request.getAttribute("ouvrier");
        ArrayList<Sac> listes = (ArrayList<Sac>) request.getAttribute("sac");
    %>
    <body class="container-fluid bg-dark text-start text-light" >
        <div class="py-4"></div>
        <h1 class="text-center" >Insertion des Ouvrier sac</h1>
        <!--<h5  class="text-center">Voir les matiere reliees au look</h5>-->
        <div class="py-5"></div>
        <form action="FormSacOuvrier" method="post" class="needs-validation" novalidate>
            <div class="row g-3 justify-content-center">
                <div class="col-sm-6">
          <label for="alrg" class="form-label h5">Choisir l'ouvrier :</label>
          <select class="form-select" id="ou" name="ou" required style="height: 55px;">
            <option value="">Ouvrier...</option>
            <% for(int i =0; i < listeo.size(); i++){ %>
            <option value="<%= listeo.get(i).getIdOuvrier() %>"><%= listeo.get(i).getOuvrier() %></option>
            <% } %>
          </select>
          <div class="invalid-feedback">
            Veuiller choisir un ouvrier.
          </div>
        </div>
                
                <div class="col-sm-6">
          <label for="alrg" class="form-label h5">Choisir le sac :</label>
          <select class="form-select" id="sac" name="sac" required style="height: 55px;">
            <option value="">Sac...</option>
            <% for(int i =0; i < listes.size(); i++){ %>
            <option value="<%= listes.get(i).getIdSac() %>"><%= listes.get(i).getNomSac() %></option>
            <% } %>
          </select>
          <div class="invalid-feedback">
            Veuiller choisir un sac.
          </div>
        </div>
                
                <div class="col-sm-6">
                <label for="nb" class="form-label h5">Nombre :</label>
                <input type="number" min="0" step="0.1" class="form-control" id="nb" name="nb" style="height: 55px;" placeholder="entrer un nombre" required>
                <div class="invalid-feedback">
                  Veuillez inserez une quantite.
                </div>
              </div>
                
                <div class="col-sm-6">
                <label for="tp" class="form-label h5">Temp de travaille</label>
                <input type="number" min="0" step="0.1" class="form-control" id="tp" name="tp" style="height: 55px;" placeholder="entrer un temp de travaille" required>
                <div class="invalid-feedback">
                  Veuillez inserez un temp de travaille.
                </div>
              </div>
                
            </div>
            <div class="my-4"></div>
            <center>
                <input type="submit" class="text-center btn btn-warning btn-lg w-25" name="name" value="Valider">
            </center>
        </form>
    </body>
     <script src="./assets/js/form-validation.js"></script>
</html>
