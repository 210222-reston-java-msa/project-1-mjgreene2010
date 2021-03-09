let welcome = document.getElementById('welcome');

//grap the current user from session
let employee = sessionStorage.getItem("currentUser");

//if the employee is null, redirect to index.html

if (employee === null) {
    window.location="http://localhost:8080/project-1/"
} else {
    let currentEmployee = JSON.parse(employee);

    console.log(currentEmployee);

    if (currentEmployee != null) welcome.innerHTML = `Welcome ${currentEmployee.firstName} ${currentEmployee.lastName}`;

    function logout() {
        let xhr = new XMLHttpRequest();

        xhr.open("POST", "http://localhost:8080/project-1/logout");
        xhr.send();

        sessionStorage.removeItem('currentEmployee');
        window.location = "http://localhost:8080/project-1/";
    }
}


  $('#myModal').on('hidden.bs.modal', function (event) {
    $('#myInput').trigger('focus')
  })
