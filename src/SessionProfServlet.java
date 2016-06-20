

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DataBase.SessionTable;
import DataBase.SujetTable;

/**
 * Servlet implementation class SessionProfServlet
 */
@WebServlet("/SessionProfServlet")
public class SessionProfServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SessionProfServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<Model.Session> sessions = SessionTable.getAllSession();
		
		request.setAttribute("sessions", sessions);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("prof_session.jsp");
	    if (dispatcher != null){
	        dispatcher.forward(request, response);
	    }
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String startDate = (String) request.getParameter("startDate");
		String endDate = (String) request.getParameter("endDate");
		
		if ( startDate == null || startDate.isEmpty() ){
			System.out.println( " startDate empty ");
			return;
		} 
		
		if ( endDate == null || endDate.isEmpty() ){
			System.out.println( " endDate empty ");
			return;
		} 
		
		SessionTable.addSession(startDate,endDate);
		
		doGet(request,response);
		
	}

}
