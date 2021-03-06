package DataBase;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;



public class DataBaseConnector {

	private static DataBaseConnector baseConnnectorInstance; 
	
	static final String JDBC_DRIVER="com.mysql.jdbc.Driver";  

	static final String DB_URL="jdbc:mysql://0.0.0.0:8889/testDB";

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
	
	public ResultSet executeSQL( String sql , Object[] params ){
		
		try{
			
		    Connection conn = getDBConnection();
		    
		    if ( conn == null ){
		    	return null;
		    }

		    java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
	        
	        for ( int i = 0 ; i < params.length ; i ++ ){
	        	stmt.setTimestamp(i + 1, (Timestamp) params[ i ]);
	        }
	        
	        stmt.executeUpdate();
	       
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
			

			Class.forName(JDBC_DRIVER);

		} catch (ClassNotFoundException e) {

			System.out.println( " error :  " + e.getMessage() + "\n" );

		}

		try {
			
			
			dbConnection = DriverManager.getConnection(DB_URL, USER, PASS);
			return dbConnection;

		} catch (SQLException e) {

			System.out.println( " error :  " + e.getMessage() + "\n" );

		}

		return dbConnection;

	}

	

}
