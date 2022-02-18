import './Students.css';
import axios from 'axios'
import { useState, useEffect} from 'react';
import {Link} from "react-router-dom";

function Students() {
  const api = axios.create({
    baseURL: "http://localhost:8080/",
  });

  const [classnames, setClassnames] = useState([]);
  const [classname, setClassname] = useState('');
  const [students, setStudents] = useState([]);

  const getClassnames = () => {
    api.get("/classname/all").then(res => {
      setClassnames(res.data);
    });
  }
  
  const getStudents = (classname, page=0) => {
    api.get("/student/getByClassname?classname_id="+classname+"&page="+page).then(res => {
      let pages = [];
      for(var i = 0; i < res.data.totalPages; i++){
        pages.push(i+1);
      }
      res.data.pages = pages;
      setStudents(res.data);
      setClassname(classname);
    });
  }

  useEffect(() => {
    getClassnames()
  }, [])

  if(students.length === 0) {
    return (
      <div>
        <h1>List of Students</h1>
        <div>
          <select onChange={e => getStudents(e.target.value)}>
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
        <h1>List of Students</h1>
        <div>
          <select onChange={e => getStudents(e.target.value)}>
            <option>Select Class</option>
            {classnames.map(classname => (
              <option key={classname.id} value={classname.id}>{classname.classname}</option>
            ))}
          </select>
        </div>
        <div>
          <table>
            <thead>
              <tr>
                <th>Firstname</th>
                <th>Lastname</th>
              </tr>
            </thead>
            <tbody>
              {students.content.map(student => (
                <tr key={student.id}>
                  <td>{student.firstname}</td>
                  <td>{student.lastname}</td>
                  <td>
                    <Link to={"exams/"+student.id}>
                      <button>Show Exams</button>
                    </Link>
                  </td>
                </tr>
              ))}
            </tbody>
          </table>
          <div className='pages'>
                {students.pages.map(page => (
                  <button key={page} onClick={e => getStudents(classname, page-1)}>{page}</button>
                ))}
          </div>
        </div>
      </div>
    );
  }
}

export default Students;
