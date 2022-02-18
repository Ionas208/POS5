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

    const save = () => {
        let ex = {
            "dateofexam": date,
            "duration": duration,
            "subject": {
                "id": subjectId
            }
        }
        console.log(ex)
        api.patch("/exam/update?exam_id="+exam.id, ex).then(res => {
            getExam();
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
        <div>
            <h1>Edit Exam</h1>
            <div>Enter new values here:</div>
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
                        <td>
                            <input type="date" value={date} onChange={e => setDate(e.target.value)}/>
                        </td>
                        <td>
                            <input type="number" value={duration} onChange={e => setDuration(e.target.value)}/>
                        </td>
                    </tr>
                </tbody>
            </table>
            <button onClick={e => save()}>Save</button>
        </div>
    )
}

export default Exam;
