package Model;

public class Tag {

	private Integer id;
	private String name;
	private String tagCol;
	
	public Tag ( int id){
		this.id = id;
	}
	
	public Integer getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getTagCol() {
		return tagCol;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setTagCol(String tagCol) {
		this.tagCol = tagCol;
	}
}
