let usernameCkeckTimeout;
function validateUsername() {
    console.log("from validateUsername");
    clearTimeout(usernameCkeckTimeout);
    usernameCkeckTimeout = setTimeout(checkUsernameInDB,2000);
}

function checkUsernameInDB(){
    console.log("from checkUsername")
    const email = $("input[name=emailUtilizator]").val()
    const validateUserPath = "inregistrare?action=validate-email&emailUtilizator=" + email
    console.log(validateUserPath)
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
                $("#errors").html("Utilizatorul exista deja");
                $("#errors").css("display", "block");
            }else{
                $("#errors").html("");
                $("#errors").css("display", "none");
            }
        }
    };
    xhttp.open("GET", validateUserPath, true);
    xhttp.send();
}
