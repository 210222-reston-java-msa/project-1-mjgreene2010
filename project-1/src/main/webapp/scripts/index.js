function sendLogin() {

    console.log("send login trigger");

    let username = document.getElementById('empUsername');
    let password = document.getElementById('empPassword');

    //object literal
    let loginCredentials = {
        username: username,
        password: password
    }

   // 1. get the XMLHttpRequest Object if.e ... let xhr = ...
   let xhr = new XMLHttpRequest();

   // 2. xhr.onreadystatechange
   xhr.onreadystatechange = function() {
       if(this.readyState === 4 && this.status === 200) {
           console.log("success");

           sessionStorage.setItem("currentUser", this.responseText)

           window.location = "http://localhost:8080/EmployeeDBServlets/home.html"

           console.log(sessionStorage.getItem('currentUser'));
       }

       if (this.readyState === 4 && this.status === 204) { //204 means no content found (but connection was made)

        console.log("failed to find user")

        let childDiv = document.getElementById("warningText")
           childDiv.textContent = "Faild to login! Username or Password is incorrect"
       }
   }

   // 3. xhr.open("POST", http:/localhost:8080/EmployeeDBServlet/url for the loginServlet")

   xhr.open("POST", "http://localhost:8080/EmployeeDBServlets/login" )

   // 4. xhr.send(JSON.stringify)

   xhr.send(JSON.stringify(loginTemplate)) //this is converting out js object to JSON
}    }