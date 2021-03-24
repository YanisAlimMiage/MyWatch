
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
          <li><a class="nav-link scrollto active" href="/">Accuil</a></li>
          <li><a class="nav-link scrollto " href="#nosM">Montres</a></li>
          <c:if test="${connected == true }" >
         
            <li><a class="nav-link scrollto" href="compte">Mon Compte</a></li>
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
  
  <c:set var="prix" value="0" scope="page" />
      <div id="hero" class="hero route bg-image">
    <div class="overlay-itro"></div>
    <div class="hero-content display-table">
      <div class="table-cell">
        <div class="container">
          
          <h1 class="hero-title mb-4">My Watch</h1>
          <p class="hero-subtitle"><span class="typed" data-typed-items="Designer, Developer, Freelancer, Photographer"></span></p>
          <h1 >
                  <a href="" class="typewrite" data-period="2000" data-type='[ "Montre Mécanique.", "Montre automatique.", "Montre connectée." ]'>
                   <span class="wrap"></span>
                 </a>
</h1>
        
        </div>
      </div>
    </div>
  </div>
    <h1></h1>
   
    <br/><br/>
    <div>
    
     <div id="nosM"class="row">
     <h2 class="nosh">Nos Montre</h2>
    <c:forEach items="${article}" var="articles">
 
    <div class="col-md-3">
    <div class="card" style="width: 18rem;">
  <img class="card-img-top" src="./img/${articles.img}" alt="Card image cap">
  <div class="card-body">
    <h5 class="card-title" name="name">${articles.name}</h5>
    <h5 class="card-title">Prix : ${articles.price}</h5>
    <p class="card-text">${articles.description} </p>
   
  
    <c:set var="ini" value="${articles}" scope="page"/>
    
    <c:if test="${connected == true }" >
  
   
   
                               <c:if test="${articles.quantity > 0 }" >
                               
                            <form action="/add/${articles.getIdarticle()}/${user.getIdusers()}">
                                 <button type="submit" class"tm-bnt">ajouter</button>
                            
                            </form>
                             </c:if>
                             <c:if test="${articles.quantity < 1 }" >
                             <p> stock insuffisant  <p>
                               </c:if>
    </c:if>
      
  </div>
</div>
</div>
 
</c:forEach>


</div>

  </body>
    </html>