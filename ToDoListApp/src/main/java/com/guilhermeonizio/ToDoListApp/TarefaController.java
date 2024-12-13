package com.guilhermeonizio.ToDoListApp;

import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/tarefas")
public class TarefaController {

    private static List<Tarefa> tarefas = new ArrayList<>(); // Lista para armazenar tarefas temporariamente

    // Método para listar todas as tarefas
    @GetMapping
    public List<Tarefa> getAllTarefas() {
        return tarefas;
    }
\
    // Método para adicionar uma tarefa
    @PostMapping
    public Tarefa addTarefa(@RequestBody Tarefa tarefa) {
        System.out.println("Tarefa recebida: " + tarefa);  // Adicionando log para depuração
        tarefas.add(tarefa);
        return tarefa; // Retorna a tarefa adicionada
    }

    // Método para marcar tarefa como concluída
    @PutMapping("/{id}")
    public Tarefa updateTarefa(@PathVariable int id) {
        Tarefa tarefa = tarefas.get(id);
        if (tarefa != null) {
            tarefa.marcarComoConcluida(); // Marca como concluída
        }
        return tarefa;
    }

    // Método para remover tarefa
    @DeleteMapping("/{id}")
    public void deleteTarefa(@PathVariable int id) {
        tarefas.remove(id);
    }
}
