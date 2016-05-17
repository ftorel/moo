package DataBase;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserTable {

	static final public String tableName = "User";
	
	static final public String id = "U_ID";
	static final public String prenom = "Prenom";
	static final public String nom = "Nom";
	static final public String mail = "Mail";
	static final public String type = "Type";
	
	static public void addUser(String prenom , String nom, String mail, Integer type ){
		
		String sqlValues = "(0,'" + 
				nom + "','" 
				+ prenom+ "'," 
				+ type + ",'" + 
				mail + "');";
				
				String sql = "INSERT INTO " +
				UserTable.tableName +" (" +
				UserTable.id + "," + 
				UserTable.prenom + "," + 
				UserTable.nom + "," + 
				UserTable.type +
				") VALUES " + sqlValues;
				
				System.out.println(sql);
				
				/*ResultSet resultSet = */DataBaseConnector.sharedInstance().executeSQL(sql);
	}
	
	static public Integer UserIdWithMail(String userMail){
		
		String sql = "SELECT " +
		UserTable.id + 
		" FROM " + 
		UserTable.tableName + 
		" WHERE " + 
		UserTable.mail + 
		" = '" + userMail + "';";
		
		System.out.println(sql);
		ResultSet resultSet = DataBaseConnector.sharedInstance().executeSQL(sql);
		if ( resultSet == null ){
			System.out.println("The SQL has been executed, the result is null");
		}else{
			try {
				if(resultSet.next()){
					System.out.println("The result of the query is :" + resultSet.getObject(1));
					return resultSet.getInt(1);
					}else{
						System.out.println("Any user with this mail.");
						return -1;
					}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("An error occured !");
				e.printStackTrace();
			}
			return -1;
		} 
		return -1;
	}
}
