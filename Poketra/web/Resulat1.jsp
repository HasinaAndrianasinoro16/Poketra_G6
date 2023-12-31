<%-- 
    Document   : index
    Created on : 12 déc. 2023, 15:52:39
    Author     : toxic
--%>

<%@page import="Model.TypeMatiere"%>
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
        ArrayList<TypeMatiere> tm = (ArrayList<TypeMatiere>) request.getAttribute("matiere");
        String look = (String) request.getAttribute("look");
        String id = (String) request.getAttribute("id");
    %>
    <body class="container-fluid bg-dark text-start text-light" >
        <div class="py-4"></div>
        <h1 class="text-center" >Resultat demander</h1>
        <!--<h5  class="text-center">Resultat demander</h5>-->
        <div class="py-4"></div>
        <div class="py-3"></div>
        <p class=" container text-start h5">Liste des matieres appartenant au look :<span class="text-warning h4" > <%=look %> </span></p>
        <div class="py-4"></div>
        <table class="table table-dark  table-hover text-light text-center ">
          <thead>
          <tr>
            <th scope="col">#</th>
            <th scope="col">code matiere</th>
            <th scope="col">matiere</th>
            <!--<th scope="col"> -- </th>-->
          </tr>
          </thead>
          <tbody>
              <% for(int i =0 ; i < tm.size(); i++) {%>
          <tr>
            <th scope="row"><%= i+1 %></th>
            <td><%= tm.get(i).getIdMatiere() %></td>
            <td><%=tm.get(i).getMatiere() %></td>
<!--            <td>
                <a href="Delete?look=<%= id %>&matiere=<%= tm.get(i).getIdMatiere() %>" class="btn btn-outline-danger btn-lg" > <i class="fas fa-trash-alt" ></i> </a>
            </td>-->
          </tr>
          <% } %>
          </tbody>
        </table>
    </body>
     <script src="./assets/js/form-validation.js"></script>
</html>
