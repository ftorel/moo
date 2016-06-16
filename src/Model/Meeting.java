package Model;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Meeting implements Comparable<Meeting> {

	private Integer id;
	private Timestamp startDate;
	private Timestamp endDate;
	private String comment;
	
	private String format = "yyyy-MM-dd hh:mm:ss";
	
	public Meeting(Integer id) {
		super();
		this.id = id;
	}
	
	public Integer getId() {
		return id;
	}
	public Timestamp getStartDate() {
		return startDate;
	}
	public Timestamp getEndDate() {
		return endDate;
	}
	public String getComment() {
		return comment;
	}

	public void setStartDate(String startDate) {
		try{
		    SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		    Date parsedDate = dateFormat.parse(startDate);
		    Timestamp timestamp = new java.sql.Timestamp(parsedDate.getTime());
		    this.startDate = timestamp;
		}catch(Exception e){
			e.printStackTrace(); 
		}
		
	}
	public void setEndDate(String endDate) {
		try{
		    SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		    Date parsedDate = dateFormat.parse(endDate);
		    Timestamp timestamp = new java.sql.Timestamp(parsedDate.getTime());
		    this.startDate = timestamp;
		}catch(Exception e){
			e.printStackTrace(); 
		}
	}
	
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	@Override
	  public int compareTo(Meeting o) {
	    return getStartDate().compareTo(o.getStartDate());
	  }

	
}
