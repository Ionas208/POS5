import './App.css';
import { useState, useEffect} from 'react';
import axios from 'axios'
import {Link, useParams} from "react-router-dom";

function Exams() {
    const api = axios.create({
        baseURL: "http://localhost:8080/",
      });

    let { id } = useParams();
    const [exams, setExams] = useState([]);
    const [subjects, setSubjects] = useState([]);

    const [subjectId, setSubjectId] = useState('');
    const [date, setDate] = useState('');
    const [duration, setDuration] = useState('');

    const getExams = () => {
        api.get("/exam/getByStudent/"+id).then(res => {
            setExams(res.data);
        });
    }

    const getSubjects = () => {
        api.get("/exam/getAllSubjects").then(res => {
            setSubjects(res.data);
        });
    }

    const addExam = () => {
        let exam = {
            "dateofexam": date,
            "duration": duration
        }
        api.post("/student/addExam?student_id="+exams[0].student.id+"&subject_id="+subjectId, exam).then(res => {
            getExams();
        });
    }

    useEffect(() => {
        getExams()
        getSubjects()
      }, []);

    return (
        <div>
            <table>
                <thead>
                    <tr>
                        <th>Subject</th>
                        <th>Date</th>
                        <th>Duration</th>
                    </tr>
                </thead>
                <tbody>
                    {exams.map(exam => (
                        <tr key={exam.id}>
                            <td>{exam.subject.longname}</td>
                            <td>{exam.dateofexam}</td>
                            <td>{exam.duration}</td>
                            <td><button>Delete</button></td>
                            <td>
                                <Link to={"/exam/"+exam.id}>
                                    <button>
                                        Edit
                                    </button>
                                </Link>
                            </td>
                        </tr>
                    ))}
                    <tr>
                        <td>
                            <select value={subjectId}  onChange={e => setSubjectId(e.target.value)}>
                                <option>Select Subject</option>
                                {subjects.map(subject => (
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
                        <td>
                            <button onClick={e => addExam()}>Add Exam</button>
                        </td>
                    </tr>
                </tbody>
            </table>
        </div>
    )
}

export default Exams;
