package br.com.higitech.ptAcopiara.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.higitech.ptAcopiara.model.Filiado;
import br.com.higitech.ptAcopiara.repository.FiliadoRepository;

@RestController
@RequestMapping("/api/filiados")
public class FiliadoController {

    @Autowired
    private FiliadoRepository filiadoRepository;

    // ROTA: Listar todos OU Buscar por termo
    // Exemplo de uso no front: 
    // GET /api/filiados (traz tudo)
    // GET /api/filiados?termo=maria (busca maria no nome, email, bairro, etc)
    @GetMapping
    public List<Filiado> listar(@RequestParam(required = false) String termo) {
        if (termo != null && !termo.isEmpty()) {
            return filiadoRepository.buscarPorQualquerCampo(termo);
        }
        return filiadoRepository.findAllByOrderByIdDesc();
    }

    // ROTA: Salvar novo filiado
    @PostMapping
    public Filiado salvar(@RequestBody Filiado filiado) {
        return filiadoRepository.save(filiado);
    }

    // ROTA: Deletar filiado
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        filiadoRepository.deleteById(id);
    }
}