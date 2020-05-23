<%@ include file="../includes/jsp_jstl.jsp"%>
<html>
<head>
    <%@ include file="../includes/head.jsp"%>
    <title>Profil</title>
</head>

<body>
<div class="bmd-layout-container bmd-drawer-f-l" >
    <%@ include file="../includes/navbar.jsp"%>
    <main class="bmd-layout-content">
        <div class="container" style="margin-top: 100px;">
            <div class="row">
                <div class="col-sm-2"></div>
                <div class="col-sm-8" style="background-color: #f2f2f2; padding-top: 20px; padding-bottom: 20px; ">
                    <table class="table table-bordered">
                        <tbody>
                        <tr>
                            <th scope="row">Nume</th>
                            <td>${requestScope.user.nume}</td>

                        </tr>
                        <tr>
                            <th scope="row">Prenume</th>
                            <td>${requestScope.user.prenume}</td>
                        </tr>
                        <tr>
                            <th scope="row">Email</th>
                            <td>${requestScope.user.email}</td>
                        </tr>
                        <tr>
                            <th scope="row">Parola</th>
                            <td>${requestScope.user.parola}</td>
                        </tr>
                        <tr>
                            <th scope="row">Telefon</th>
                            <td>${requestScope.user.telefon}</td>
                        </tr>
                        </tbody>
                    </table>
                    <a href="?action=edit">
                        <button type="button" style="background-color: #660020; color:white; padding: 10px; width: 25%; align-content: center; margin-top: 20px" >Editeaza</button>
                    </a>
                </div>
            </div>
            <div class="col-sm-2"></div>
        </div>
    </main>
</div>
</body>
</html>
