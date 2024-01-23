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
        ArrayList<ListeEmploye> liste = (ArrayList<ListeEmploye>) request.getAttribute("liste");
     %>
    <body class="container-fluid bg-dark text-start text-light" >
        <div class="py-4"></div>
        <h1 class="text-center" >Resultat demander</h1>
        <!--<h5  class="text-center">Resultat demander</h5>-->
        <div class="my-4"></div>
        <div class="py-4"></div>
        <div class="py-4"></div>
        <table class="table table-dark  table-hover text-light text-center container">
          <thead>
          <tr>
            <th scope="col">#</th>
            <th scope="col">code Employe</th>
            <th scope="col">Employe</th>
            <th scope="col" >poste</th>
            <th scope="col">duree</th>
            <th scope="col" >taux horraire</th>
            <!--<th scope="col"> -- </th>-->
          </tr>
          </thead>
          <tbody>
              <% for(int i =0 ; i < liste.size(); i++) {%>
          <tr>
            <th scope="row"><%= i+1 %></th>
            <td><%= liste.get(i).getIdEmploye() %></td>
            <td><%= liste.get(i).getEmploye() %></td>
            <td><%= liste.get(i).getPoste() %></td>
            <td><%= liste.get(i).getDuree() %></td>
            <td><%= liste.get(i).getTauxHoraire() %></td>
          </tr>
          <% } %>
          </tbody>
        </table>
    </body>
     <script src="./assets/js/form-validation.js"></script>
</html>
