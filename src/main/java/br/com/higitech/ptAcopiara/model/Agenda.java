package br.com.higitech.ptAcopiara.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Agenda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String dateText;
    private String title;
    private String location;
    private String description;
	public Long getId() {
		return id;
	}
	public String getDateText() {
		return dateText;
	}
	public String getTitle() {
		return title;
	}
	public String getLocation() {
		return location;
	}
	public String getDescription() {
		return description;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setDateText(String dateText) {
		this.dateText = dateText;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public void setDescription(String description) {
		this.description = description;
	}
      
}