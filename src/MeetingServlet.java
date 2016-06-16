

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DataBase.TeamMeetingTable;
import Utils.Constant;

/**
 * Servlet implementation class MeetingServlet
 */
@WebServlet("/MeetingServlet")
public class MeetingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MeetingServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession httpSession = request.getSession();
		int teamId = (Integer) httpSession.getAttribute( Constant.TAG_TEAM_ID );
		
		if ( teamId == -1 ){
			return;
		}
		
		ArrayList<Model.Meeting> meetings = TeamMeetingTable.getMeetingsByTeamId(teamId);
		
		if ( meetings == null ){
			return;
		}
		 
		request.setAttribute("meetings", meetings);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("eleve_team.jsp");
	    if (dispatcher != null){
	        dispatcher.forward(request, response);
	    }
		 
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
