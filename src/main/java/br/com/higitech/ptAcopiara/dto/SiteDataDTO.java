package br.com.higitech.ptAcopiara.dto;

import java.util.List;

import br.com.higitech.ptAcopiara.model.Agenda;
import br.com.higitech.ptAcopiara.model.Historico;
import br.com.higitech.ptAcopiara.model.Projeto;
import lombok.Data;

@Data
public class SiteDataDTO {
    // Campos soltos para mapear no Config
    private String heroTitle;
    private String heroSubtitle;
    private String heroImage;
    
    // Objetos aninhados (para facilitar o mapeamento do JSON que já temos no front)
    private NextActDTO nextAct;
    private AboutDTO about;
    private ProjectBannerDTO projectBanner;
    private String newsTitle;

    // Listas
    private List<Agenda> agenda;
    private List<Projeto> projects;
    private List<Historico> history;

    // DTOs internos auxiliares para bater com o JSON do front
    @Data public static class NextActDTO {
        private String title;
        private String date;
        private String loc;
        private String pauta;
    }
    @Data public static class AboutDTO {
        private String title;
        private String text;
    }
    @Data public static class ProjectBannerDTO {
        private String title;
        private String desc;
        private String bg;
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
	public NextActDTO getNextAct() {
		return nextAct;
	}
	public AboutDTO getAbout() {
		return about;
	}
	public ProjectBannerDTO getProjectBanner() {
		return projectBanner;
	}
	public String getNewsTitle() {
		return newsTitle;
	}
	public List<Agenda> getAgenda() {
		return agenda;
	}
	public List<Projeto> getProjects() {
		return projects;
	}
	public List<Historico> getHistory() {
		return history;
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
	public void setNextAct(NextActDTO nextAct) {
		this.nextAct = nextAct;
	}
	public void setAbout(AboutDTO about) {
		this.about = about;
	}
	public void setProjectBanner(ProjectBannerDTO projectBanner) {
		this.projectBanner = projectBanner;
	}
	public void setNewsTitle(String newsTitle) {
		this.newsTitle = newsTitle;
	}
	public void setAgenda(List<Agenda> agenda) {
		this.agenda = agenda;
	}
	public void setProjects(List<Projeto> projects) {
		this.projects = projects;
	}
	public void setHistory(List<Historico> history) {
		this.history = history;
	}
    
    
}