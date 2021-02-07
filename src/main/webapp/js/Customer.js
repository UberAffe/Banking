/**
 * 
 */
var user
window.onload = ()=>{
	user = JSON.parse(localStorage.getItem("user"));
	setupAccounts();
}

function setupAccounts(){
	var accounts = user.accounts;
	for(account in accounts){
		;
	}
}