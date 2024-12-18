// src/components/Task.js
import React from 'react';

const Task = ({ task, toggleCompletion, removeTask }) => {
  return (
    <div className='task-item'>
      <h3>{task.titulo}</h3>
      <p>{task.descricao}</p>
      <p>Status: {task.concluida ? "Concluída" : "Pendente"}</p>
      <div className="actions">
        <button className="complete" onClick={() => toggleCompletion(task.id)}>
          {task.concluida ? "Desmarcar" : "Concluir"}
        </button>
        <button className="remove" onClick={() => removeTask(task.id)}>
          Remover
        </button>
      </div>
    </div>
  );
};

export default Task;
