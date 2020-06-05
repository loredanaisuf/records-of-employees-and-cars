<%@ include file="../includes/jsp_jstl.jsp"%>

<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

    <title>Adaugare</title>
</head>
<body  >
<!-- style="background-color:#660020 "
    style="background-image: url('./bg2.jpg');"
-->
<div class="container"  style="background-color: #f2f2f2;">
    <div class="row" style="align-items: center; margin-top: 10px;">

        <div class="col-sm-12" style="background-color: #660020;" >
            <h2 style="text-align: center;margin: 15px; color:white">~${requestScope.UserToEdit eq null ? 'Adaugare' : 'Editare'} Angajat~</h2>
        </div>

        <div class="col-sm-2" ></div>
        <div class="col-sm-8" >

            <div style="align-items: center; background-color: #f2f2f2;">
                <form method="post" name="inregistrare">
                    <div class="alert alert-danger" style="display: <c:out value="${requestScope.displayError}"/>" id="errors">
                        <c:out value="${requestScope.error}"/>
                    </div>
                    <div class="form-group">
                        <label for="utilizator" style="font-weight:bold; margin-top: 30px;" >Nume</label>
                        <input type="text"class="form-control" id="utilizator"  name="numeUtilizator" aria-describedby="emailHelp" value="${requestScope.UserToEdit.nume}">
                    </div>
                    <div class="form-group">
                        <label for="prenume" style="font-weight: bold;">Prenume</label>
                        <input type="text"class="form-control" id="prenume"  name="prenumeUtilizator" aria-describedby="emailHelp" value="${requestScope.UserToEdit.prenume}">
                    </div>
                    <div class="form-group">
                        <label for="id_masina" style="font-weight: bold;">Numarul de inmatriculare al masinii</label>
                        <input type="text"class="form-control" id="id_masina"  name="idMasinaUtilizator" aria-describedby="emailHelp" value="${requestScope.UserToEdit.id_masina}">
                    </div>
                    <div class="form-group">
                        <label for="telefon" style="font-weight: bold;">Telefon</label>
                        <input type="text"class="form-control" id="telefon"  name="telefonUtilizator" aria-describedby="emailHelp" value="${requestScope.UserToEdit.telefon}">
                    </div>
                    <div class="form-group">
                        <label for="email" style="font-weight: bold;">Email</label>
                        <input type="text"class="form-control" id="email"  name="emailUtilizator" aria-describedby="emailHelp" value="${requestScope.UserToEdit.email}" onkeyup="validateUsername()">
                    </div>
                    <div class="form-group">
                        <label for="parola" style="font-weight: bold;">Parola</label>
                        <input type="password" class="form-control" id="parola" name="parolaUtilizator" value="${requestScope.UserToEdit.parola}">
                    </div>
                    <div class="form-group">
                        <label for="parolaConfirm" style="font-weight: bold;">Confirma parola</label>
                        <input type="password" class="form-control" id="parolaConfirm" name="parolaConfirmUtilizator" value="${requestScope.UserToEdit.parola}">
                    </div>

                     <button type="button" style="background-color: #660020; width: 300px; color:white; padding: 10px; margin: 20px; align-items: center; margin-bottom: 50px;" onclick="validateForm()">${requestScope.UserToEdit eq null ? 'Adauga' : 'Edit'}</button>
<%--                    <button type="submit" style="background-color: #660020; width: 300px; color:white; padding: 10px; margin: 20px; align-items: center; margin-bottom: 50px;" >Adauga</button>--%>

                </form>
            </div>

            <div class="col-sm-2" ></div>
        </div>
    </div>

</div>
<jsp:include page="../includes/scripts_body.jsp"/>
</body>
</html>
