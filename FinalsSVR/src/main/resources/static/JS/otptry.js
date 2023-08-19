function otpchk(){
    let otp = document.getElementById("otp").value;
    let key = document.getElementById("key").value;
  
    if(otp.value == ""){
      document.getElementById('errormessage').innerHTML = "Passwords do not match";
      return false;
    }
    if(otp.value != key.value){
      document.getElementById('errormessage').innerHTML = "Passwords do not match";
      return false;
    }
    return true;
  }