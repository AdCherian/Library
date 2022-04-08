package ksi.springbooks.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Category {
	public Category() {
		super();
	}
	@Id
	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long idc;
	private String description;
	
	
	public long getIdc() {
		return this.idc;
	}
	public void setIdc(long idc) {
		this.idc = idc;
	}
	public String getDescription() {
		return this.description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
