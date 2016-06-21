package DataBase;

import java.util.ArrayList;

public class SujetFeatureTagTable {

	static final public String tableName = "sujetfeaturetag";
	static final public String idFeature = "id_Feature";
	static final public String idTag = "id_Tag";
	static final public String idSubject = "id_Subject";
	
	public static ArrayList<Model.Sujet> assignFeatureToSubject( ArrayList<Model.Sujet> sujetList ){
		
		/*
		 SELECT Feature.name, Tag.name 
		 FROM sujetfeaturetag 
		 JOIN Feature 
		 	ON sujetfeaturetag.id_Feature = Feature.idFeature 
		 JOIN Tag 
		 	ON sujetfeaturetag.id_Tag = Tag.idTag 
		 WHERE sujetfeaturetag.id_Subject = 1
		 */
		
		
		for ( int i = 0 ; i < sujetList.size() ; i ++ ){
			
		}
		
		
		return null;
		
	}
	
}
