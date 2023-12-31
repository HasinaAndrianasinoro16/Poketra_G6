<%-- 
    Document   : index
    Created on : 12 déc. 2023, 15:52:39
    Author     : toxic
--%>

<%@page import="Model.Look"%>
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
        ArrayList<Look> lk = (ArrayList<Look>) request.getAttribute("look");
    %>
    <body class="container-fluid bg-dark text-start text-light" >
        <div class="py-5"></div>
        <h1 class="text-center" >Insertion d'une nouvelle matiere</h1>
        <div class="py-4"></div>
<!--        <h5  class="text-center">insertion d'une nouvelle matiere</h5>-->
        <div class="my-4"></div>
        <form action="FormMatiere" method="post" class="needs-validation" novalidate>
            <div class="row g-3 justify-content-center">
                 <div class="col-sm-7">
                <label for="mt" class="form-label h5">insertion de la nouvelle matiere :</label>
                <input type="text" class="form-control" id="mt" name="mt" style="height: 55px;" placeholder="entrer une matiere" required>
                <div class="invalid-feedback">
                  Veuillez inserez une quantite.
                </div>
              </div>
                <div class="my-3"></div>
               <div class="col-sm-7">
                   <label  class="form-label h5">choix du look : </label>
                   <% for(int i =0; i < lk.size(); i++){ %>
                   <div class="form-check form-check-inline">
                    <input class="form-check-input" type="checkbox" value="<%= lk.get(i).getIdLook() %>" id="exampleCheckbox" name="lk">
                    <label class="form-check-label h6" for="exampleCheckbox">
                    <%= lk.get(i).getLook() %>
                    </label>
                    </div>
                    <% } %>
    
</div>
            </div>
            <div class="my-4"></div>
            <center>
                <input type="submit" class="text-center btn btn-warning btn-lg w-25" name="name" value="Inserer la matiere">
            </center>
        </form>
    </body>
     <script src="./assets/js/form-validation.js"></script>
</html>
