<%-- 
    Document   : index
    Created on : 12 déc. 2023, 15:52:39
    Author     : toxic
--%>

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
        <div class="py-5"></div>
        <h1 class="text-center" >Insertion d'un nouveau Sac</h1>
        <!--<h5  class="text-center">insertion d'un nouveau look</h5>-->
        <div class="py-4"></div>
        <form action="FormCreateSac" method="post" class="needs-validation" novalidate>
            <div class="row g-3 justify-content-center ">
                 <div class="col-sm-5">
                <label for="sc" class="form-label h5">insertion d'un Sac :</label>
                <input type="text" class="form-control" id="sc" name="sc" style="height: 55px;" placeholder="entrer un look" required>
                <div class="invalid-feedback">
                  Veuillez inserez un nom eCorrect.
                </div>
              </div>
            </div>
            <div class="py-4"></div>
            <center>
                <input type="submit" class="text-center btn btn-warning btn-lg w-25" name="name" value="inserer le model">
            </center>
        </form>
    </body>
     <script src="./assets/js/form-validation.js"></script>
</html>
