<%@ include file="../includes/jsp_jstl.jsp"%>
<!doctype html>
<html lang="en">
<head>
    <%@ include file="../includes/head.jsp"%>
    <title>Editare profil</title>
</head>
<body >
<div class="container"  style="background-color: #f2f2f2;">
    <div class="row" style="align-items: center; margin-top: 10px;">

        <div class="col-sm-12" style="background-color: #660020;" >
            <h2 style="text-align: center;margin: 15px; color:white">~Editare profil~</h2>
        </div>

        <div class="col-sm-2" ></div>
        <div class="col-sm-8" >
            <div style="align-items: center; background-color: #f2f2f2;">
                <form method="post">
<%--                    <div class="form-group">--%>
<%--                        <label for="firma" style="margin-top: 30px;" >Firma</label>--%>
<%--                        <input type="text"class="form-control" id="firma"  name="firma" aria-describedby="emailHelp" value="${requestScope.UserToEdit.nume}">--%>
<%--                    </div>--%>
                    <div class="form-group">
                        <label for="utilizator" style="margin-top: 30px;" >Nume</label>
                        <input type="text"class="form-control" id="utilizator"  name="nume" aria-describedby="emailHelp" value="${requestScope.UserToEditProfile.nume}">
                    </div>
                    <div class="form-group">
                        <label for="prenume" style="color: black;">Prenume</label>
                        <input type="text"class="form-control" id="prenume"  name="prenume" aria-describedby="emailHelp" value="${requestScope.UserToEditProfile.prenume}">
                    </div>
                    <div class="form-group">
                        <label for="telefon" >Telefon</label>
                        <input type="text"class="form-control" id="telefon"  name="telefon" aria-describedby="emailHelp" value="${requestScope.UserToEditProfile.telefon}">
                    </div>
                    <div class="form-group">
                        <label for="email" >Email</label>
                        <input type="text" class="form-control" id="email" name="email" onkeyup="validateUsername()" value="${requestScope.UserToEditProfile.email}">
                    </div>

                    <div class="form-group">
                        <label for="parola">Parola</label>
                        <input type="text" class="form-control" id="parola" name="parola" value="${requestScope.UserToEditProfile.parola}">
                    </div>

                    <button type="submit" style="background-color: #660020; width: 300px; color:white; padding: 10px; margin: 20px; align-items: center; margin-bottom: 50px;" >Editeaza</button>
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


