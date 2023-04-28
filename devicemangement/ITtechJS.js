
function showYesNo(clicked) {
  console.log(clicked.value);
  var v=document.getElementById('item').setAttribute('value',clicked.value);
  
        // var myvalue=clicked;
    } 
// function myFunction() {
//   alert("Successfully Requested");
// }

function nouserfound() {
  alert("No user Found");
  document.getElementById('reqname').value = "";
  document.getElementById('sysid').value = "";
}

function userfound() {
  alert("User already Exists!! Please request for product");
}
var bt = document.getElementById('subm');
function myclose(){
  document.getElementById('systemid').value = "";
  document.getElementById('name').value = "";
            document.getElementById('phone').value = "";
            document.getElementById('os').value = "";
            // document.getElementById('complaints').value = "";
            document.getElementById('email').value = "";
  bt.style.background='blue';
  bt.style.color='white'
  bt.style.cursor='pointer'
}
 

function remo(clicked){
  // console.log(clicked.value);
  let ss=clicked.value+"hi"
  console.log(ss);
  console.log(cardsDiv)
  var parent=document.getElementById(ss);
  console.log(parent)
  // var child=parent.getElementById(clicked.value+"hii");
  // console.log(parent.getElementsByTagName("div"));
  document.getElementById("cards").removeChild(parent);
  let c=0
  // localStorage
  // items.forEach((item) => {
  //   c=c+1
  //   console.log(item)
    // if (item.name==clicked.value){
        window.localStorage.removeItem('items'[0]);
    // }

  // });
}
var btss = document.getElementById('sub');


function showPopup(event) {
  event.preventDefault();
  var name = document.getElementById("reqname").value;
  var email = document.getElementById("item").value;
  console.log(email)
  if (name !== "" && email !== "") {
    console.log(name)
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

function yess(){
  btss.style.cursor='no-drop'
            btss.disabled=true;
}

function subb(){
  alert("Product Requested Successfully")
  window.location.href="firstpage.html";
}



  const items = JSON.parse(localStorage.getItem('items')) || [];
    const cardsDiv = document.getElementById('cards');
    // cardsDiv.id=item.name;
      // cardsDiv.className=item.name;
      console.log(cardsDiv);
      console.log(items)
      console.log(localStorage)
    items.forEach((item) => {
      // localStorage.clear();
      const card = document.createElement('div');
      card.classList.add('card');
      const img = document.createElement('img');
      img.src = item.image;
      const name = document.createElement('h2');
      name.textContent = item.name;
      const button = document.createElement('span');
      
      const button1 = document.createElement('span');
      card.id=item.name+"hi";
      console.log(cards+"safadsf");
      // localStorage.setItem(item.name+"hi",JSON.stringify(item))
      
      button.innerHTML = '<button id="'+item.name+'" value="'+item.name+'"onClick="showYesNo('+item.name+')" data-toggle="modal" data-target="#basicModal" value="Request">Request</button>';
      // button.innerHTML = '<button id="'+item.name+'" value="'+item.name+'"onClick="remo('+item.name+')" value="Remove">Remove</button>';
      
      // button.id.onclick()=window.location.href="imgupload.html"
      // button.onclick=hii();
      card.appendChild(img);
      card.appendChild(name);
      card.appendChild(button);
      // card.appendChild(button1);
      cardsDiv.appendChild(card);
    });
  const myButton = document.getElementById("sub");
  const form = document.getElementById('requests');
  form.addEventListener('submit', (e)=>{
      e.preventDefault();
      const formData = new FormData(form);
      let formDataObject = Object.fromEntries(formData.entries());
      let formDataJsonString = JSON.stringify(formDataObject);
      fetch('http://localhost:8080/Device_Management/request/create', {
          method:'POST',
           //Set the headers that specify you're sending a JSON body request and accepting JSON response
          headers: {
            "Content-Type": "application/json",
            Accept: "application/json",
          },
          body: formDataJsonString
          }).then(res => res.json)
            .then(data => console.log(data))
            .catch((err) =>{
                alert(err);
                console.log(err)
          // window.location.href = "ITtech.html";
            });
    });



    let v= document.getElementById('sysid');
function fetchName(v){
  // console.log(v)
  // console.log(items)
  // console.log(cardsDiv)
  // console.log(card)
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
        
        document.getElementById('reqname').value = objectData[i].name;
        document.getElementById('reqname').readOnly = true;
        btss.style.cursor='pointer'
            btss.disabled=false;

        break;
        
      }
}
if (flag==1){
        
            nouserfound();
        }
      })
    // });
    }

    let v2= document.getElementById('systemid');
    
    function fetchuser(v2){
      console.log(v2)
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
            if (v2==v1){
              flag=0;
              // document.getElementById('systemid')
          // console.log(document.getElementById('email').value = objectData[1].email)
            console.log(v1,"fsadsf",v2);
            document.getElementById('name').readOnly = true;
            document.getElementById('phone').readOnly = true;
            document.getElementById('os').readOnly = true;
            // document.getElementById('complaints').readOnly = true;
            document.getElementById('email').readOnly = true;
            console.log(bt);
            bt.disabled=true;
            bt.style.background='grey';
            bt.style.color='black'
            
            bt.style.cursor='no-drop'
            // document.getElementById('name').value = objectData[i].name;
            
            break;
          }
    }
    if (flag==0){
            console.log(flag,"hiiiuser")
                userfound();
                
               
            }
    else{
      document.getElementById('name').readOnly = false;
            document.getElementById('phone').readOnly = false;
            document.getElementById('os').readOnly = false;
            // document.getElementById('complaints').readOnly = false;
            document.getElementById('email').readOnly = false;
            bt.style.background='blue';
            bt.style.color='white'
            bt.style.cursor='pointer'
            bt.disabled=false;
    }
          });
        // });
    }
    
    



const myButtons = document.getElementById("subm");
const forms = document.getElementById('ticketsraise');

forms.addEventListener('submit', (e)=>{
e.preventDefault();

const formDatas = new FormData(forms);
let formDataObjects = Object.fromEntries(formDatas.entries());
let formDataJsonStrings = JSON.stringify(formDataObjects);
// console.log(formDataObjects);
formDataObjects.complaints="No Complaints"
console.log(formDataObjects);
fetch('http://localhost:8080/Device_Management/users/create', {
  method:'POST',
   //Set the headers that specify you're sending a JSON body request and accepting JSON response
headers: {
  "Content-Type": "application/json",
  Accept: "application/json",
},
  body: formDataJsonStrings
}).then(res => res.json)
.then(data => console.log(data))
.catch((err) =>{
  alert(err);
  console.log(err)
});
});
  