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
    %>
    <body class="container" >
        <h1 class="text-center" >Projet poketra</h1>
        <h5  class="text-center">Resultat demander</h5>
        <div class="my-4"></div>
        <table class="table table-striped text-center">
          <thead>
          <tr>
            <th scope="col">#</th>
            <th scope="col">code matiere</th>
            <th scope="col">matiere</th>
          </tr>
          </thead>
          <tbody>
              <% for(int i =0 ; i < tm.size(); i++) {%>
          <tr>
            <th scope="row"><%= i+1 %></th>
            <td><%= tm.get(i).getIdMatiere() %></td>
            <td><%=tm.get(i).getMatiere() %></td>
          </tr>
          <% } %>
          </tbody>
        </table>
    </body>
     <script src="./assets/js/form-validation.js"></script>
</html>
