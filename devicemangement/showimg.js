
function show()
{
	if (document.getElementById)
	document.getElementById("blink1").style.visibility = "visible";
  document.getElementById("blink2").style.visibility = "visible";
  document.getElementById("blink3").style.visibility = "visible";
}
// blink "off" state
function hide()
{
	if (document.getElementById)
	document.getElementById("blink1").style.visibility = "hidden";
  document.getElementById("blink2").style.visibility = "hidden";
  document.getElementById("blink3").style.visibility = "hidden";
}
// toggle "on" and "off" states every 450 ms to achieve a blink effect
// end after 4500 ms (less than five seconds)
for(var i=900; i < 4500; i=i+900)
{
	setTimeout("hide()",i);
	setTimeout("show()",i+450);
}




let counter = 0;
let pending = 0;

fetch("http://localhost:8080/Device_Management/users/display")
  .then(response => response.json())
  .then(data => {
    counter = data.length;
    console.log(counter + "count");
  });

fetch("http://localhost:8080/Device_Management/status/display")
  .then(response => response.json())
  .then(data => {
    const doneTasks = data.filter(task => task.progress === "Done");
    const notDoneTasks = data.filter(task => task.progress !== "Done");
    const doneCount = doneTasks.length;
    const notDoneCount = notDoneTasks.length;
    const doneCountBox = document.querySelector('.task-count:nth-of-type(1) .count');
    doneCountBox.textContent = doneCount;
    const notDoneCountBox = document.querySelector('.task-count:nth-of-type(2) .count');
    notDoneCountBox.textContent = notDoneCount;
    const vv = doneCount + notDoneCount;
    console.log(vv + "vv");
    console.log(counter + "hii");
    pending = counter - vv;
    console.log(pending + "asfd");
    document.getElementById("demo").innerHTML = `${pending}`;
    // Call a separate function that needs the updated value of pending
    doSomethingWithPending(pending);
  });

function doSomethingWithPending(pending) {
  console.log("Pending tasks: " + pending);
  // Do something with the updated value of pending
}



fetch("http://localhost:8080/Device_Management/status/display")
  .then(response => response.json())
  .then(data => {
    // Create a new button element
    
    const element = document.getElementById("tt1");

    // Add an event listener to the button
    element.addEventListener("click", () => {
      // function down(){

      
      // Filter objects with progress "Done"
      const filteredData = data.filter(item => item.progress === "Done");

      // Create a new PDF document
      const doc = new jsPDF();
let c=1;
      // Set the document properties
      doc.setProperties({
        title: "Filtered Data",
        subject: "Data with progress 'Done'",
        author: "Your Name",
        keywords: "Filtered Data, Progress Done",
      });

      // Define the table headers
      const headers = [["S_no","SystemID","name","Complaint","Status"]];
      var dataRows=[]

      // Fetch user data and format the table rows
      fetch("http://localhost:8080/Device_Management/users/display")
        .then(response => response.json())
        .then(users => {
          filteredData.forEach(item => {
            const user = users.find(u => u.systemid === item.sysId);
            if (user) {
              dataRows.push([c++,item.sysId, user.name, user.complaints, item.progress]);
            }
          });

          // Add the table to the document
          doc.autoTable({
            head: headers,
            body: dataRows,
          });

          // Save the document as a PDF file
          doc.save("Data_Done.pdf");
        });
    });
       // Append the button to the document
      //  document.body.appendChild(button);
  });



  fetch("http://localhost:8080/Device_Management/status/display")
  .then(response => response.json())
  .then(data => {
    // Create a new button element
    const element = document.getElementById("tt2");

    // Add an event listener to the button
    element.addEventListener("click", () => {
      // Filter objects with progress "Done"
      const filteredData = data.filter(item => item.progress === "Not Done");

      // Create a new PDF document
      const doc = new jsPDF();

      // Set the document properties
      doc.setProperties({
        title: "Filtered Data",
        subject: "Data with progress 'Not Done'",
        author: "Your Name",
        keywords: "Filtered Data, Progress Done",
      });
      let c=1
      // Define the table headers
      const headers = [["S_no", "System_ID","Name", "Complaint", "Status" ]];
      var dataRows=[]

      // Fetch user data and format the table rows
      fetch("http://localhost:8080/Device_Management/users/display")
        .then(response => response.json())
        .then(users => {
          filteredData.forEach(item => {
            const user = users.find(u => u.systemid === item.sysId);
            if (user) {
              dataRows.push([c++,item.sysId, user.name, user.complaints, item.progress]);
            }
          });

          // Add the table to the document
          doc.autoTable({
            head: headers,
            body: dataRows,
          });

          // Save the document as a PDF file
          doc.save("Data_Not_Done.pdf");
        });
    });

    // Append the button to the document
    // document.body.appendChild(button);
  });
  




  fetch("http://localhost:8080/Device_Management/status/display")
  .then(response => response.json())
  .then(statuses => {
    // Fetch all user data
    fetch("http://localhost:8080/Device_Management/users/display")
      .then(response => response.json())
      .then(users => {
        // Find users that are not present in either "Done" or "Not Done"
        const filteredUsers = users.filter(user =>
          !statuses.some(status => status.sysId === user.systemid)
        );

        // Create a new button element
        const element = document.getElementById("tt");

    // Add an event listener to the button
    element.addEventListener("click", () => {
          // Create a new PDF document
          const doc = new jsPDF();

          // Set the document properties
          doc.setProperties({
            title: "Filtered Users",
            subject: "Users not present in 'Done' or 'Not Done' status",
            author: "Your Name",
            keywords: "Filtered Users, Status",
          });
          const sub="hiii"
          // Define the table headers
          const headers = [["System ID","Name", "Email","Complaint"]];

          // Format the table rows
          const dataRows = filteredUsers.map(user => [user.systemid,user.name, user.email,user.complaints ]);

          // Add the table to the document
          doc.autoTable({
            head: headers,
            body: dataRows,
          });

          // Save the document as a PDF file
          doc.save("Data_Not_Visited.pdf");
        });

        // Append the button to the document
        // document.body.appendChild(button);
      });
  });







fetch("http://localhost:8080/Device_Management/status/display")
  .then(response => response.json())
  .then(data => {
    const doneTasks = data.filter(task => task.progress === "Done");
    const notDoneTasks = data.filter(task => task.progress !== "Done");
    const pending = document.getElementById("demo").innerHTML;

    const ctx = document.createElement('canvas');
    const chartContainer = document.getElementById('myChartContainer');
    chartContainer.appendChild(ctx);

    const chart = new Chart(ctx, {
      type: 'pie',
      data: {
        labels: ['Done', 'Not Done', 'Pending'],
        datasets: [{
          data: [doneTasks.length, notDoneTasks.length, pending],
          backgroundColor: [
          'rgba(135, 211, 124, 0.8)', //green
            
            'rgba(0, 148, 255, 0.8)', // Blue
            'rgba(245, 105, 84, 0.8)'//red
          ],
          borderColor: [
          'rgba(135, 211, 124, 1)',
            
            'rgba(0, 148, 255, 1)',
            'rgba(245, 105, 84, 1)'
          ],
          borderWidth: 1
        }]
      },
      options: {
        responsive: true,
        maintainAspectRatio: false,
        title: {
          display: true,
          text: 'Task Progress',
          fontSize: 20,
          fontColor: '#333'
        },
        legend: {
          display: true,
          position: 'bottom',
          labels: {
            fontColor: '#333'
          }
        },
        tooltips: {
          callbacks: {
            label: function(tooltipItem, data) {
              var label = data.labels[tooltipItem.index];
              var value = data.datasets[0].data[tooltipItem.index];
              return `${label}: ${value}`;
            }
          }
        }
      }
    });
  });
