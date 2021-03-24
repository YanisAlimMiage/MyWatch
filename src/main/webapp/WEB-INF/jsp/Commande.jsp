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
          
            <li><a class="nav-link scrollto" href="compte">Mon Compte</a></li>
          <li> <a class="nav-link scrollto" href="deconnect" > deconnexion </a></li>
           <li> <form action="/${user.getIdusers()}">
                                 <a class="nav-link scrollto active"><button type="submit" class"tm-bnt">commande</button></a>
                            
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
  <div class="container pt-5">

  
  
</br>
</br>
</br>
 <div class="progress">
  <div class="progress-bar w-100" role="progressbar" aria-valuenow="100" aria-valuemin="0" aria-valuemax="100"></div>
</div>
</br>
</br>
  
  
  
  <c:set var="prix" value="0" scope="page" />
  <c:set var="ini" value="1" scope="page" />
  <c:if test="${not empty commande }" >
   
       <c:forEach items="${commande}" var="orderss">
       <c:if test="${ orderss.send!=true && orderss.getArticles().size() !=0}" >
  <h3 style="text-align: center;">Panier: </h3>
   </c:if>
        </c:forEach>
 
 
  
  
  
  
  
  <c:forEach items="${commande}" var="orderss">
   <c:if test="${ orderss.send!=true && orderss.getArticles().size() !=0}" >
  
  <table class="table table-striped">
  <thead>
    <tr>
      
      <th scope="col">Numero</th>
      <th scope="col">Nom</th>
     
      <th></th>
    </tr>
  </thead>
  <tbody>
   <c:forEach items="${orderss.articles}" var="article">
    <tr>
    
      
      <td>${ini}</td>
      <td>${article.name}</td>
     
      <td><form modelAttribute="orderss" id="login-form" class="form" action="/removeArticle/${article.getIdarticle()}/${orderss.getIdcommande()}" method="get">
                         
                   <input type="submit" name="submit" class="btn btn-danger" value="Supprimer">
                        </form><td>
    </tr>
   <c:set var="ini" value="${ini + 1}" scope="page"/>
   <c:set var="prix" value="${prix +article.price}" scope="page"/>
     </c:forEach>
    
  </tbody>
</table>
 </c:if>
  </c:forEach>
 </c:if>
 

 
 
 
  <c:if test="${not empty commande }" >
   
       <c:forEach items="${commande}" var="orderss">
       <c:if test="${ orderss.send!=true && orderss.getArticles().size() !=0 }" >
 <h3  style="text-align: center;" >Prix Total : ${prix} €</h3>
  <form modelAttribute="orderss" id="login-form" class="form" action="comptee/${orderss. getIdcommande()}" method="get">
                         
                   <input   type="submit" name="submit" class="btn btn-info btn-md" value="passer commande">
                        </form>
                        
                        
                </c:if>
  </c:forEach>
 </c:if>        
                        
          
          
           </br>

</br>
</br>              
                        
                        <div class="progress">
  <div class="progress-bar w-100" role="progressbar" aria-valuenow="100" aria-valuemin="0" aria-valuemax="100"></div>
</div>
       
           </br>

</br>
</br>                    
      
      <c:set var="cmdn" value="0" scope="page" />
      <c:set var="cmpt" value="0" scope="page" />
      
       <c:if test="${not empty commande }" >
       <c:forEach items="${commande}" var="orderss">
       <c:if test="${ orderss.send==true }" >
        <c:if test="${cmpt==0 }" >
        <h3  style="text-align: center;">Historique des Commandes </h3>
        </c:if>
         <c:set var="cmpt" value="${cmpt + 1}" scope="page"/>
        </c:if>
          </c:forEach>
         </c:if>
        
         <c:if test="${not empty commande }" >
        <c:forEach items="${commande}" var="orderss">
        <c:set var="cmdn" value="${cmdn + 1}" scope="page"/>
   <c:if test="${ orderss.send==true }" >
  <h4  style="text-align: center;">Commande numero ${cmdn}  : <h4>
  <table class="table table-striped">
  <thead>
    <tr>
      
     
      <th scope="col">Nom</th>
      <th scope="col">Prix</th>
      
    </tr>
  </thead>
  <tbody>
   <c:forEach items="${orderss.articles}" var="article">
    <tr>
    
      
     
      <td>${article.name}</td>
      <td>${article.price} €</td>
      
    </tr>
   <c:set var="ini" value="${ini + 1}" scope="page"/>
   <c:set var="prix" value="${prix +article.price}" scope="page"/>
     </c:forEach>
    
  </tbody>
</table>
 </c:if>
  </c:forEach>
 </c:if>
        
        
          </br>

</br>
</br>       

                        <div class="progress">
  <div class="progress-bar w-100" role="progressbar" aria-valuenow="100" aria-valuemin="0" aria-valuemax="100"></div>
</div>
</br>

</br>
</br>       
        
        </div>
                        
  </body>
    </html>