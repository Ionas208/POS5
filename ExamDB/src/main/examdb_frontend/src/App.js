import './App.css';
import Students from './Students';
import Exams from './Exams';
import Exam from './Exam';
import { useState, useEffect} from 'react';
import { BrowserRouter as Router, Route, Routes} from 'react-router-dom';

function App() {
  return (
    <Router>
      <Routes>
        <Route exact path="/" element={<Students/>} />
        <Route exact path="/exams/:id" element={<Exams/>} />
        <Route exact path="/exam/:id" element={<Exam/>} />
      </Routes>
    </Router>
  )
}

export default App;
