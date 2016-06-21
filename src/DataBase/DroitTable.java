package DataBase;

import com.sun.org.apache.xpath.internal.functions.FuncBoolean;

public class DroitTable {

	static final String tableName = "droit";
	static final String userMail = "user_email";
	static final String idDocument = "Document_idDocument";
	static final String droit = "droit";
	
	static public void addRightToDocument(String userMail,String documentId,String droit){
		
		String sqlValues = "('" +
				userMail + "','" +
				documentId + "','" +
				droit + "');";
				
				String sql = "INSERT INTO " +
						DroitTable.tableName +" (" +
						DroitTable.userMail + "," + 
						DroitTable.idDocument + "," + 
						DroitTable.droit +
				") VALUES " + sqlValues;
		
		System.out.println( " sql addRight ====> " + sql );
		
		DataBaseConnector.sharedInstance().executeSQL(sql);
		
	}
	
}
