package Model;

import java.sql.Date;

public class Document {

	private String id;
	private String userId;
	private String name;
	private String url;
	private Date creationDate;
	private String uploaderName;
	
	public String droit;
	
	public Document(String id, String userMail, String name, String url, Date creationDate,String uploaderName) {
		super();
		this.id = id;
		this.userId = userMail;
		this.name = name;
		this.url = url;
		this.creationDate = creationDate;
		this.uploaderName = uploaderName;
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
	
	public String getUploaderName(){
		return this.uploaderName;
	}
}
