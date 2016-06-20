<%@ page language="java"  import="java.sql.*" import="java.util.*"  contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="Model.Session" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Sessions - Professeur</title>
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

	<%List sessions =(List)request.getAttribute("sessions");%>

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
        <h1 id="titre_pages">Sessions</h1>
      </div>
    </div>

    <div id="menu_horizontal" class="row text-center">
      <div class="col-md-2 col-sm-2 col-xs-2">  
        <a href="prof_accueil.html"><img id="logo_sujet" src="drawable/home.png" height="40" width="40"></a>
      </div>

      <div class="col-md-2 col-sm-2 col-xs-2">
        <a href=""><img id="logo_equipe" src="drawable/sessions.svg" height="40" width="40"></a>
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
              <a href=""><li><img src="drawable/sessions.svg" height="30" width="30"></li></a> 
              <a href="prof_sujet.html"><li><img src="drawable/sujet.svg" height="30" width="30"></li></a> 
              <a href="prof_equipe.html"><li><img src="drawable/equipe.svg" height="30" width="30"></li></a> 
              <a href="prof_rdv.html"><li><img src="drawable/rdv.svg" height="30" width="30"></li></a>
              <a href="prof_documents.html"><li><img src="drawable/docs.svg" height="30" width="30"></li></a> 
            </ul>
          </li>
        </ul>
      </div>
      
      <div id="menu_lateral" class="col-sm-3">
         <ul class="list-group">
          <a href="prof_accueil.html"><li class="list-group-item"><img src="drawable/home.png" height="50" width="50"> ACCUEIL</li></a>
          <a href=""><li class="list-group-item list-group-item-danger"><img src="drawable/sessions.svg" height="50" width="50"><b> SESSIONS</b></li></a>
          <a href="prof_sujet.html"><li class="list-group-item list-group-item-success"><img src="drawable/sujet.svg" height="50" width="50"> SUJETS</li></a>
          <a href="prof_equipe.html"><li class="list-group-item list-group-item-info"><img src="drawable/equipe.svg" height="50" width="50"> ÉQUIPES</li></a>
          <a href="prof_rdv.html"><li class="list-group-item list-group-item-warning"><img src="drawable/rdv.svg" height="50" width="50"> RDV</li></a>
          <a href="prof_documents.html"><li class="list-group-item list-group-item-danger"><img src="drawable/docs.svg" height="50" width="50"> DOCUMENTS </li></a>
        </ul>
      </div>



      <div class="col-md-9 col-sm-12 col-xs-12">
        <div class="panel panel-danger">
          <div id="panel_title" class="panel-heading">Sessions</div>
          <br/>  
          <div class="panel-body">  
            <div id="listing-sessions" class="panel-group">
              <div class="panel panel-danger">
                <div class="panel-heading">
                  <h3 class="panel-title">
                    <a href="#collapseOne" data-parent="#accordion" data-toggle="collapse" class="accordion-toggle">Liste des sessions</a>
                  </h3>
                </div>
                <div class="panel-collapse in" id="collapseOne">
                  <div class="panel-body">
                  <ul id="sessions_liste">
                  
                  <% for ( int i = 0 ; i < sessions.size() ; i ++) { %>
                  	
                  	<% Session s = (Session) sessions.get(i); %>
                  	
                  	<li> <%= s.getStartDay() + " - " + s.getEndDay() %>   </li>
                  	
              
                  <%}%>
                  
               
                  
                  </ul>
                  </div>
                </div>
              </div>
            </div> 
            <br/> 
            <div class="text-center"><button id="add_session" type="button" class="btn btn-danger"><span class="glyphicon glyphicon-plus"></span> Nouvelle session</button></div>
            <br/> 
            <div id="cadre-session" class="panel panel-danger">
              <div class="panel-heading"> Création session</div>
              <div class="panel-body">
                <form method="post" action="http://localhost:8080/Moo/SessionProfServlet">
                  <div class="col-md-3 col-md-offset-3 col-sm-3 col-sm-offset-3 col-xs-12">
                    <div class="form-group">
                      <label class="control-label" for="date">Date de début :</label>
                      <div class="input-group">
                        <span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
                        <input class="form-control date" id="date" name="startDate" type="text" value="">
                      </div>
                    </div>
                  </div> 
                  <div class="col-md-3 col-sm-3 col-xs-12">
                    <div class="form-group">
                      <label class="control-label" for="date">Date de fin :</label>
                      <div class="input-group">
                        <span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
                        <input class="form-control date" id="date" name="endDate" type="text" value="">
                      </div>
                    </div>
                  </div> 
                  <div class="col-md-12 col-sm-12 col-xs-12">
                  <div class="text-center"><button id="validation_btn" type="submit" class="btn btn-danger">Valider</button></div></div>
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
      var date_input=$('input[id="date"]'); //our date input has the name "date"
      var container=$('.bootstrap-iso form').length>0 ? $('.bootstrap-iso form').parent() : "body";
      var options={
        format: 'dd/mm/yyyy',
        container: container,
        todayHighlight: true,
        autoclose: true,
        language: 'fr'
      };
      date_input.datepicker(options);
    }) 

  $(document).ready(function(){
      $("#add_session").click(function(){
          $("#cadre-session").show();
      });
  });


</script>

</html>