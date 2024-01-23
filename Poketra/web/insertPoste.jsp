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
        ArrayList<Ouvrier> o = (ArrayList<Ouvrier>) request.getAttribute("o");
        ArrayList<Employe> em = (ArrayList<Employe>) request.getAttribute("em");
    %>
    <body class="container-fluid bg-dark text-start text-light" >
        <div class="py-5"></div>
        <h1 class="text-center" >Insertion du poste de l'employe</h1>
        <div class="py-4"></div>
        <form action="FormInsertPoste" method="post" class="needs-validation" novalidate>
            <div class="row g-3 justify-content-center ">
               <div class="col-sm-5">
                   <label for="alrg" class="form-label h5">Poste :</label>
                        <select class="form-select" id="sac" name="poste" required style="height: 55px;">
                            <option value="">poste...</option>
                            <% for(int i =0; i < o.size(); i++){ %>
                            <option value="<%= o.get(i).getIdOuvrier() %>"><%= o.get(i).getOuvrier() %></option>
                            <% } %>
                        </select>
                    <div class="invalid-feedback">
                        Veuiller choisir un poste.
                    </div>
                </div>
                
               <div class="col-sm-5">
                   <label for="alrg" class="form-label h5">Employe :</label>
                        <select class="form-select" id="sac" name="emp" required style="height: 55px;">
                            <option value="">employe...</option>
                            <% for(int i =0; i < em.size(); i++){ %>
                            <option value="<%= em.get(i).getIdEmploye() %>"><%= em.get(i).getNom().toUpperCase() %> <%= em.get(i).getPrenom() %></option>
                            <% } %>
                        </select>
                    <div class="invalid-feedback">
                        Veuiller choisir un employe.
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
