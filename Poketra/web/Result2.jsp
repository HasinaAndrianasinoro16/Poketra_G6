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
        ArrayList<Sac_matiere> tm =  (ArrayList<Sac_matiere>)request.getAttribute("sacMatiere");
    %>
    <body class="container-fluid bg-dark text-start text-light" >
        <div class="py-4"></div>
        <h1 class="text-center" >Resultat demander</h1>
        <!--<h5  class="text-center">Resultat demander</h5>-->
        <div class="my-4"></div>
        <div class="py-4"></div>
        <p class="container text-start h5" >Les sacs fait a partir de la matiere: <span class="text-warning h4" ><%= tm.get(0).getMatiere() %></span></p>
        <div class="py-4"></div>
        <table class="table table-dark  table-hover text-light text-center container">
          <thead>
          <tr>
            <th scope="col">#</th>
            <th scope="col">code sac</th>
            <th scope="col">sac</th>
            <th scope="col">Taille</th>
            <th scope="col">Quantite</th>
            <!--<th scope="col"> -- </th>-->
          </tr>
          </thead>
          <tbody>
              <% for(int i =0 ; i < tm.size(); i++) {%>
          <tr>
            <th scope="row"><%= i+1 %></th>
            <td><%=tm.get(i).getIdSac() %></td>
            <td><%=tm.get(i).getNomSac() %></td>
            <td><%=tm.get(i).getTaille() %></td>
            <td><%=tm.get(i).getQuantite() %></td>
          </tr>
          <% } %>
          </tbody>
        </table>
    </body>
     <script src="./assets/js/form-validation.js"></script>
</html>
