package DataBase;

import java.sql.ResultSet;
import java.util.ArrayList;

import Model.Feature;
import Model.Sujet;
import Model.Tag;

public class SujetFeatureTagTable {

	static final public String tableName = "sujetfeaturetag";
	static final public String idFeature = "id_Feature";
	static final public String idTag = "id_Tag";
	static final public String idSubject = "id_Subject";
	
	
	public static  ArrayList<Model.Feature> getAllFeatureTagged(){
		
		/*
		 SELECT Feature.name, Tag.name 
		 FROM sujetfeaturetag 
		 JOIN Feature 
		 	ON sujetfeaturetag.id_Feature = Feature.idFeature 
		 JOIN Tag 
		 	ON sujetfeaturetag.id_Tag = Tag.idTag 
		 */
		
		ArrayList<Model.Feature> list = new ArrayList<Model.Feature>();
		
		
		String sql = 
				"SELECT " + FeatureTable.tableName + "." + FeatureTable.id + " , " +
							FeatureTable.tableName + "." + FeatureTable.name + " , " +
							FeatureTable.tableName + "." + FeatureTable.description + " , " +
							TagTable.tableName + "." + TagTable.id + " , " + 
							TagTable.tableName + "." + TagTable.name + " , " + 
							TagTable.tableName + "." + TagTable.tagCol +
				" FROM " + SujetFeatureTagTable.tableName + 
					" JOIN " + FeatureTable.tableName +
						" ON " + SujetFeatureTagTable.tableName +"."+ SujetFeatureTagTable.idFeature + " = " +  FeatureTable.tableName + "." + FeatureTable.id  +
					" JOIN " + TagTable.tableName +
						" ON " + SujetFeatureTagTable.tableName +"."+ SujetFeatureTagTable.idTag + " = " +  TagTable.tableName + "." + TagTable.id  ;
				
		System.out.println( " sql getAllFeatureTagged ====>  " + sql);
		
		ResultSet resultSet = DataBaseConnector.sharedInstance().executeSQL(sql);
		
		if ( resultSet == null ){
			System.out.println("The SQL has been executed, the result is null");
		}else{
			try {
				while (resultSet.next()){
					
					int featureId = (Integer) resultSet.getObject(FeatureTable.id);
					String featureName = (String) resultSet.getObject(FeatureTable.name);
					String featureDescription = (String) resultSet.getObject(FeatureTable.description);
					
					Feature feature = new Feature(featureId);
					feature.setDescription(featureDescription);
					feature.setName(featureName);
					
					int tagId = (Integer) resultSet.getObject(TagTable.id);
					String tagName = (String) resultSet.getObject(TagTable.name);
					String tagCol = (String) resultSet.getObject(TagTable.tagCol);
					
					Tag tag = new Tag(tagId);
					tag.setName(tagName);
					tag.setTagCol(tagCol);
					
					feature.setTag(tag);
					
					list.add(feature);
					
				}
			}
			catch (Exception e){
				System.out.println("Exeption during query :" + e);
			}
		}
		
		return list;
	}
	
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
		
		
		for ( Sujet sujet : sujetList ){
			
			System.out.println( " params ==>  \n sujetId : " + Integer.toString(sujet.getId()) );
			
			String sql = 
					"SELECT " + FeatureTable.tableName + "." + FeatureTable.id + " , " +
								FeatureTable.tableName + "." + FeatureTable.name + " , " +
								FeatureTable.tableName + "." + FeatureTable.description + " , " +
								TagTable.tableName + "." + TagTable.id + " , " + 
								TagTable.tableName + "." + TagTable.name + " , " + 
								TagTable.tableName + "." + TagTable.tagCol +
					" FROM " + SujetFeatureTagTable.tableName + 
						" JOIN " + FeatureTable.tableName +
							" ON " + SujetFeatureTagTable.tableName +"."+ SujetFeatureTagTable.idFeature + " = " +  FeatureTable.tableName + "." + FeatureTable.id  +
						" JOIN " + TagTable.tableName +
							" ON " + SujetFeatureTagTable.tableName +"."+ SujetFeatureTagTable.idTag + " = " +  TagTable.tableName + "." + TagTable.id  +
					" WHERE " + SujetFeatureTagTable.tableName + "." + SujetFeatureTagTable.idSubject + " = " + Integer.toString(sujet.getId()) 
						;
			
			System.out.println( " sql assignTeamToSubject ====>  " + sql);
			
			ResultSet resultSet = DataBaseConnector.sharedInstance().executeSQL(sql);
			
			if ( resultSet == null ){
				System.out.println("The SQL has been executed, the result is null");
			}else{
				try {
					while (resultSet.next()){
						
						int featureId = (Integer) resultSet.getObject(FeatureTable.id);
						String featureName = (String) resultSet.getObject(FeatureTable.name);
						String featureDescription = (String) resultSet.getObject(FeatureTable.description);
						
						Feature feature = new Feature(featureId);
						feature.setDescription(featureDescription);
						feature.setName(featureName);
						
						int tagId = (Integer) resultSet.getObject(TagTable.id);
						String tagName = (String) resultSet.getObject(TagTable.name);
						String tagCol = (String) resultSet.getObject(TagTable.tagCol);
						
						Tag tag = new Tag(tagId);
						tag.setName(tagName);
						tag.setTagCol(tagCol);
						
						feature.setTag(tag);
						
						sujet.addFeature(feature);
						
					}
				}
				catch (Exception e){
					System.out.println("Exeption during query :" + e);
				}
			}
			
			
		}
		
		
		return sujetList;
		
	}
	
}
