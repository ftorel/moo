<%@ page language="java" import="java.sql.*" import="java.util.*"  contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="Model.Session" %>
<%@ page import="Model.Sujet" %>
<%@ page import="Model.Team" %>

<!DOCTYPE html>
<html lang="en">
<head>
  <title>Sujets - Professeur</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <link href="css/font-awesome.min.css" rel="stylesheet"> 
  <link href="css/connexion_accueil.css" rel="stylesheet"/>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
  <script src="js/jquery.js"></script> 
  <script src="js/bootstrap.min.js"></script> 

    <link href="http://cdn.rawgit.com/davidstutz/bootstrap-multiselect/master/dist/css/bootstrap-multiselect.css" rel="stylesheet" type="text/css" />
    <script src="http://cdn.rawgit.com/davidstutz/bootstrap-multiselect/master/dist/js/bootstrap-multiselect.js" type="text/javascript"></script>

</head> 

<body>

  <div class="container-fluid">
  
  <%List sessions =(List)request.getAttribute("sessions");%>
  <%List sujets =(List)request.getAttribute("sujets");%>
  <%List teams =(List)request.getAttribute("teams");%>

    <div class="row">
      <div class="col-md-5 col-md-offset-1 col-sm-5 col-sm-offset-1 col-xs-6">
        <img id="logo_isep_pages" src="drawable/Isep-Logo.png">
      </div>

      <div class="col-md-2 col-md-offset-4 col-sm-2 col-sm-offset-4 col-xs-2 col-xs-offset-4 ">
        <img id="logo_deconnexion_pages" src="drawable/deconnexion.svg">
      </div>
    </div>

    <div class="row text-center">
      <div class="col-md-12 col-sm-12 col-xs-12">
        <h1 id="titre_pages">Sujets</h1>
      </div>
    </div>

    <div id="menu_horizontal" class="row text-center">
      <div class="col-md-2 col-sm-2 col-xs-2">  
        <a href="prof_accueil.html"><img id="logo_sujet" src="drawable/home.png" height="40" width="40"></a>
      </div>

      <div class="col-md-2 col-sm-2 col-xs-2">
        <a href="prof_session.html"><img id="logo_equipe" src="drawable/sessions.svg" height="40" width="40"></a>
      </div>

      <div class="col-md-2 col-sm-2 col-xs-2">
        <a href=""><img id="logo_equipe" src="drawable/sujet.svg" height="40" width="40"></a>
      </div>

      <div class="col-md-2 col-sm-2 col-xs-2">
        <a href="prof_equipe.html"><img id="logo_equipe" src="drawable/equipe.svg" height="40" width="40"></a>
      </div>
            
      <div class="col-md-2  col-sm-2 col-xs-2">
        <a href="prof_rdv.html"><img id="logo_rdv" src="drawable/rdv.svg" height="40" width="40"></a>
      </div>

      <div class="col-md-2  col-sm-2 col-xs-2">
        <a href="prof_documents.html"><img id="logo_docs" src="drawable/docs.svg" height="40" width="40"></a>
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
              <a href="prof_accueil.html"><li><img src="drawable/home.png" height="30" width="30"></li></a>
              <a href="prof_session.html"><li><img src="drawable/sessions.svg" height="30" width="30"></li></a> 
              <a href="prof_sujet.html"><li><img src="drawable/sujet.svg" height="30" width="30"></li></a> 
              <a href="prof_equipe.html"><li><img src="drawable/equipe.svg" height="30" width="30"></li></a> 
              <a href="prof_rdv.html"><li><img src="drawable/rdv.svg" height="30" width="30"></li></a>
              <a href=""><li><img src="drawable/docs.svg" height="30" width="30"></li></a> 
            </ul>
          </li>
        </ul>
      </div>
      
      <div id="menu_lateral" class="col-sm-3">
         <ul class="list-group">
          <a href="prof_accueil.html"><li class="list-group-item"><img src="drawable/home.png" height="50" width="50"> ACCUEIL</li></a>
          <a href="prof_session.html"><li class="list-group-item list-group-item-danger"><img src="drawable/sessions.svg" height="50" width="50"> SESSIONS</li></a>

          <a href="prof_sujet.html"><li class="list-group-item list-group-item-success"><img src="drawable/sujet.svg" height="50" width="50"> SUJETS</li></a>

          <a href="prof_equipe.html"><li class="list-group-item list-group-item-info"><img src="drawable/equipe.svg" height="50" width="50"> ÉQUIPES</li></a>
          <a href="prof_rdv.html"><li class="list-group-item list-group-item-warning"><img src="drawable/rdv.svg" height="50" width="50"> RDV</li></a>
          <a href=""><li class="list-group-item list-group-item-danger"><img src="drawable/docs.svg" height="50" width="50"><b> DOCUMENTS</b> </li></a>
        </ul>
      </div>



      <div class="col-md-9 col-sm-12 col-xs-12">
        <div class="panel panel-danger">
          <div id="panel_title" class="panel-heading">Creer et assigner des Sujets</div>
           <br/><br/>    

    
        <div class="panel-body">
		<form method="post" action="SaveSubject" enctype="multipart/form-data">             
              <div class="col-md-12 col-sm-12 col-xs-12 text-center"></div>

<p id="legende" >Titre du Sujet:	
<input type="text" name="Tsubj"></p><br>
Description du sujet:<br>
 <input class="description" type="text" name="Dsubj"><br>
<br>

<p id="legende" >Sélectionner une session :</p>

                <form role="form" name="form-session" action="" method="post">
                  <div class="form-group text-center">
                    <select class="form-control" id="session_selector">
                    
                    <% for ( int i = 0 ; i < sessions.size() ; i ++ ){ %>
                    	<% Session s = (Session) sessions.get(i); %>
                    	<option> <%= s.getStartDay() + " - " + s.getEndDay() %></option>
                    <%}%>
                    
                      
                    </select>
                    <br>
                </form>
                
			<p id="legende" >Sélectionner les équipes :</p>
			<select id="equipes" multiple="multiple">
					<% for ( int i = 0 ; i < teams.size() ; i ++ ){ %>
                    	<% Team t = (Team) teams.get(i); %>
                    	<option values=""> <%= t.getName()  %></option>
                    <%}%>
			       
			    </select>

<br>
<br>


              <div class="form-group col-md-12 col-sm-12 col-xs-12 text-center"><input type="submit" class="btn btn-danger" id="save_btn" value="Save"/></div>
            </form>
<br>
<br>

      


        <div class="panel panel-danger">
          <div id="panel_title" class="panel-heading">Récapitulatif du sujet</div>

<p id="legende">Sélectionner un Sujet:</p>

			<% Sujet sujet = null; %>

              <form role="form" name="form" action="" method="post">
                <div class="form-group text-center">
                  <select class="form-control" id="equipe_selector">
                    <% for ( int i = 0 ; i < sujets.size() ; i ++ ){ %>
                    	<% sujet = (Sujet) sujets.get(i); %>
                    	<option values=""> <%= sujet.getName()  %></option>
                    <%}%>
                  </select>
                  <br>
              </form>
              
              <% if ( sujet != null) {%>


			<table class="table description">
	            <thead>
	              <tr>
	                <th>Description</th>
	              </tr>
	            </thead>
	            <tbody>
	              <tr>
	                <td> <%= sujet.getDecription() %></td>
	              </tr>
	           </tbody>
	   	</table>
	
	
	          <table class="table assign">
	            <thead>
	              <tr>
	                <th>Client</th>
	                <th>équipes assignées</th>
	              </tr>
	            </thead>
	            <tbody>
	              <tr>
	                <td>Zakia KAZI-AOUL</td>
	                <td>Vert Bouteille</td>
	              </tr>
	              <tr>
	                <td></td>
	                <td>Bleu</td>
	              </tr>
	              <tr>
	                <td></td>
	                <td>Rouge</td>
	              </tr> 
	           </tbody>
          </table>


		<table class="table fonctions">
	            <thead>
	              <tr>
	                <th>Fonctionnalités</th>
	                <th>Th&egraveme</th>
				<th>Priorité</th>
	              </tr>
	            </thead>
	            <tbody>
	              <tr>
	                <td>Downloader un document</td>
	                <td>Dépot de documents</td>
	                <td>2</td>
	              </tr>
	              <tr>
	                <td>Se connecter avec identifiants ISEP</td>
	                <td>Connection</td>
	                <td>2</td>
	              </tr>
	              <tr>
	                <td>Choisir une equipe</td>
	                <td>Choix equipe</td>
	                <td>1</td>
	              </tr> 
	           </tbody>
          </table>
          
          
          <%}%>

        </div>
        </div>
        </div>
      </div>
    </div>

  </div>

</body>

    <script type="text/javascript">
        jQuery(document).ready(function ($) {
            $("li.content").hide();
            $("ul.toggle-menu").delegate("li.toggle", "click", function () {
                $(this).next().toggle("fast").siblings(".content").hide("fast");
            });
        });


        $(function () {
            $('#equipes').multiselect({
                includeSelectAllOption: false
            });

        });

</script>


</html>