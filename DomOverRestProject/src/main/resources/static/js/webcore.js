function load() {
	console.log("OK");

	getComponent("app-root", "app-root");
}

function getComponent(tag, id) {
	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			document.getElementById(id).innerHTML = this.responseText;

			var list = document.getElementById(id).hasChildNodes();
			if (list > 0) {
				const children = document.getElementById(id).childNodes;
				const len = children.length;
				for (let i = 0; i < len; i++) {
					if (children[i].nodeName.toLowerCase().startsWith("app")) {
						getComponent(children[i].nodeName.toLowerCase(),
								children[i].id.toLowerCase());
					}
				}
			}
		}
	};
	xhttp.open("GET", "/" + tag, true);
	xhttp.send();
}