// src/components/Task.js
import React from 'react';

const Task = ({ task, toggleCompletion, removeTask }) => {
  return (
    <div>
      <h3>{task.titulo}</h3>
      <p>{task.descricao}</p>
      <p>Status: {task.concluida ? "Concluída" : "Pendente"}</p>
      <button onClick={() => toggleCompletion(task.id)}>
        {task.concluida ? "Desmarcar" : "Concluir"}
      </button>
      <button onClick={() => removeTask(task.id)}>Remover</button>
    </div>
  );
};

export default Task;
