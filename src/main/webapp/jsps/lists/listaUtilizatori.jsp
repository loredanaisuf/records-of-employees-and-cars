<%@ include file="../includes/jsp_jstl.jsp"%>
<html>

<head>
    <%@ include file="../includes/head.jsp"%>
    <title>Utilizatori</title>
</head>
<body>
    <div class="bmd-layout-container bmd-drawer-f-l" >
        <%@ include file="../includes/navbar.jsp"%>
        <main class="bmd-layout-content">
            <div class="container" style="background-color: #f2f2f2;">
                <div class="row">

                    <div class="col-sm-12">

                    </div>

                </div>

                <div class="row"></div>
                <div class="row">
                    <div class="col-sm-12">
                        <table class="table table-striped" style="margin-top: 40px;">
                            <thead class=".thead-dark">
                            <tr>
                                <th scope="col">Nume</th>
                                <th scope="col">Prenume</th>
                                <th scope="col">Telefon</th>
                                <th scope="col">Nr inmatriculare masina</th>
                                <th scope="col">Email</th>
                                <th scope="col">Parola</th>
                                <th scope="col">Optiuni</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="utilizator" items="${requestScope.UsersTobeDisplayed}">
                                <tr>
                                    <td>${utilizator.nume}</td>
                                    <td>${utilizator.prenume}</td>
                                    <td>${utilizator.telefon}</td>
                                    <td>${utilizator.id_masina}</td>
                                    <td>${utilizator.email}</td>
                                    <td>${utilizator.parola}</td>
                                    <td>
                                        <a href="?action=edit&id=${utilizator.id} "data-toggle="tooltip" title="Editeaza" style="display: ${requestScope.displayAdmin};color: rgba(0, 0, 0, 0.54); "><span class="material-icons">edit</span> </a>
                                        <a href="?action=delete&id=${utilizator.id} "data-toggle="tooltip" title="Sterge" style="display: ${requestScope.displayAdmin};color: rgba(0, 0, 0, 0.54); "><span class="material-icons">delete</span></a>
                                    </td>
                                </tr>
                            </c:forEach>


                            </tbody>
                        </table>
                    </div>
                </div>

                <div class="row">

                    <div class="col-sm-12">
                        <a href="?action=add">
                            <button type="button" style="display: ${requestScope.displayAdmin};background-color: #660020; color:white; padding: 10px; margin: 20px;" >Adauga angajat</button>
                        </a>
<%--                        <button type="button" style="display:none;background-color: #660020; color:white; padding: 10px; margin: 20px;" onclick="afisare()">Afiseaza din BD</button>--%>
                        <a href="${pageContext.request.contextPath}/pontaj">
                            <button type="button" style="display: ${requestScope.displayAdmin}; background-color: #660020; color:white; padding: 10px; margin: 20px;" >Pontaj</button>
                        </a>

                        <button id = "find-me">Show my location</button><br/>
                        <p id = "status"></p>
                        <a id = "map-link" target="_blank"></a>

                    </div>

                </div>
            </div>
        </main>
    </div>

<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>

-->
    <script type="text/javascript" src="resources/js/maps.js"></script>
</body>
</html>
