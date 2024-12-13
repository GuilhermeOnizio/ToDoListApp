// src/components/AddTask.js
import React, { useState } from 'react';
import axios from 'axios';

const AddTask = ({ addTask }) => {
  const [titulo, setTitulo] = useState('');
  const [descricao, setDescricao] = useState('');

  const handleSubmit = (event) => {
    event.preventDefault();

    const newTask = {
      titulo,
      descricao,
      concluida: false, // A tarefa é criada como não concluída
    };
    
    console.log(newTask);  // Verifique os dados antes de enviar


    // Envia a tarefa para o back-end
    axios.post('http://localhost:8080/api/tarefas', newTask)
    .then((response) => {
      console.log('Resposta do backend:', response.data);  // Verifique a resposta
      addTask(response.data);
      setTitulo('');
      setDescricao('');
    })
    .catch(error => {
      console.error('Erro ao adicionar tarefa:', error);
      alert('Ocorreu um erro ao adicionar a tarefa.');
    });
  
  };

  return (
    <form onSubmit={handleSubmit}>
      <input
        type="text"
        placeholder="Título"
        value={titulo}
        onChange={(e) => setTitulo(e.target.value)}
        required
      />
      <input
        type="text"
        placeholder="Descrição"
        value={descricao}
        onChange={(e) => setDescricao(e.target.value)}
        required
      />
      <button type="submit">Adicionar Tarefa</button>
    </form>
  );
};

export default AddTask;
