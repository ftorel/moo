

import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.tools.internal.ws.processor.model.Model;

import DataBase.DataBaseConnector;
import DataBase.FileTable;
import Model.Document;

/**
 * Servlet implementation class SQLExecutor
 */
@WebServlet("/SQLExecutor")
public class SQLExecutor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SQLExecutor() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		//tring sql = "";
		
		/* Document table creation SQL
		 sql = "CREATE TABLE Documents " +
					"(D_ID Int NOT NULL AUTO_INCREMENT ," + 
					"Name varchar(255) NOT NULL, " +
					"Url varchar(255) NOT NULL, " +
					"U_ID Int, " +
					"PRIMARY KEY (D_ID), " +
					"FOREIGN KEY (U_ID) REFERENCES User(U_ID));";
					*/
		
		ArrayList<Document> docList =  FileTable.FilesForUserId("7");
		
		System.out.println("The sql is " + docList);
	
		/*ResultSet resultSet = DataBaseConnector.sharedInstance().executeSQL(sql);
		
		System.out.println("The sql is " + sql);
		
		if ( resultSet == null ){
			System.out.println("The SQL has been executed, the result is null");
		}else{
			   try {
				   System.out.println("The SQL has been excuted");
			   } 
			   catch (Exception e) {
				   System.out.println("Sql exeption" + e);
		    } 
		}*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
