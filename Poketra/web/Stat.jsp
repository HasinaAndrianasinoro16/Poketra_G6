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
    <script src="./assets/js/form-validation.js"></script>
     <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
    </head>
    <%
        int mal = (int) request.getAttribute("mal");
        int femal = (int) request.getAttribute("femal");
        int pmal = (int) request.getAttribute("pmal");
        int pfemal = (int) request.getAttribute("pfemal");
        int total = (int) request.getAttribute("total");
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
            <th scope="col">Vente total</th>
            <th scope="col">Vente Homme</th>
            <th scope="col">Vente Femme</th>
            <!--<th scope="col"> -- </th>-->
          </tr>
          </thead>
          <tbody>
              
          <tr>
              <td><%= total %></td>
              <td><%= mal %></td>
              <td><%= femal %></td>
          </tr>
          </tbody>
        </table>
          <div class="py-3"></div>
          
          <canvas id="myChart" width="100" height="50"></canvas>
          
    </body>
    <script>
        // Sample data for the bar chart
        var data = {
            labels: ["Homme", "Femme"],
            datasets: [{
                data: [<%= pmal %>, <%= pfemal %>],
                backgroundColor: [
                    'rgba(255, 99, 132, 0.2)',
                    'rgba(54, 162, 235, 0.2)'
                ],
                borderColor: [
                    'rgba(255, 99, 132, 1)',
                    'rgba(54, 162, 235, 1)'
                ],
                borderWidth: 1
            }]
        };

        // Get the canvas element
        var ctx = document.getElementById('myChart').getContext('2d');

        // Create a bar chart
        var myBarChart = new Chart(ctx, {
            type: 'bar',
            data: data,
            options: {
                scales: {
                    y: {
                        beginAtZero: true
                    }
                }
            }
        });
    </script>
    
     
</html>
