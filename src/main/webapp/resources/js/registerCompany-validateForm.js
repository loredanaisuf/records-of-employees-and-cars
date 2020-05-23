function validateFormAdmin(){
    console.log("from validateFormAdmin");
    const email = $("input[name=emailAdmin]").val();
    const firma = $("input[name=firma]").val();

    const parola = $("input[name=parolaAdmin]").val();
    const parolaConfirm = $("input[name=parolaConfirmAdmin]").val();

    if(firma.length == 0){
        $("#errors").html("Trebuie sa introduceti un nume pentru companie!");
        $("#errors").css("display","block");
        return false;
    }

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


    $("form[name=inregistrareCompanie]").submit();
}


