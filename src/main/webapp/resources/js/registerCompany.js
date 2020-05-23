let companyCkeckTimeout;
function validateCompany() {
    console.log("from validateComoany");
    clearTimeout(companyCkeckTimeout);
    companyCkeckTimeout = setTimeout(checkCompanyInDB,2000);
}

function checkCompanyInDB(){
    console.log("from checkCompany")
    const firma = $("input[name=firma]").val()
    const validatePath = "inregistrareCompanie?action=validate-company&firma=" + firma
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
                $("#errors").html("Aceasta firma este deja inregistrata");
                $("#errors").css("display", "block");
            }else{
                $("#errors").html("");
                $("#errors").css("display", "none");
            }
        }
    };
    xhttp.open("GET", validatePath, true);
    xhttp.send();
}
