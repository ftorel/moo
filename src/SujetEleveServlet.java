

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DataBase.ProjetTable;
import Model.Sujet;
import Utils.Constant;

/**
 * Servlet implementation class SujetEleveServlet
 */
@WebServlet("/SujetEleveServlet")
public class SujetEleveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SujetEleveServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession httpSession = request.getSession();
		Integer sessionId = (Integer) httpSession.getAttribute( Constant.TAG_SESSION_ID );
		Integer teamId = (Integer) httpSession.getAttribute( Constant.TAG_TEAM_ID );
		
		Sujet sujet = ProjetTable.getSubjectByUserMail(sessionId,teamId);
		
		request.setAttribute("sujet", sujet);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("eleve_subject.jsp");
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
