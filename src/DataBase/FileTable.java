package DataBase;

import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;


//import java.sql.ResultSet;

public class FileTable {

	static final public String tableName = "Document";
	
	static final public String id = "idDocument";
	static final public String nom = "name";
	static final public String url = "path";
	static final public String creationDate = "creationDate";
	
	
static public void addFile(String name , String url, String userId){
	
	System.out.println( " penis 1"  );
	
	java.sql.Date date = new java.sql.Date(System.currentTimeMillis());
	
	System.out.println( " penis 2 "  );
	
		String sqlValues = "('" +
				name + "','" +
				url + "','" +
				date + "');";
				
				String sql = "INSERT INTO " +
						FileTable.tableName +" (" +
						FileTable.nom + "," + 
						FileTable.url + "," + 
						FileTable.creationDate +
				") VALUES " + sqlValues;
				
				System.out.println( " sql addFile ====> " + sql );
				
				DataBaseConnector.sharedInstance().executeSQL(sql);
	}

static public void removeFile(String docUrl){
	
	String sql = "DELETE " + 
			"FROM " + 
			FileTable.tableName + 
			" WHERE " + 
			FileTable.url + 
			" = '" + docUrl + "';";
			System.out.println(sql);

			DataBaseConnector.sharedInstance().executeSQL(sql);
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
				Date creationDate = resultSet.getDate(FileTable.creationDate);
				
				Model.Document tempDoc = new Model.Document(id, "5", name, url,creationDate);
				
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
