package Model;

import java.net.URL;

public class Document {

	private String id;
	private String userId;
	private String name;
	private String url;
	
	public Document(String id, String userId, String name, String url) {
		super();
		this.id = id;
		this.userId = userId;
		this.name = name;
		this.url = url;
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
	
	
}
