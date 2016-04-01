package DataBase;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class DataBaseConnector {

	private static DataBaseConnector baseConnnectorInstance; 
	
	static final String JDBC_DRIVER="com.mysql.jdbc.Driver";  
	//jdbc:mysql://hostname:port/dbname
    static final String DB_URL="jdbc:mysql://perrino.fr/nperrinofblpierre.mysql.db";

    //  Database credentials
    static final String USER = "perrinofblpierre";
    static final String PASS = "MoodISEP0";
    
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
	
	public void executeSQL(String sqlString){
		
		try{
			Class.forName(JDBC_DRIVER);

			Connection co = DriverManager.getConnection(DB_URL,USER,PASS);
			
			if (co != null) {
                System.out.println("Connected to the database");
            } else {
            	System.out.println("Not connected to the database");
            }
			
	        //Statement stmt = co.createStatement();
	        //ResultSet rset = stmt.executeQuery(sqlString); 
	        
	        //stmt.close();
			
			
	  
	    	return;
	    	
			} 
		catch (SQLException ex) {
		            ex.printStackTrace();
		    } 
		catch (ClassNotFoundException e) {
		            // TODO Auto-generated catch block
		            e.printStackTrace();
		    } finally {
		    	
		    }
		return;
	}

}
