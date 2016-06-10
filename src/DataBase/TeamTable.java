package DataBase;

import java.sql.ResultSet;
import java.util.ArrayList;

import Model.Team;

public class TeamTable {

	static final public String tableName = "Team";
	static final public String id = "id_team";
	static final public String name = "name";
	
	
static public  ArrayList<Model.Team> getTeamWithMembers(Integer sessionId){
	
	
	ArrayList<Model.Team> teamList = getAllTeamName();
	
	/*
	SELECT Team.name, User.firstname 
	FROM participation
	JOIN Team 
		ON Team.id_team = participation.team_id_team
	JOIN User
		ON User.email = participation.user_email
	WHERE User.type = 1
	 */
		
		String sql = 
			"SELECT " + TeamTable.tableName + "." + TeamTable.name + " , " + UserTable.tableName +"."+ UserTable.prenom + UserTable.tableName +"."+ UserTable.nom +
			"FROM " + ParticipationTable.tableName + 
				"JOIN " + TeamTable.tableName +
					"ON " + TeamTable.tableName +"."+ TeamTable.id + " = " +  ParticipationTable.tableName + "." + ParticipationTable.teamId  +
				"JOIN " + UserTable.tableName +
					"ON " + UserTable.tableName + UserTable.mail + " = " + ParticipationTable.tableName + "." + ParticipationTable.userMail  +
			" WHERE " + UserTable.tableName + "." + UserTable.type + " = 1 "; 

		System.out.println(sql);
		
		ResultSet resultSet = DataBaseConnector.sharedInstance().executeSQL(sql);
		if ( resultSet == null ){
			System.out.println("The SQL has been executed, the result is null");
		}else{
			try {

				while (resultSet.next()){
					String userName = (String) resultSet.getObject(UserTable.prenom);
					String teamName = (String) resultSet.getObject(TeamTable.name);
					
					int position = teamList.indexOf( new Team (teamName) );
					
					if ( position == -1 ){
						break;
					}
						
					Team team = teamList.get(position);
					
					if ( team == null ){
						break;
					}
					
					
					//team.addUser( new User);
					
					
					//TODO add the user to the correct team
					
				}
				return teamList;
			}
			catch (Exception e){
				System.out.println("Exeption during query :" + e);
			}
		}

		return null;
	}
	

	static private ArrayList<Model.Team> getAllTeamName(){
		
		ArrayList<Model.Team> teamList = new ArrayList<Model.Team>();
		
		//get all the team 
		
		String sqlGetAllTeam = 
				"SELECT " + TeamTable.tableName + "." + TeamTable.name + " , " + TeamTable.tableName + "." + TeamTable.id +
				"FROM " + TeamTable.tableName;
		
		System.out.println( "get all team : " + sqlGetAllTeam );
						
		ResultSet resultGetAllTeam = DataBaseConnector.sharedInstance().executeSQL(sqlGetAllTeam);
		
		if ( resultGetAllTeam == null ){
			System.out.println("The SQL has been executed, the result is null");
		}else{
			try{
				
				while (resultGetAllTeam.next()){
					Integer id = (Integer) resultGetAllTeam.getObject(TeamTable.id);
					String teamName = (String) resultGetAllTeam.getObject(TeamTable.name);
					
					//map.put(teamName, new ArrayList<Model.User>() );
					
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
