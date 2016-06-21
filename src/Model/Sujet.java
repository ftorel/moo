package Model;

import java.util.ArrayList;

public class Sujet {

	private Integer id;
	private String name;
	private String decription;
	
	private ArrayList<Model.Team> teamList = new ArrayList<Model.Team>();
	
	private ArrayList<Model.Feature> featureList = new ArrayList<Model.Feature>();
	
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
	
	public void addFeature(Feature feature){
		featureList.add(feature);
	}
	
	public ArrayList<Model.Feature> getAllFeature(){
		if ( featureList.isEmpty() ){
			System.out.println(" no feature assigned to this subject " + this.name);
		}
		return featureList;
	}
	
	public void addTeam( Team team){
		teamList.add(team);
	}
	
	public ArrayList<Model.Team> getAllTeam(){
		if ( teamList.isEmpty() ){
			System.out.println(" no team assigned to this subject " + this.name);
		}
		return teamList;
	}
	
}
