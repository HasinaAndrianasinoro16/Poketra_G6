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
        ArrayList<SacBenefice> liste = (ArrayList<SacBenefice>) request.getAttribute("ls");
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
            <th scope="col">code sac</th>
            <th scope="col">sac</th>
            <th scope="col" >taille</th>
            <th scope="col">benefice</th>
            <!--<th scope="col"> -- </th>-->
          </tr>
          </thead>
          <tbody>
              <% for(int i =0 ; i < liste.size(); i++) {%>
          <tr>
            <th scope="row"><%= i+1 %></th>
            <td><%= liste.get(i).getIdSac() %></td>
            <td><%= liste.get(i).getTaille() %></td>
            <td><%= liste.get(i).getNomSac() %></td>
            <td><%= liste.get(i).getBenefice() %></td>
          </tr>
          <% } %>
          </tbody>
        </table>
    </body>
     <script src="./assets/js/form-validation.js"></script>
</html>
