<%@ include file="../includes/jsp_jstl.jsp"%>
<html>
    <head>
        <%@ include file="../includes/head.jsp"%>
        <title>Masini</title>
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
                        <input class="form-control mr-sm-2" id="input" type="search"  onkeyup="searchCars()" placeholder="Cauta dupa nume" aria-label="Search">
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
                        <div class="col-sm-12">
                            <input type="text" id="myInput" onkeyup="searchCars()" placeholder="Search for names..">

                        </div>
                    </div>

                     <div class="row"></div>
                     <div class="row">
                        <table class="table table-striped" id="tableCars" style="margin-top: 10px;">
                            <thead class=".thead-dark">
                            <tr>
                                <th scope="col">NrInmatriculare</th>
                                <th scope="col">Optiuni</th>
                                <th scope="col">Informatii</th>
                                <th scope="col">Grafice</th>
                                <th scope="col">Marca</th>
                                <th scope="col">AnFabricatie</th>
                                <th scope="col">ITP</th>
                                <th scope="col">AsigurareRCA</th>
                                <th scope="col">AsigurareCasco</th>
                                <th scope="col">Rovigieta</th>
                            </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="masina" items="${requestScope.CarsTobeDisplayed}">
                                    <tr>
                                        <th>${masina.nrInmatriculare}</th>
                                        <td>
                                            <span>
                                                <a href="?action=editMasina&id=${masina.nrInmatriculare} " title="Editeaza" style="color: rgba(0, 0, 0, 0.54); "><span class="material-icons">edit</span> </a>
                                                <a href="?action=deleteMasina&id=${masina.nrInmatriculare} "data-toggle="tooltip" title="Sterge" style="display: ${requestScope.displayAdmin};color: rgba(0, 0, 0, 0.54); align-content :center;  "><span class="material-icons">delete</span></a>
                                            </span>
                                        </td>
                                        <td>
                                            <a href="?action=addInf&id=${masina.nrInmatriculare}" title="Adauga" style="color: rgba(0, 0, 0, 0.54); " onclick="openForm()"><span class="material-icons" style="align-content: center;">add</span></a>
                                            <a href="?action=seeInf&id=${masina.nrInmatriculare} "data-toggle="tooltip" title="Vezi informatiile" style="color: rgba(0, 0, 0, 0.54); " > <span class="material-icons" style="align-content: center;">info</span></a>
                                        </td>
                                        <td>
                                            <a href="?action=information&id=${masina.nrInmatriculare} "data-toggle="tooltip" title="Vezi graficele" style="display: ${requestScope.displayAdmin};color: rgba(0, 0, 0, 0.54); align-content :center;  ">
                                                <button type="button" style="background-color: rgba(0, 0, 0, 0.54); color: white " >Vezi graficul</button>
                                            </a>
                                        </td>
                                        <td>${masina.marca}</td>
                                        <td>${masina.anulFabricatiei}</td>
                                        <td>${masina.itp}</td>
                                        <td>${masina.rca}</td>
                                        <td>${masina.casco}</td>
                                        <td>${masina.rovignieta}</td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                     </div>

                     <div class="row">
                        <div class="col-sm-12" style="align-content: center">
                            <a href="?action=addMasina">
                                <button type="button" style="background-color: #660020; color:white; padding: 10px; margin: 20px;" >Adauga masina</button>
                            </a>

                        </div>
                     </div>
                </div>
            </main>
        </div>
        <script type="text/javascript" src="resources/js/popup-form.js"></script>

        <script>
            function searchCars() {
                // Declare variables
                console.log("From searchCars");
                var input, filter, table, tr, td, i, txtValue;
                input = document.getElementById("myInput");
                filter = input.value.toUpperCase();
                table = document.getElementById("tableCars");
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

