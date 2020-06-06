<%@ include file="../includes/jsp_jstl.jsp"%>
<html>

<head>
    <%@ include file="../includes/head.jsp"%>
    <title>Utilizatori</title>
</head>
<body>
    <div class="bmd-layout-container bmd-drawer-f-l" >
        <%@ include file="../includes/navbar_with_search.jsp"%>
        <main class="bmd-layout-content">
            <div class="container" style="background-color: #f2f2f2; overflow-x: scroll;">
                <div class="row">

                    <div class="col-sm-12"></div>

                </div>

                <div class="row"></div>
                <div class="row">
                    <div class="col-sm-12" style="margin-top: 30px">
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
