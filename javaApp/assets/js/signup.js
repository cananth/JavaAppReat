var check = function() {
  if (document.getElementById('password').value !=
    document.getElementById('confirm_password').value) {
    document.getElementById('message').style.color = 'red';
    document.getElementById('message').innerHTML = 'password not matching';
  } else if ((document.getElementById('password').value == "") && (document.getElementById('confirm_password').value == "")) {
	  document.getElementById('message').innerHTML = '';
	 } else {
		document.getElementById('message').style.color = 'green';
    document.getElementById('message').innerHTML = 'password is matching!--';
 }  
}
 function Validate() {
        var password = document.getElementById('password').value;
        var confirmPassword = document.getElementById('confirm_password').value;
        if (password != confirmPassword) {
            alert("Passwords do not match.");
            return false;
        }
        return true;
    }
    
var validate = function() {
	if ((document.getElementById('name').value == "Guest") || (document.getElementById('name').value == "guest")) {
	document.getElementById('namemessage').style.color = 'red';
	document.getElementById('namemessage').innerHTML = 'Guest cannot be the username!';
	} else {
		document.getElementById('namemessage').innerHTML = '';
	}
}	
