/**
 * 
 */

$(function() 
    {
      $('#logo_sujet').mousedown(function()
	      {
	        $(this).fadeTo("fast", 0.55);
	      });
	      $('#logo_sujet').mouseup(function()
	      {
	        $(this).fadeTo("fast", 1);
	        document.location.href="http://localhost:8080/Moo/SujetEleveServlet";
	      });
      
      $('#logo_deconnexion').mousedown(function()
   		  {
   	        $(this).fadeTo("fast", 0.55);
   	      });
   	      $('#logo_deconnexion').mouseup(function()
   	      {
   	        $(this).fadeTo("fast", 1);
   	     	window.open ('connexion.html','_self',false);
   	      });
   	      
   	   $('#logo_home').mousedown(function()
   	   		  {
   	   	        $(this).fadeTo("fast", 0.55);
   	   	      });
   	   	      $('#logo_deconnexion').mouseup(function()
   	   	      {
   	   	        $(this).fadeTo("fast", 1);
   	   	     	window.open ('acceuil_eleve.html','_self',false);
   	   	      });


      $('#logo_equipe li').mousedown(function()
	      {
	        $(this).fadeTo("fast", 0.55);
	      });
	      $('#logo_equipe').mouseup(function()
	      {
	        $(this).fadeTo("fast", 1);
	        document.location.href="http://localhost:8080/Moo/AddTeamServelt";
	      });


      $('#logo_rdv').mousedown(function()
	      {
	        $(this).fadeTo("fast", 0.55);
	      });
	      $('#logo_rdv').mouseup(function()
	      {
	        $(this).fadeTo("fast", 1);
	        document.location.href="http://localhost:8080/Moo/MeetingServlet";
	      });
	      
	 

      $('#logo_docs').mousedown(function()
	      {
	        $(this).fadeTo("fast", 0.55);
	      });
	      $('#logo_docs').mouseup(function()
	      {
	        $(this).fadeTo("fast", 1);
	        document.location.href="http://localhost:8080/Moo/DocumentServlet";
	      });

    });