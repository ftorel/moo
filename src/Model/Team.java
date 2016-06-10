package Model;

import java.util.ArrayList;

public class Team {
	
	private Integer id;
	
	private String name;
	
	private ArrayList<User> members = new ArrayList<User>();
	
	public Team(int teamId ,String name){
		this.name = name;
		this.id = teamId;
	}
	
	public Team(String name ){
		this.name = name;
	}

	public String getName() {
		return name;
	}

	
	public Integer getId() {
		return id;
	}

	public void addUser( User user ){
		members.add(user);
	}
	
	@Override
	public boolean equals(Object o) 
	{
		if ( o instanceof Team ){
			return false;
		}	
		Team currentTeam = (Team) o;
		
		if ( this.name.equals(currentTeam.name) ){
			return true;
		}
		return false;
	} 


}
