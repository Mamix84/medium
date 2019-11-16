function load() {
	console.log("OK - Framework");

	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			document.getElementById("app-root").innerHTML = this.responseText;
			getComponent("app-root", "app-root");
		}
	}
	xhttp.open("GET", "/app?tag=app-root", true);
	xhttp.send();

}

function getComponent(tag, tag_id) {

	if (document.getElementById(tag_id) == undefined)
		return;

	var list = document.getElementById(tag_id).hasChildNodes();
	if (list > 0) {
		const children = document.getElementById(tag_id).childNodes;
		const len = children.length;
		for (let i = 0; i < len; i++) {
			if (children[i] !== undefined) {
				id = children[i].id;

				if (id === undefined) {
					id = "";
				} else {
					id = id.toLowerCase();
				}

				if (children[i].nodeName.toLowerCase().startsWith("app")) {
					var xhttp = new XMLHttpRequest();
					xhttp.onreadystatechange = function() {
						if (this.readyState == 4 && this.status == 200) {
							document.getElementById(children[i].nodeName.toLowerCase()).innerHTML = this.responseText;
							getComponent(children[i].nodeName.toLowerCase(), id);
						}
					}
					xhttp.open("GET", "/app?tag="
							+ children[i].nodeName.toLowerCase(), true);
					xhttp.send();
				} else {
					getComponent(children[i].nodeName.toLowerCase(), id);
				}

			}
		}

	}
}

// function getComponent(tag, id) {
// var xhttp = new XMLHttpRequest();
// xhttp.onreadystatechange = function() {
// if (this.readyState == 4 && this.status == 200) {
// inspectComponent(id);
// }
// };
// if (tag.toLowerCase().startsWith("app")) {
// xhttp.open("GET", "/app?tag=" + tag, true);
// xhttp.send();
// } else {
// if (id !== undefined && id != "")
// inspectComponent(id);
// }
// }
//
// function inspectComponent(tag_id) {
// document.getElementById(tag_id).innerHTML = this.responseText;
//
// var list = document.getElementById(tag_id).hasChildNodes();
// if (list > 0) {
// const children = document.getElementById(tag_id).childNodes;
// const len = children.length;
// for (let i = 0; i < len; i++) {
// if (children[i] !== undefined) {
//
// id = children[i].id;
//
// if (id === undefined) {
// id = "";
// } else {
// id = id.toLowerCase();
// }
//
// getComponent(children[i].nodeName.toLowerCase(), id);
// }
// }
// }
// }
