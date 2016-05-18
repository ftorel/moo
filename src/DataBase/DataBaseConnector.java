package DataBase;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class DataBaseConnector {

	private static DataBaseConnector baseConnnectorInstance; 
	
	static final String JDBC_DRIVER="com.mysql.jdbc.Driver";  

    static final String DB_URL="jdbc:mysql://0.0.0.0:8889/DleMoo";

    //  Database credentials
    static final String USER = "bg";
    static final String PASS = "bg";
     
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
		
		System.out.print("start executeSQL" + "\n");
		
		try{
			
		    Connection conn = getDBConnection();
		    
		    if ( conn == null ){
		    	return null;
		    }

	        Statement stmt = conn.createStatement();

	        if(sqlString.contains("DELETE") || sqlString.contains("CREATE") || sqlString.contains("INSERT") || sqlString.contains("UPDATE") || sqlString.contains("DROP")){
	        	  stmt.executeUpdate(sqlString);
	        }else{
	        	return stmt.executeQuery(sqlString);
	        }
	        
	        stmt.close();
	        conn.close();
	  
	    	return null;
	    	
			} 
		catch (SQLException ex) {
			System.out.println(" error :  " + ex.getMessage() + "\n");
		    }
		
		return null;
	}
	
	private static Connection getDBConnection() {

		Connection dbConnection = null;

		try {
			
			System.out.print("init driver");

			Class.forName(JDBC_DRIVER);

		} catch (ClassNotFoundException e) {

			System.out.println( " error :  " + e.getMessage() + "\n" );

		}

		try {
			
			System.out.print("start db connection");
			System.out.print("url = " + DB_URL + "\n");
			System.out.print("user = " + USER + "\n");
			System.out.print("pass = " + PASS + "\n");

			dbConnection = DriverManager.getConnection(DB_URL, USER, PASS);
			return dbConnection;

		} catch (SQLException e) {

			System.out.println( " error :  " + e.getMessage() + "\n" );

		}

		return dbConnection;

	}

	

}
