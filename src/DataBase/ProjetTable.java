package DataBase;

import java.sql.ResultSet;

import Model.Sujet;

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
	
	
}
