// src/components/TaskList.js
import React, { useEffect, useState } from 'react';
import axios from 'axios';
import Task from './Task';
import AddTask from './AddTask';

const TaskList = () => {
  const [tasks, setTasks] = useState([]);

  // Carregar tarefas do back-end
  useEffect(() => {
    axios.get('http://localhost:8080/api/tarefas')
      .then(response => {
        setTasks(response.data);
      })
      .catch(error => {
        console.error('Erro ao carregar tarefas:', error);
        alert('Ocorreu um erro ao carregar as tarefas.');
      });
  }, []);

  // Adicionar tarefa
  const addTask = (task) => {
    setTasks([...tasks, task]); // Atualiza a lista localmente
  };

  // Marcar tarefa como concluída
  const toggleCompletion = (id) => {
    console.log("ID enviado para marcar como concluída:", id);  // Verifique o valor do id aqui
  
    if (id <= 0) {
      console.error('ID inválido. O ID não pode ser 0 ou negativo.');
      return;
    }
  
    axios.put(`http://localhost:8080/api/tarefas/${id}`)
      .then(() => {
        setTasks(tasks.map(task =>
          task.id === id ? { ...task, concluida: !task.concluida } : task
        ));
      })
      .catch(error => {
        console.error('Erro ao marcar tarefa como concluída', error);
        alert('Erro ao marcar tarefa como concluída.');
      });
  };
  
  const removeTask = (id) => {
    console.log("ID enviado para remoção da tarefa:", id);  // Verifique o valor do id aqui
  
    if (id <= 0) {
      console.error('ID inválido. O ID não pode ser 0 ou negativo.');
      return;
    }
  
    axios.delete(`http://localhost:8080/api/tarefas/${id}`)
      .then(() => {
        setTasks(tasks.filter(task => task.id !== id));
      })
      .catch(error => {
        console.error('Erro ao remover tarefa', error);
        alert('Erro ao remover tarefa.');
      });
  };

  return (
    <div>
      <h1>To-Do List</h1>
      <AddTask addTask={addTask} />
      <div className='task-list'>
        {tasks.map((task) => (
          <Task key={task.id} task={task} toggleCompletion={toggleCompletion} removeTask={removeTask} />
        ))}
      </div>
    </div>
  );
};

export default TaskList;
