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
      //  clickedonrow(el)
    });

    var table = document.getElementById("table_body");
    table.innerHTML = myTable;
  })


function emailing(){
  fetch("http://localhost:8080/Device_Management/users/display")
  .then(response => response.json())
  .then(objectData => {
    console.log(objectData);
    let myopt = "";
    let arrays=[]
    // let count=0;
    objectData.map((values) => {
      // count += 1;
      
      console.log(arrays)
      if (arrays.includes(values.systemid)){

      }
      else{
      myopt += `<option id=${values.systemid}>${values.systemid}</option>`;
      //  clickedonrow(el)
      arrays.push(values.systemid);
    }
    });
    
    var sele = document.getElementById("myopt");
    sele.innerHTML = myopt;



  })
}





document.getElementById("myopt").addEventListener('change', (e)=>{
  let selected = e.target;
  let selectedval =  selected.value
  console.log(selectedval)
  document.getElementById('systemsid1').value = selectedval
  console.log(document.getElementById('systemsid1').value)

  fetch("http://localhost:8080/Device_Management/users/display")
  .then(response => response.json())
  .then(objectData => {
    console.log(objectData);
    // let myopt = "";
    // let arrays=[]
    // let count=0;
    objectData.map((values) => {
      // count += 1;
      
      // console.log(arrays)
      if (selectedval==values.systemid){
        document.getElementById('email1').value = values.email;
        console.log(values.name)
        var vv=document.getElementById('nam').value = values.name;
        console.log(`${document.getElementById('email1').value}`)
      
      }
    //   else{
    //   myopt += `<option id=${values.systemid}>${values.systemid}</option>`;
    //   //  clickedonrow(el)
    //   arrays.push(values.systemid);
    // }
    });
  })


})


const myButtons = document.getElementById("su");


const forms = document.getElementById('mailing');

forms.addEventListener('submit', (e)=>{
e.preventDefault();

const formDatass = new FormData(forms);
let formDataObjectss = Object.fromEntries(formDatass.entries());
let formDataJsonString = JSON.stringify(formDataObjectss);
// console.log(formDataObject.email)

console.log(formDataObjectss.email1);


  Email.send({
    Host : "smtp.elasticemail.com",
    Username : "aryan.gollapelly@wavemaker.com",
    Password : "2D4B24DF4805DC5340CA4749B6BEA5B1B7C1",
    To :`${formDataObjectss.email1}`,
    // console.log(formDataObject.email);
    From : 'aryan.gollapelly@wavemaker.com',
    Subject : "Greetings from Technician!!",
    Body :document.getElementById("body1").value
    }).then(
    message => alert("message sent successfully")
    
    );

    console.log(document.getElementById('email1').value);    

}

)
// function fetchSys

// var bt = document.getElementById('su');
// var j1=document.getElementById('email1').value;
//         // console.log(values.name)
// var j2=document.getElementById('nam').value;
// var j3=document.getElementById('systemsid1').value;
// console
// if (j1.length==0 || j2.length==0 || j3.length==0){
//   bt.disabled=true;
            
            
//             bt.style.cursor='no-drop'
            
// }
// else{
//   bt.disabled=true;
//   bt.style.cursor='pointer'
// }



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
  console.log(ps+"hi")
  fetch("http://localhost:8080/Device_Management/status/display")
.then(response => response.json())
.then(objectData=>{

      var vv="DONE"
      // console.log(objectData[row-1])
      for (i = 0; i < (objectData.length); i++){
        
        
        
        let u=row
        // console.log(vv,v1)
        if (objectData[i].sysId == ps){

          // flag=0;
          var v1= objectData[i].progress;
          var v1=v1.toUpperCase()
          // console.log(v1+"this is data")
          if(v1==vv)
          {
            // console.log(v1+"hii");
            // console.log(vv+"h");
            // localStorage.
            // document.getElementById('GFG_Button'+u).style.backgroundColor ='green';
            break

          }
          else{
            // console.log(v1)
            // document.getElementById('GFG_Button'+u).style.backgroundColor ='red';
            break
          }
          // document.getElementById('systemid')
      // console.log(document.getElementById('email').value = objectData[1].email)
      
      }
      else{
        document.getElementById('GFG_Button'+u).style.backgroundColor ='white'
    }
  }
  });
  shows(ps,row)
}
let row;
function changepriority(el) {
  var uTable = document.getElementById('mytable');
  console.log(uTable)
  row = el.parentNode.parentNode.rowIndex;
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
  console.log(row+"ur row");
  fetchdetails(ps,row)
}

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
function fetchdetails(ps,roww){
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
      var b1=objectData[i].uId
      console.log(v1+"hello")
        if (v1==v && (roww+49)==b1){
          console.log(b1,"sno",roww)
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
// let ro;
// function clickedonrow(el){
//   var uTable = document.getElementById('mytable');
//   console.log(uTable)
//   let ro = el.rowIndex;
//   console.log(ro,"this is not");
// }

const myButton = document.getElementById("sub");


const form = document.getElementById('status');
var flag=1;
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

  
  
//   fetch("http://localhost:8080/Device_Management/users/display")
//   .then(response => response.json())
//   .then(objectDatass=>{






// for (i = 0; i < objectDatass.length; i++){
//   var v6= objectDatass[i].systemid;
//   var b1=objectDatass[i].s_no;
//   console.log(formDataObject.sysId,"how is this",v6)
//   console.log(row,b1,"sdahksdfkhl")
//   if (v6==formDataObject.sysId && row==b1)
//         {
//          b1=objectDatass[i].s_no;
//           uId=b1;
//           console.log(formDataObject,"from")
//           console.log(uId)
//         }
// }
// console.log(b1)
//   });



  
console.log(b1,"userid");
for (i = 0; i < objectData.length; i++){
      // var store=console.log(objectData[i])
      // console.log(store)
      var v1= objectData[i].sysId;
      var b1=objectData[i].uId;
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
        // clickedonrow(el);
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
    // clickedonrow(el);
}
})
});

function submiting(){
  
  // document.getElementById('progress').value = " ";
  
  // document.getElementById('priority').value = " ";
  // document.getElementById('sysID').value = " ";
  // document.getElementById('name').value = " ";

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
function shows(ob,roww) {
  
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
        var b1=objectData[i].s_no;
        if (v == v1 && (roww+49)==b1) {
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
          // var vm = myreqs.replace(', undefined', '');
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
