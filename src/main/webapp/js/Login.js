/**
 * 
 */
console.log("js loaded");
//document.getElementById("loginButton").addEventListener("submit",submit);
//var user;

function submit() {
	alert("button clicked");
	var type = document.getElementsByClassName("option");
	var xhr = new XMLHttpRequest();
	var callback;
	if(type.value="login"){
		callback=login;
	}else{
		callback=register;
	}
	var json = {
		username:document.getElementById("username"),
		password:document.getElementById("password")
	};
	json = JSON.stringify(json);
	xhr.onreadystatechange = callback;
	xhr.open("GET","http://localhost:8080/Banking/rest/user/login");
	xhr.setRequestHeader("credentials",json);
	xhr.send();
	
	function login(){
		if(xhr.readyState==4&&xhr.status==200){
			console.log("response recieved");
			localStorage.setItem("user", xhr.responseText);
			window.location.href= "customerlanding.jsp";
		}
	}
	function register(){
		
	}
}