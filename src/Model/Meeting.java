package Model;

import java.sql.Timestamp;

import com.sun.xml.internal.bind.v2.model.core.ID;

public class Meeting {

	private Integer id;
	private Timestamp startDate;
	private Timestamp endDate;
	private String comment;
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

	public void setStartDate(Timestamp startDate) {
		this.startDate = startDate;
	}
	public void setEndDate(Timestamp endDate) {
		this.endDate = endDate;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}

	
}
