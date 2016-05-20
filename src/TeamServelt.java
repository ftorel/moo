

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
		
		ArrayList<Team> datalist = new ArrayList<Team>();
		
		String sql = "SELECT name FROM Team ;";
		System.out.println(sql);
		ResultSet resultSet = DataBaseConnector.sharedInstance().executeSQL(sql);
		
		if ( resultSet == null ){
			System.out.println("The SQL has been executed, the result is null");
		}else{
			   try {
				   while (resultSet.next()) {
			            /*String teamName = resultSet.getString(TEAM_NAME);
			            Team team = TeamTable.
			            datalist.add( team );*/
			        }
			   } 
			   catch (SQLException e) {
				   System.out.println("Sql exeption" + e);
		    } 
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
