package DataBase;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Model.Team;

public class ParticipationTable {

	static final public String tableName = "Participation";
	static final public String id = "id_participation";
	static final public String userMail = "user_email";
	static final public String teamId = "team_id_team";
	static final public String sessionId = "Session_id_session";
	
	static public  ArrayList<Model.Team> getTeamWithMembers(){
		
		ArrayList<Model.Team> teamList = TeamTable.getAllTeamName();
		
		if ( teamList == null || teamList.isEmpty() ){
			System.out.println("no team");
			return null;
		}
		
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
			"SELECT " + TeamTable.tableName + "." + TeamTable.name + " , " +
						TeamTable.tableName + "." + TeamTable.id + " , " +
						UserTable.tableName +"."+ UserTable.prenom + " , " +
						UserTable.tableName +"."+ UserTable.nom + " , " +
						UserTable.tableName +"."+ UserTable.mail +
			" FROM " + ParticipationTable.tableName + 
				" JOIN " + TeamTable.tableName +
					" ON " + TeamTable.tableName +"."+ TeamTable.id + " = " +  ParticipationTable.tableName + "." + ParticipationTable.teamId  +
				" JOIN " + UserTable.tableName +
					" ON " + UserTable.tableName +"." + UserTable.mail + " = " + ParticipationTable.tableName + "." + ParticipationTable.userMail  +
			" WHERE " + UserTable.tableName + "." + UserTable.type + " = 1 "; 

		System.out.println(sql);
		
		ResultSet resultSet = DataBaseConnector.sharedInstance().executeSQL(sql);
		if ( resultSet == null ){
			System.out.println("The SQL has been executed, the result is null");
		}else{
			try {

				while (resultSet.next()){
					String userName = (String) resultSet.getObject(UserTable.prenom);
					String userEmail = (String) resultSet.getObject(UserTable.mail);
					String userLastName = (String) resultSet.getObject(UserTable.nom);
					String teamName = (String) resultSet.getObject(TeamTable.name);
					Integer teamId = (Integer) resultSet.getObject(TeamTable.id);
					
					
					int position = teamList.indexOf( new Team (teamId,teamName) );
										
					if ( position != -1 ){
						
						Team team = teamList.get(position);
						
						if ( team != null ){
							
							Model.User user = new Model.User(userLastName, userName, 1 , userEmail);
							
							team.addUser(user);
						}
						
					}
										
				}
				return teamList;
			}
			catch (Exception e){
				System.out.println("Exeption during query :" + e);
			}
		}

		return null;
	}
	
	static public ArrayList<Model.Team> getTeamPartnersByUserEmail( String email ){
		
		
		int teamId = getTeamIdByUserEmail(email);
		
		if ( teamId == -1 ){
			System.out.println(" there is no team for " + email);
			return null;
		} else {
			System.out.println("teamId : " + teamId);
		}
		
		ArrayList<Model.Team> list = new ArrayList<Model.Team>();
		
		/*
		 SELECT Team.name , Team.id_team , User.firstname , User.lastname , User.email 
		 FROM Participation 
		 JOIN Team 
		 	ON Team.id_team = Participation.team_id_team 
		 JOIN User 
		 	ON User.email = Participation.user_email 
		 WHERE User.type = 1 
		 	AND Team.id_team = 
		 	( SELECT participation.team_id_team FROM participation WHERE participation.user_email = 'test1@gmail.com')
		 */
		
		String sql = 
				"SELECT " + TeamTable.tableName + "." + TeamTable.name + " , " +
							TeamTable.tableName + "." + TeamTable.id + " , " +
							UserTable.tableName +"."+ UserTable.prenom + " , " +
							UserTable.tableName +"."+ UserTable.nom + " , " +
							UserTable.tableName +"."+ UserTable.mail +
				" FROM " + ParticipationTable.tableName + 
					" JOIN " + TeamTable.tableName +
						" ON " + TeamTable.tableName +"."+ TeamTable.id + " = " +  ParticipationTable.tableName + "." + ParticipationTable.teamId  +
					" JOIN " + UserTable.tableName +
						" ON " + UserTable.tableName +"." + UserTable.mail + " = " + ParticipationTable.tableName + "." + ParticipationTable.userMail  +
				" WHERE " + UserTable.tableName + "." + UserTable.type + " = 1 " + 
						" AND " +  TeamTable.tableName +"."+ TeamTable.id + " = " + Integer.toString(teamId)
						;
		
		System.out.println(sql);
		
		ResultSet resultSet = DataBaseConnector.sharedInstance().executeSQL(sql);
		if ( resultSet == null ){
			System.out.println("The SQL has been executed, the result is null");
		}else{
			try {

				while (resultSet.next()){
					String userName = (String) resultSet.getObject(UserTable.prenom);
					String userEmail = (String) resultSet.getObject(UserTable.mail);
					String userLastName = (String) resultSet.getObject(UserTable.nom);
					String teamName = (String) resultSet.getObject(TeamTable.name);
					
					if ( list.isEmpty() ){
						list.add( new Team(teamId,teamName));
					}
					
					Team team = list.get(0);
					
					if ( team != null ){
						Model.User user = new Model.User(userLastName, userName, 1 , userEmail);
						team.addUser(user);
					}
										
				}
				return list;
			}
			catch (Exception e){
				System.out.println("Exeption during query :" + e);
			}
		}

		return null;
			
	}
	
	static public int getTeamIdByUserEmail( String userMail ){
		
		//( SELECT participation.team_id_team FROM participation WHERE participation.user_email = 'test1@gmail.com')
		
		String sql = 
				"SELECT " + ParticipationTable.tableName + "." + ParticipationTable.teamId + 
				" FROM " + ParticipationTable.tableName + 
				" WHERE " + ParticipationTable.tableName + "." + ParticipationTable.userMail + " = " + "'" + userMail + "'"
				;
		
		System.out.println("getTeamIdByUserEmail " + sql);
		
		ResultSet resultSet = DataBaseConnector.sharedInstance().executeSQL(sql);
		
		if ( resultSet == null ){
			System.out.println("The SQL has been executed, the result is null");
		}else{
			try {
				
				while (resultSet.next()){
					int id = (Integer) resultSet.getObject( ParticipationTable.teamId);
					return id;
				}
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return -1;
	}
	
	
	static public boolean isUserAlreadyHaveTeam( String email ){
		
		int sessionId = SessionTable.getIdCurrentSession();
		
		/*
		SELECT participation.id_participation
		FROM participation
		WHERE participation.user_email = 'test1@gmail.com' AND participation.Session_id_session = '1'
		 */
		
		String sql = 
				"SELECT * " +
				" FROM " + ParticipationTable.tableName +
				" WHERE " + ParticipationTable.tableName + "." + ParticipationTable.userMail + " = " + "'" + email + "'" +
					" AND " + ParticipationTable.tableName + "." + ParticipationTable.sessionId + " = " + "'" + sessionId + "'"
				;
		
		
		System.out.println( " sql isUserAlreadyExists : " + sql );
		
		ResultSet resultSet = DataBaseConnector.sharedInstance().executeSQL(sql);
		
		if ( resultSet == null ){
			System.out.println("The SQL has been executed, the result is null");
		}else{
			try {
				return resultSet.next();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return false;
	}
	
	
	static public boolean addUserToSpecificTeam( String userMail, String userSession, String selectedTeamName){
		
		//INSERT INTO `participation`( `user_email`, `team_id_team`, `Session_id_session`) 
		//VALUES ( 'ftorel@isep.fr', ( SELECT Team.id_team FROM Team WHERE Team.name = 'camion'), 1 )
		
		
		//INSERT INTO Participation ( 'user_email','team_id_team','Session_id_session' )  
		//VALUES  ( 'florian.torel@isep.fr', (  SELECT Team.id_team FROM Team WHERE Team.name = 'camion' ) , 1 ) 
		
		/*
		 INSERT INTO `participation`( `user_email`, `team_id_team`, `Session_id_session`) 
		 VALUES 
		 ( 
		 	user_mail,
		 	( SELECT Team.id_team FROM Team WHERE Team.name = selected_team_name), 
		 	session_id
		 )
		 */
		
		String sql = 
				"INSERT INTO " + ParticipationTable.tableName + " ( "  + ParticipationTable.userMail + "," + ParticipationTable.teamId  + "," + ParticipationTable.sessionId + " ) " +                  
				" VALUES " +
					" ( " +  
						"'" + userMail + "'" + "," +
						" ( " + 
							" SELECT " + TeamTable.tableName + "." + TeamTable.id + 
							" FROM " + TeamTable.tableName + 
							" WHERE " + TeamTable.tableName + "." + TeamTable.name + " = " + "'" + selectedTeamName + "'" + 
						" ) " + "," +
						"'" + userSession + "'" +
					" ) ";
		
		System.out.println( "sql addUserToSpecificTeam ===> " + sql);
		
		
		ResultSet resultSet = DataBaseConnector.sharedInstance().executeSQL(sql);
		
		if ( resultSet == null ){
			System.out.println("The SQL has been executed, the result is null");
			
			return true;
		}else{
			return false;
		}
			
		
		
	}
	
	
	
	
}
