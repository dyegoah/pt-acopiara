package br.com.higitech.ptAcopiara.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.higitech.ptAcopiara.dto.ProjetosSecaoDTO;
import br.com.higitech.ptAcopiara.model.Projeto;
import br.com.higitech.ptAcopiara.model.SiteConfig;
import br.com.higitech.ptAcopiara.repository.ProjetoRepository;
import br.com.higitech.ptAcopiara.repository.SiteConfigRepository;

@RestController
@RequestMapping("/api/projetos-secao")
@CrossOrigin(origins = "*")
public class ProjetosSecaoController {

    @Autowired
    private SiteConfigRepository configRepo;

    @Autowired
    private ProjetoRepository projetoRepo;

    @GetMapping
    public ResponseEntity<ProjetosSecaoDTO> getSecaoProjetos() {
        SiteConfig config = configRepo.findById(1L).orElse(new SiteConfig());

        ProjetosSecaoDTO dto = new ProjetosSecaoDTO();
        dto.setBannerTitle(config.getProjectBannerTitle());
        dto.setBannerDesc(config.getProjectBannerDesc());
        dto.setBannerBg(config.getProjectBannerBg());

        List<Projeto> projetos = projetoRepo.findAll();
        dto.setProjetos(projetos);

        return ResponseEntity.ok(dto);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<String> salvarSecaoProjetos(@RequestBody ProjetosSecaoDTO dto) {

        // 1. Salva Configuração do Banner
        SiteConfig config = configRepo.findById(1L).orElse(new SiteConfig());
        config.setId(1L); 
        config.setProjectBannerTitle(dto.getBannerTitle());
        config.setProjectBannerDesc(dto.getBannerDesc());
        config.setProjectBannerBg(dto.getBannerBg());
        configRepo.save(config);

        // 2. Salva Lista de Projetos
        // Primeiro limpa a tabela antiga
        projetoRepo.deleteAll();
        
        // CORREÇÃO AQUI:
        if (dto.getProjetos() != null && !dto.getProjetos().isEmpty()) {
            // Força o ID a ser nulo. Isso obriga o banco a criar novas linhas (INSERT)
            // ao invés de tentar atualizar linhas que acabamos de apagar (UPDATE).
            dto.getProjetos().forEach(p -> p.setId(null));
            
            projetoRepo.saveAll(dto.getProjetos());
        }

        return ResponseEntity.ok("Seção salva com sucesso!");
    }
}