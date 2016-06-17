<%@ page language="java" import="java.sql.*" import="java.util.*"  contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="Model.Team" %>
<%@ page import="Model.User" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Mon Équipe</title>
  <meta charset="utf-8">
   <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <link href="css/connexion_accueil.css" rel="stylesheet"/>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</head>
<body>

<%List data =(List)request.getAttribute("data");%>
<%boolean shouldJoinTeam = Boolean.parseBoolean( (String) request.getAttribute("shouldJoinTeam")); %>

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
      <h1 id="titre_pages">Mon Équipe</h1>
    </div>
  </div>

  <div id="menu_horizontal" class="row text-center">
        <div class="col-md-2 col-md-offset-2 col-sm-2 col-md-offset-2 col-xs-2 col-xs-offset-1">  
          <a href="eleve_accueil.html"><img id="drawable/logo_sujet" src="home.png" height="40" width="40"></a>
        </div>

        <div class="col-md-2 col-sm-2 col-xs-2">
          <a href="http://localhost:8080/Moo/SujetEleveServlet"><img id="logo_sujet" src="drawable/sujet.svg" height="40" width="40"></a>
        </div>

        <div class="col-md-2 col-sm-2 col-xs-2">
          <img id="logo_equipe" src="drawable/equipe.svg" height="40" width="40">
        </div>
        
        <div class="col-md-2  col-sm-2 col-xs-2">
          <a href="http://localhost:8080/Moo/MeetingServlet"><img id="logo_rdv" src="drawable/rdv.svg" height="40" width="40"></a>
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
              <a href="eleve_accueil.html"><li><img src="drawable/home.png" height="30" width="30"></li></a>
              <a href="http://localhost:8080/Moo/SujetEleveServlet"><li><img src="drawable/sujet.svg" height="30" width="30"></li></a> 
              <li><img src="drawable/equipe.svg" height="30" width="30"></li>
              <a href="http://localhost:8080/Moo/MeetingServlet"><li><img src="drawable/rdv.svg" height="30" width="30"></li></a>
              <a href="http://localhost:8080/Moo/DocumentServlet"><li><img src="drawable/docs.svg" height="30" width="30"></li></a> 
            </ul>
          </li>
        </ul>
      </div>

    <div id="menu_lateral" class="col-sm-3">
       <ul class="list-group">
        <a href="eleve_accueil.html"><li class="list-group-item"><img src="drawable/home.png" height="50" width="50"> ACCUEIL</li></a>
        <a href="http://localhost:8080/Moo/SujetEleveServlet"><li class="list-group-item list-group-item-success"><img src="drawable/sujet.svg" height="50" width="50"> MON SUJET</li></a>
        <li class="list-group-item list-group-item-info"><img src="drawable/equipe.svg" height="50" width="50"> <b> MON ÉQUIPE</b> </li>
        <a href="http://localhost:8080/Moo/MeetingServlet"><li class="list-group-item list-group-item-warning"><img src="drawable/rdv.svg" height="50" width="50"> RDV</li></a>
        <a href="http://localhost:8080/Moo/DocumentServlet"><li class="list-group-item list-group-item-danger"><img src="drawable/docs.svg" height="50" width="50"> DOCUMENTS</li></a>
      </ul>
    </div>

    <div class="col-md-9 col-sm-12 col-xs-12">
      <div class="panel panel-info">
        <div id="panel_title" class="panel-heading">Choix Équipe</div>
          <div class="panel-body">
          
          
          <% for(int i = 0; i < data.size(); i+=1) { %>
 
			  <%Team team = ((Team)data.get(i)); %>
          
          
	            <div id="accordion1" class="panel-group">
	
	              <div class="panel panel-primary">
	                <div class="panel-heading">
	                  <h4 class="panel-title">
	                    <a href="#collapseOne" data-parent="#accordion" data-toggle="collapse" class="accordion-toggle">  <%= team.getName() %></a>
	                  </h4>
	                </div>
                
                
	                <%List<User> members = team.getMembers(); %>
		    
				    <%for(int j = 0; j < members.size() ; j+=1) { %>
				    
				    	<%User membre = (User) members.get(j); %>
				    	
				    	<div class="panel-collapse in" id="collapseOne">
		                  <div class="panel-body"><%= membre.getNom() + " " + membre.getPrenom()  %></div>
		                </div>
				    				      
				    <% } %>
                
                
                
              </div>
              
             
            </div>
            
            
        <% } %>
          
          </div>
      </div>
      
      
      
      <% if ( shouldJoinTeam ){ %>
          
      <div class="panel panel-info">
        <div id="panel_title" class="panel-heading">Sélectionnez votre groupe</div>
        <div class="panel-body">
          <form role="form" name="form" action ="http://localhost:8080/Moo/AddTeamServelt" method="post">
          <!-- <form role="form"> -->
          <div class="form-group text-center">
          <select class="form-control" id="sel1">
             
		    	<%for(int i = 0; i < data.size(); i+=1) { %>
		    
		    		<%Team team = ((Team)data.get(i)); %>
					<option><%=team.getName()%></option>
		    
				<% } %> 
				
          </select>
          <br>
          <button id="upload_btn" type="submit" class="btn btn-info">Valider</button>
        </form>
        </div>
      </div>
    </div>
    
    <%}%>

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