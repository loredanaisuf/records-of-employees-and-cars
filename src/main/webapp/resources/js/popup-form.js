function openForm() {
    var html = "<form class=\"form-container\">";
    html +="<label for=\"data\">Data</label>";
    html +="<input type=\"date\" placeholder=\"Introdu data\" id=\"data\" name=\"data\" required>";
    html += "<label for=\"nr_km\">Numarul de km</label>";
    html += "<input type=\"text\" placeholder=\"Introdu nr de km\" id=\"nr_km\" name=\"numar_km\" required>";
    html += "<label for=\"cant\">Litri de motorina</label>";
    html += "<input type=\"text\" placeholder=\"Introdu caltitatea\" id=\"cant\" name=\"cantitate\" required>";
    html += "<button type=\"submit\" class=\"btn\">Adauga</button>";
    html += "<button type=\"button\" class=\"btn cancel\" onclick=\"closeForm()\">Inchide</button>";
    html += "</form>";
    document.getElementById("myForm").innerHTML = html;
    $("#myForm").css("display", "block");
}

function closeForm() {
    $("#myForm").css("display", "none");
}
