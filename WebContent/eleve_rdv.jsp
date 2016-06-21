<%@ page language="java" import="java.sql.*" import="java.util.*"  contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="Model.Meeting" %>
<!DOCTYPE html>
<html>
<head>
	<title>Rendez-vous</title>

		<meta charset="utf-8">
 		<meta name="viewport" content="width=device-width, initial-scale=1">
  		<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  		<link href="css/connexion_accueil.css" rel="stylesheet"/>
  		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
  		<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
		  <!-- <link rel="stylesheet" href="css/datepicker.css"> -->
</head>
<body>

  <div class="container-fluid">

    <div class="row">
      <div class="col-md-5 col-md-offset-1 col-sm-5 col-sm-offset-1 col-xs-6">
        <img id="logo_isep_pages" src="drawable/Isep-Logo.png">
      </div>
      <div class="col-md-2 col-md-offset-4 col-sm-2 col-sm-offset-4 col-xs-3 col-xs-offset-3 ">
        <a href="connexion.html"><img id="logo_deconnexion_pages" src="drawable/deconnexion.svg"></a>
      </div>
    </div>

    <div class="row text-center">
      <div class="col-md-12 col-sm-12 col-xs-12">
        <h1 id="titre_pages">Rendez-vous</h1>
      </div>
    </div>

    <div id="menu_horizontal" class="row text-center">
      <div class="col-md-2 col-md-offset-2 col-sm-2 col-md-offset-2 col-xs-2 col-xs-offset-1">  
        <a href="eleve_accueil.html"><img id="logo_sujet" src="drawable/home.png" height="40" width="40"></a>
      </div>

      <div class="col-md-2 col-sm-2 col-xs-2">
        <a href="http://localhost:8080/Moo/SujetEleveServelt"><img id="logo_sujet" src="drawable/sujet.svg" height="40" width="40"></a>
      </div>

      <div class="col-md-2 col-sm-2 col-xs-2">
        <a href="http://localhost:8080/Moo/AddTeamServelt"><img id="logo_equipe" src="drawable/equipe.svg" height="40" width="40"></a>
      </div>
            
      <div class="col-md-2  col-sm-2 col-xs-2">
        <img id="logo_rdv" src="drawable/rdv.svg" height="40" width="40">
      </div>

      <div class="col-md-2  col-sm-2 col-xs-2">
        <a href="http://localhost:8080/Moo/DocumentServelt"><img id="logo_docs" src="drawable/docs.svg" height="40" width="40"></a>
      </div>            
    </div>

    <div id="cadre_contenu" class="row">

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
              <a href="http://localhost:8080/Moo/SujetEleveServlet"><li><img src="drawable/sujet.svg" height="30" width="30"></li></a> 
              <a href="http://localhost:8080/Moo/AddTeamServelt"><li><img src="drawable/equipe.svg" height="30" width="30"></li></a> 
              <a href=""><li><img src="drawable/rdv.svg" height="30" width="30"></li></a>
              <a href="http://localhost:8080/Moo/DocumentServlet"><li><img src="drawable/docs.svg" height="30" width="30"></li></a> 
            </ul>
          </li>
        </ul>
      </div>
      
    <div id="menu_lateral" class="col-sm-3">
       <ul class="list-group">
        <a href="eleve_accueil.html"><li class="list-group-item"><img src="drawable/home.png" height="50" width="50"> ACCUEIL</li></a>
        <a href="http://localhost:8080/Moo/SujetEleveServlet"><li class="list-group-item list-group-item-success"><img src="drawable/sujet.svg" height="50" width="50"> MON SUJET</li></a>
        <a href="http://localhost:8080/Moo/AddTeamServelt"><li class="list-group-item list-group-item-info"><img src="drawable/equipe.svg" height="50" width="50"> <b> MON ÉQUIPE</b> </li></a>
        <a href=""><li class="list-group-item list-group-item-warning"><img src="drawable/rdv.svg" height="50" width="50"> RDV</li></a>
        <a href="http://localhost:8080/Moo/DocumentServlet"><li class="list-group-item list-group-item-danger"><img src="drawable/docs.svg" height="50" width="50"> DOCUMENTS</li></a>
      </ul>
    </div>

	<% List meetings = (List) request.getAttribute("meetings");%>

	<div id="cadre_rdv" class="col-md-9 col-sm-12 col-xs-12">
        <div class="panel panel-warning">
          <div id="panel_title" class="panel-heading">RDV</div>
          <div class="panel-body">

            <table class="table table-striped">
            
            <thead>
               <tr>
                 <th>#</th>
                 <th>Date</th>
                 <th>Heure</th>
                 <th>Durée</th>
                 <th>Remarques</th>
               </tr>
             </thead>
            
            <% for ( int i = 0 ; i < meetings.size() ; i ++  ){
            	
            	Meeting meeting = (Meeting) meetings.get(i); %>
            	
            	<tr>
                  <td> <%= i %></td>
                  <td> <%= meeting.getDay() %></td>
                  <td>   <%= meeting.getHour() %></td>
              		<td><%= meeting.getMeetingTime() %> </td>
              		<td> <%= meeting.getComment() %></td>
                </tr>
            	
            <% }%>

            </table>

          </div>
        </div>
      </div>
      
    
    
    
    
    </div>
  </div>

</body>

<script>
  jQuery(document).ready(function($){
  $("li.content").hide();
  $("ul.toggle-menu").delegate("li.toggle", "click", function() { 
  $(this).next().toggle("fast").siblings(".content").hide("fast");
    });
});

</script>

</html>