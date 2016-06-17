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
	
	public String getComment() {
		return comment;
	}

	public void setStartDate(Timestamp startDate) {
		this.startDate = startDate;
	}
	public void setEndDate(Timestamp endDate) {
		this.endDate = endDate;
	}
	
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	public String getMeetingTime(){
		return compareTwoTimeStamps(endDate,startDate);
	}
	
	public String getHour(){
		String hour = new SimpleDateFormat("HH").format(startDate);
		String minute = new SimpleDateFormat("mm").format(startDate);
		return hour + "h" + minute;
	}
	
	public String getDay(){
		return new SimpleDateFormat("dd/MM/yyyy").format(startDate);
	}
	
	@Override
	  public int compareTo(Meeting o) {
	    return startDate.compareTo(o.startDate);
	  }

	
	private String compareTwoTimeStamps(java.sql.Timestamp currentTime, java.sql.Timestamp oldTime)
	{
	  long milliseconds1 = oldTime.getTime();
	  long milliseconds2 = currentTime.getTime();

	  long diff = milliseconds2 - milliseconds1;
	  long diffSeconds = diff / 1000;
	  long diffMinutes = diff / (60 * 1000);
	  
	  String sec = Long.toString(diffSeconds);

	  return Long.toString(diffMinutes) + " min " + sec.substring(0, 2) + " sec " ;
	}
	
}
