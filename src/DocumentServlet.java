

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DataBase.DataBaseConnector;
import DataBase.FileTable;
import Model.Document;
import Model.Team;
import Utils.Constant;

/**
 * Servlet implementation class DocumentServlet
 */
@WebServlet("/DocumentServlet")
public class DocumentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DocumentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// TODO Change here for the session ID loader
		HttpSession httpSession = request.getSession();
		
		
		
		Integer type = (Integer) httpSession.getAttribute(Constant.TAG_USER_TYPE);
		
		
		if(type == 4){
			
			String userMail = (String) httpSession.getAttribute( Constant.TAG_MAIL );
			HashMap<Team, ArrayList<Document>> datalist = FileTable.getDocumentByTeams();
			
			request.setAttribute("data", datalist);

			RequestDispatcher dispatcher = request.getRequestDispatcher("prof_document.jsp");
			
			if (dispatcher != null){
				dispatcher.forward(request, response);
			}
			
			return;
		}
		
		String userMail = (String) httpSession.getAttribute( Constant.TAG_MAIL );
		ArrayList<Document> datalist = FileTable.FilesForUserId(userMail);
		
		request.setAttribute("data", datalist);

		RequestDispatcher dispatcher = request.getRequestDispatcher("eleve_documents.jsp");
		
		if (dispatcher != null){
			dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
