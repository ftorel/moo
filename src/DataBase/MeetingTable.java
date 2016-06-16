package DataBase;

import java.sql.ResultSet;

import Model.Meeting;

public class MeetingTable {

	static final public String tableName = "Meeting";
	
	static final public String id = "idMeeting";
	static final public String comment = "comment";
	static final public String startDate = "startDate";
	static final public String endDate = "endDate";
	
	public static Meeting getMeetingById( int id ){
		
		String sql = 
				" SELECT " + MeetingTable.tableName + "." + MeetingTable.startDate + "," +
						 MeetingTable.tableName + "." + MeetingTable.endDate + "," +
						 MeetingTable.tableName + "." + MeetingTable.comment + "," +
				" FROM " + MeetingTable.tableName + 
				" WHERE " + MeetingTable.tableName + "." + MeetingTable.id + " = " + Integer.toString(id);
		
		System.out.println( " sql getMeetingById ==> " + sql);
		
		ResultSet resultGetAllTeam = DataBaseConnector.sharedInstance().executeSQL(sql);
		
		if ( resultGetAllTeam == null ){
			System.out.println("The SQL has been executed, the result is null");
		}else{
			try{
				
				while (resultGetAllTeam.next()){
					
				}
				
			} catch (Exception e){
				
			}
		}
		
		return null;
		
	}
	
}
