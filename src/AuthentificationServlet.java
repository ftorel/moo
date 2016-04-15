

import java.io.IOException;

import javax.naming.AuthenticationException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ISEP.LDAPObject;
import ISEP.LDAPaccess;

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
		
		String result = ISEPAuth("ftorel","isep201");
		
		System.out.println(result);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	
	
	private String ClientAuth( String login, String password ){
		
		return "";
	}
	
	
	/**
	 * This method is used to detect if the user is in isep's db
	 * It works for student or teacher or tutor
	 * 
	 * @param login
	 * @param password
	 * @return 
	 */
	private String ISEPAuth( String login, String password ){
	
		LDAPaccess access = new LDAPaccess();
		try {
			LDAPObject test = access.LDAPget( login , password ); 

		if (test == null)
		{
			return "login invalide";
		}
			return test.getType();
		} catch(Exception e) {
			
			if ( e instanceof AuthenticationException ){
				return "login invalide";
			}
			
			System.err.println(e.getMessage());
			return "error";
		}
	}

}
