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

function postExpense() {

    let currentEmployee = JSON.parse(employee);

    let expenseForm = document.getElementById("expense-form");
    let expenseType = document.getElementById("reimbursement-type").value;
    let expenseDescription = document.getElementById("description").value;
    let expenseAmount = document.getElementById("amount").value;
    
 

    expenseForm.addEventListener('submit', function (e) {
        e.preventDefault();

        // console.log(`type: ${type}`);
        // console.log(`description: ${description}`);
        // console.log(`amount: ${amount}`);
            
        fetch('http://localhost:8080/project-1/expensepost', {
            
            method: 'POST',
            body: JSON.stringify({
                "amount": expenseAmount,
                "reimbursementType": expenseType,
                "description": expenseDescription,
                "employee" : {"id" : currentEmployee.id}
            }),
            headers: {
                'Content-Type' : 'application/json; charset=UTF-8'
            },
        })

        .then(function(response){
            return response.json()
        })
        .then(function(data){
            console.log(data)
        })
    })

    onloadTable();

}



let onloadTable = window.onload = function () {
    let currentEmployee = JSON.parse(employee)

    let table_body = document.getElementById('reimbursement-body');
    table_body.innerHTML = "";
    let tr = "";

    // table_body.style.display="none";

    fetch('http://localhost:8080/project-1/reimbursements')
        .then(response => response.json())
        .then(function (data) {

            for (let i = 0; i < data.length; i++) {
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




