<%@ include file="../includes/jsp_jstl.jsp"%>
<html>
    <head>
        <%@ include file="../includes/head.jsp"%>
        <title>Masini</title>
    </head>

    <body>
        <div class="bmd-layout-container bmd-drawer-f-l" >
            <%@ include file="../includes/navbar_with_search.jsp"%>
            <main class="bmd-layout-content">
                <div class="container" style="background-color: #f2f2f2; overflow-x: scroll;">
                    <div class="row">
                        <div class="col-sm-12">
<%--                            <input type="text" id="myInput" onkeyup="searchCars()" placeholder="Search for names..">--%>

                        </div>
                    </div>

                     <div class="row"></div>
                     <div class="row">
                        <table class="table table-striped" id="tableCars" style="margin-top: 30px;">
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
                                            <a href="?action=information&id=${masina.nrInmatriculare} "data-toggle="tooltip" title="Vezi graficele" style="color: rgba(0, 0, 0, 0.54); align-content :center;  ">
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
                                <button type="button" style="display: ${requestScope.displayAdmin};background-color: #660020; color:white; padding: 10px; margin: 20px;" >Adauga masina</button>
                            </a>

                        </div>
                     </div>
                </div>
            </main>
        </div>


        <script>
            function searchFunction() {
                // Declare variables
                console.log("From searchCars");
                var input, filter, table, tr, td, i, txtValue;
                input = document.getElementById("input");
                filter = input.value.toUpperCase();
                table = document.getElementById("tableCars");
                tr = table.getElementsByTagName("tr");

                // Loop through all table rows, and hide those who don't match the search query
                for (i = 0; i < tr.length; i++) {
                    td = tr[i].getElementsByTagName("th")[0];
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

