package DataBase;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ParticipationTable {

	static final public String tableName = "Participation";
	static final public String id = "id_participation";
	static final public String userMail = "user_email";
	static final public String teamId = "team_id_team";
	static final public String sessionId = "Session_id_session";
	
	
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
				
				System.out.println( " isUserAlreadyExists : " + String.valueOf(resultSet.next()) );
				
				return resultSet.next();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return false;
	}
}
