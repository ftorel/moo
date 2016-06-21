

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DataBase.SessionTable;
import DataBase.TeamTable;
import Model.Session;

/**
 * Servlet implementation class TeamProfServelt
 */
@WebServlet("/TeamProfServelt")
public class TeamProfServelt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeamProfServelt() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		ArrayList<Model.Session> sessions = SessionTable.getAllSession();
		
		// todo get team bySession 
		
		
		request.setAttribute("sessions", sessions);
		request.getSession().setAttribute("id", sessions.get(0).getId());
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("prof_team.jsp");
	    if (dispatcher != null){
	        dispatcher.forward(request, response);
	    }
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String name = (String) request.getParameter("team_name");
		Integer id = (Integer)request.getSession().getAttribute("id");
		
		
		System.out.println( " name : " + name );
		System.out.println( " description : " + Integer.toString(id) );
		
		
		TeamTable.addTeam(id, name);
		
		
		doGet(request,response);
		
		
	}

}
