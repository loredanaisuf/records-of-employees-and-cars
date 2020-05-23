

function validateForm(){
    console.log("from validateForm");
    const email = $("input[name=emailUtilizator]").val();

    const parola = $("input[name=parolaUtilizator]").val();
    const parolaConfirm = $("input[name=parolaConfirmUtilizator]").val();

    if(email.length == 0){
        $("#errors").html("Email-ul nu trebuie sa fie nul!");
        $("#errors").css("display","block");
        return false;
    }
    if(parola.length == 0){
        $("#errors").html("Parola nu trebuie sa fie nula!");
        $("#errors").css("display","block");
        return false;
    }

    if(parola != parolaConfirm){
        $("#errors").html("Parolele nu se potrivesc!");
        $("#errors").css("display", "block");
        return false;
    }


    $("form[name=inregistrare]").submit();
}


