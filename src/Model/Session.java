package Model;

import java.sql.Timestamp;

public class Session {

	private Integer Id;
	private Timestamp startDate;
	private Timestamp endDate;
	
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
	
	
}
