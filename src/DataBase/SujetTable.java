package DataBase;

import java.sql.ResultSet;

import Model.Sujet;

public class SujetTable {

	static final String tableName = "Sujet";
	static final String id = "id_sujet";
	static final String name = "name";
	static final String description = "description";
	
	public static Sujet getSubjetById( int id ){
		
		String sql = 
				" SELECT " + SujetTable.tableName + "." + SujetTable.name + "," +
						SujetTable.tableName + "." + SujetTable.description + 
				" FROM " + SujetTable.tableName + 
				" WHERE " + SujetTable.tableName + "." + SujetTable.id + " = " + Integer.toString(id);
		
		System.out.println( " sql getSubjetById ====> " + sql );
		
		
		ResultSet resultSet = DataBaseConnector.sharedInstance().executeSQL(sql);
		
		Sujet sujet = null;
		
		if ( resultSet == null ){
			System.out.println("The SQL has been executed, the result is null");
		}else{
			try {
				
				while (resultSet.next()){
					String name = (String) resultSet.getObject(SujetTable.name);
					String description = (String) resultSet.getObject(SujetTable.description);
					
					sujet = new Sujet(id);
					sujet.setName(name);
					sujet.setDecription(description);
					
				}
			}
			catch (Exception e){
				System.out.println("Exeption during query :" + e);
			}
		}
		
		if ( sujet == null ){
			System.out.println( "error occured with getSubjectId ");
			return null;
		}
				
		return sujet;
	}
	
}
