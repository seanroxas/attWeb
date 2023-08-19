

function otpchk(){
  let otp = document.getElementById("otp");
  let key = document.getElementById("key");

  if(otp.value == ""){
    document.getElementById("errormessage").innerHTML = "Passwords do not match";
    return false;
  }
  if(otp.value != key.value){
    document.getElementById("errormessage").innerHTML = "Passwords do not match";
    return false;
  }
  return true;
}

function DeleteConfirm() {
  var txt ="Confirm Delete?";
  if (confirm(txt) == true){
	return true;
  } 
  else {
	return false;}
}

function colorstat() {
	const status = document.querySelectorAll("td");
  for (let i = 0; i < status.length; i++) { // iterate all thorugh td
      if (status[i].innerText == "1") { // check if td has desired value
          status[i].style.backgroundColor = "LawnGreen"; // if matches, change color
          status[i].innerHTML = 'Present';
          }
       else if(status[i].innerText=="0"){
			status[i].style.backgroundColor = "DarkSalmon";
			status[i].innerHTML = 'Absent';
}
}
}

function addchk(){
 let studentpass = document.getElementById("studentpass");
  let cpass = document.getElementById("cpass");

  if(studentpass.value != cpass.value){
    document.getElementById('errormessage').innerHTML = "Passwords do not match";
    return false;
  }
  return true
}

function addchk(){
  let studentpass = document.getElementById("studentpass");
   let cpass = document.getElementById("cpass");
 
   if(studentpass.value != cpass.value){
     document.getElementById('errormessage').innerHTML = "Passwords do not match";
     return false;
   }
   return true
 }
 
 function addminchk(){
  let pass = document.getElementById("password");
   let cpass = document.getElementById("admincpass");
 
   if(pass.value != cpass.value){
     document.getElementById('errormessage').innerHTML = "Passwords do not match";
     return false;
   }
   return true
 }

 function OTP(){
  let pass = document.getElementById("password");
 
   if(pass.value != cpass.value){
     document.getElementById('errormessage').innerHTML = "Passwords do not match";
     return false;
   }
   return true
 }

const characters ='ABCDEFGHIJKLMNOPQRSTUVWXYZ';
function generateString(length) {
    length = 5;
    let result = '';
    const charactersLength = characters.length;
    for ( let i = 0; i < length; i++ ) {
        result += characters.charAt(Math.floor(Math.random() * charactersLength));
    }
    document.getElementById("key").value = result;
    return result;
}

console.log(generateString(5));
