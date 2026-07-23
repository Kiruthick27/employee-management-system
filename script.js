const API_URL = "http://localhost:8080/employee";
const LOGIN_API_URL = "http://localhost:8080/Login";
const REGISTRATION_API_URL = "http://localhost:8080/register";
let editingId = null;



function addEmployee(){

    let id = document.getElementById("id").value;
    let name = document.getElementById("name").value.trim();
    let salary = document.getElementById("salary").value;

    if(id === "" || name === "" || salary === "" || id ==="0"){
        if(parseInt(id) <= 0){
            alert("ID must be greater than ZERO number");
            return;
        }
        alert("Please fill all fields");
        return;
    }


    if(name.length < 3){
        alert("Name must be at least 3 characters long");
        return;
    }

    if(parseFloat(salary) <= 0){
        alert("Salary must be grater than 0");
        return;
    }

    if(editingId !== null){
        updateEmployee();
        return;
    }


    let employee = {

        id: parseInt(id),

        name: name,

        salary: parseFloat(salary),

    };


    fetch(API_URL, {

        method:"POST",

        headers:{
            "Content-Type":"application/json"
        },

        body: JSON.stringify(employee)

    })

    .then(response => response.text())

    .then(data => {

        alert("Employee Added Successfully");
        
        getEmployees();
        
    })
    
    .catch(error => console.log(error));

}



function getEmployees(){

    fetch(API_URL)

    .then(response => response.json())

    .then(data => {


        let table = document.getElementById("employeeTable");

        table.innerHTML="";


        data.forEach(emp => {


            table.innerHTML += `

            <tr>

                <td>${emp.id}</td>

                <td>${emp.name}</td>

                <td>${emp.salary}</td>

                <td>
                    <button onclick="editEmployee(${emp.id}, '${emp.name}', ${emp.salary})">Edit</button>
                    <button onclick="deleteEmployee(${emp.id})">Delete</button>
                </td>

            </tr>

            `;


        });


    });

}


if (document.getElementById("employeeTable")) {
    getEmployees();
}


function editEmployee(id, name, salary){
    editingId = id;
    document.getElementById("id").value = id;
    document.getElementById("name").value = name;
    document.getElementById("salary").value = salary;

    document.getElementById("saveBtn").innerText = "Update Employee";
}



function updateEmployee(){

    let employee = {

        id: editingId,
        name: document.getElementById("name").value,
        salary: parseFloat(document.getElementById("salary").value),
    };

    fetch(`${API_URL}/${editingId}`, {
        method: "PUT",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(employee)
    })
    .then(response => response.text())
    .then(data => {
        alert("Employee Updated Successfully");
        editingId = null;
        document.getElementById("saveBtn").innerText = "Add Employee";
        getEmployees();
    })
    .catch(error => console.log(error));
}

function deleteEmployee(id){

    if(confirm("Are you sure you want to delete this employee?")){

        fetch(API_URL+ "/" + id, {
            method: "DELETE"
        })
        .then(response => response.text())
        .then(data => {
            alert(data);
            getEmployees();
        })
        .catch(error => console.log(error));
    }
}

function Login(event) {
    event.preventDefault();

    const username = document.getElementById("username").value.trim();
    const password = document.getElementById("password").value;

    if (username === "" || password === "") {
        alert("Please fill all fields");
        return;
    }

    const user = {
        username: username,
        password: password
    };

    fetch(LOGIN_API_URL, {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(user)
    })
    .then(response => {
        if (response.ok) {
            return response.text();
        }

        throw new Error("Invalid username or password");
    })
    .then(data => {
        alert(data);
        window.location.href = "index.html";
    })
    .catch(error => {
        alert(error.message);
    });
}

function registration() {
    window.location.href = "registration.html";
    return;

}

function register(event) {
    event.preventDefault();

    const username = document.getElementById("username").value.trim();
    const password = document.getElementById("password").value;
    const confirmPassword =
        document.getElementById("confirmPassword").value;

    if (username === "" || password === "" || confirmPassword === "") {
        alert("Please fill all fields");
        return;
    }

    if (password !== confirmPassword) {
        alert("Passwords do not match");
        return;
    }

    const user = {
        username: username,
        password: password
    };

    fetch(REGISTRATION_API_URL, {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(user)
    })
    .then(response => {
        return response.text().then(message => ({
            ok: response.ok,
            message: message
        }));
    })
    .then(result => {

        if (!result.ok) {
            alert(result.message);
            return;
        }

        alert(result.message);
        window.location.href = "login.html";
    })
    .catch(error => {
        alert("Backend connection failed");
        console.log(error);
    });
}

function logout() {
    if(confirm("Are you sure you want to logout?")){
        alert("Logout successful");
        window.location.href = "login.html";
        return;
    }
}