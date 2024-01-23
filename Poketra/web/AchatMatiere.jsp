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
        ArrayList<Matiere> m = (ArrayList<Matiere>) request.getAttribute("mat");
    %>
    <body class="container-fluid bg-dark text-start text-light" >
        <div class="py-4"></div>
        <h1 class="text-center" >Achat de materiel</h1>
        <!--<h5  class="text-center">Voir les matiere reliees au look</h5>-->
        <div class="py-5"></div>
        <form action="FormAchatmatiere" method="post" class="needs-validation" novalidate>
            <div class="row g-3 justify-content-center">
                <div class="col-sm-5">
          <label for="alrg" class="form-label h5">Materiel</label>
          <select class="form-select" id="mat" name="mat" required style="height: 55px;">
            <option value="">materiel...</option>
            <% for(int i =0; i < m.size(); i++) { %>
            <option value="<%= m.get(i).getIdMatiere() %>"><%= m.get(i).getMatiere() %></option>
            <% } %>
          </select>
          <div class="invalid-feedback">
            Veuiller choisir une matiere.
          </div>
        </div>
          
           <div class="col-sm-5">
                <label for="lk" class="form-label h5">Quantite :</label>
                <input type="number" step="0.1" min="1" class="form-control" id="qte" name="qte" style="height: 55px;" placeholder="quatite" required>
                <div class="invalid-feedback">
                  Veuillez inserez une quantite.
                </div>
              </div>
            </div>
            <div class="my-4"></div>
            <center>
                <input type="submit" class="text-center btn btn-warning btn-lg w-25" name="name" value="Insertion !">
            </center>
        </form>
    </body>
     <script src="./assets/js/form-validation.js"></script>
</html>
