<%@ include file="../includes/jsp_jstl.jsp"%>
<!doctype html>
<html lang="en">
<head>
    <%@ include file="../includes/head.jsp"%>
    <title>Inregistrare companie</title>
</head>
<body >
<div class="container"  style="background-color: #f2f2f2;">
    <div class="row" style="align-items: center; margin-top: 10px;">

        <div class="col-sm-12" style="background-color: #660020;" >
            <h3 style="text-align: center;margin: 15px; color:white">~Inregistrare companie~</h3>
        </div>

        <div class="col-sm-2" ></div>
        <div class="col-sm-8" >
            <div style="align-items: center; background-color: #f2f2f2;">
                <form method="post" name="inregistrareCompanie">
                    <div class="alert alert-success" style="margin-top: 20px; display: <c:out value="${requestScope.displaySuccess}"/>" id="success">
                        <c:out value="${requestScope.success}"/>
                    </div>
                    <a href="${pageContext.request.contextPath}/login">
                        <button type="button" style="display: <c:out value="${requestScope.displayLogin}"/>; background-color: #660020; width: 300px; color:white; padding: 10px; margin: 20px;" >Logare</button>
                    </a>

                    <div class="alert alert-danger" style="display: <c:out value="${requestScope.displayError}"/>" id="errorsFirm">
                        <c:out value="${requestScope.error}"/>
                    </div>
                    <div class="form-group">
                        <label for="firma" style="font-weight:bold; margin-top: 30px;">Firma</label>
                        <input type="text"class="form-control" id="firma"   onkeyup="validateCompany()" name="firma" >
                    </div>
                    <div class="form-group">
                        <label for="utilizator" style="font-weight: bold;">Nume</label>
                        <input type="text"class="form-control" id="utilizator"  name="numeAdmin">
                    </div>
                    <div class="form-group">
                        <label for="prenume" style="font-weight: bold;">Prenume</label>
                        <input type="text"class="form-control" id="prenume"  name="prenumeAdmin">
                    </div>
                    <div class="form-group">
                        <label for="cod" style="font-weight: bold;">Cod de inregistrare</label>
                        <input type="text"class="form-control" id="cod"  name="cod">
                    </div>
                    <div class="form-group">
                        <label for="telefon" style="font-weight: bold;">Telefon</label>
                        <input type="text"class="form-control" id="telefon"  name="telefonAdmin">
                    </div>
                    <div class="form-group">
                        <label for="email" style="font-weight: bold;">Email</label>
                        <input type="text" class="form-control" id="email" onkeyup="validateEmail()" name="emailAdmin" >
                    </div>

                    <div class="form-group">
                        <label for="parola" style="font-weight: bold;">Parola</label>
                        <input type="password" class="form-control" id="parola" name="parolaAdmin">
                    </div>
                    <div class="form-group">
                        <label for="parolaConfirm" style="font-weight: bold;">Confirma parola</label>
                        <input type="password" class="form-control" id="parolaConfirm" name="parolaConfirmAdmin">
                    </div>

                    <div class="alert alert-danger" style="display: <c:out value="${requestScope.displayError}"/>" id="errors">
                        <c:out value="${requestScope.error}"/>
                    </div>

                    <button type="button" style="background-color: #660020; width: 300px; color:white; padding: 10px; margin: 20px; align-items: center; margin-bottom: 50px;" onclick="validateFormAdmin()" >Adauga</button>
                    <%--                    <button type="submit" style="background-color: #660020; width: 300px; color:white; padding: 10px; margin: 20px; align-items: center; margin-bottom: 50px;" >Adauga</button>--%>

                </form>
            </div>

            <div class="col-sm-2" ></div>
        </div>
    </div>

</div>
<jsp:include page="../includes/scripts_body.jsp"/>
<script type="text/javascript" src="resources/js/registerCompany.js"></script>
<script type="text/javascript" src="resources/js/registerCompany-validateEmail.js"></script>
<script type="text/javascript" src="resources/js/registerCompany-validateForm.js"></script>
</body>
</html>

