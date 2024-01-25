<%-- 
    Document   : index
    Created on : 12 déc. 2023, 15:52:39
    Author     : toxic
--%>

<%@page import="Model.*"%>
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
        ArrayList<Sac> s = (ArrayList<Sac>) request.getAttribute("sac");
        ArrayList<Client> c = (ArrayList<Client>) request.getAttribute("client");
    %>
    <body class="container-fluid bg-dark text-start text-light" >
        <div class="py-5"></div>
        <h1 class="text-center" >Insertion d'un Client</h1>
        <!--<h5  class="text-center">insertion d'un nouveau look</h5>-->
        <div class="py-4"></div>
        <form action="FormVente" method="post" class="needs-validation" novalidate>
            <div class="row g-3 justify-content-center ">
                
                <div class="col-sm-5">
          <label for="alrg" class="form-label h5">Sac :</label>
          <select class="form-select" id="sac" name="sac" required style="height: 55px;">
            <option value="">sac...</option>
            <% for(int i =0; i < s.size(); i++){ %>
            <option value="<%= s.get(i).getIdSac() %>"><%= s.get(i).getNomSac() %></option>
            <% } %>
          </select>
          <div class="invalid-feedback">
            Veuiller choisir un sac.
          </div>
        </div>
                
                <div class="col-sm-5">
          <label for="alrg" class="form-label h5">Client :</label>
          <select class="form-select" id="sac" name="cl" required style="height: 55px;">
            <option value="">Client...</option>
            <% for(int i =0; i < c.size(); i++){ %>
            <option value="<%= c.get(i).getIdClient() %>"><%= c.get(i).getNom().toUpperCase() %> <%= c.get(i).getPrenom() %></option>
            <% } %>
          </select>
          <div class="invalid-feedback">
            Veuiller choisir un client.
          </div>
        </div>
                
                <div class="col-sm-5">
                <label for="ou" class="form-label h5">Nombre de sac :</label>
                <input type="number" class="form-control" id="ou" name="nb" min="1" style="height: 55px;"  required>
                <div class="invalid-feedback">
                  Veuillez inserez un nombre.
                </div>
              </div>
            </div>
            <div class="py-4"></div>
            <center>
                <input type="submit" class="text-center btn btn-warning btn-lg w-25" name="name" value="inserer!">
            </center>
        </form>
    </body>
     <script src="./assets/js/form-validation.js"></script>
</html>
