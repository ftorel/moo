package DataBase;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserTable {

	static final public String tableName = "User";
	static final public String prenom = "firstname";
	static final public String nom = "lastname";
	static final public String mail = "email";
	static final public String type = "type";
	
	static public void addUser(String prenom , String nom, String mail, Integer type ){
		
		String sqlValues = "('" + 
				nom + "','" 
				+ prenom+ "'," 
				+ type + ",'" + 
				mail + "');";
				
				String sql = "INSERT INTO " +
				UserTable.tableName +" ("+ 
				UserTable.prenom + "," + 
				UserTable.nom + "," + 
				UserTable.type + "," + 
				UserTable.mail +
				") VALUES " + sqlValues;
				
				System.out.println(sql);
				
				/*ResultSet resultSet = */DataBaseConnector.sharedInstance().executeSQL(sql);
	}
	
	static public void getAllUser(){
		
		String sql = "SELECT " +
				"*" + 
				" FROM " + 
				UserTable.tableName + 
				 "';";
		
		System.out.println(sql);
		ResultSet resultSet = DataBaseConnector.sharedInstance().executeSQL(sql);
		
		if ( resultSet  == null ){
			
		} else {
			
		}
		
	}
	
	static public String UserExistWithMail(String userMail){
		
		String sql = "SELECT " +
		UserTable.mail + 
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
					return resultSet.getString(1);
					}else{
						System.out.println("Any user with this mail.");
						return "";
					}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("An error occured !");
				e.printStackTrace();
			}
			return "";
		} 
		return "";
	}
}
