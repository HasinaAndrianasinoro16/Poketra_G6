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
    <body class="container-fluid bg-dark text-start text-light" >
        <div class="py-4"></div>
        <h1 class="text-center" >Voir les matiere reliees au look</h1>
        <!--<h5  class="text-center">Voir les matiere reliees au look</h5>-->
        <div class="py-5"></div>
        <form action="FormBenefice" method="post" class="needs-validation" novalidate>
            <div class="row g-3 justify-content-center">
                <div class="col-sm-4">
          <label for="alrg" class="form-label h5">Prix Min:</label>
          <input type="number" step="0.1" min="0" class="form-control" id="lk" name="min" style="height: 55px;" placeholder="prix minimum" required>
          <div class="invalid-feedback">
            Veuiller choisir un look.
          </div>
        </div>
          
          <div class="col-sm-4">
          <label for="alrg" class="form-label h5">Prix Max</label>
          <input type="number" min="0" step="0.1" class="form-control" id="lk" name="max" style="height: 55px;" placeholder="prix maximum" required>
          <div class="invalid-feedback">
            Veuiller choisir un look.
          </div>
        </div>
            </div>
            <div class="my-4"></div>
            <center>
                <input type="submit" class="text-center btn btn-warning btn-lg w-25" name="name" value="Voir les matieres">
            </center>
        </form>
    </body>
     <script src="./assets/js/form-validation.js"></script>
</html>
