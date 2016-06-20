

import java.io.IOException;

import javax.naming.AuthenticationException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DataBase.ParticipationTable;
import DataBase.SessionTable;
import DataBase.UserTable;
import ISEP.LDAPObject;
import ISEP.LDAPaccess;
import Utils.Constant;

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
		
		boolean onISEPServer = false;
		boolean isFlorianUser = true;
		
		String login = request.getParameter("log");
		String password = request.getParameter("pass");
		
		LDAPObject result= null;
		
		if ( ! login.equals("flo") && ! password.equals("flo") ){
			if ( onISEPServer ){
				result = ISEPAuth( login , password );
			} else {
				if ( isFlorianUser ){
					result = new LDAPObject("ftorel", "isep2013", "Florian", "Torel", "Florian", "eleve", "7872", "ftorel@isep.fr");
				} else {
					result = new LDAPObject("pp7869", "756NPR", "Pierre", "Perrin", "Pierre", "eleve", "7869", "pierre.perrin@isep.fr");
				}
			}
		} else {
			result = new LDAPObject("floriantorel", "florian2013", "FlorianProf", "TorelProf", "FlorianProf", "professeur", "7872", "ftorelprofesseur@isep.fr");
		}
	
		
		
		if ( result == null ){
			return;
		}
		
		String type = result.getType(); 
		String redirectPage = "";
		
		Integer typeInt = 0;
			
		if ( type.equals("eleve")){
			redirectPage = "eleve_accueil.html";
			typeInt = 1;
		} else if ( type.equals("client") ){
			redirectPage = "accueil_client.html";
			typeInt = 2;
		} else if ( type.equals("tuteur") ){
			typeInt = 3;
		} else if ( type.equals("professeur") ){
			redirectPage = "prof_accueil.html";
			typeInt = 4;
		}
		
		UserTable.getAllUser();
		
		String userMail =  UserTable.UserExistWithMail(result.mail);
		
		if (!userMail.isEmpty()){
			System.out.println("User already registered");
		}else{
			UserTable.addUser(result.prenom, result.nomFamille, result.mail	, typeInt);
			userMail = UserTable.UserExistWithMail(result.mail);
		}
		
		if (!userMail.isEmpty()){
			System.out.println("Prepare redirection to " + redirectPage);
			
			int idSession = SessionTable.getIdCurrentSession();
		
			if ( idSession == -1){
				System.out.println("An error occured with the session id");
				return;
			}
			
			int teamId = ParticipationTable.getTeamIdByUserEmail(userMail);
			
			System.out.println("Session ID " + idSession);
			System.out.println("Team ID " + teamId);
					
			HttpSession httpSession = request.getSession();
			httpSession.setAttribute( Constant.TAG_MAIL , userMail);
			httpSession.setAttribute( Constant.TAG_SESSION_ID , idSession);
			httpSession.setAttribute( Constant.TAG_TEAM_ID , teamId);
			
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
	

}
