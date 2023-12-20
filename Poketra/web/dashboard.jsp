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
    
    <nav class="navbar navbar-dark bg-dark" aria-label="Dark offcanvas navbar" style="border-bottom: 2px solid white;">
        <div class="container-fluid">
            <a class="navbar-brand col-md-4" href="#"><img src="./assets/logo/Poketra Groupe6-logo//vector/default-monochrome.svg" alt="no picture" width="100%" height="80"></a>
          <button class="navbar-toggler" type="button" data-bs-toggle="offcanvas" data-bs-target="#offcanvasNavbarDark" aria-controls="offcanvasNavbarDark">
            <span class="navbar-toggler-icon"></span>
          </button>
          <div class="offcanvas offcanvas-end text-bg-dark" tabindex="-1" id="offcanvasNavbarDark" aria-labelledby="offcanvasNavbarDarkLabel">
            <div class="offcanvas-header">
              <h5 class="offcanvas-title" id="offcanvasNavbarDarkLabel">Projet Poketra G6</h5>
              <button type="button" class="btn-close btn-close-white" data-bs-dismiss="offcanvas" aria-label="Close"></button>
            </div>
            <div class="offcanvas-body">
              <ul class="navbar-nav justify-content-end flex-grow-1 pe-3">
                   <li class="nav-item">
                  <a class="btn btn-lg btn-warning w-100" aria-current="page" href="#"><i class="fas fa-cart-arrow-down mx-1"></i>My Cart</a>
                </li>
                <div class="py-3"></div>
                <li class="nav-item">
                  <a class="btn btn-lg btn-outline-light w-100" aria-current="page" href="index.jsp"><i class="fas fa-home mx-1"></i> Home</a>
                </li>
                <div class="py-3"></div>
                <li class="nav-item">
                  <a class="btn btn-lg btn-outline-light w-100" aria-current="page" href="creationSac.jsp"><i class="fas fa-tag mx-1"></i>Model sac creation</a>
                </li>
                <div class="py-3"></div>
                
                <li class="nav-item dropdown ">
                  <a class="dropdown-toggle btn btn-lg btn-outline-light w-100" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                      <i class="fas fa-tags" ></i> Insertion
                  </a>
                  <ul class="dropdown-menu">
                    <li><a class="dropdown-item h5" href="insertLook.jsp">Look</a></li>
                    <li><a class="dropdown-item h5" href="insertTaille.jsp">Taille</a></li>
                    <li><a class="dropdown-item h5" href="formulaireMatiereCtrl">Matiere</a></li>
                    <li><a class="dropdown-item h5" href="FormMatiereSac">Sac matiere</a></li>
                  </ul>
                </li>
                <div class="py-3"></div>
                <li class="nav-item dropdown ">
                  <a class="dropdown-toggle btn btn-lg btn-outline-light w-100" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                      <i class="fas fa-list-ul" ></i> Liste
                  </a>
                  <ul class="dropdown-menu  ">
                    <li><a class="dropdown-item h5" href="insertMatierectrl">Voir matiere</a></li>
                    <li><a class="dropdown-item h5" href="FiltreMatiere">Filtre matiere sac</a></li>
                  </ul>
                </li>
              </ul>
            </div>
          </div>
        </div>
      </nav>
    <script src="./assets/dist/js/bootstrap.bundle.min.js"></script>
    
    
    
    
    
    
    
<!--        <header class="d-flex flex-wrap align-items-center justify-content-center justify-content-md-between py-3 mb-4 border-bottom bg-dark">
            <a href="./index.jsp" class="d-flex justify-content-center col-md-3 mb-2 mb-md-0 text-dark text-decoration-none"> 
        <svg class="bi me-2" width="40" height="32" role="img" aria-label="Bootstrap"><use xlink:href="#bootstrap"></use></svg>
        <img src="./assets/logo/Poketra G6-logo/vector/default-monochrome.svg" style="border-radius: 20%"  width="120%" height="50" alt="alt"/>
      </a>

      <ul class="nav col-12 col-md-auto mb-2 justify-content-center mb-md-0">
          <li><a href="index.jsp" class="nav-link px-2 link-light"> <i class="fas fa-star" ></i> Insert. Look</a></li>\\
          <li><a href="creationSac.jsp" class="nav-link px-2 link-light"> <i class="fas fa-star" ></i> creation sac</a></li>
          <li><a href="insertTaille.jsp" class="nav-link px-2 link-light"> <i class="fas fa-star" ></i> insert. Taille</a></li>
          <li><a href="formulaireMatiereCtrl" class="nav-link px-2 link-light"> <i class="fas fa-tags" ></i> Insert. matiere</a></li>
          <li><a href="FormMatiereSac" class="nav-link px-2 link-light"> <i class="fas fa-tags" ></i> Insert. sac matiere</a></li>
          <li><a href="insertMatierectrl" class="nav-link px-2 link-light"> <i class="fas fa-list-ul" ></i> voir matieres</a></li>
          <li><a href="FiltreMatiere" class="nav-link px-2 link-light"> <i class="fas fa-list-ul" ></i> filtre matiere</a></li>
      </ul>

      <div class="col-md-3 text-end">
          <button type="button" class="btn btn-warning me-2 btn-lg"> <i class="fas fa-cart-arrow-down" ></i> My Cart</button>
        <button type="button" class="btn btn-warning">Sign-up</button>
      </div>
    </header>-->
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
