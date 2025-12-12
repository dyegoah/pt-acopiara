package br.com.higitech.ptAcopiara.dto;

import java.util.List;

import br.com.higitech.ptAcopiara.model.Projeto;

public class ProjetosSecaoDTO {

    // Banner "O BRASIL DO PT ACONTECE AQUI"
    private String bannerTitle;
    private String bannerDesc;
    private String bannerBg;

    // Lista de obras/projetos
    private List<Projeto> projetos;

    public String getBannerTitle() {
        return bannerTitle;
    }

    public void setBannerTitle(String bannerTitle) {
        this.bannerTitle = bannerTitle;
    }

    public String getBannerDesc() {
        return bannerDesc;
    }

    public void setBannerDesc(String bannerDesc) {
        this.bannerDesc = bannerDesc;
    }

    public String getBannerBg() {
        return bannerBg;
    }

    public void setBannerBg(String bannerBg) {
        this.bannerBg = bannerBg;
    }

    public List<Projeto> getProjetos() {
        return projetos;
    }

    public void setProjetos(List<Projeto> projetos) {
        this.projetos = projetos;
    }
}
