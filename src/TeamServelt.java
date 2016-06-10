

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DataBase.DataBaseConnector;
import DataBase.ParticipationTable;
import DataBase.SessionTable;
import DataBase.TeamTable;
import Model.Team;

/**
 * Servlet implementation class AddTeamServelt
 */
@WebServlet("/AddTeamServelt")
public class TeamServelt extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public static final String TEAM_NAME = "name";
       
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
		
		
		boolean isUserAlreadyHaveTeam = ParticipationTable.isUserAlreadyHaveTeam("test3@gmail.com");
		
		ArrayList<Team> datalist = TeamTable.getTeamWithMembers();
		
		if ( datalist == null ){
			System.out.println(" no datalist on teamServelt");
			return;
		}
		
		request.setAttribute("data", datalist);
		
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
		
		String name = request.getParameter(TEAM_NAME);
		String sqlValues = "(0,'" + name + "');";
		String sql = "INSERT INTO Team (id, name) VALUES "+ sqlValues;
		System.out.println(sql);
		ResultSet resultSet = DataBaseConnector.sharedInstance().executeSQL(sql);
		if ( resultSet == null ){
			System.out.println("The SQL has been executed");
		}
		
	}
	

}
