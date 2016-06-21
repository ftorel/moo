<%@ page language="java" import="java.sql.*" import="java.util.*"  contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="Model.Session" %>
<%@ page import="Model.Sujet" %>
<%@ page import="Model.Team" %>
<%@ page import="Model.Feature" %>

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
  <%List features =(List)request.getAttribute("features");%>

    <div class="row">
      <div class="col-md-5 col-md-offset-1 col-sm-5 col-sm-offset-1 col-xs-6">
        <img id="logo_isep_pages" src="drawable/Isep-Logo.png">
      </div>

      <div class="col-md-2 col-md-offset-4 col-sm-2 col-sm-offset-4 col-xs-2 col-xs-offset-4 ">
        <a href="connexion.html"><img id="logo_deconnexion_pages" src="drawable/deconnexion.svg"></a>
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
        <a href="http://localhost:8080/Moo/SessionProfServlet"><img id="logo_equipe" src="drawable/sessions.svg" height="40" width="40"></a>
      </div>

      <div class="col-md-2 col-sm-2 col-xs-2">
        <a href=""><img id="logo_equipe" src="drawable/sujet.svg" height="40" width="40"></a>
      </div>

      <div class="col-md-2 col-sm-2 col-xs-2">
        <a href="http://localhost:8080/Moo/TeamProfServelt"><img id="logo_equipe" src="drawable/equipe.svg" height="40" width="40"></a>
      </div>
            
      <div class="col-md-2  col-sm-2 col-xs-2">
        <a href="http://localhost:8080/Moo/MeetingProfServlet"><img id="logo_rdv" src="drawable/rdv.svg" height="40" width="40"></a>
      </div>

      <div class="col-md-2  col-sm-2 col-xs-2">
        <a href="http://localhost:8080/Moo/DocumentServlet"><img id="logo_docs" src="drawable/docs.svg" height="40" width="40"></a>
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
              <a href="http://localhost:8080/Moo/SessionProfServlet"><li><img src="drawable/sessions.svg" height="30" width="30"></li></a> 
              <a href=""><li><img src="drawable/sujet.svg" height="30" width="30"></li></a> 
              <a href="http://localhost:8080/Moo/TeamProfServelt"><li><img src="drawable/equipe.svg" height="30" width="30"></li></a> 
              <a href="http://localhost:8080/Moo/MeetingProfServlet"><li><img src="drawable/rdv.svg" height="30" width="30"></li></a>
              <a href="http://localhost:8080/Moo/DocumentServlet"><li><img src="drawable/docs.svg" height="30" width="30"></li></a> 
            </ul>
          </li>
        </ul>
      </div>
      
      <div id="menu_lateral" class="col-sm-3">
         <ul class="list-group">
          <a href="prof_accueil.html"><li class="list-group-item"><img src="drawable/home.png" height="50" width="50"> ACCUEIL</li></a>
          <a href="http://localhost:8080/Moo/SessionProfServlet"><li class="list-group-item list-group-item-danger"><img src="drawable/sessions.svg" height="50" width="50"> SESSIONS</li></a>

          <a href=""><li class="list-group-item list-group-item-success"><img src="drawable/sujet.svg" height="50" width="50"> SUJETS</li></a>

          <a href="http://localhost:8080/Moo/TeamProfServelt"><li class="list-group-item list-group-item-info"><img src="drawable/equipe.svg" height="50" width="50"> ÉQUIPES</li></a>
          <a href="http://localhost:8080/Moo/MeetingProfServlet"><li class="list-group-item list-group-item-warning"><img src="drawable/rdv.svg" height="50" width="50"> RDV</li></a>
          <a href="http://localhost:8080/Moo/DocumentServlet"><li class="list-group-item list-group-item-danger"><img src="drawable/docs.svg" height="50" width="50"><b> DOCUMENTS</b> </li></a>
        </ul>
      </div>
      
      <div class="col-md-9 col-sm-12 col-xs-12">
        <div class="panel panel-success">
          <div id="panel_title" class="panel-heading">Création des sujets</div>
        <br/>
        <div class="panel-body">
          <form method="post" action="http://localhost:8080/Moo/SujetProfServlet" enctype="multipart/form-data">             
            <div class="col-md-12 col-sm-12 col-xs-12 text-center"></div>
              <div class="form-group">
                <label for="subject_title">Entrez un titre pour le sujet:</label>
                  <input type="text" class="form-control" id="subject_title">
              </div>

              <div class"form-group">
                <label for="subject_description">Description du sujet :</label>
                  <textarea class="form-control" rows="5" id="subject_description"></textarea>
              </div>

              <br/>
              
              <% if ( sessions != null) {%>
             
              <div class="form-group">
              <label for="form-session">Sélectionner une session :</label>
                <form role="form" name="form-session" action="" method="post">
                  <div class="form-group text-center">
                    <select class="form-control" id="session_selector">
                      <% for ( int i = 0 ; i < sessions.size() ; i ++ ){ %>
                    	<% Session s = (Session) sessions.get(i); %>
                    	<option name="sessions"> <%= s.getStartDay() + " - " + s.getEndDay() %></option>
                    <%}%>
                    </select>
                </form>
              </div>
              
              <%}%>
              
              <% if ( teams != null) {%>

              <div class="form-group">
              <label for="equipes">Sélectionner les équipes :</label>
                <select id="features_selector" multiple class="form-control"">
                  <% for ( int i = 0 ; i < teams.size() ; i ++ ){ %>
                    	<% Team t = (Team) teams.get(i); %>
                    	<option name="teams"> <%= t.getName()  %></option>
                    <%}%>
                </select>
              </div>
              
              <%}%>
              
              
              <% if ( features != null) {%>

              <div class="form-group">
              <label for="form-session">Sélectionner les fonctionnalités :</label>
                <form role="form" name="form-features" action="" method="post">
                  <div class="form-group">
                    <select id="features_selector" multiple class="form-control">
                      <% for ( int i = 0 ; i < features.size() ; i ++ ){ %>
                    	<% Feature f = (Feature) features.get(i); %>
                    	<option name="features"> <%= f.getName()  %></option>
                    <%}%>
                    </select>
                  </div>
                </form>
              </div>
              
              <%}%>

              <br/>

              <div class="form-group col-md-12 col-sm-12 col-xs-12 text-center">
                <input type="submit" class="btn btn-success" id="save_btn" value="Sauvegarder"/>
              </div>

            </form>

          </div>
        </div>
      </div>
      
      <% Sujet sujet = null; %>

              
        <div class="panel panel-success">
          <div id="panel_title" class="panel-heading">Récapitulatif du sujet</div>
          <div class="panel-body">
            <br/>
            <label for="subject_selector">Sélectionner un sujet:</label>
                <form role="form" name="form" action="" method="post">
                  <div class="form-group text-center">
                    <select class="form-control" id="subject_selector">
                      <% for ( int i = 0 ; i < sujets.size() ; i ++ ){ %>
                    	<% sujet = (Sujet) sujets.get(i); %>
                    	<option values=""> <%= sujet.getName()  %></option>
                    	<%}%>
                    </select>
                  </div>
                </form>
          </div>
          
          <% if ( sujet != null) {%>

          <div class="panel-body text-center">
            <div id="subject1_description">
              <div class="panel panel-success">
                <div class="panel-heading"><h3 class="panel-title">Description du sujet</h3></div>
                <div class="panel-body"><%= sujet.getDecription() %></div>
              </div>
            </div> 
          </div> 
          

          
          <% if ( sujet.getAllTeam() != null) {%>
	
          
          <div class="panel-body">

            <table class="table table-striped text-center" id="subject_assignation">
              <thead>
	              <tr>
	                <th>Equipes assignées</th>
	              </tr>
	            </thead>
	            <tbody>
	            
	            	<% for ( int j = 0 ; j < sujet.getAllTeam().size() ; j ++ ) {%>
	            	
	            		<%Team team = sujet.getAllTeam().get(j);%>
		            
		              <tr>
		                <td><%= team.getName() %></td>
		              </tr>
		              
	              <%}%>
	              
	           </tbody>
            </table>

          </div>
          
          <%}%>
          
          
          
          
          <% if ( sujet.getAllFeature() != null) {%>
          
          <div class="panel-body">

            <table class="table table-striped" id="subject_features">
              <thead>
		              <tr>
		                <th>Name</th>
		                <th>Description</th>
						<th>Tag</th>
		              </tr>
		            </thead>
		            <tbody>
		             
		             <% for ( int j = 0 ; j < sujet.getAllFeature().size() ; j ++ ) {%>
	            	
	            		<%Feature feature = sujet.getAllFeature().get(j);%>
		            
		              <tr>
		                <td><%= feature.getName() %></td>
		                <td><%= feature.getDescription() %></td>
		                <td><%= feature.getTag().getName() %></td>
		              </tr>
		              
	              <%}%>
		             
		              
		           </tbody>
            </table>
            
         
          </div>
          
          <%}%>
          
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