<%@ page language="java" contentType="text/html; charset=UTF-8" import="java.sql.*" import="java.util.*"  pageEncoding="UTF-8"%>
<%@ page import="Model.Session" %>
<%@ page import="Model.Team" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Équipes - Professeur</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <link href="css/font-awesome.min.css" rel="stylesheet"> 
  <link href="css/connexion_accueil.css" rel="stylesheet"/>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
  <script src="js/jquery.js"></script> 
  <script src="js/bootstrap.min.js"></script> 

  <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/js/bootstrap-datepicker.min.js"></script>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/css/bootstrap-datepicker3.css"/>


</head> 

<body>

  <div class="container-fluid">
  
  <%List sessions =(List)request.getAttribute("sessions");%>
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
        <h1 id="titre_pages">Équipes</h1>
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
        <a href="http://localhost:8080/Moo/SujetProfServlet"><img id="logo_equipe" src="drawable/sujet.svg" height="40" width="40"></a>
      </div>

      <div class="col-md-2 col-sm-2 col-xs-2">
        <a href=""><img id="logo_equipe" src="drawable/equipe.svg" height="40" width="40"></a>
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
              <a href="http://localhost:8080/Moo/SujetProfServlet"><li><img src="drawable/sujet.svg" height="30" width="30"></li></a> 
              <a href=""><li><img src="drawable/equipe.svg" height="30" width="30"></li></a> 
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
          <a href="http://localhost:8080/Moo/SujetProfServlet"><li class="list-group-item list-group-item-success"><img src="drawable/sujet.svg" height="50" width="50"> SUJETS</li></a>
          <a href=""><li class="list-group-item list-group-item-info"><img src="drawable/equipe.svg" height="50" width="50"> <b>ÉQUIPES</b></li></a>
          <a href="http://localhost:8080/Moo/MeetingProfServlet"><li class="list-group-item list-group-item-warning"><img src="drawable/rdv.svg" height="50" width="50"> RDV</li></a>
          <a href="http://localhost:8080/Moo/DocumentServlet"><li class="list-group-item list-group-item-danger"><img src="drawable/docs.svg" height="50" width="50"> DOCUMENTS </li></a>
        </ul>
      </div>



      <div class="col-md-9 col-sm-12 col-xs-12">
        <div class="panel panel-info">
          <div id="panel_title" class="panel-heading">Équipes</div>
          <br/>  
          <div class="panel-body">  
            <div id="listing-teams" class="panel-group">
              <div class="panel panel-info">
                <div class="panel-heading">Équipes existantes</div>
                <div class="panel-body text-center">
                  <label>Sélectionner une session :</label>
                  <form role="form" name="form-session" action="" method="post">
                  <div class="form-group text-center">
                    <select class="form-control" id="session_team_selector">
                      <option value="teams 1">Session 1</option>
                      <option value="teams 2">Session 2</option>
                      <option value="teams 3">Session 3</option>
                    </select>
                  </div>
                  <br>
                  </form>

                  <div id="cadre-teams1" class="teams 1">
                    <div class="panel panel-info">
                    <div class="panel-heading">
                      <h3 class="panel-title">
                        <a href="#collapseOne" data-parent="#accordion" data-toggle="collapse" class="accordion-toggle">Liste des équipes - Session 1</a>
                      </h3>
                    </div>
                    <div class="panel-collapse in" id="collapseOne">
                    <div class="panel-body"><ul id="teams_list"><li>Equipe Vert</li><li>Equipe Rouge</li><li>Equipe Jaune</li></ul></div>
                    </div>
                    </div>
                  </div>  

                  <div id="cadre-teams2" class="teams 2">
                    <div class="panel panel-info">
                    <div class="panel-heading">
                      <h3 class="panel-title">
                        <a href="#collapseOne" data-parent="#accordion" data-toggle="collapse" class="accordion-toggle">Liste des équipes - Session 2</a>
                      </h3>
                    </div>
                    <div class="panel-collapse in" id="collapseOne">
                    <div class="panel-body"><ul id="teams_list"><li>Equipe Bleu</li><li>Equipe Orange</li><li>Equipe Blanc</li></ul></div>
                    </div>
                    </div>
                  </div>  
                </div>
              </div> 

            <br/> 
            <div class="text-center"><button id="add_team" type="button" class="btn btn-info"><span class="glyphicon glyphicon-plus"></span> Nouvelle équipe</button></div>
            <br/> 
            <div id="cadre-team" class="panel panel-info">
              <div class="panel-heading">Equipe Vert</div>
              <div class="panel-body text-center">
                <form method="post" action="http://localhost:8080/Moo/TeamProfServelt" >
                  <div class="form-group">
                    <label for="session_selector">Sélectionner une session :</label>
                    <select class="form-control" id="session_selector">
                    <% for ( int i = 0 ; i < sessions.size() ; i ++ ) {%>
                    	<%Session s = (Session) sessions.get(i); %>
                    	<option name="session_id"  > <%= s.getStartDay() %></option>
                    <%}%>
                    
                    </select>
                  </div>
                  <div class="form-group">
                    <label for="usr">Entrez un nom d'équipe :</label>
                    <input name="team_name" type="text" class="form-control" id="team_name">
                  </div>

                  <div class="col-md-12 col-sm-12 col-xs-12">
                  <div class="text-center"><button id="validation_btn" type="submit" class="btn btn-info">Valider</button></div></div>
                </form>               
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


  $(document).ready(function(){
      $("#add_team").click(function(){
          $("#cadre-team").show();
      });
  });


  $(document).ready(function() {
    $("#session_team_selector").change(function () {
            if ($(this).val() == "teams 1") {
                $("#cadre-teams1").show();
                $("#cadre-teams2").hide();
            } else {
                $("#cadre-teams1").hide();
                $("#cadre-teams2").show();
            }
        });
  }); 


  $(document).ready(function(){
      $("#add_session").click(function(){
          $("#cadre-team").show();
      });
  });


</script>

</html>