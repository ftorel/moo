package DataBase;

import java.io.File;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.media.jai.Histogram;

import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.TypeHost;

import Model.Team;
import sun.security.action.GetBooleanAction;


//import java.sql.ResultSet;

public class FileTable {
 
	static final public String tableName = "Document";
	
	static final public String id = "idDocument";
	static final public String nom = "name";
	static final public String url = "path";
	static final public String creationDate = "creationDate";
	static final public String uploaderName = "uploaderName";
	
	
static public Boolean addFile(String name , String url, String userMail, Integer teamId){
	
	String uploaderName = UserTable.UserNameWithMail(userMail);
	
	if (uploaderName == null){
		return false;
	}
	
	java.sql.Date date = new java.sql.Date(System.currentTimeMillis());
		String sqlValues = "('" +
				name + "','" +
				url + "','" +
				uploaderName + "','" +
				date + "');";
				
				String sql = "INSERT INTO " +
						FileTable.tableName +" (" +
						FileTable.nom + "," + 
						FileTable.url + "," + 
						FileTable.uploaderName + "," +
						FileTable.creationDate +
				") VALUES " + sqlValues;
				
				DataBaseConnector.sharedInstance().executeSQL(sql);

				String currentDocID = FileTable.getDocumentForDate(url);
				
				ArrayList<String> members = TeamTable.getMembersMail(teamId);
				
				if (currentDocID == null || members.size() == 0){
					FileTable.removeFile(url);
					return false;
				}
				
				for (String memberMail : members) {
					
					String droit = "10";
					if(memberMail.equals(userMail)){
						droit = "11";
					}
					
					DroitTable.addRightToDocument(memberMail, currentDocID, droit);
				}
				return true;
	}

static public void removeFile(String docUrl){
	
	
	String documentID = getDocumentForDate(docUrl);
	
	String sql2 = "DELETE " + 
			"FROM " + 
			DroitTable.tableName + 
			" WHERE " + 
			DroitTable.idDocument + 
			" = '" + documentID + "';";
	System.out.println("Delete righths " + sql2);

	
	String sql = "DELETE " + 
			"FROM " + 
			FileTable.tableName + 
			" WHERE " + 
			FileTable.url + 
			" = '" + docUrl + "';";
	System.out.println("Delete doc " + sql);

			DataBaseConnector.sharedInstance().executeSQL(sql2);
			DataBaseConnector.sharedInstance().executeSQL(sql);
}
	
static public String getDocumentForDate (String  url){
	
	String sql = "SELECT *" + 
			" FROM " + 
			FileTable.tableName + " WHERE " + FileTable.url + " = '" + url + "';";
	
	System.out.println("getDocumentForDate sql ====>" + sql);
	
	ResultSet resultSet = DataBaseConnector.sharedInstance().executeSQL(sql);
	
	if ( resultSet == null ){
		System.out.println("The SQL has been executed, the result is null");
	}else{
		try {
			
			System.out.println(" getDocumentForDate id"+ id);
			while (resultSet.next()){
				String id =  resultSet.getObject(FileTable.id).toString();
				System.out.println(" getDocumentForDate id"+ resultSet.getObject(FileTable.id));
				return id;
			}
		}
		catch (Exception e){
			System.out.println("Exeption during query :" + e);
			return  null;
		}
	}
	return  null;
}


static public ArrayList<Model.Document> FilesForUserId(String userMail){
	
	
	
	String sql = 
			"SELECT " + FileTable.tableName + "." + FileTable.url + " , " +
					FileTable.tableName + "." + FileTable.uploaderName + " , " +
					FileTable.tableName + "." + FileTable.id + " , " +
					FileTable.tableName + "." + FileTable.url + " , " +
					FileTable.tableName + "." + FileTable.nom + " , " +
					FileTable.tableName + "." + FileTable.creationDate +
			" FROM " + DroitTable.tableName + 
				" JOIN " + FileTable.tableName +
					" ON " + FileTable.tableName +"."+ FileTable.id + " = " +  DroitTable.tableName + "." + DroitTable.idDocument  + 
					" WHERE " + DroitTable.tableName +"."+ DroitTable.userMail + " = '" + userMail +
					"' ;";
	
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
				String uploaderName =  resultSet.getObject(FileTable.uploaderName).toString();
				Date creationDate = resultSet.getDate(FileTable.creationDate);
				
				Model.Document tempDoc = new Model.Document(id, userMail, name, url,creationDate,uploaderName);
				
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
