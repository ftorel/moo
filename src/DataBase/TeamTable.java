package DataBase;

import java.sql.ResultSet;
import java.util.ArrayList;

import Model.Team;

public class TeamTable {

	static final public String tableName = "Team";
	static final public String id = "id_team";
	static final public String name = "name";
	
	
static public  ArrayList<Model.Team> getAllTeams(Integer sessionId){
		
		String sql = "SELECT id_team" + 
				"FROM " + 
				ParticipationTable.tableName + 
				" WHERE " + 
				ParticipationTable.sessionId + 
				" = '" + sessionId + "';";
				
				System.out.println(sql);
				ResultSet resultSet = DataBaseConnector.sharedInstance().executeSQL(sql);
				if ( resultSet == null ){
					System.out.println("The SQL has been executed, the result is null");
				}else{
					try {

						ArrayList<Model.Team> teamList = new ArrayList<Model.Team>();
						
						while (resultSet.next()){
						
							String teamId = (String) resultSet.getObject(ParticipationTable.teamId);
							Team currentTeam = TeamTable.getTeam(teamId);
							teamList.add(currentTeam);
						}
						return teamList;
					}
					catch (Exception e){
						System.out.println("Exeption during query :" + e);
					}
				}
		
				return null;
	}
	
	static public Team getTeam(String teamId){
		
		String sql = "Select *" + 
				"FROM " + 
				TeamTable.tableName + 
				" WHERE " + 
				TeamTable.id + 
				" = '" + teamId + "';";
				
				ResultSet resultSet = DataBaseConnector.sharedInstance().executeSQL(sql);
				if ( resultSet == null ){
					System.out.println("The SQL has been executed, the result is null");
				}else{
					try {
						
						while (resultSet.next()){
						
							Integer id = (Integer) resultSet.getObject(TeamTable.id);
							String name = (String) resultSet.getObject(TeamTable.name);
							
							Team tempTeam = new Team(id, name);
							
							return tempTeam;
						}
					}
					catch (Exception e){
						System.out.println("Exeption during query :" + e);
					}
				}
				return null;
	}
	
	static public ArrayList<String> getMembersMail(Integer teamId){
		
		String sql = "Select " + ParticipationTable.userMail  + 
				"FROM " + 
				ParticipationTable.tableName + 
				" WHERE " + 
				ParticipationTable.teamId + 
				" = '" + teamId + "';";
				
				ResultSet resultSet = DataBaseConnector.sharedInstance().executeSQL(sql);
				if ( resultSet == null ){
					System.out.println("The SQL has been executed, the result is null");
				}else{
					try {
						
						ArrayList<String> teamMembers = new ArrayList<String>();
						while (resultSet.next()){
					
							String userMail = (String) resultSet.getObject(ParticipationTable.userMail);
							teamMembers.add(userMail);
						}
						return teamMembers;
					}
					catch (Exception e){
						System.out.println("Exeption during query :" + e);
					}
				}
				return null;
	}
}
