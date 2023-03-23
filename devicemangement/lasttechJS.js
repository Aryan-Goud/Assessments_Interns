var count = 0;
fetch("http://localhost:8080/Device_Management/users/display")
  .then(response => response.json())
  .then(objectData => {
    console.log(objectData);
    let myTable = "";
    objectData.map((values) => {
      count += 1;
      myTable += `<tr id="trs${count}" onclick="clickedonrow(this)">
            <td>${count}</td>
            <td><a href="#" onclick="shows(this);" style="color: #333;" id="ai${count}">${values.systemid}</a></td>
            <td>${values.name}</td>
            <td>
      
      <button id="GFG_Button${count}" onclick="changepriority(this)"  data-target="#bb" data-toggle="modal"><span style='font-size:15px;'>&#10004;</span></button></td>    
       </td>     </tr>`;
    });

    var table = document.getElementById("table_body");
    table.innerHTML = myTable;
  })
//   $('#priority1').change(function(event){
//     var selectedcategory = $(this).children("option:selected").val();
//     sessionStorage.setItem("itemName",selectedcategory);
// });

// $('select').find('option[value='+sessionStorage.getItem('itemName')+']').attr('selected','selected');

// if (localStorage.getItem('selectedOption')) {
//   // Set the selected option to the value stored in localStorage
//   document.getElementById('priority1').value = localStorage.getItem('selectedOption');
// }
function clickedonrow(el){
  var uTable = document.getElementById('mytable');
  console.log(uTable)
  let row = el.rowIndex;
  console.log(row);
  console.log(document.getElementById('trs'+row))
  var oCells = uTable.rows.item(row).cells;
  let pselect = oCells[1].innerHTML
  let s="ai"+row
  let ps=document.getElementById(s).textContent
  console.log(ps)
  fetch("http://localhost:8080/Device_Management/status/display")
.then(response => response.json())
.then(objectData=>{

      var vv="DONE"
      console.log(objectData[row-1])
      for (i = 0; i < (objectData.length); i++){
        var v1= objectData[i].progress;
        var v1=v1.toUpperCase()
        let u=row
        console.log(vv,v1)
        if (v1==vv){
          // flag=0;
          
          // document.getElementById('systemid')
      // console.log(document.getElementById('email').value = objectData[1].email)
      console.log(v1+"hii");
      
      document.getElementById('GFG_Button'+u).style.backgroundColor ='green';
        
      }
      else{
        console.log(v1)
  document.getElementById('GFG_Button'+u).style.backgroundColor ='red';

    }
  }
  });
  shows(ps)
}
function changepriority(el) {
  var uTable = document.getElementById('mytable');
  console.log(uTable)
  let row = el.parentNode.parentNode.rowIndex;
  console.log(row);

  var oCells = uTable.rows.item(row).cells;
  let pselect = oCells[1].innerHTML
  let s="ai"+row
  let ps=document.getElementById(s).textContent
  console.log(ps)
    // var v=pselect.document.getElementById('priority1').value
  // console.log(v)
  // let priorityval = pselect.options
  // console.log(priorityval)
  // let sel = el.target
  // console.log(sel)
  // let desc = sel.options[sel.selectedIndex].text;
  // console.log(desc);
  document.getElementById('sysId').value=ps
  document.getElementById('sysId').readOnly = true;
  fetchdetails(ps)
}

// Store the selected option in localStorage when the user changes it
// console.log(document.getElementById('priority1'))
// document.getElementById('priority1').addEventListener('change', function () {
//   localStorage.setItem('selectedOption', this.value);
//   console.log(localStorage.getItem('selectedOption'))
// });



// if (localStorage.getItem('selectedOption')) {
//   // Set the selected option to the value stored in localStorage
//   document.getElementById('status1').value = localStorage.getItem('selectedOption');
// }

// Store the selected option in localStorage when the user changes it
// document.getElementById('status1').addEventListener('change', function () {
//   localStorage.setItem('selectedOption', this.value);
// });
//       $('select').change(function(){
//     alert($(this).data('id'));
// });
// var up = document.getElementById("GFG_UP");

// function getText() {
//   select = document.querySelector('#priority1');
//   output = select.value;
//   select2 = document.querySelector('#status1');
//   output2 = select2.value;
//   document.getElementById('priority').value = output;
//   document.getElementById('priority').readOnly = true;
//   document.getElementById('progress').value = output2;
//   document.getElementById('progress').readOnly = true;

// }

document.getElementById("priority1").addEventListener('change', (e)=>{
  let selected = e.target;
  let selectedval =  selected.value
  console.log(selectedval)
  document.getElementById('priority').value = selectedval
  console.log(document.getElementById('priority').value)
  let selecteds = e.target;
  let selectedvals =  selecteds.value
  console.log(selectedvals)
  document.getElementById('status').value = selectedvals
  console.log(document.getElementById('status').value)
})
document.getElementById("status1").addEventListener('change', (e)=>{
  let selecteds = e.target;
  let selectedvals =  selecteds.value
  console.log(selectedvals)
  document.getElementById('progress').value = selectedvals
  console.log(document.getElementById('progress').value)
})

// console.log(( "#priority option:selected" ).text());
function myFunction() {
  // Declare variables
  var input, filter, table, tr, td, i, txtValue;
  input = document.getElementById("myInput");
  filter = input.value.toUpperCase();
  table = document.getElementById("mytable");
  tr = table.getElementsByTagName("tr");

  // Loop through all table rows, and hide those who don't match the search query
  for (i = 0; i < tr.length; i++) {
    td = tr[i].getElementsByTagName("td")[2];
    if (td) {
      txtValue = td.textContent || td.innerText;
      if (txtValue.toUpperCase().indexOf(filter) > -1) {
        tr[i].style.display = "";
      } else {
        tr[i].style.display = "none";
      }
    }
  }
}
function fetchdetails(ps){
  var v=ps
// let v= document.getElementById('systemid');
console.log(v+"hii")
fetch("http://localhost:8080/Device_Management/status/display")
.then(response => response.json())
.then(objectData=>{
var flag=1;
for (i = 0; i < objectData.length; i++){
      // var store=console.log(objectData[i])
      // console.log(store)
      var v1= objectData[i].sysId;
      console.log(v1+"hello")
        if (v1==v){
          
          flag=0;
          // document.getElementById('systemid')
      // console.log(document.getElementById('email').value = objectData[1].email)
      document.getElementById('priority').value = objectData[i].priority;
      document.getElementById('priority').readOnly = true;
      document.getElementById('progress').value = objectData[i].progress;
      document.getElementById('progress').readOnly = true;
        break;
        
      }
}
if (flag==1){
  document.getElementById('priority').value = "";
  document.getElementById('priority').readOnly = false;
      document.getElementById('progress').value = "";
      document.getElementById('progress').readOnly = false;
      }

//   // objectData.map((values)=>{
  
});
// });
}
const myButton = document.getElementById("sub");


const form = document.getElementById('status');

form.addEventListener('submit', (e) => {
  e.preventDefault();

  const formData = new FormData(form);
  let formDataObject = Object.fromEntries(formData.entries());
  console.log(formDataObject.priority+"hello")
  delete formDataObject.priority1
  delete formDataObject.status1
  let formDataJsonString = JSON.stringify(formDataObject);
  console.log(formDataJsonString.progress)
  fetch("http://localhost:8080/Device_Management/status/display")
.then(response => response.json())
.then(objectData=>{
var flag=1;
for (i = 0; i < objectData.length; i++){
      // var store=console.log(objectData[i])
      // console.log(store)
      var v1= objectData[i].sysId;
      console.log(v1+"hello")
        if (v1==formDataObject.sysId)
        {
          flag=0;
          console.log("same sysid")
          

        fetch('http://localhost:8080/Device_Management/status/update', {
          method: 'PUT',
          //Set the headers that specify you're sending a JSON body request and accepting JSON response
          headers: {
            "Content-Type": "application/json",
            Accept: "application/json",
          },
          body: formDataJsonString
        }).then(res => res.json)
          .then(data => console.log(data))
          .catch((err) => {
            alert(err);
            console.log(err)
          });
                

        }
        colorchange();
}
if (flag==1){
  fetch('http://localhost:8080/Device_Management/status/create', {
    method: 'POST',
    //Set the headers that specify you're sending a JSON body request and accepting JSON response
    headers: {
      "Content-Type": "application/json",
      Accept: "application/json",
    },
    body: formDataJsonString
  }).then(res => res.json)
    .then(data => console.log(data))
    .catch((err) => {
      alert(err);
      console.log(err)
    });
    colorchange();
}
})
});

function submiting(){

}

//       const api_url = 
//       "http://localhost:8080/Device_Management/users/display";

// // Defining async function
// async function getapi(url) {

//     // Storing response
//     const response = await fetch(url);

//     // Storing data in form of JSON
//     var data = await response.json();
//     console.log(data);
//     if (response) {
//         hideloader();
//     }
//     show(data);
// }
// // Calling that async function
// getapi(api_url);


// var requestOptions = {
//   method: 'GET',
//   redirect: 'follow'
// };

// fetch("http://localhost:8080/Device_Management/users/display", requestOptions)
//   .then(response => response.json)
//   .then(result => {
//     console.log(result)
//   })
//   .catch(error => console.log('error', error));

// $(this).find(':selected').data('id')
function disi() {

  // document.getElementById('priority1').value = ;
}
function shows(ob) {
  fetch("http://localhost:8080/Device_Management/users/display")
    .then(response => response.json())
    .then(objectData => {
      // console.log(objectData);
      var v = ob;
      // console.log($(ob).text());
      // console.log(v)
      // var flag=1;
      for (i = 0; i < objectData.length; i++) {
        // var store=console.log(objectData[i])
        // console.log(store)
        var v1 = objectData[i].systemid;
        if (v == v1) {
          // flag=0;
          // document.getElementById('systemid')
          // console.log(document.getElementById('email').value = objectData[1].email)
          document.getElementById('description1').value = objectData[i].complaints;
          document.getElementById('description1').readOnly = true;
          document.getElementById('systemid1').value = objectData[i].systemid;
          document.getElementById('systemid1').readOnly = true;
          document.getElementById('name1').value = objectData[i].name;
          document.getElementById('name1').readOnly = true;
          break;

        }
      }
    }
    )
  fetch("http://localhost:8080/Device_Management/request/display")
    .then(response => response.json())
    .then(objectData => {
      // console.log(objectData);
      var v = ob;
      // console.log($(ob).text());
      // console.log(v)
      // var flag=1;
      var f = 1;
      for (i = 0; i < objectData.length; i++) {
        // var store=console.log(objectData[i])
        // console.log(store)
        var v1 = objectData[i].sysid;
        if (v == v1) {
          f = 0;
          // flag=0;
          // document.getElementById('systemid')
          // console.log(document.getElementById('email').value = objectData[1].email)
          var myreqs = objectData[i].item + ', ' + myreqs;
          var vm = myreqs.replace(', undefined', '');
          document.getElementById('request1').value = vm;
          document.getElementById('request1').readOnly = true;


        }
      }
      if (f == 1) {
        var y = "no request"
        document.getElementById('request1').value = y;
        document.getElementById('request1').readOnly = true;
      }
    }
    )
}



// function colorchange(){
// // let v= document.getElementById('systemid');
// // console.log(v)
// fetch("http://localhost:8080/Device_Management/users/display")
// .then(response => response.json())
// .then(objectData=>{
// // console.log(objectData);
// // let myTable="";
// // console.log(v)
// // console.log(objectData[1])
// // let v= document.getElementById('systemid');
// // console.log(v)
// var flag=1;
// for (i = 1; i < (objectData.length)+1; i++){
//       // var store=console.log(objectData[i])
//       // console.log(store)
//       fetch("http://localhost:8080/Device_Management/status/display")
// .then(response => response.json())
// .then(objectDatass=>{

//       var vv="DONE"
      
//       for (i = 1; i < (objectDatass.length)+1; i++){
//         var v1= objectDatass[i].progress;
//         var v1=v1.toUpperCase()
//         console.log(vv,v1)
//         if (v1.toUpperCase()==vv){
//           flag=0;
          
//           // document.getElementById('systemid')
//       // console.log(document.getElementById('email').value = objectData[1].email)
//       console.log(v1+"hii");
      
//       document.getElementById('GFG_Button'+i).style.backgroundColor ='green';
        
//       }
//       else{
//         console.log(v1)
//   document.getElementById('GFG_Button'+i).style.backgroundColor ='red';

//     }
//   }
//   });
// }
// // if(flag==1){
// //   console.log(v1)
// //   document.getElementById('GFG_Button').style.backgroundColor ='red';

// // }


// //   // objectData.map((values)=>{
  
// });
// // });
// }
