function showPopup(event) {
    event.preventDefault();
    var name = document.getElementById("name").value;
    var email = document.getElementById("email").value;
    if (systemid!==""&& name !== "" && email !== "" && phone!=="" && os!=="" && complaints!=="") {
        document.querySelector(".popup").classList.add("show");
        document.querySelector(".popup-overlay").classList.add("show");
        document.querySelector("body").classList.add("disabled");
    }
}

function hidePopup() {
window.location.href = "firstpage.html";
    // document.querySelector(".popup").classList.remove("show");
    // document.querySelector(".popup-overlay").classList.remove("show");
    // document.querySelector("body").classList.remove("disabled");
}



// var toggleSubmit = function() {
//   var isDisabled = ![].some.call(document.querySelectorAll("input[type=text]"), function(input) {
//     return input.value.length;
//   });

//   var submitBtn = document.querySelector("input[type=submit]");

//   if (isDisabled) {
//     submitBtn.setAttribute("disabled", "disabled");
//   } else {
//     submitBtn.removeAttribute("disabled");
//   }
// };

// document.querySelector("form").addEventListener("input", toggleSubmit, false);
let v= document.getElementById('systemid');
function fetchSystemName(v){
// let v= document.getElementById('systemid');
// console.log(v)
fetch("http://localhost:8080/Device_Management/users/display")
.then(response => response.json())
.then(objectData=>{
// console.log(objectData);
// let myTable="";
// console.log(v)
// console.log(objectData[1])
// let v= document.getElementById('systemid');
// console.log(v)
var flag=1;
for (i = 0; i < objectData.length; i++){
      // var store=console.log(objectData[i])
      // console.log(store)
      var v1= objectData[i].systemid;
        if (v==v1){
          flag=0;
          // document.getElementById('systemid')
      // console.log(document.getElementById('email').value = objectData[1].email)
      document.getElementById('email').value = objectData[i].email;
      document.getElementById('email').readOnly = true;
      document.getElementById('phone').value = objectData[i].phone;
      document.getElementById('phone').readOnly = true;
        document.getElementById('name').value = objectData[i].name;
        document.getElementById('name').readOnly = true;
        document.getElementById('os').value = objectData[i].os;
        document.getElementById('os').readOnly = true;
        break;
        
      }
}
if (flag==1){
  document.getElementById('email').value = "";
  document.getElementById('email').readOnly = false;
      document.getElementById('phone').value = "";
      document.getElementById('phone').readOnly = false;
        document.getElementById('name').value = "";
        document.getElementById('name').readOnly = false;
        document.getElementById('os').value = ""   ;  
        document.getElementById('os').readOnly = false;
        document.getElementById('complaints').value = ""; 
      }

//   // objectData.map((values)=>{
  
});
// });
}

//         function btnToggleVisibility(obj) {
//     var targetElement = document.getElementById(obj.getAttribute('data-target'));

//     targetElement.classList.toggle('show');
// }

// window.btnToggleVisibility = btnToggleVisibility;

const myButton = document.getElementById("sub");


const form = document.getElementById('ticketsraise');

form.addEventListener('submit', (e)=>{
e.preventDefault();

const formData = new FormData(form);
let formDataObject = Object.fromEntries(formData.entries());
let formDataJsonString = JSON.stringify(formDataObject);
// console.log(formDataObject.email)

console.log(formDataObject.email);
Email.send({
// console.log(formDataObject.email);
Host : "smtp.elasticemail.com",
Username : "aryan.gollapelly@wavemaker.com",
Password : "2D4B24DF4805DC5340CA4749B6BEA5B1B7C1",
To :`${formDataObject.email}`,
// console.log(formDataObject.email);
From : 'aryan.gollapelly@wavemaker.com',
Subject : "Ticket Raised Successfully",
Body : "Name: "+document.getElementById("name").value
        +"<br> Email: "+document.getElementById("email").value
        +"<br> System ID: "+document.getElementById("systemid").value
        +"<br> Phone number: "+document.getElementById("phone").value
        +"<br> Issue: "+document.getElementById("complaints").value
}).then(

);
// }else{
// alert("Please check the mail is correct or not")
// }




console.log(formDataObject);
fetch('http://localhost:8080/Device_Management/users/create', {
  // sendmail();
  method:'POST',
   //Set the headers that specify you're sending a JSON body request and accepting JSON response
headers: {
  "Content-Type": "application/json",
  Accept: "application/json",
},
  body: formDataJsonString
}).then(res =>res.json)
.then(data => console.log(data))
.catch((err) =>{
  alert(err);
  console.log(err)
});
});