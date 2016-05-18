package FileManager;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DataBase.FileTable;

/**
 * Servlet implementation class FileDelete
 */
@WebServlet("/FileDelete")
public class FileDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FileDelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		    String doc_id = request.getParameter("docId");
		    String doc_url = request.getParameter("docUrl");
		
			try{
				File file = new File(doc_url);
        	
				if(file.delete()){
					System.out.println(file.getName() + " is deleted!");
					FileTable.removeFile(doc_id);
					
					RequestDispatcher dispatcher = request.getRequestDispatcher("DocumentServlet");
					dispatcher.forward(request,response);
				}else{
					System.out.println("Delete operation is failed.");
				}
    	}catch(Exception e){	
    		e.printStackTrace();
    	}
	}

}
