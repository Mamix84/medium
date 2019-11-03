

function load(){
	console.log("OK");

	  var xhttp = new XMLHttpRequest();
	  xhttp.onreadystatechange = function() {
	    if (this.readyState == 4 && this.status == 200) {
	     document.getElementById("app").innerHTML = this.responseText;
	    }
	  };
	  xhttp.open("GET", "/app", true);
	  xhttp.send();
}