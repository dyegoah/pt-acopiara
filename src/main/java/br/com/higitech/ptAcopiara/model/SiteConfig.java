package br.com.higitech.ptAcopiara.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "site_config")
public class SiteConfig {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Hero
    private String heroTitle;
    @Column(columnDefinition="TEXT")
    private String heroSubtitle;
    private String heroImage;

    // Next Activity
    private String nextActTitle;
    private String nextActDate;
    private String nextActLoc;
    @Column(columnDefinition="TEXT")
    private String nextActPauta;

    // About
    private String aboutTitle;
    @Column(columnDefinition="TEXT")
    private String aboutText;

    // Project Banner
    private String projectBannerTitle;
    @Column(columnDefinition="TEXT")
    private String projectBannerDesc;
    private String projectBannerBg;

    // News
    private String newsTitle;

	public Long getId() {
		return id;
	}

	public String getHeroTitle() {
		return heroTitle;
	}

	public String getHeroSubtitle() {
		return heroSubtitle;
	}

	public String getHeroImage() {
		return heroImage;
	}

	public String getNextActTitle() {
		return nextActTitle;
	}

	public String getNextActDate() {
		return nextActDate;
	}

	public String getNextActLoc() {
		return nextActLoc;
	}

	public String getNextActPauta() {
		return nextActPauta;
	}

	public String getAboutTitle() {
		return aboutTitle;
	}

	public String getAboutText() {
		return aboutText;
	}

	public String getProjectBannerTitle() {
		return projectBannerTitle;
	}

	public String getProjectBannerDesc() {
		return projectBannerDesc;
	}

	public String getProjectBannerBg() {
		return projectBannerBg;
	}

	public String getNewsTitle() {
		return newsTitle;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setHeroTitle(String heroTitle) {
		this.heroTitle = heroTitle;
	}

	public void setHeroSubtitle(String heroSubtitle) {
		this.heroSubtitle = heroSubtitle;
	}

	public void setHeroImage(String heroImage) {
		this.heroImage = heroImage;
	}

	public void setNextActTitle(String nextActTitle) {
		this.nextActTitle = nextActTitle;
	}

	public void setNextActDate(String nextActDate) {
		this.nextActDate = nextActDate;
	}

	public void setNextActLoc(String nextActLoc) {
		this.nextActLoc = nextActLoc;
	}

	public void setNextActPauta(String nextActPauta) {
		this.nextActPauta = nextActPauta;
	}

	public void setAboutTitle(String aboutTitle) {
		this.aboutTitle = aboutTitle;
	}

	public void setAboutText(String aboutText) {
		this.aboutText = aboutText;
	}

	public void setProjectBannerTitle(String projectBannerTitle) {
		this.projectBannerTitle = projectBannerTitle;
	}

	public void setProjectBannerDesc(String projectBannerDesc) {
		this.projectBannerDesc = projectBannerDesc;
	}

	public void setProjectBannerBg(String projectBannerBg) {
		this.projectBannerBg = projectBannerBg;
	}

	public void setNewsTitle(String newsTitle) {
		this.newsTitle = newsTitle;
	}
    
    
    
}