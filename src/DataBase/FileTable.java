package DataBase;

import java.sql.ResultSet;
import java.util.ArrayList;


//import java.sql.ResultSet;

public class FileTable {

	static final public String tableName = "Document";
	
	static final public String id = "idDocument";
	static final public String nom = "name";
	static final public String url = "path";
	
	
static public void addFile(String name , String url, String userId){
		
		String sqlValues = "(0,'" +
				name + "','" +
				url + "');";
				
				String sql = "INSERT INTO " +
						FileTable.tableName +" (" +
						FileTable.id + "," + 
						FileTable.nom + "," + 
						FileTable.url +
				") VALUES " + sqlValues;
				
				
				/*String sqlValues2 = "(0,'" +
						name + "','" +
						url + "');";
						
						String sql2 = "INSERT INTO " +
								"Droit" +" (" +
								FileTable.id + "," + 
								FileTable.nom + "," + 
								FileTable.url +
						") VALUES " + sqlValues2;
				
				System.out.println(sql);*/
				
				/*ResultSet resultSet = */DataBaseConnector.sharedInstance().executeSQL(sql);
	}

static public void removeFile(String docUrl){
	
	String sql = "DELETE " + 
			"FROM " + 
			FileTable.tableName + 
			" WHERE " + 
			FileTable.url + 
			" = '" + docUrl + "';";
			System.out.println(sql);
			
			/*ResultSet resultSet = */DataBaseConnector.sharedInstance().executeSQL(sql);
}
	
//TODO: Only for testing
static public ArrayList<Model.Document> FilesForUserId(){
	
	String sql = "SELECT * " + 
	"FROM " + 
	FileTable.tableName + ";";
	
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
				
				Model.Document tempDoc = new Model.Document(id, "5", name, url);
				
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
