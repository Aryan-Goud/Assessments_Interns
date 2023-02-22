var results = '';
var f=1;
var a=['+','/','*','-','.'];
function put(value) {
    if (f==0 && a.indexOf(value)== -1){
        results='';
    }
    f=1;
	results += value;
	document.getElementById('element').value = results;
}

function Screenclear() {
	results = '';
	document.getElementById('element').value = results;
}

function backspace() {
	results = results.slice(0, -1);
	document.getElementById('element').value = results;
}

function calculate() {
    
	try {
        f=0;
		results = eval(results);
		document.getElementById('element').value = results;
	} catch (error) {
		results = '';
		document.getElementById('element').value = 'Enter valid operations';
	}
}
