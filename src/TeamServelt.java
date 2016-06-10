

import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DataBase.DataBaseConnector;
import DataBase.ParticipationTable;
import DataBase.TeamTable;
import Model.Team;
import Utils.Constant;

/**
 * Servlet implementation class AddTeamServelt
 */
@WebServlet("/AddTeamServelt")
public class TeamServelt extends HttpServlet {
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeamServelt() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession httpSession = request.getSession();
		String userMail = (String) httpSession.getAttribute( Constant.TAG_MAIL );
		
		boolean isUserAlreadyHaveTeam = ParticipationTable.isUserAlreadyHaveTeam(userMail);
		
		ArrayList<Team> datalist = new ArrayList<Team>();
		
		if ( ! isUserAlreadyHaveTeam ){
			
			//display each team
			
			datalist = TeamTable.getTeamWithMembers();
					
			if ( datalist == null){
				System.out.println(" no datalist on teamServelt");
				return;
			}
			
		} else {
			
			//display the user team
			
			//TODO finish this method
			datalist = TeamTable.getTeamByUser( userMail );
			
			if ( datalist == null || datalist.isEmpty()){
				System.out.println(" no datalist on teamServelt");
				return;
			}
			
		}
		
		request.setAttribute("data", datalist);
		request.setAttribute("shouldJoinTeam", isUserAlreadyHaveTeam);
		
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
		
		HttpSession httpSession = request.getSession();
		String userMail = (String) httpSession.getAttribute( Constant.TAG_MAIL );
		Integer sessionId = (Integer) httpSession.getAttribute( Constant.TAG_SESSION_ID );
		
		String sId = String.valueOf(sessionId);
		
		if ( userMail == null || userMail.isEmpty() || sId == null || sId.isEmpty() ){
			//TODO deconnecter l'utilisateur et l'envoyer sur la page de connection
			return;
		}
		
		
		String selectedTeamName = (String) request.getParameter("team");
		
		if ( selectedTeamName == null || selectedTeamName.isEmpty() ){
			System.out.println( "error occured name is null ");
			return;
		} 
		
		ParticipationTable.addUserToSpecificTeam(userMail, sId, selectedTeamName);
		
	}
	

}
