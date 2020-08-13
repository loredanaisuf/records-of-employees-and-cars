let emailCkeckTimeout;
function validateEmail() {
    console.log("from validateEmail");
    clearTimeout(emailCkeckTimeout);
    emailCkeckTimeout = setTimeout(checkEmailInDB,2000);
}

function checkEmailInDB(){
    console.log("from checkCompany")
    const email = $("input[name=emailAdmin]").val()
    const validatePath = "inregistrareCompanie?action=validate-email&emailAdmin=" + email
    console.log(validatePath)
    /* $.ajax({
         url: validateUserPath,
         success: function(result){
             //$("#div1").html(result);
             alert(result);
         }
     });*/

    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            console.log(this.response);
            var respData = JSON.parse(this.response)
            if(respData.exists == "true"){
                $("#errorsFirm").html("Aceast email exista deja");
                $("#errorsFirm").css("display", "block");
            }else{
                $("#errorsFirm").html("");
                $("#errorsFirm").css("display", "none");
            }
        }
    };
    xhttp.open("GET", validatePath, true);
    xhttp.send();
}
