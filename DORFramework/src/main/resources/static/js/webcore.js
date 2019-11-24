function load(appCode) {
	console.log("OK - Framework");

	var node = document.body;
	getComponent(node, appCode);

}

function getComponent(node, appCode) {

	const children = node.childNodes;
	const len = children.length;
	for (let i = 0; i < len; i++) {
		if (children[i].nodeType == 3
				&& children[i].nodeValue.trim().startsWith('@' + appCode)) {

			
			
			var xhttp = new XMLHttpRequest();
			xhttp.onreadystatechange = function() {
				if (this.readyState == 4 && this.status == 200) {
					var template = document.createElement('template');
					
					node.removeChild(children[i]);
					
					var response = JSON.parse(this.responseText.trim()); 
					
					template.innerHTML = response.html;
					node.appendChild(template.content.firstChild);
					
					getComponent(document.getElementById(response.id), appCode);
				}
			}
			var tag = children[i].nodeValue.trim().slice(1);

			xhttp.open("GET", "/app?tag=" + tag, true);
			xhttp.send();

		}
	}
}

function postEvent(tag, tag_id) {
	console.log("POST EVENT");

	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {

		}
	}

	xhttp.open("POST", "/app?tag=" + tag, true);
	xhttp.send();
}