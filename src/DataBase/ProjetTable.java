package DataBase;

import java.sql.ResultSet;
import java.util.ArrayList;

import Model.Sujet;
import Model.Team;

public class ProjetTable {


	static final public String tableName = "projet";
	static final public String subjectId = "subject_id_subject" ;
	static final public String teamId = "team_id_team";
	static final public String sessionId = "session_id_session";
	
	
	public static Sujet getSubjectByUserMail( int sessionId, int teamId ){

		
		// SELECT projet.subject_id_subject FROM projet WHERE projet.session_id_session = 1 AND projet.team_id_team = 1
		
		String sql = 
				" SELECT " + ProjetTable.tableName + "." + ProjetTable.subjectId + 
				" FROM " + ProjetTable.tableName + 
				" WHERE " + ProjetTable.tableName + "." + ProjetTable.sessionId + " = " + Integer.toString(sessionId) +
					" AND " + ProjetTable.tableName + "." + ProjetTable.teamId + " = " + Integer.toString(teamId)
					;
		
		System.out.println(" sql getSubjectByUserMail ====> " + sql );
		
		ResultSet resultSet = DataBaseConnector.sharedInstance().executeSQL(sql);
		
		int sujetId = -1;
		
		if ( resultSet == null ){
			System.out.println("The SQL has been executed, the result is null");
		}else{
			try {
				
				while (resultSet.next()){
					sujetId = (Integer) resultSet.getObject(ProjetTable.subjectId);	
				}
			}
			catch (Exception e){
				System.out.println("Exeption during query :" + e);
			}
		}
		
		
		
		if ( sujetId == -1 ){
			System.out.println( "error occured with getSubjectByUserMail ");
			return null;
		}
		
		Sujet sujet = SujetTable.getSubjetById(sujetId);
		
		return sujet;
		
	
	}
	
	public static ArrayList<Model.Sujet> assignTeamToSubject( ArrayList<Model.Sujet> sujetList, int session ){
		
		/*
		 SELECT Team.id_team, Team.name 
		 FROM projet 
		 JOIN Team 
		 	ON Team.id_team = projet.team_id_team 
		 WHERE projet.subject_id_subject = 1 AND projet.session_id_session = 1
		 */
		
		if ( sujetList.isEmpty() ){
			return null;
		}
		
		for ( Sujet sujet : sujetList ){
						
			if ( sujet.getId() == null ){
				System.out.println( " sujet id is null ");
				return null;
			}
			
			System.out.println( " params ==>  \n sujetId : " + Integer.toString(sujet.getId()) + " \n " + "session : " + Integer.toString(session) );
			
			String sql = 
					"SELECT " + TeamTable.tableName + "." + TeamTable.name + " , " +
								TeamTable.tableName + "." + TeamTable.id +
					" FROM " + ProjetTable.tableName + 
						" JOIN " + TeamTable.tableName +
							" ON " + TeamTable.tableName +"."+ TeamTable.id + " = " +  ProjetTable.tableName + "." + ProjetTable.teamId  +
					" WHERE " + ProjetTable.tableName + "." + ProjetTable.subjectId + " = " + Integer.toString(sujet.getId()) + 
						" AND " + ProjetTable.tableName + "." + ProjetTable.sessionId + " = " + Integer.toString(session)
						;
			
			System.out.println( " sql assignTeamToSubject ====>  " + sql);
			
			ResultSet resultSet = DataBaseConnector.sharedInstance().executeSQL(sql);
			
			if ( resultSet == null ){
				System.out.println("The SQL has been executed, the result is null");
			}else{
				try {
					while (resultSet.next()){
						int teamId = (Integer) resultSet.getObject(TeamTable.id);
						String name = (String) resultSet.getObject(TeamTable.name);
						
						Team team = new Team(teamId);
						team.setName(name);
						
						sujet.addTeam(team);
						
					}
				}
				catch (Exception e){
					System.out.println("Exeption during query :" + e);
				}
			}
			
		}
		
		
		return sujetList;
	}
	
	
}
