package br.com.higitech.ptAcopiara.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Historico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String type; // majoritaria, vereador...
    private String yearElection;
    private String votes;
    private String photoUrl;
    @Column(columnDefinition="TEXT")
    private String details;
	public Long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getType() {
		return type;
	}
	public String getYearElection() {
		return yearElection;
	}
	public String getVotes() {
		return votes;
	}
	public String getPhotoUrl() {
		return photoUrl;
	}
	public String getDetails() {
		return details;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setType(String type) {
		this.type = type;
	}
	public void setYearElection(String yearElection) {
		this.yearElection = yearElection;
	}
	public void setVotes(String votes) {
		this.votes = votes;
	}
	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}
	public void setDetails(String details) {
		this.details = details;
	}
    
        
}