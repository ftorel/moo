

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.AuthenticationException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;

import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

import DataBase.DataBaseConnector;
import DataBase.UserTable;
import ISEP.LDAPObject;
import ISEP.LDAPaccess;
import Model.User;

/**
 * Servlet implementation class AuthentificationServlet
 */
@WebServlet("/AuthentificationServlet")
public class AuthentificationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AuthentificationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String login = request.getParameter("log");
		String password = request.getParameter("pass");
		
		
		
		LDAPObject result = ISEPAuth( login , password );
		
		if ( result == null ){
			response.sendRedirect("connexion.html");
			return;
		}
		
		String type = result.getType(); 
		String redirectPage = "";
		
		Integer typeInt = 0;
		
		if ( type.equals("eleve")){
			redirectPage = "eleve_accueil.html";
			typeInt = 0;
		} else if ( type.equals("client") ){
			redirectPage = "accueil_client.html";
			typeInt = 1;
		} else if ( type.equals("tuteur") ){
			typeInt = 2;
		} else if ( type.equals("professeur") ){
			redirectPage = "accueil_prof.html";
			typeInt = 3;
		}
		
		String userMail = UserTable.UserExistWithMail(result.mail);
		
		if (!userMail.isEmpty()){
			System.out.println("User already registered");
		}else{
			
			UserTable.addUser(result.prenom, result.nomFamille, result.mail	, typeInt);
			userMail = UserTable.UserExistWithMail(result.mail);
		}
		
		if (!userMail.isEmpty()){
			System.out.println("Prepare redirection to " + redirectPage);
			
			String sessionId = request.getSession().getId();
			
			System.out.println("Session ID " + sessionId);
			System.out.println("Keeping userId in cookies " + redirectPage);
		
			Cookie newCookie = new Cookie(sessionId,userMail);
			response.addCookie(newCookie);
			
			response.sendRedirect(redirectPage);
		}else{
			System.out.println("An error occured here");
		}
	}
	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		doGet(request,response);
	}
	
	/**
	 * This method is used to detect if the user is in isep's db
	 * 
	 * @param login
	 * @param password
	 * @return 
	 */
	private LDAPObject ISEPAuth( String login, String password ){
	
		LDAPaccess access = new LDAPaccess();
		try {
			LDAPObject isepUser = access.LDAPget( login , password ); 

		if (isepUser == null)
		{	
			System.err.println("user doesn't exist");
			return null;
		}
		   
			return isepUser;
			
		} catch(Exception e) {
			
			if ( e instanceof AuthenticationException ){
				System.err.println(e.getMessage());
				return null;
			}
			
			System.err.println(e.getMessage());
			return null;
		}
	}
	
	private User warpUserModel (LDAPObject isepUser){
		return new User(isepUser.getLogin(), isepUser.getPassword(), isepUser.getNom(), isepUser.getNomFamille(), isepUser.getPrenom(), isepUser.getType(), isepUser.getNumber(), isepUser.getMail());
	}

}
