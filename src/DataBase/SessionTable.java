package DataBase;

import java.sql.ResultSet;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import Model.Session;


public class SessionTable {

	static final public String tableName = "Session";
	static final public String id = "id_session";
	static final public String startDate = "startDate";
	static final public String endDate = "endDate";
	

	
	public static int getIdCurrentSession(){
		
		
		Date date = new Date();
		Timestamp timestamp = new Timestamp(date.getTime());
		String currentDate = timestamp.toString();
		
		/*
		 SELECT session.id_session 
		FROM session 	 
		WHERE currentDate between Session.startDate and Session.endDate
		 */
		
		System.out.println( "currentTimeStamp : " + currentDate );
				
		String sql = 
				"SELECT " + SessionTable.tableName + "." + SessionTable.id +
				" FROM " + SessionTable.tableName +
				" WHERE " +"'"+ currentDate + "'" +
					" BETWEEN " + SessionTable.tableName +"."+ SessionTable.startDate + " AND " + SessionTable.tableName +"." + SessionTable.endDate
				;
		
		System.out.println( "sql getIDCURRENTSESSION : " + sql  );
			
		ResultSet resultSet = DataBaseConnector.sharedInstance().executeSQL(sql);
		
		if ( resultSet == null ){
			System.out.println("The SQL has been executed, the result is null");
		}else{
			try {
				
				while (resultSet.next()){
				
					Integer id = (Integer) resultSet.getObject(SessionTable.id);	
					
					return id;
				}
			}
			catch (Exception e){
				System.out.println("Exeption during query :" + e);
			}
		}
		return -1;
		
	}
	
	public static ArrayList<Model.Session> getAllSession(){
		
		/*
		 SELECT session.id_session, 
		 */
		
		String sql = 
				"SELECT " + SessionTable.tableName + "." + SessionTable.id + " , " + 
						SessionTable.tableName + "." + SessionTable.startDate + " , " + 
						SessionTable.tableName + "." + SessionTable.endDate  + 
				" FROM " + SessionTable.tableName;
				
		System.out.println( "sql getAllSession : " + sql  );
		
		ResultSet resultSet = DataBaseConnector.sharedInstance().executeSQL(sql);
		
		ArrayList<Model.Session> sessionList = new ArrayList<Model.Session>();
		
		if ( resultSet == null ){
			System.out.println("The SQL has been executed, the result is null");
		}else{
			try {
				
				while (resultSet.next()){
				
					Integer id = (Integer) resultSet.getObject(SessionTable.id);
					Timestamp startDate = (Timestamp) resultSet.getObject(SessionTable.startDate);
					Timestamp endDate = (Timestamp) resultSet.getObject(SessionTable.endDate);
					
					Session session = new Session(id);
					session.setEndDate(endDate);
					session.setStartDate(startDate);
					
					sessionList.add(session);
					
				}
			}
			catch (Exception e){
				System.out.println("Exeption during query :" + e);
			}
		}
		
		return sessionList;
	}
	
	private static Timestamp convertStringDate( String date ){
		
		//convert string format 
		try{
			
		    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		    Date parsedDate = dateFormat.parse(date);
		    Timestamp timestamp = new java.sql.Timestamp(parsedDate.getTime());
		    
		    String a = new SimpleDateFormat("yyyy-MM-dd").format(timestamp);
		    
		    SimpleDateFormat newformat = new SimpleDateFormat("yyyy-MM-dd");
		    Date parsedNewDate = newformat.parse(a);
		    return new java.sql.Timestamp(parsedNewDate.getTime());
		    
		}catch(Exception e){//this generic but you can control another types of exception
			e.printStackTrace();
		}
		
		return null;
	}
	
	public static void addSession( String startDate, String endDate){
		
		Timestamp startTimeStamp = convertStringDate( startDate );
		Timestamp endTimeStamp = convertStringDate( endDate );
		
		Object[] params = new Object[]{startTimeStamp,endTimeStamp};
		
		String sql = 
				"INSERT INTO " + SessionTable.tableName + " ( "  + SessionTable.startDate + "," + SessionTable.endDate + " ) " +                  
				" VALUES " +
					" ( " +  
						"?" + "," +
						 "?" +
					" ) ";
		
		System.out.println( "sql addUserToSpecificTeam ===> " + sql);
		
		
		ResultSet resultSet = DataBaseConnector.sharedInstance().executeSQL(sql,params);
		
	}
	
}
