package com.guilhermeonizio.ToDoListApp;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/tarefas")
public class TarefaController {

    private static List<Tarefa> tarefas = new ArrayList<>(); // Lista para armazenar tarefas temporariamente
    private static int contadorId = 0; // Contador fixo para IDs

    // Método para listar todas as tarefas
    @GetMapping
    public List<Tarefa> getAllTarefas() {
        return tarefas;
    }

    // Método para adicionar uma tarefa
    @PostMapping
    public Tarefa addTarefa(@RequestBody Tarefa tarefa) {
        tarefa.setId(contadorId + 1);  // Gera ID único baseado no contadorId, começando de 1
        contadorId++;  // Incrementa o contador
        tarefas.add(tarefa);
        return tarefa;
    }

    // Método para marcar tarefa como concluída

    @PutMapping("/{id}")
    public ResponseEntity<?> updateTarefa(@PathVariable int id) {
        System.out.println("Tamanho da lista: " + tarefas.size());
        System.out.println("Índice recebido: " + id);

        // Verifica se o id está dentro do intervalo válido
        if (id <= 0 || id > tarefas.size()) {
            String mensagemErro = "O índice fornecido está fora do limite da lista. Índice: " + id;
            System.err.println(mensagemErro);
            return ResponseEntity.badRequest().body(mensagemErro);
        }

        Tarefa tarefa = tarefas.get(id - 1);  // Ajusta o índice para basear em zero
        tarefa.marcarComoConcluida(); // Marca como concluída
        System.out.println("Tarefa atualizada: " + tarefa);
        return ResponseEntity.ok(tarefa);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTarefa(@PathVariable int id) {
        // Verifica se o id está dentro do intervalo válido
        if (id <= 0 || id > tarefas.size()) {
            String mensagemErro = "O índice fornecido está fora do limite da lista. Índice: " + id;
            System.err.println(mensagemErro);
            return ResponseEntity.badRequest().body(mensagemErro);
        }

        tarefas.remove(id - 1);  // Ajusta o índice para basear em zero
        return ResponseEntity.ok("Tarefa removida com sucesso.");
    }
}
