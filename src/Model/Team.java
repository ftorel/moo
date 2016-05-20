package Model;

public class Team {
	
	private Integer id;
	private String name;
	//private ArrayList<User> members;
	
	public Team(Integer id ,String name){
		
	/*	members = new ArrayList<User>();
			
		User userFlo = new User();
		userFlo.setNom("Florian");
		members.add( userFlo);
		
		User userPierre = new User();
		userPierre.setNom("Perrin");
		members.add( userPierre);*/
		
		this.name = name;
		this.id = id;
	}

	public String getName() {
		return name;
	}

	/*public void setName(String name) {
		this.name = name;
	}*/
	
	public Integer getId() {
		return id;
	}

	/*public Integer setId(Integer is) {
		this.name = name;
	}*/

	/*public ArrayList<User> getMembers() {
		return members;
	}

	public void setMembers(ArrayList<User> members) {
		this.members = members;
	}*/


}
