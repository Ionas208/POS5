url = "http://localhost:8080/"
classname_global = null

const getClassnames = async () => {
    try{
        let res = await fetch(url+'classname/all',{
            method: 'GET',
            headers: {
                'Content-Type': 'application/json'
            },
        });
        const classnames = await res.json();
        console.log(classnames)
        setClassnames(classnames);
    }catch (err){
        console.log(err);
    }
}

const setClassnames = (classnames) => {
    const classnameSelect = document.getElementById("classnames");
    classnames.forEach(c => {
        let option = document.createElement("option");
        option.innerHTML = c.classname;
        option.setAttribute("value", c.id);
        classnameSelect.appendChild(option);
    });
    classnameSelect.addEventListener("change", (e) => {
        classname_global = e.target.value;
        getStudents(e.target.value, 0);
    });
}

const getStudents = async (classname, page) => {
    let res = await fetch(url+'student/getByClassname?classname_id='+classname+'&page='+page,{
        method: 'GET',
        headers: {
            'Content-Type': 'application/json'
        }
    });
    const students = await res.json();
    setStudents(students);
    setPages(students);
}

const setPages = (students) => {
    const page_container = document.getElementById("page_container");
    page_container.innerHTML = "";
    for(var page = 1; page <= students.totalPages; page++){
        let page_item = document.createElement("div");
        page_item.className = "page_item";
        page_item.innerHTML = page;
        if(page == students.number){
            page_item.className = "page_item active";
        }else{
            page_item.addEventListener("click", (e) => {
                getStudents(classname_global, e.target.innerHTML-1);
            });
        }
        page_container.appendChild(page_item);
    }
}

const setStudents = (students) => {
    const student_table = document.getElementById("student_table");
    const student_table_body = document.getElementById("student_table_body");
    student_table_body.innerHTML = "";
    students.content.forEach(s => {
        let row = document.createElement("tr");

        let firstname = document.createElement("td");
        firstname.innerHTML = s.firstname;
        row.appendChild(firstname);

        let lastname = document.createElement("td");
        lastname.innerHTML = s.lastname;
        row.appendChild(lastname);

        student_table_body.appendChild(row);
    });
    student_table.style.display = "block";
}

getClassnames();