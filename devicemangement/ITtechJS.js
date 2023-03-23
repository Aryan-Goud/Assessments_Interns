function myFunction() {
    alert("Successfully Requested");
  }
          function showYesNo(clicked) {
          document.getElementById('item').setAttribute('value', clicked);
          // v.readOnly = false;
                  // var myvalue=clicked;
              }   
          // var myvalue = document.getElementById('');
          // var myvalue = "dvd";
          // document.getElementById('dvd').setAttribute('value', myvalue);
          // var myvalue = "Speakers";
          // document.getElementById('speaker').setAttribute('value', myvalue);
          // // var myvalue = "Mouse";
          // document.getElementById('mouse').setAttribute('value', myvalue);
          // // var myvalue = "Mainboard";
          // document.getElementById('mainboard').setAttribute('value', myvalue);
          // // var myvalue = "Keypad";
          // document.getElementById('keypad').setAttribute('value', myvalue);
          // function showYesNo(this.id){
          // 	var answer = "";
          // 	if (confirm("Are you sure?")) {
          // 		answer = "added";
          // 	} else {
          // 		answer = "Not added";
          // 	}
          // }
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
            window.location.href = "ITtech.html";
  
        });
    });