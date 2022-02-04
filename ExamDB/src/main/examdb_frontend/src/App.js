import './App.css';
import axios from 'axios'
import { useState, useEffect} from 'react';

function App() {
  const api = axios.create({
    baseURL: "http://localhost:8080/",
  });

  const [classnames, setClassnames] = useState([]);
  const [students, setStudents] = useState([]);

  const getClassnames = () => {
    api.get("/classname/all").then(res => {
      setClassnames(res.data);
    });
    console.log(classnames);
  }
  
  const getStudents = (event) => {
    api.get("/student/getByClassname?classname_id="+event.target.value).then(res => {
      setStudents(res.data);
    });
    console.log(students);
  }

  useEffect(() => {
    getClassnames()
  }, [])

  if(students.length === 0) {
    return (
      <div>
        <div>
          <select onChange={e => getStudents(e)}>
            <option>Select Class</option>
            {classnames.map(classname => (
              <option key={classname.id} value={classname.id}>{classname.classname}</option>
            ))}
          </select>
        </div>
      </div>
    );
  } else {
    return (
      <div>
        <div>
          <select onChange={e => getStudents(e)}>
            <option>Select Class</option>
            {classnames.map(classname => (
              <option key={classname.id} value={classname.id}>{classname.classname}</option>
            ))}
          </select>
        </div>
        <div>
          <table>
            <thead>
              <th>Firstname</th>
              <th>Lastname</th>
            </thead>
          </table>
        </div>
      </div>
    );
  }
}

export default App;
