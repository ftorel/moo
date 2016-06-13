<%@ page language="java" import="java.sql.*" import="java.util.*"  contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="Model.Team" %>
<%@ page import="Model.User" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Mon Equipe</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
  <img id="logo_isep" src="drawable/Isep-Logo.png" />
  <img id="logo_deconnexion" src="drawable/deconnexion.svg" />
  <style type="text/css">
  body {
    font-family: "Arial Rounded MT Bold", Arial, sans-serif;
    margin: 0;
    padding: 0;
  }
  .container-fluid {
    margin: 0;
    padding: 0; 
  }

  .jumbotron {
    background-color: #ffffff;
  }

  #logo_isep
{
    max-width: 12%; 
    position: absolute;
    left: 5vw;
    top: 1vw;
}

#logo_deconnexion
{
    width: 4%;
    height: auto;
    position: absolute;
    right: 5vw;
    top: 2vw;
}
  </style>
</head>
<body>


<div class="container-fluid">
  <div class="jumbotron">
  <div class="row">
    <div class="col-sm-3" >
    </div>
    <div class="col-sm-6">
      <h1 style="text-align: center;">Mon Equipe</h1>      
    </div>
    <div class="col-sm-3">
    </div>
  </div>
  </div>
  <div class="row" style="margin: 0 40px 0 20px;">
    <div class="col-sm-3">
       <ul class="list-group">
        <li class="list-group-item list-group-item-success">
          <p class="glyphicon glyphicon-name"></p><img src="drawable/sujet.svg" height="60" width="60"> MON SUJET
        </li>
        <li class="list-group-item list-group-item-info"><img src="drawable/equipe.svg" height="60" width="60"> <b>MON EQUIPE</b></li>
        <li class="list-group-item list-group-item-warning"><img src="drawable/rdv.svg" height="60" width="60"> RDV</li>
        <li class="list-group-item list-group-item-danger"><img src="drawable/docs.svg" height="60" width="60"> DOCUMENTS</li>
      </ul>
    </div>
    
    <%List data =(List)request.getAttribute("data");
	boolean shouldJoinTeam = Boolean.parseBoolean( (String) request.getAttribute("shouldJoinTeam")); %>
   
	<div class="col-sm-9">
	      <div class="panel panel-default">
	      
	      <% if ( shouldJoinTeam ){ %>
	        <div class="panel-heading"><h3>CHOIX EQUIPE</h3></div>
	        <% } else { %>
	        <div class="panel-heading"><h3>VOTRE EQUIPE</h3></div>
	        <% } %>
	        <div class="panel-body">
	        
	<div id="accordion1" class="panel-group">

	
	
    <% for(int i = 0; i < data.size(); i+=1) { %>
 
    <%Team team = ((Team)data.get(i)); %>

	  <div class="panel panel-primary">
	    <div class="panel-heading">
	      <h4 class="panel-title">
	        <a href="#collapseOne" data-parent="#accordion" data-toggle="collapse" class="accordion-toggle"><%= team.getName() %></a>
	      </h4>
	    </div>
	    <div class="panel-collapse in" id="collapseOne">
	    
	    <%List<User> members = team.getMembers(); %>
	    
	    <%for(int j = 0; j < members.size() ; j+=1) { %>
	    
	    	<%User membre = (User) members.get(j); %>
	    	
	      	<p class="panel-body"><%= membre.getNom() + " " + membre.getPrenom()  %></p>
	      
	      <% } %>
	      
	    </div>
	  </div>
  
  <% } %>
    
	</div>

      </div>
    </div>
    
    
    <% if ( shouldJoinTeam ){ %>
    			
    	<div class="panel panel-default"><div class="panel-heading">Sélectionner votre groupe</div><div class="panel-body"><form role="form" name="form" action="" method="post">
		  <form role="form" method ="POST" action ="http://localhost:8080/Moo/AddTeamServelt">
		    <div class="form-group">
		      <select class="form-control" id="sel1" name ="team">
		      
		      <%List d =(List)request.getAttribute("data");
		       
		    	for(int i = 0; i < d.size(); i+=1) { %>
		    
		    	<%Team team = ((Team)d.get(i)); %>
		    	<option><%=team.getName()%></option>
		    
		     <% } %> 
		      
		      </select>
		      <br>
		      
		      <button type="submit" class="btn btn-default">Valider</button>
		      
		</form></div></div>
    			
 	<%}%>
        
        
</body>
</html>