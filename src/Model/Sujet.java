package Model;

public class Sujet {

	private Integer id;
	private String name;
	private String decription;
	
	public Sujet ( int id ){
		this.id = id;
	}
	
	
	public Integer getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getDecription() {
		return decription;
	}

	public void setName(String name) {
		this.name = name;
	}
	public void setDecription(String decription) {
		this.decription = decription;
	}
}
