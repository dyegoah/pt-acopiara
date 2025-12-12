package br.com.higitech.ptAcopiara.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Projeto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String valueText;
    private String status;
    private String icon;
    private String label;
    @Column(columnDefinition="TEXT")
    private String description;
	public Long getId() {
		return id;
	}
	public String getTitle() {
		return title;
	}
	public String getValueText() {
		return valueText;
	}
	public String getStatus() {
		return status;
	}
	public String getIcon() {
		return icon;
	}
	public String getLabel() {
		return label;
	}
	public String getDescription() {
		return description;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setValueText(String valueText) {
		this.valueText = valueText;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public void setDescription(String description) {
		this.description = description;
	}
    
    
}