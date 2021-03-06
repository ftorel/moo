<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>RDV - Professeur</title>

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
        <a href="http://localhost:8080/Moo/TeamProfServelt"><img id="logo_equipe" src="drawable/equipe.svg" height="40" width="40"></a>
      </div>
            
      <div class="col-md-2  col-sm-2 col-xs-2">
        <a href=""><img id="logo_rdv" src="drawable/rdv.svg" height="40" width="40"></a>
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
              <a href="prof_accueil.html"><li><img src="home.png" height="30" width="30"></li></a>
              <a href="http://localhost:8080/Moo/SessionProfServlet"><li><img src="sessions.svg" height="30" width="30"></li></a> 
              <a href="http://localhost:8080/Moo/SujetProfServlet"><li><img src="sujet.svg" height="30" width="30"></li></a> 
              <a href="http://localhost:8080/Moo/TeamProfServelt"><li><img src="equipe.svg" height="30" width="30"></li></a> 
              <a href=""><li><img src="rdv.svg" height="30" width="30"></li></a>
              <a href="http://localhost:8080/Moo/DocumentServlet"><li><img src="docs.svg" height="30" width="30"></li></a> 
            </ul>
          </li>
        </ul>
      </div>
      
      <div id="menu_lateral" class="col-sm-3">
         <ul class="list-group">
          <a href="prof_accueil.html"><li class="list-group-item"><img src="drawable/home.png" height="50" width="50"> ACCUEIL</li></a>
          <a href="http://localhost:8080/Moo/SessionProfServlet"><li class="list-group-item list-group-item-danger"><img src="drawable/sessions.svg" height="50" width="50"> SESSIONS</li></a>
          <a href="http://localhost:8080/Moo/SujetProfServlet"><li class="list-group-item list-group-item-success"><img src="drawable/sujet.svg" height="50" width="50"> SUJETS</li></a>
          <a href="http://localhost:8080/Moo/TeamProfServelt"><li class="list-group-item list-group-item-info"><img src="drawable/equipe.svg" height="50" width="50"> ÉQUIPES </li></a>
          <a href=""><li class="list-group-item list-group-item-warning"><img src="drawable/rdv.svg" height="50" width="50"><b> RDV</b></li></a>
          <a href="http://localhost:8080/Moo/DocumentServlet"><li class="list-group-item list-group-item-danger"><img src="drawable/docs.svg" height="50" width="50"> DOCUMENTS</li></a>
        </ul>
      </div>


      <div id="cadre_rdv" class="col-md-9 col-sm-12 col-xs-12">
        <div class="panel panel-warning">
          <div id="panel_title" class="panel-heading">RDV</div>
          <div class="panel-body">

            <table class="table table-striped">

              <p id="legende" class="text-center">Sélectionner une session :</p>

                <form role="form" name="form-session" action="" method="post">
                  <div class="form-group text-center">
                    <select class="form-control" id="session_selector">
                      <option>Session 1</option>
                      <option>Session 2</option>
                      <option>Session 3</option>
                    </select>
                    <br>
                </form>

              <p id="legende">Sélectionner une équipe :</p>

              <form role="form" name="form" action="" method="post">
                <div class="form-group text-center">
                  <select class="form-control" id="equipe_selector">
                    <option>Vert bouteille</option>
                    <option>Rouge vif</option>
                    <option>Jaune citron</option>
                  </select>
                  <br>
              </form>

              <input id="clickMe" type="button" class="btn btn-warning" value="Lancer le minuteur" onclick="addTimer();" />
                <p id="demo"></p>
                <p id="stop"></p>

              <thead>
                  <tr>
                    <th>#</th>
                    <th>Date</th>
                    <th>Heure</th>
                    <th>Durée</th>
                    <th>Remarques</th>
                  </tr>
                </thead>

              	<tr>
                  <td>1</td>
                  <td>13/05/2016</td>
                  <td>15h00</td>
              		<td>30 min</td>
              		<td>Premier rdv client</td>
                </tr>

                <tr>
                  <td>2</td>
                  <td>16/05/2016</td>
                  <td>12h00</td>
                  <td>15 min</td>
                  <td>Deuxième rdv client : RAS</td>
                </tr>

                <tr>
                  <td>3</td>
                  <td>21/05/2016</td>
                  <td>16h00</td>
                  <td>25 min</td>
                  <td>3e rdv client : OK</td>
                </tr>

            </table>

          </div>
        </div>
      </div>
    </div>
  </div>

</body>

<script>

  var theTimer = setInterval(myTimer,1000);
  clearInterval(theTimer);
  var time = 0;
  var timerRun = false;

  function addTimer()
  {

    if(time == 0)
      {
        theTimer = setInterval(myTimer,1000);
        timerRun = true;
      }
    else
      {
        clearInterval(theTimer);
        time = 0 ;
        timerRun = false;
      }
  
    addStopButton("button");

  }

  function myTimer() 
  {
    //   var d = new Date();
    time = time + 1;
    //document.getElementById("demo").innerHTML = time
    //document.getElementById("demo").
    d = new Date(time * 1000);
    var m =  d.getMinutes().toString();
    var s =  d.getSeconds().toString();

    if (m.length == 1)
    {
      m = "0" + m
    }
    if (s.length == 1)
    {
      s = "0" + s
    }
    document.getElementById("demo").innerHTML = m + ":" + s;
  }

  function addStopButton(type) 
  {
      //Create an input type dynamically.   
      var element = document.getElementById("clickMe");
      //Assign different attributes to the element. 
      element.type = type;
      
      // Really? You want the default value to be the type string?
      var name = "Lancer le minuteur";  // And the name too

      document.getElementById("demo").innerHTML = "00:00";
      
      if (timerRun)
      {
        name = "Arrêter le minuteur";
      }
      else
      {
        document.getElementById("demo").innerHTML = "";
      }

      element.value = name;
      element.name = name;
      element.onclick = function() 
      { // Note this is a function
        addTimer();
      };
  }

  jQuery(document).ready(function($){
  $("li.content").hide();
  $("ul.toggle-menu").delegate("li.toggle", "click", function() { 
  $(this).next().toggle("fast").siblings(".content").hide("fast");
    });
});

</script>

</html>