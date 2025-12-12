package br.com.higitech.ptAcopiara.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.higitech.ptAcopiara.model.Noticia;
import br.com.higitech.ptAcopiara.repository.NoticiaRepository;

@RestController
@RequestMapping("/api/noticias")
public class NoticiaController {

    @Autowired
    private NoticiaRepository noticiaRepository;

    @GetMapping
    public List<Noticia> listar() {
        // Retorna todas, ordenadas por data (o frontend limita a 4 se necessário)
        return noticiaRepository.findAllByOrderByDataPublicacaoDesc();
    }

    @PostMapping
    public Noticia salvar(@RequestBody Noticia noticia) {
        return noticiaRepository.save(noticia);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        noticiaRepository.deleteById(id);
    }
}