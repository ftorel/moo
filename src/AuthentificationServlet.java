

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.AuthenticationException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DataBase.DataBaseConnector;
import ISEP.LDAPObject;
import ISEP.LDAPaccess;
import Model.User;
import Model.UserManager;

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
		
		if (this.existUserInDataBase(result.mail)){
			System.out.println("User already registered");
		}else{
			String sqlValues = "(0,'" + result.nomFamille + "','" + result.prenom + "'," + typeInt + ",'" + result.mail + "');";
			
			String sql = "INSERT INTO User (id, prenom, nom, type, mail) VALUES "+ sqlValues;
			
			System.out.println(sql);
			
			ResultSet resultSet = DataBaseConnector.sharedInstance().executeSQL(sql);
			
			if ( resultSet == null ){
				System.out.println("The SQL has been executed");
			}
		}
		
		System.out.println("Prepare redirection to " + redirectPage);
		
		response.sendRedirect(redirectPage);
	}
	
	boolean existUserInDataBase(String userMail){

		
		String sql = "SELECT id FROM User WHERE mail = '" + userMail + "';";
		System.out.println(sql);
		ResultSet resultSet = DataBaseConnector.sharedInstance().executeSQL(sql);
		
		if ( resultSet == null ){
			System.out.println("The SQL has been executed, the result is null");
		}else{
			   try {
				   return resultSet.first();
			   } 
			   catch (SQLException e) {
				   System.out.println("Sql exeption" + e);
		    } 
		}
		return false;
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
		    UserManager.sharedInstance().currentUser = this.warpUserModel(isepUser);
		
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
