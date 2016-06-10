package DataBase;

import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.Date;


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
					
					System.out.println( " SessionId = " + String.valueOf(id) );
					
					return id;
				}
			}
			catch (Exception e){
				System.out.println("Exeption during query :" + e);
			}
		}
		return -1;
		
	}
	
}
