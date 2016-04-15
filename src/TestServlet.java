import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DataBase.DataBaseConnector;
import ISEP.LDAPObject;
import ISEP.LDAPaccess;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		DataBaseConnector.sharedInstance().executeSQL("CREATE TABLE lolilol (PersonID int);");
		
		PrintWriter out = response.getWriter();
		
		/*LDAPaccess access = new LDAPaccess();
		try {
			LDAPObject test = access.LDAPget("ftor", "isep2013"); 

		if (test == null)
		{
			System.out.println("login invalide");
			System.exit(1);
		}
			System.out.println(test.toString()); 
			System.exit(0);
		} catch(Exception e) {
			System.err.println(e.getMessage());
			System.exit(1);
		}*/
		
		String htmlCode = "<html>"
				+ "<body>"
				+ "FINISHHH"
				+ "</body></html>";
				
		out.println(htmlCode);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
