$(document).ready(function() {
	 $('#submitBtn').click(function(event)
			   {   
			    event.preventDefault();
			   	var loginString = $("#login").val();
				var passwordString = $("#password").val();
			       
				 $.ajax({
			           type: "POST",
			           url: URL.base + "AuthentificationServlet",  
			           data:{"login":loginString,"password":passwordString},
			           success: function (data) {
			        	   if(data == 0){
			              	 alert("No connected... wrong login/password");
			        	   }else{
			            	  alert("Connected");
			        	   }
			           }
			       });         
			   });
});
