<%-- 
    Document   : dashboard
    Created on : 12 déc. 2023, 15:54:24
    Author     : toxic
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        <header class="d-flex flex-wrap align-items-center justify-content-center justify-content-md-between py-3 mb-4 border-bottom bg-dark">
            <a href="./index.jsp" class="d-flex justify-content-center col-md-3 mb-2 mb-md-0 text-dark text-decoration-none"> 
        <!--<svg class="bi me-2" width="40" height="32" role="img" aria-label="Bootstrap"><use xlink:href="#bootstrap"></use></svg>-->
        <img src="./assets/logo/Poketra G6-logo/vector/default-monochrome.svg" style="border-radius: 20%"  width="120%" height="50" alt="alt"/>
      </a>

      <ul class="nav col-12 col-md-auto mb-2 justify-content-center mb-md-0">
          <li><a href="index.jsp" class="nav-link px-2 link-light"> <i class="fas fa-star" ></i> Insert. Look</a></li>
          <li><a href="formulaireMatiereCtrl" class="nav-link px-2 link-light"> <i class="fas fa-tags" ></i> Insert. matiere</a></li>
          <li><a href="insertMatierectrl" class="nav-link px-2 link-light"> <i class="fas fa-list-ul" ></i> voir matieres</a></li>
      </ul>

      <div class="col-md-3 text-end">
        <button type="button" class="btn btn-outline-light me-2">Sign-in</button>
        <button type="button" class="btn btn-warning">Sign-up</button>
      </div>
    </header>
<!--        <header class="d-flex flex-wrap justify-content-center py-3 mb-4 border-bottom">
      <a href="/" class="d-flex align-items-center mb-3 mb-md-0 me-md-auto text-dark text-decoration-none">
               <span class="fs-4">G6 projet poketra</span>
      </a>

      <ul class="nav nav-pills">
          <li class="nav-item"><a href="index.jsp" class="nav-link " aria-current="page">insertion d'un look</a></li>
        <li class="nav-item"><a href="formulaireMatiereCtrl" class="nav-link">insertion d'une nouvelle matiere</a></li>
        <li class="nav-item"><a href="insertMatierectrl" class="nav-link">voir les matieres</a></li>
      </ul>
    </header>-->
</html>
