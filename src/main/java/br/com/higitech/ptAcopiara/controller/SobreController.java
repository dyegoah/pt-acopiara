package br.com.higitech.ptAcopiara.controller;

import br.com.higitech.ptAcopiara.model.Sobre;
import br.com.higitech.ptAcopiara.repository.SobreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/sobre")
public class SobreController {

    @Autowired
    private SobreRepository sobreRepository;

    @GetMapping
    public Sobre obter() {
        // Tenta buscar o registro de ID 1 (Padrão Singleton)
        // Se não existir, retorna um objeto vazio para o frontend não quebrar
        return sobreRepository.findById(1L).orElse(new Sobre());
    }

    @PostMapping
    public Sobre salvar(@RequestBody Sobre sobreRecebido) {
        // 1. Busca se já existe o registro "Sobre" (ID 1)
        Sobre registroNoBanco = sobreRepository.findById(1L).orElse(null);

        if (registroNoBanco == null) {
            // CENÁRIO 1: PRIMEIRO CADASTRO
            // Não setamos o ID manualmente. Deixamos o banco gerar (IDENTITY).
            // O banco provavelmente atribuirá o ID 1 se a tabela estiver vazia.
            return sobreRepository.save(sobreRecebido);
        } else {
            // CENÁRIO 2: ATUALIZAÇÃO
            // Atualizamos apenas os campos do objeto que já existe no banco (mantendo o ID dele)
            registroNoBanco.setTitulo(sobreRecebido.getTitulo());
            registroNoBanco.setTexto(sobreRecebido.getTexto());
            return sobreRepository.save(registroNoBanco);
        }
    }
}