

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Utils.Constant;
import DataBase.ParticipationTable;
import DataBase.ProjetTable;
import DataBase.SessionTable;
import DataBase.SujetTable;
import DataBase.TeamTable;

/**
 * Servlet implementation class SujetProfServlet
 */
@WebServlet("/SujetProfServlet")
public class SujetProfServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SujetProfServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		ArrayList<Model.Session> sessions = SessionTable.getAllSession();
		ArrayList<Model.Team> teams = TeamTable.getAllTeamName();
		ArrayList<Model.Sujet> sujets = SujetTable.getAllSujet();
		
		if ( sessions.isEmpty() || teams.isEmpty() || sujets.isEmpty() ){
			return;
		}
		
		HttpSession httpSession = request.getSession();
        Integer sessionId = (Integer) httpSession.getAttribute( Constant.TAG_SESSION_ID );
		
		ProjetTable.assignTeamToSubject(sujets, sessionId);
		
		request.setAttribute("sessions", sessions);
		request.setAttribute("teams", teams);
		request.setAttribute("sujets", sujets);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("prof_sujet.jsp");
	    if (dispatcher != null){
	        dispatcher.forward(request, response);
	    }
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String name = (String) request.getParameter("name");
		String description = (String) request.getParameter("description");
		
		if ( name == null || name.isEmpty() ){
			System.out.println( " name empty ");
			return;
		} 
		
		if ( description == null || description.isEmpty() ){
			System.out.println( " description empty ");
			return;
		} 
		
		SujetTable.addSujet(name, description);
		
		doGet(request,response);
		
	}

}
