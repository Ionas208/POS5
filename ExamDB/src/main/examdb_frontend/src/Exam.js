import './App.css';
import { useState, useEffect} from 'react';
import axios from 'axios'
import {Link, useParams} from "react-router-dom";

function Exam() {
    let { id } = useParams();
    const api = axios.create({
        baseURL: "http://localhost:8080/",
      });

    const [exam, setExam] = useState(null);
    const [subjects, setSubjects] = useState([]);

    const [subjectId, setSubjectId] = useState('');
    const [date, setDate] = useState('');
    const [duration, setDuration] = useState('');
    

    const getExam = () => {
        api.get("/exam/getById?exam_id="+id).then(res => {
            setExam(res.data);
        });
    }
    
    const getSubjects = () => {
        api.get("/exam/getAllSubjects").then(res => {
            setSubjects(res.data);
        });
    }

    useEffect(() => {
        getExam()
        getSubjects()
      }, []);

      if (exam==null){
          return <div></div>
      }
    return (
        <table>
            <thead>
                <tr>
                    <th>Subject</th>
                    <th>Date</th>
                    <th>Duration</th>
                </tr>
            </thead>
            <tbody>
                <tr key={exam.id}>
                    <td>
                        <select value={subjectId}  onChange={e => setSubjectId(e.target.value)}>
                            <option key={exam.subject.id} value={exam.subject.id}>{exam.subject.shortname}</option>
                            {(subjects.filter(subject => subject.id !== exam.subject.id)).map(subject => (
                                <option key={subject.id} value={subject.id}>{subject.shortname}</option>
                            ))}
                        </select>
                    </td>
                </tr>
            </tbody>
        </table>
    )
}

export default Exam;
