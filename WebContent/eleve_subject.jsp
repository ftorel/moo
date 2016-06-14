<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="Model.Sujet" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Mon sujet</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <link href="css/connexion_accueil.css" rel="stylesheet"/>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
  
</head>
<body>


<div class="container-fluid">

	<div class="row">
    <div class="col-md-5 col-md-offset-1 col-sm-5 col-sm-offset-1 col-xs-6">
      <!-- <img id="logo_isep" src="Isep-Logo.png" width="160"> -->
      <img id="logo_isep_pages" src="drawable/Isep-Logo.png">
    </div>

    <div class="col-md-2 col-md-offset-4 col-sm-2 col-sm-offset-4 col-xs-3 col-xs-offset-3 ">
      <img id="logo_deconnexion_pages" src="drawable/deconnexion.svg">
    </div>
  </div>

  <div class="row text-center">
    <div class="col-md-12">
      <h1 id="titre_pages">Mon sujet</h1>
    </div>
  </div>

  <div id="menu_horizontal" class="row text-center">
        <div class="col-md-2 col-md-offset-2 col-sm-2 col-md-offset-2 col-xs-2 col-xs-offset-1">  
          <a href="eleve_accueil.html"><img id="logo_sujet" src="drawable/home.png" height="40" width="40"></a>
        </div>

        <div class="col-md-2 col-sm-2 col-xs-2">
          <a href=""><img id="logo_equipe" src="drawable/sujet.svg" height="40" width="40"></a>
        </div>

        <div class="col-md-2 col-sm-2 col-xs-2">
          <a href="eleve_equipe.html"><img id="logo_equipe" src="drawable/equipe.svg" height="40" width="40"></a>
        </div>
        
        <div class="col-md-2  col-sm-2 col-xs-2">
          <a href="eleve_rdv.html"><img id="logo_rdv" src="drawable/rdv.svg" height="40" width="40"></a>
        </div>

        <div class="col-md-2  col-sm-2 col-xs-2">
          <a href="eleve_DocumentsV2.html"><img id="logo_docs" src="drawable/docs.svg" height="40" width="40"></a>
        </div>
      </div>

    <div id="cadre_contenu" class="row">
    	<div id="menu_lateral" class="col-sm-3">
        <ul class="list-group">
          <a href="eleve_accueil.html"><li class="list-group-item"><img src="drawable/home.png" height="50" width="50"> ACCUEIL</li></a>
          <a href=""><li class="list-group-item list-group-item-success"><img src="drawable/sujet.svg" height="50" width="50"><b>  MON SUJET</b></li></a>
          <a href="eleve_equipe.html"><li class="list-group-item list-group-item-info"><img src="drawable/equipe.svg" height="50" width="50">  MON ÉQUIPE</li></a>
          <a href="eleve_rdv.html"><li class="list-group-item list-group-item-warning"><img src="drawable/rdv.svg" height="50" width="50">  RDV</li></a>
          <a href="eleve_DocumentsV2.html"><li class="list-group-item list-group-item-danger"><img src="drawable/docs.svg" height="50" width="50">  DOCUMENTS</li></a>
        </ul>
      </div>

      <div id="menu_xs" class="menu-links">
        <ul class="toggle-menu">
          <li class="toggle">
            <span class="toggle-menu-bar"></span>
            <span class="toggle-menu-bar"></span>
            <span class="toggle-menu-bar"></span>
          </li>
          <li class="content">
            <ul>
              <a href="eleve_accueil.html"><li><img src="drawable/home.png" height="30" width="30"></li></a>
              <a href=""><li><img src="drawable/sujet.svg" height="30" width="30"></li></a> 
              <a href="eleve_equipe.html"><li><img src="drawable/equipe.svg" height="30" width="30"></li></a> 
              <a href="eleve_rdv.html"><li><img src="drawable/rdv.svg" height="30" width="30"></li></a>
              <a href="eleve_DocumentsV2.html"><li><img src="drawable/docs.svg" height="30" width="30"></li></a> 
            </ul>
          </li>
        </ul>
      </div>

 
   
    <% Sujet sujet = (Sujet) request.getAttribute("sujet");  
    	String title = " Pas de sujet ";
    	String description = " Vous devez être dans une équipe pour avoir un sujet. \n " +
    			"Merci de séléctionner votre équipe.";
    
    	if ( sujet != null ) {
    		title = sujet.getName();
    		description = sujet.getDecription();
    	}
    %>
    
    <div id="cadre_sujet" class="col-md-9 col-sm-12 col-xs-12">
        <div class="panel panel-success">
          <div id="panel_title" class="panel-heading"><%= title%></div>
            <div class="panel-body">
	            <%= description%>
            </div>
        </div>
      </div>
    
   
  </div>
</div>

</body>


<script type="text/javascript">
  jQuery(document).ready(function($){
  $("li.content").hide();
  $("ul.toggle-menu").delegate("li.toggle", "click", function() { 
  $(this).next().toggle("fast").siblings(".content").hide("fast");
    });
});
</script>

</html>