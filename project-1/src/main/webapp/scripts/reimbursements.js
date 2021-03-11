let employee = sessionStorage.getItem("currentUser");

//if the employee is null, redirect to index.html

if (employee === null) {
    window.location = "http://localhost:8080/project-1/"
} else {
    let currentEmployee = JSON.parse(employee);

    console.log(currentEmployee);

    function logout() {
        let xhr = new XMLHttpRequest();

        xhr.open("POST", "http://localhost:8080/project-1/logout");
        xhr.send();

        sessionStorage.removeItem('currentEmployee');
        window.location = "http://localhost:8080/project-1/";
    }
}



window.onload = function() {
    let currentEmployee = JSON.parse(employee)

    let table_body = document.getElementById('reimbursement-body');
    table_body.innerHTML = "";
    let tr="";

    // table_body.style.display="none";

    fetch('http://localhost:8080/project-1/reimbursements')
        .then(response => response.json())
        .then(function(data) {
    
            for (let i = 0 ; i < data.length; i++) {
                if (data[i].employee.id != currentEmployee.id) {
            
                    continue;
                  
                } else {

                    tr += '<tr>'
                    tr += `<td> ${data[i].id} </td>`
                    tr += `<td> ${data[i].reimbursementType} </td>`
                    tr += `<td> ${data[i].description} </td>`
                    tr += `<td> ${data[i].amount} </td>`
                    tr += `<td> ${data[i].status} </td>`
                    tr += `<td> ${data[i].postingDate} </td>`
                    tr += '</tr>'
                } 
            }

            table_body.innerHTML += tr;
           
        })
    }


$('#myModal').on('hidden.bs.modal', function (event) {
    $('#myInput').trigger('focus')
})
