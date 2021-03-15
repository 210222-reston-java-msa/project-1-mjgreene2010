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

window.onload = function () {
    let currentEmployee = JSON.parse(employee)

    let reimbursementButton = document.getElementById("reimbursement_button")
    let approveDenyButton = document.getElementById("approve_deny_button")

    if (currentEmployee.isManager === true) {
        reimbursementButton.disabled = true;
    } else {
        approveDenyButton.disabled = true;
    }
    
    let employeeButton = document

    if (currentEmployee.isManager === false) {

        let table_header = document.getElementById('reimbursement-header');

        table_header.innerHTML = '<tr> <th scope="col">Ticket# </th>' +
            '<th scope="col">Reimbursement Type</th>' +
            '<th scope="col">Description</th>' +
            '<th scope="col">Amount</th>' +
            '<th scope="col">Status</th>' +
            '<th scope="col">Post Date</th> </tr>'
            
        let table_body = document.getElementById('reimbursement-body');
        table_body.innerHTML = "";
        console.log(table_header)
        let tr = "";


        // table_body.style.display = "none";

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
                        tr += `<td> $${data[i].amount} </td>`
                        tr += `<td> ${data[i].status} </td>`
                        tr += `<td> ${data[i].postingDate} </td>`
                        tr += '</tr>'
                    }
                }

                table_body.innerHTML += tr;

            })

    } else if (currentEmployee.isManager === true) {

        let table_header = document.getElementById('reimbursement-header');

        table_header.innerHTML = '<tr> <th scope="col">Ticket# </th>' +
            '<th scope="col">Name</th>' +
            '<th scope="col">Reimbursement Type</th>' +
            '<th scope="col">Description</th>' +
            '<th scope="col">Amount</th>' +
            '<th scope="col">Status</th>' +
            '<th scope="col">Post Date</th> ' +
            '<th scope="col">Resolve Date</th>' +
            '<th scope="col">Resolve Manager</th></tr>'
        // table_body.innerHTML = "";

        let table_body = document.getElementById('reimbursement-body');
        table_body.innerHTML = "";
        let tr = "";


        // table_body.style.display = "none";

        // fetch('http://localhost:8080/project-1/reimbursements')
        //     .then(response => response.json())
        //     .then(function (data) {

        fetch('http://localhost:8080/project-1/managertable')
            .then(response => response.json())
            .then( function (data) {

                for (let i = 0; i < data.length; i++) {
                  
                    // if(data[i].id === data2[i].reimbursementId) {


                        tr += '<tr>'
                        tr += `<td> ${data[i].id}</td>`
                        tr += `<td> ${data[i]["employee"].id} </td>`
                        tr += `<td> ${data[i].reimbursementType} </td>`
                        tr += `<td> ${data[i].description} </td>`
                        tr += `<td> $${data[i].amount} </td>`
                        tr += `<td> ${data[i].status} </td>`
                        tr += `<td> ${data[i].postingDate} </td>`
                        tr += `<td> ${data[i]["managertable"].resolveDate} </td>`
                        tr += `<td> ${data[i]["managertable"].resolveManagerId} </td>`
                        tr += '</tr>'
                    // }
                }

                table_body.innerHTML += tr;

            })
    }



}

function expensePost() {

    let currentEmployee = JSON.parse(employee);

    let expenseForm = document.getElementById('expense-form');
    let expenseAmount = document.getElementById('amount').value;
    let expenseType = document.getElementById('reimbursement-type').value;
    let expenseDescription = document.getElementById('description').value;

    fetch('http://localhost:8080/project-1/expensepost', {

        method: 'POST',
        body: JSON.stringify({
            "amount": expenseAmount,
            "reimbursement_type": expenseType,
            "description": expenseDescription,
            "employee": { "id": currentEmployee.id }
        }),
        headers: {
            'Content-Type': 'application/json'
        }
    })

        .then(response => response.json())

        .then(json => {
            console.log(json);
        });

}

function approveDenyPost() {

    console.log("post is firing")
    let currentEmployee = JSON.parse(employee);

    let approveDeny = document.getElementsByName("approveDenyRadio").value
    // let result = document.getElementById("result").value
    let decision = document.querySelector('input[name=approveDenyRadio]:checked').value
    let reimbursementId = document.getElementById("ticket").value

    console.log(decision)
    console.log(reimbursementId)
    console.log(currentEmployee.id)

    // for(let i = 0; i < approveDeny.length; i++) {
    //     if (approveDeny[i].checked) {
    //         result.innerHTML = approveDeny[i].value
    //     }
    // }

    fetch('http://localhost:8080/project-1/managerpost', {

        method: 'POST',
        body: JSON.stringify({
            "managertable": {"reimbursementId" : reimbursementId},
            "managertable": {"resolveManagerId" : currentEmployee.id},
            "status": decision,
        }),
        headers: {
            'Content-Type': 'application/json'
        }
    })

        .then(response => response.json())

        .then(json => {
            console.log(json);
        });


}









