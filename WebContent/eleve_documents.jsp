<%@ page language="java" import="java.sql.*" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="Model.Document" %>
<%@ page import="Model.User" %>    
    

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
  <title>Documents</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <link href="css/font-awesome.min.css" rel="stylesheet"> 
  <link href="css/connexion_accueil.css" rel="stylesheet"/>
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
      <div class="col-md-2 col-md-offset-2 col-sm-3 col-xs-2 col-xs-offset-1">  
        <img id="logo_sujet" src="drawable/home.png" height="40" width="40">
      </div>


      <div class="col-md-2 col-sm-3 col-xs-2">
        <img id="logo_equipe" src="drawable/sujet.svg" height="40" width="40">
      </div>

      <div class="col-md-2 col-sm-3 col-xs-2">
        <img id="logo_equipe" src="drawable/equipe.svg" height="40" width="40">
      </div>
      
      <div class="col-md-2  col-sm-3 col-xs-2">
        <img id="logo_rdv" src="drawable/rdv.svg" height="40" width="40">
      </div>

      <div class="col-md-2  col-sm-3 col-xs-2">
        <img id="logo_docs" src="drawable/docs.svg" height="40" width="40">
      </div>
    </div>


    <div id="cadre_contenu" class="row">

      <div id="menu_lateral" class="col-sm-3">
        <ul class="list-group">
          <a href="eleve_accueil.html">
            <li class="list-group-item"><img src="home.png" height="50" width="50"> ACCUEIL</li>
          </a>
          <a href="eleve_sujet.html"> 
            <li class="list-group-item list-group-item-success"><img src="drawable/sujet.svg" height="50" width="50"> MON SUJET</li>
          </a>
          <a href="eleve_team.html">
            <li class="list-group-item list-group-item-info"><img src="drawable/equipe.svg" height="50" width="50">  MON ÉQUIPE</li>
          </a>
          <a href="eleve_rdv.html">
            <li class="list-group-item list-group-item-warning"><img src="drawable/rdv.svg" height="50" width="50"> RDV</li>
          </a>
          <a href="">
            <li class="list-group-item list-group-item-danger"><img src="drawable/docs.svg" height="50" width="50"> <b> DOCUMENTS</b></li>
          </a>
        </ul>
      </div>



      <div id="menu_xs" class="menu-links">
        <ul class="toggle-menu">
          <li class="toggle">
            <span class="toggle-menu-bar"></span>
            <span class="toggle-menu-bar"></span>
            <span class="toggle-menu-bar"></span>
          </li>
          <li class="content" style="display: none;">
            <ul>
              <li><img src="sujet.svg" height="60" width="60"></li> <p>&nbsp;</p>
              <li><img src="equipe.svg" height="60" width="60"></li> <p>&nbsp;</p>
              <li><img src="rdv.svg" height="60" width="60"></li> <p>&nbsp;</p>
              <li><img src="docs.svg" height="60" width="60"></li> <p>&nbsp;</p>
            </ul>
          </li>
        </ul>
      </div>


      <div class="col-md-9 col-sm-9 col-xs-12">
        <div class="panel panel-default">
          <form method="post" action="UploadServlet" enctype="multipart/form-data">
            Select file to upload :  (max 20Mb)
            <br/><br/>
            <input type="file" name="uploadFile" />
            <br/><br/>
            <input type="submit" value="Upload" />
          </form>
        
        <div class="panel-body">
        
        <div class="panel panel-default">
          <div class="panel-heading">
            <h3 class="panel-title">Documents</h3>
          </div>
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


<%List data =(List)request.getAttribute("data");

	for(int i = 0; i < data.size(); i+=1) { %>

	<%Document doc = ((Document)data.get(i)); %>
        <tbody>
              <tr>
                <td><%=i + 1 %></td>
                <td><%= doc.getName() %></td>
                <td><i class="fa fa-download fa-1x"> Download </i><br></td>
                <td><i class="fa fa-remove fa-1x"></i> Remove <br></td>
                <td><%= doc.getCreationDate() %></td>
                <td>Pierre</td>
              </tr>
  
 				 <% } %>
		 </tbody>

          </table>
        </div>
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