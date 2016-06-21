<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" import="java.sql.*" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="Model.Document" %>
<%@ page import="Model.User" %>    
<%@ page import="Model.Team" %>    

<!DOCTYPE html>
<html lang="en">
<head>
  <title>Docs - Professeur</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <link href="css/font-awesome.min.css" rel="stylesheet"> 
  <link href="connexion_accueil.css" rel="stylesheet"/>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
  <script src="js/jquery.js"></script> 
  <script src="js/bootstrap.min.js"></script> 
</head> 

<body>

  <div class="container-fluid">

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
        <h1 id="titre_pages">Documents</h1>
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
        <a href="prof_sujet.html"><img id="logo_equipe" src="drawable/sujet.svg" height="40" width="40"></a>
      </div>

      <div class="col-md-2 col-sm-2 col-xs-2">
        <a href="prof_equipe.html"><img id="logo_equipe" src="drawable/equipe.svg" height="40" width="40"></a>
      </div>
            
      <div class="col-md-2  col-sm-2 col-xs-2">
        <a href="prof_rdv.html"><img id="logo_rdv" src="drawable/rdv.svg" height="40" width="40"></a>
      </div>

      <div class="col-md-2  col-sm-2 col-xs-2">
        <a href=""><img id="logo_docs" src="drawable/docs.svg" height="40" width="40"></a>
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




     <%
    
     HashMap<Team, ArrayList<Document>> data =(HashMap<Team, ArrayList<Document>>)request.getAttribute("data");
     List<Team> teams = new ArrayList<Team>( data.keySet());
     
     for(int teamIndex = 0; teamIndex < teams.size(); teamIndex+=1) { 
    	 

    	 Team team = (Team)teams.get(teamIndex);
    	 
    	 %>
    	 
    	 
      <div class="col-md-9 col-sm-12 col-xs-12">
       
        
        <div class="panel-body">
        
        <div class="panel panel-danger">
          <div id="panel_title" class="panel-heading"><%=team.getName()%></div>
          <table class="table">

            <thead>
              <tr>
                <th>#</th>
                <th>Nom Doc</th>
                <th>Download</th>
                <th>Remove</th>
                <th>Date d'Upload</th>
                <th>Ajouté par</th>
              </tr>
            </thead>
            
            
    	 <% 
    	 
    	 ArrayList<Document> documents = data.get(team);
    	 
    	 for(int documentIndex = 0; documentIndex < documents.size(); documentIndex+=1) { 
    		 
    		 Document doc = documents.get(documentIndex);
    	 %>
        <tbody>
              <tr>
                <td><%=documentIndex + 1 %></td>
                <td><%= doc.getName() %></td>
                <td><form action='FileDownloader' method ="POST">           	
					<input type="submit" name="downloadButton" value="Download" />
					<input type='hidden' name='docUrl' id='D_URL' value=<%=doc.getUrl()%> />
				</form></td>
				<td><form action='FileDelete' method ="POST">           	
					<input type='hidden' name='docUrl' id='D_RMV' value=<%=doc.getUrl()%> />
					<input type="submit" name="deleteButton" value="Delete" />
				</form></td>
                <td><%= doc.getCreationDate() %></td>
                <td><%= doc.getUploaderName() %></td>
              </tr>
             	<% }  %>
             		 </tbody>

          </table>
        </div>
        </div>
       
       </div>
             	<% }  %>
             	
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