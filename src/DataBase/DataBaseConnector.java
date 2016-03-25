package DataBase;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class DataBaseConnector {

	private static DataBaseConnector baseConnnectorInstance; 
	
	static final String JDBC_DRIVER="com.mysql.jdbc.Driver";  
    static final String DB_URL="perrinofblpierre.mysql.db";

    //  Database credentials
    static final String USER = "perrinofblpierre";
    static final String PASS = "MoodISEP0";
	
	private static DataBaseConnector initInstance(){
		if ( baseConnnectorInstance == null ){
			baseConnnectorInstance = new DataBaseConnector();
	
			
			  try{
					Class.forName("com.mysql.jdbc.Driver");

					
				    Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
			        Statement stmt = conn.createStatement();

					  } catch (SQLException ex) {
				            ex.printStackTrace();
				        } catch (ClassNotFoundException e) {
				            // TODO Auto-generated catch block
				            e.printStackTrace();
				        }
			  
		}
		return baseConnnectorInstance;
	}
	
	public DataBaseConnector sharedInstance(){
		return initInstance();
	}
	
	public DataBaseConnector() {
		// TODO Auto-generated constructor stub
	}
	
}
