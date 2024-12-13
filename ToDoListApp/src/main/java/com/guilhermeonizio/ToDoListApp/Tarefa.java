package com.guilhermeonizio.ToDoListApp;

public class Tarefa {

    private static int contadorId = 0;  // Contador para gerar IDs únicos

    private int id;
    private String titulo;
    private String descricao;
    private boolean concluida;

    // Construtor sem argumentos (necessário para deserialização JSON)
    public Tarefa() {
        this.id = ++contadorId;
        this.concluida = false;
    }

    // Construtor com título e descrição
    public Tarefa(String titulo, String descricao) {
        this.id = ++contadorId;
        this.titulo = titulo;
        this.descricao = descricao;
        this.concluida = false;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isConcluida() {
        return concluida;
    }

    public void setConcluida(boolean concluida) {
        this.concluida = concluida;
    }

    public void marcarComoConcluida() {
        this.concluida = true;
    }

    @Override
    public String toString() {
        return "Título: " + titulo + "\nDescrição: " + descricao + "\nStatus: " + (concluida ? "Concluída" : "Pendente");
    }
}
