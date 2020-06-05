<%@ include file="../includes/jsp_jstl.jsp"%>
<html>

<head>
    <%@ include file="../includes/head.jsp"%>
    <title>Utilizatori</title>
</head>
<body>
    <div class="bmd-layout-container bmd-drawer-f-l" >

        <header class="bmd-layout-header" style="background-color: #660020;">
            <div class="navbar navbar-light bg-faded">
                <button class="navbar-toggler" type="button" data-toggle="drawer" data-target="#dw-s1">
                    <span class="sr-only">Toggle drawer</span>
                    <i class="material-icons" style="color: white;">menu</i>
                </button>
                <span class="navbar-brand mb-0 h1" style=" color: white;">             </span>

                <form class="form-inline">
                    <input class="form-control mr-sm-2" id="input" type="search"  onkeyup="searchFunction()" placeholder="Cauta dupa nume" aria-label="Search">
                </form>

                <ul class="nav navbar-nav">
                    <li class="nav-item">
                        <a href="${pageContext.request.contextPath}/logout "data-toggle="tooltip" title="Deconectare" style="color: white; "><span class="material-icons">logout</span> </a>
                    </li>
                </ul>
            </div>
        </header>

        <div id="dw-s1" class="bmd-layout-drawer bg-faded" style="color: #660020;">
            <header>
                <a href="${pageContext.request.contextPath}/profil" class="navbar-brand " style="background-color: #660020; color: white; text-align: center;">Profilul tau</a>
            </header>
            <ul class="list-group">
                <a href="${pageContext.request.contextPath}/utilizatori" >
                    <p   class="menu-list" >
                        <i class="material-icons" style="color:#660020; margin-right: 20px; size: 1px;">person</i>Utilizatori</p>
                </a>
                <a href="${pageContext.request.contextPath}/calendar">
                    <p   class="menu-list" >
                        <i class="material-icons" style="color:#660020; margin-right: 20px; size: 1px;">today</i>Calendar</p>
                </a>
                <a href="${pageContext.request.contextPath}/masini">
                    <p   class="menu-list">
                        <i class="material-icons" style="color:#660020; margin-right: 20px; size: 1px;">directions_car</i>Masini</p>
                </a>
                <a href="${pageContext.request.contextPath}/remorci">
                    <p  class="menu-list" >
                        <i class="material-icons" style="color:#660020; margin-right: 20px; size: 1px;">local_shipping</i> Remorci</p>
                </a>
                <a href="${pageContext.request.contextPath}/locatii">
                    <p  class="menu-list">
                        <i class="material-icons" style="color:#660020; margin-right: 20px; size: 1px;">location_on</i>  Vezi locatiile</p>
                </a>
            </ul>
        </div>

        <main class="bmd-layout-content">
            <div class="container" style="background-color: #f2f2f2; overflow-x: scroll;">
                <div class="row">

                    <div class="col-sm-12"></div>

                </div>

                <div class="row"></div>
                <div class="row">
                    <div class="col-sm-12" style="margin-top: 40px">
                        <table class="table table-striped" id="tableUsers" >
                            <thead class=".thead-dark">
                            <tr >
                                <th scope="col">Nume</th>
                                <th scope="col">Prenume</th>
                                <th scope="col">Telefon</th>
                                <th scope="col">Nr inmatriculare masina</th>
                                <th scope="col">Email</th>
                                <th scope="col" style="display: ${requestScope.displayAdmin};" >Parola</th>
                                <th scope="col" style="display: none">Optiuni</th>
                                <th scope="col" style="display: none"></th>
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
                                    <td style="display: ${requestScope.displayAdmin};">${utilizator.parola}</td>
                                    <td>
                                        <a href="?action=edit&id=${utilizator.id} "data-toggle="tooltip" title="Editeaza" style="display: ${requestScope.displayAdmin};color: rgba(0, 0, 0, 0.54); "><span class="material-icons">edit</span> </a>
                                        <a href="?action=delete&id=${utilizator.id} "data-toggle="tooltip" title="Sterge" style="display: ${requestScope.displayAdmin};color: rgba(0, 0, 0, 0.54); "><span class="material-icons">delete</span></a>
                                    </td>
                                    <td>
                                        <a href="?action=pontaj&id=${utilizator.id} "data-toggle="tooltip" style="display: ${requestScope.displayAdmin};color: rgba(0, 0, 0, 0.54); align-content :center;  ">
                                            <button type="button" style="background-color: rgba(0, 0, 0, 0.54); color: white " >Ponteaza</button>
                                        </a>
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

<%--                        <button id = "find-me">Show my location</button><br/>--%>
                        <p id = "status"></p>
                        <a id = "map-link" target="_blank"></a>

                    </div>

                </div>
            </div>
        </main>
    </div>

    <script type="text/javascript" src="resources/js/maps.js?rndstr=<%= System.currentTimeMillis() %>"></script>

    <script>
        function searchFunction() {
            // Declare variables
            var input, filter, table, tr, td, i, txtValue;
            input = document.getElementById("input");
            filter = input.value.toUpperCase();
            table = document.getElementById("tableUsers");
            tr = table.getElementsByTagName("tr");

            // Loop through all table rows, and hide those who don't match the search query
            for (i = 0; i < tr.length; i++) {
                td = tr[i].getElementsByTagName("td")[0];
                if (td) {
                    txtValue = td.textContent || td.innerText;
                    if (txtValue.toUpperCase().indexOf(filter) > -1) {
                        tr[i].style.display = "";
                    } else {
                        tr[i].style.display = "none";
                    }
                }
            }
        }
    </script>
</body>
</html>
