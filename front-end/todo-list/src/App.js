// src/App.js
import React from 'react';
import TaskList from './components/TaskList';
import './styles.css';

function App() {
  return (
    <div className="App">
      <div className="container">
        <TaskList />
      </div>
    </div>
  );
}

export default App;
