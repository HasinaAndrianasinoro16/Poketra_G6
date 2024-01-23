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
                    <li><a class="dropdown-item h5" href="PrixSacCtrl">Prix Sac</a></li>
                    <li><a class="dropdown-item h5" href="AchatMatiere">Achat de Matiere</a></li>
                    <li><a class="dropdown-item h5" href="InsertOuvrier.jsp">Insertion ouvrier</a></li>
                    <li><a class="dropdown-item h5" href="PrixRevient">Prix Revient</a></li>
                    <li><a class="dropdown-item h5" href="SacOuvriers">Sac Ouvrier</a></li>
                    <li><a class="dropdown-item h5" href="InsertEmploye.jsp">Insertion Employe</a></li>
                    <li><a class="dropdown-item h5" href="InsertPoste">Insertion Poste</a></li>
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
                    <li><a class="dropdown-item h5" href="./FiltrePrix.jsp">Filtre prix sac</a></li>
                    <li><a class="dropdown-item h5" href="Fabrication">Fabrication de Sac</a></li>
                    <li><a class="dropdown-item h5" href="FiltreBenefice.jsp">Filtre benefice</a></li>
                    <li><a class="dropdown-item h5" href="ListeEmployeCtrl">Liste employe et taux horaire</a></li>
                  </ul>
                </li>
              </ul>
            </div>
          </div>
        </div>
      </nav>
    <script src="./assets/dist/js/bootstrap.bundle.min.js"></script>
</html>
