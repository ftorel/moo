package DataBase;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;

public class TeamMeetingTable {

	static final String tableName = "teammeeting";
	static final String idTeam = "idTeam";
	static final String idMeeting = "idMeeting";
	
	public static ArrayList<Model.Meeting> getMeetingsByTeamId( int teamId ){
		
		/*
		 SELECT Meeting.comment 
		 FROM teammeeting 
		 JOIN Meeting 
		 	ON Meeting.idMeeting = teammeeting.idMeeting 
		 JOIN Team 
		 	ON Team.id_team = teammeeting.idTeam 
		 WHERE Team.id_team = teamId
		 */
		
		String sql = 
				" SELECT " + MeetingTable.tableName + "." + MeetingTable.comment + "," +
						MeetingTable.tableName + "." + MeetingTable.startDate + "," +
						MeetingTable.tableName + "." + MeetingTable.endDate + "," +
						MeetingTable.tableName + "." + MeetingTable.id + "," +
				" FROM " + TeamMeetingTable.tableName + 
				" JOIN " + MeetingTable.tableName +
					" ON " + MeetingTable.tableName + "." + MeetingTable.id + " = " + TeamMeetingTable.tableName + "." + TeamMeetingTable.idMeeting +
				" JOIN " + TeamTable.tableName +
					" ON " + TeamTable.tableName + "." + TeamTable.id + " = " + TeamMeetingTable.tableName + "." + TeamMeetingTable.idTeam +
				" WHERE " + TeamTable.tableName + "." + TeamTable.id + " = " + Integer.toString(teamId);
		
		ResultSet result = DataBaseConnector.sharedInstance().executeSQL(sql);
		
		if ( result == null ){
			System.out.println("The SQL has been executed, the result is null");
		}else{
			
			ArrayList<Model.Meeting> meetings = new ArrayList<Model.Meeting>();
			
			try{
				
				while (result.next()){
					
					Integer meetingId = (Integer) result.getObject(MeetingTable.id);
					String comment = (String) result.getObject(MeetingTable.comment);
					String endDate = (String) result.getObject(MeetingTable.endDate);
					String startDate = (String) result.getObject(MeetingTable.startDate);
					
					Model.Meeting meeting = new Model.Meeting(meetingId);
					meeting.setComment(comment);
					meeting.setEndDate(endDate);
					meeting.setStartDate(startDate);
					
					meetings.add(meeting);
					
				}
				
			} catch (Exception e){
				e.printStackTrace();
			}
			
			if ( meetings.isEmpty() ){
				System.out.println(" meetings list is empty");
				return null;
			}
			
			Collections.sort(meetings);
			return meetings;
		}
		
		return null;
	}
	
}
