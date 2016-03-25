package DataBase;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

import com.sun.org.apache.xpath.internal.functions.FuncBoolean;

import java.sql.*;

public class DataBaseConnector {

	private static DataBaseConnector baseConnnectorInstance; 
	
	static final String JDBC_DRIVER="com.mysql.jdbc.Driver";  
    static final String DB_URL="perrinofblpierre.mysql.db";

    //  Database credentials
    static final String USER = "perrinofblpierre";
    static final String PASS = "MoodISEP0";
    
    public DataBaseConnector sharedInstance(){
		return initInstance();
	}
	
	private DataBaseConnector() {
		// TODO Auto-generated constructor stub
	}
	
	private static DataBaseConnector initInstance(){
		if ( baseConnnectorInstance == null ){
			baseConnnectorInstance = new DataBaseConnector();
		}
		return baseConnnectorInstance;
	}
	
	public ResultSet executeSQL(String sqlString){
		
		try{
			Class.forName("com.mysql.jdbc.Driver");

		    Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
	        Statement stmt = conn.createStatement();
	        ResultSet rset = stmt.executeQuery(sqlString); 
	        
	        stmt.close();
	        conn.close();
	  
	    	return rset;
	    	
			} 
		catch (SQLException ex) {
		            ex.printStackTrace();
		    } 
		catch (ClassNotFoundException e) {
		            // TODO Auto-generated catch block
		            e.printStackTrace();
		    }
		return null;
	}

}
