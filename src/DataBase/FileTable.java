package DataBase;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;
import com.sun.xml.internal.txw2.Document;

//import java.sql.ResultSet;

public class FileTable {

	static final public String tableName = "Documents";
	
	static final public String id = "D_ID";
	static final public String userID = "U_ID";
	static final public String nom = "Name";
	static final public String url = "URL";
	
	
static public void addFile(String name , String url, String userId){
		
		String sqlValues = "(0,'" +
				name + "','" +
				url + "','" + 
				userId + "');";
				
				String sql = "INSERT INTO " +
						FileTable.tableName +" (" +
						FileTable.id + "," + 
						FileTable.nom + "," + 
						FileTable.url + "," +
						FileTable.userID +
				") VALUES " + sqlValues;
				
				System.out.println(sql);
				
				/*ResultSet resultSet = */DataBaseConnector.sharedInstance().executeSQL(sql);
	}

static public void removeFile(String docId){
	
	String sql = "DELETE " + 
			"FROM " + 
			FileTable.tableName + 
			" WHERE " + 
			FileTable.id + 
			" = '" + docId + "';";
			System.out.println(sql);
			
			/*ResultSet resultSet = */DataBaseConnector.sharedInstance().executeSQL(sql);
}
	
static public ArrayList<Model.Document> FilesForUserId(String userId){
	
	String sql = "SELECT * " + 
	"FROM " + 
	FileTable.tableName + 
	" WHERE " + 
	FileTable.userID + 
	" = '" + userId + "';";
	
	System.out.println(sql);
	ResultSet resultSet = DataBaseConnector.sharedInstance().executeSQL(sql);
	if ( resultSet == null ){
		System.out.println("The SQL has been executed, the result is null");
	}else{
		try {

			ArrayList<Model.Document> documentList = new ArrayList<Model.Document>();
			
			while (resultSet.next()){
			
				String url = (String) resultSet.getObject(FileTable.url);
				String name = (String) resultSet.getObject(FileTable.nom);
				String id =  resultSet.getObject(FileTable.id).toString();
				
				Model.Document tempDoc = new Model.Document(id, userId, name, url);
				
				documentList.add(tempDoc);
			}
			return documentList;
		}
		catch (Exception e){
			System.out.println("Exeption during query :" + e);
		}
	}
	
	return null;
}


}
