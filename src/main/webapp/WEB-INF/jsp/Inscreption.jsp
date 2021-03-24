
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
<html>
  <head>
  <meta  http-equiv="Content-Type"  content="text/html; charset=UTF-8">

     <link  rel="stylesheet" type="text/css" href="./css/style.css">
     <script type="text/javascript" src="./js/js.js"></script>
    <title>MyWatch</title>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
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
          <li><a class="nav-link scrollto" href="commande">Commandes & Panier</a></li>
           
          <li> <a class="nav-link scrollto" href="deconnect" > deconnexion </a></li>
          </c:if>
          <c:if test="${connected != true }" >
          <li><a class="nav-link scrollto " href="connexion">Connexion</a></li>
          <li><a class="nav-link scrollto active" href="inscreption">Inscription</a></li>
          
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













<div class="container">    

        <div id="signupbox" style=" margin-top:50px" class="mainbox col-md-8 col-md-offset-2 col-sm-8 col-sm-offset-2">
                    <div class="panel panel-info">
                        <div class="panel-heading">
                            <div class="panel-title">FORMULAIRE D'INSCRIPTION</div>
                            <div style="float:right; font-size: 85%; position: relative; top:-10px">Vous avez un compte!  <a id="signinlink" href="connexion" onclick="$('#signupbox').hide(); $('#loginbox').show()">Se connecter</a></div>
                        </div>  
                        <div class="panel-body" >
                            <form modelAttribute="personne" id="signupform" class="form-horizontal" role="form" action="newUser" method="post">
                                
                                
                                    
                                
                                  
                                <div class="form-group">
                                    <label for="email" class="col-md-3 control-label">Email</label>
                                    <div class="col-md-9">
                                        <input type="text" class="form-control" name="email" placeholder="Email Address">
                                    </div>
                                </div>
                                    
                                <div class="form-group">
                                    <label for="password" class="col-md-3 control-label">Mot de passe</label>
                                    <div class="col-md-9">
                                        <input type="password" id="login-password" class="form-control" name="password" placeholder="mot de passe">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="lastname" class="col-md-3 control-label">Nom</label>
                                    <div class="col-md-9">
                                        <input type="text" class="form-control" name="lastname" placeholder="Nom">
                                    </div>
                                </div>
                              
                                    
                                <div class="form-group">
                                    <label for="icode" class="col-md-3 control-label">Prénom</label>
                                    <div class="col-md-9">
                                        <input type="text" class="form-control" name="name" placeholder="Prénom">
                                    </div>
                                </div>
                                <input class="btn btn-info btn-md" type="submit" value="S'inscrire">
                               
                                
                               
                                
                                
                                
                            </form>
                         </div>
                    </div>

               
               
                
         </div> 
    </div>
     </body>
    </html>
    