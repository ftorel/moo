package DataBase;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class DataBaseConnector {

	private static DataBaseConnector baseConnnectorInstance; 
	
	static final String JDBC_DRIVER="com.mysql.jdbc.Driver";  

    static final String DB_URL="jdbc:mysql://sql7.freemysqlhosting.net/sql7113207";

    //  Database credentials
    static final String USER = "sql7113207";
    static final String PASS = "F4byJz1M7p";
    
    public static DataBaseConnector sharedInstance(){
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
			Class.forName(JDBC_DRIVER);

		    Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);

	        Statement stmt = conn.createStatement();

	        if(sqlString.contains("INSERT") || sqlString.contains("UPDATE") || sqlString.contains("DROP")){
	        	  stmt.executeUpdate(sqlString);
	        }else{
	        	return stmt.executeQuery(sqlString);
	        }
	        
	        stmt.close();
	        conn.close();
	  
	    	return null;
	    	
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
