<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
<html>
  <head>
<%@ page pageEncoding="UTF-8" %>

     <link  rel="stylesheet" type="text/css" href="./css/style.css">
     <script type="text/javascript" src="./js/js.js"></script>
    <title>MyWatch</title>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
        <link rel="icon" href="%PUBLIC_URL%/favicon.ico" />
    
  </head>
 <body>
 <header id="header" class="fixed-top">
    <div class="container d-flex align-items-center justify-content-between">

      <h1 class="logo"><a href="/">My Watch</a></h1>
   
    

      <nav id="navbar" class="navbar">
        <ul>
          <li><a class="nav-link scrollto " href="/">Accuil</a></li>
         
          <c:if test="${connected == true }" >
         
           <li><a class="nav-link scrollto active" href="compte">Mon Compte</a></li>
          <li> <a class="nav-link scrollto" href="deconnect" > deconnexion </a></li>
           <li> <form action="/${user.getIdusers()}">
                                 <a class="nav-link scrollto "><button type="submit" class"tm-bnt">commande</button></a>
                            
                            </form></li>
          </c:if>
          <c:if test="${connected != true }" >
          <li><a class="nav-link scrollto " href="connexion">Connexion</a></li>
          <li><a class="nav-link scrollto" href="inscreption">Inscription</a></li>
          
        </c:if>
        </ul>
        <i class="bi bi-list mobile-nav-toggle"></i>
      </nav>
    </div>
  </header>
  </br>
</br>
</br>
</br>
</br>
  <div class="jumbotron">
  <h1 class="display-4"> Bienvenue ${user.name}, </h1>
  <p class="lead"></p>
  <hr class="my-4">
  
  
</div>
  
  <a class="btn btn-danger" href="deconnect" > deconnexion </a>
  </body>
    </html>