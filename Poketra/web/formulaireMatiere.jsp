<%-- 
    Document   : index
    Created on : 12 déc. 2023, 15:52:39
    Author     : toxic
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="Model.Look"%>
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
        ArrayList<Look> lk = (ArrayList<Look>) request.getAttribute("look");
    %>
    <body class="container" >
        <h1 class="text-center" >Projet poketra</h1>
        <h5  class="text-center">Voir les matiere reliees au look</h5>
        <div class="my-4"></div>
        <form action="FormResultat" method="post" class="needs-validation" novalidate>
            <div class="row g-3 justify-content-center">
                <div class="col-sm-6">
          <label for="alrg" class="form-label">Look</label>
          <select class="form-select" id="art" name="art" required>
            <option value="">Look...</option>
            <% for(int i =0; i < lk.size(); i++) { %>
            <option value="<%= lk.get(i).getIdLook() %>"><%= lk.get(i).getLook() %></option>
            <% } %>
          </select>
          <div class="invalid-feedback">
            Veuiller choisir un look.
          </div>
        </div>
            </div>
            <div class="my-4"></div>
            <center>
                <input type="submit" class="text-center btn btn-success btn-lg" name="name" value="Voir les matieres">
            </center>
        </form>
    </body>
     <script src="./assets/js/form-validation.js"></script>
</html>
