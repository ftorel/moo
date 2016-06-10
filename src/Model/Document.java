package Model;

import java.net.URL;
import java.sql.Date;

public class Document {

	private String id;
	private String userId;
	private String name;
	private String url;
	private Date creationDate;
	
	public Document(String id, String userId, String name, String url, Date creationDate) {
		super();
		this.id = id;
		this.userId = userId;
		this.name = name;
		this.url = url;
		this.creationDate = creationDate;
	}

	public String getId() {
		return id;
	}

	public String getUserId() {
		return userId;
	}

	public String getName() {
		return name;
	}

	public String getUrl() {
		return url;
	}
	
	public Date getCreationDate(){
		return this.creationDate;
	}
	
}
