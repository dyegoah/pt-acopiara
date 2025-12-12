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

import br.com.higitech.ptAcopiara.model.Agenda;
import br.com.higitech.ptAcopiara.repository.AgendaRepository;

@RestController
@RequestMapping("/api/agenda")
public class AgendaController {

    @Autowired
    private AgendaRepository agendaRepository;

    @GetMapping
    public List<Agenda> listar() {
        // Retorna a lista completa de agendas do banco
        return agendaRepository.findAll();
    }

    @PostMapping
    public Agenda salvar(@RequestBody Agenda agenda) {
        // Salva ou atualiza um item da agenda
        return agendaRepository.save(agenda);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        agendaRepository.deleteById(id);
    }
}