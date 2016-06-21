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
	
	public Team(int teamId){
		this.id = teamId;
	}
	

	public String getName() {
		return name;
	}
		
	public void setName(String name) {
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void addUser( User user ){
		members.add(user);
	}
	
	public ArrayList<User> getMembers(){
		return members;
	}
	
	
	@Override
	public boolean equals(Object o) 
	{
		if (this == o)
            return true;
        if (o == null)
            return false;
        if (getClass() != o.getClass())
            return false;
        
		Team currentTeam = (Team) o;
		
		if ( this.name.equals(currentTeam.name) ){
			return true;
		}
		return false;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return id;
	} 
	
	
	


}
