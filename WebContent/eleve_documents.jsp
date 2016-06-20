<%@ page language="java" import="java.sql.*" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="Model.Document" %>
<%@ page import="Model.User" %>    
    

<!DOCTYPE html>
<html lang="en">
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
      <div class="col-md-2 col-md-offset-2 col-sm-2 col-md-offset-2 col-xs-2 col-xs-offset-1">  
        <a href="eleve_accueil.html"><img id="logo_sujet" src="drawable/home.png" height="40" width="40"></a>
      </div>

      <div class="col-md-2 col-sm-2 col-xs-2">
        <a href="http://localhost:8080/Moo/SujetEleveServlet"><img id="logo_equipe" src="drawable/sujet.svg" height="40" width="40"></a>
      </div>

      <div class="col-md-2 col-sm-2 col-xs-2">
        <a href="http://localhost:8080/Moo/AddTeamServelt"><img id="logo_equipe" src="drawable/equipe.svg" height="40" width="40"></a>
      </div>
      
      <div class="col-md-2  col-sm-2 col-xs-2">
        <a href="http://localhost:8080/Moo/MeetingServlet"><img id="logo_rdv" src="drawable/rdv.svg" height="40" width="40"></a>
      </div>

      <div class="col-md-2  col-sm-2 col-xs-2">
        <img id="logo_docs" src="drawable/docs.svg" height="40" width="40">
      </div>
    </div>


    <div id="cadre_contenu" class="row">

      <div id="menu_lateral" class="col-sm-3">
        <ul class="list-group">
          <a href="eleve_accueil.html"><li class="list-group-item"><img src="drawable/home.png" height="50" width="50"> ACCUEIL</li></a>
          <a href="http://localhost:8080/Moo/SujetEleveServlet"><li class="list-group-item list-group-item-success"><img src="drawable/sujet.svg" height="50" width="50"> MON SUJET</li></a>
          <a href="http://localhost:8080/Moo/AddTeamServelt"><li class="list-group-item list-group-item-info"><img src="drawable/equipe.svg" height="50" width="50">  MON ÉQUIPE</li></a>
          <a href="http://localhost:8080/Moo/MeetingServlet"><li class="list-group-item list-group-item-warning"><img src="drawable/rdv.svg" height="50" width="50"> RDV</li></a>
          <li class="list-group-item list-group-item-danger"><img src="drawable/docs.svg" height="50" width="50"> <b> DOCUMENTS</b></li>
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
              <a href="eleve_accueil.html"><li><img src="home.png" height="30" width="30"></li></a>
              <a href="http://localhost:8080/Moo/SujetEleveServlet"><li><img src="sujet.svg" height="30" width="30"></li></a> 
              <a href="http://localhost:8080/Moo/AddTeamServelt"><li><img src="equipe.svg" height="30" width="30"></li></a> 
              <a href="http://localhost:8080/Moo/MeetingServlet"><li><img src="rdv.svg" height="30" width="30"></li></a>
              <li><img src="docs.svg" height="30" width="30"></li>
            </ul>
          </li>
        </ul>
      </div>



      <div class="col-md-9 col-sm-12 col-xs-12">
        <div class="panel panel-danger">
          <div id="panel_title" class="panel-heading">Sélectionner un fichier à poster (max 20Mb)</div>
           <br/><br/>
            <form method="post" action="UploadServlet" enctype="multipart/form-data">             
              <div class="col-md-12 col-sm-12 col-xs-12 text-center"><input type="file" name="uploadFile"/></div>
              <br/><br/>
              <br/>
              <div class="form-group col-md-12 col-sm-12 col-xs-12 text-center"><input type="submit" class="btn btn-danger" id="upload_btn" value="Upload"/></div>
            </form>
           <br/><br/>
           <br/>
        
        <div class="panel-body">
        
        <div class="panel panel-danger">
          <div id="panel_title" class="panel-heading">Documents</div>
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
	<%Integer droit = Integer.parseInt(doc.droit);
	System.out.println("Document droit" + droit);%>
        <tbody>
              <tr>
                <td><%=i + 1 %></td>
                <td><%= doc.getName() %></td>
                <td><form action='FileDownloader' method ="POST">
                	<%if(droit == 11 || droit == 01){%>            	
					<input type="submit" name="downloadButton" value="Download" />
					<input type='hidden' name='docUrl' id='D_URL' value=<%=doc.getUrl()%> />
                	<%}else{%>
                	<input type="submit" name="downloadButton" value="Download"  disabled/>
					<input type='hidden' name='docUrl' id='D_URL' value=<%=doc.getUrl()%> />
                	<%}%>
				</form></td>
				<td><form action='FileDelete' method ="POST">
				<%if(droit > 10){%>            	
					<input type='hidden' name='docUrl' id='D_RMV' value=<%=doc.getUrl()%> />
					<input type="submit" name="deleteButton" value="Delete" />
                	<%}else{%>
                	<input type='hidden' name='docUrl' id='D_RMV' value=<%=doc.getUrl()%> />
					<input type="submit" name="deleteButton" value="Delete" disabled/>
                	<%}%>
				</form></td>
                <td><%= doc.getCreationDate() %></td>
                <td><%= doc.getUploaderName() %></td>
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