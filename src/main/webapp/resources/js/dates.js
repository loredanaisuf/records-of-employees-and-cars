function showDates(){
    console.log("from showDates")
    const calendarPath = "calendar?action=showDates";
    console.log(calendarPath)
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
            var strMap = JSON.stringify(Array.from(this.response));
            console.log("strmap: " + strMap);
            var mapObj = new Map(JSON.parse(strMap));
            console.log("mapObj: " + mapObj);
            var respData = JSON.parse(this.response)
            console.log("RespData: " + respData);
            console.log("HashMao: " + respData.listOfDates);
            // if(respData.exists == "true"){
            //     $("#errors").html("Utilizatorul exista deja");
            //     $("#errors").css("display", "block");
            // }else{
            //     $("#errors").html("");
            //     $("#errors").css("display", "none");
            // }
        }
    };
    xhttp.open("GET", calendarPath, true);
    xhttp.send();
}