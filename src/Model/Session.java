package Model;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class Session {

	private Integer Id;
	private Timestamp startDate;
	private Timestamp endDate;
	
	public Session( int id){
		this.Id = id;
	}
	
	public Integer getId() {
		return Id;
	}
	public Timestamp getStartDate() {
		return startDate;
	}
	public Timestamp getEndDate() {
		return endDate;
	}
	public void setStartDate(Timestamp startDate) {
		this.startDate = startDate;
	}
	public void setEndDate(Timestamp endDate) {
		this.endDate = endDate;
	}
	public String getStartDay() {
		return new SimpleDateFormat("dd/MM/yyyy").format(startDate);
	}
	public String getEndDay() {
		return new SimpleDateFormat("dd/MM/yyyy").format(endDate);
	}
	
}
