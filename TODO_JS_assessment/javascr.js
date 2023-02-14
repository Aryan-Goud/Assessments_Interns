let tasks = {
    Exercising: 'done',
    GoingToBank: 'pending', 
    Breakfast: 'done', 
    AttendBirthdayParty: 'pending' 
};

var pt = document.querySelector('#pendingtasks');
var dt = document.querySelector('#donetasks');
var pending = pt.innerHTML;
var done = dt.innerHTML;
var list = document.querySelector('ul');
var count = document.querySelector('#todo');
var total = count.innerHTML;
Object.keys(tasks).forEach((i)=>{
    let li = document.createElement("li");
    li.innerText = i;
    list.appendChild(li);
    if (i == "Exercising")
    {
    li.classList.toggle('checked');
    }
    if (i == "Breakfast")
    {
        li.classList.toggle('checked');
    }
  })
  function btnclicked() {
    var l = document.createElement("li");
    var value = document.getElementById("inp").value;
    var t = document.createTextNode(value);
    l.appendChild(t);
    if (value === '') {
      var retVal = prompt("You haven't entered any task \r Enter Task: ", "Task name");
      var val=document.createTextNode(retVal);
      l.appendChild(val);
    }
    document.getElementById("task").appendChild(l);
    total++;
    count.innerHTML = total;
    pt.innerHTML = total-done;
    document.getElementById("inp").value = "";
  } 
  list.addEventListener('click', 
  function(listeners)
  {
    if (listeners.target.tagName === 'LI') 
    {
      listeners.target.classList.toggle('checked');
      done=document.querySelectorAll('.checked').length;
      dt.innerHTML=done;
      pt.innerHTML=total-done;
    }
  });
