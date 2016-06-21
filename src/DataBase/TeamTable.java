package DataBase;

import java.sql.ResultSet;
import java.util.ArrayList;

import Model.Team;

public class TeamTable {

	static final public String tableName = "Team";
	static final public String id = "id_team";
	static final public String name = "name";

	
	
	static public void addTeam( int sessionId, String teamName ){
		
		String sqlValues = "( '" + teamName + "' );";
				
				String sql = "INSERT INTO " +
				TeamTable.tableName +" ("+ 
				TeamTable.name +
				") VALUES " + sqlValues;
				
				System.out.println(  "sql addTeam ==> " + sql);
				
		ResultSet resultGetAllTeam = DataBaseConnector.sharedInstance().executeSQL(sql);
				
		int teamId = getTeamIdByTeamName(teamName);
		
		if ( teamId == -1 ){
			System.out.println(" error getting team id");
			return;
		}
		
		String sqlValue2s = "( '" + Integer.toString(sessionId) + "'"  + " , " + "'" + Integer.toString(teamId) + "' " + ", " + "'" +  Integer.toString(2) +  "'" + ");";
		
			String sql2 = "INSERT INTO " +
			ProjetTable.tableName +" ("+ ProjetTable.sessionId + " , " +  ProjetTable.teamId + " , " + ProjetTable.subjectId  + ") VALUES " + sqlValue2s;
		
		System.out.println(  "sql addTeam ==> " + sql2);
		
		DataBaseConnector.sharedInstance().executeSQL(sql2);
		
		
	}
	
	
	static public int getTeamIdByTeamName(String name){
		
		
		String sqlGetAllTeam = 
				"SELECT " + TeamTable.tableName + "." + TeamTable.id + 
				" FROM " + TeamTable.tableName +
				" WHERE " + TeamTable.tableName + "." + TeamTable.name + " = " + "'" + name + "'";
		
		
		System.out.println(  " sql sqlGetAllTeam ==> " + sqlGetAllTeam );

		ResultSet resultGetAllTeam = DataBaseConnector.sharedInstance().executeSQL(sqlGetAllTeam);
		
		if ( resultGetAllTeam == null ){
			System.out.println("The SQL has been executed, the result is null");
		}else{
			try{
				
				while (resultGetAllTeam.next()){
					Integer id = (Integer) resultGetAllTeam.getObject(TeamTable.id);
					return id;
				}
				
			} catch (Exception e){
				
			}
		}
		
		
		return -1;
	}
	static public ArrayList<Model.Team> getAllTeamName(){
		
		ArrayList<Model.Team> teamList = new ArrayList<Model.Team>();
		
		//get all the team 
		
		String sqlGetAllTeam = 
				"SELECT " + TeamTable.tableName + "." + TeamTable.name + " , " + TeamTable.tableName + "." + TeamTable.id +
				" FROM " + TeamTable.tableName;
		
		System.out.println( "get all team : " + sqlGetAllTeam );
						
		ResultSet resultGetAllTeam = DataBaseConnector.sharedInstance().executeSQL(sqlGetAllTeam);
		
		if ( resultGetAllTeam == null ){
			System.out.println("The SQL has been executed, the result is null");
		}else{
			try{
				
				while (resultGetAllTeam.next()){
					Integer id = (Integer) resultGetAllTeam.getObject(TeamTable.id);
					String teamName = (String) resultGetAllTeam.getObject(TeamTable.name);
					
					System.out.println( " teamName : " + teamName);
										
					Team team = new Team(id,teamName);
					teamList.add(team);
				}
				
			} catch (Exception e){
				
			}
		}
		
		return teamList;
		
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
				" FROM " + 
				ParticipationTable.tableName + 
				" WHERE " + 
				ParticipationTable.teamId + 
				" = '" + teamId + "';";
		
		System.out.println("getMembersMail SQL ===> " + sql);
				
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
