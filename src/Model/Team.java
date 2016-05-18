package Model;

import java.util.ArrayList;

public class Team {
	
	private String name;
	private ArrayList<User> members;
	
	public Team( String name){
		
		members = new ArrayList<User>();
			
		User userFlo = new User();
		userFlo.setNom("Florian");
		members.add( userFlo);
		
		User userPierre = new User();
		userPierre.setNom("Perrin");
		members.add( userPierre);
		
		this.name = name;
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<User> getMembers() {
		return members;
	}

	public void setMembers(ArrayList<User> members) {
		this.members = members;
	}


}
