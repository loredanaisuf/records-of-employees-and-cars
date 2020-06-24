<%@ include file="../includes/jsp_jstl.jsp"%>
<html>
    <head>
    <%@ include file="../includes/head.jsp"%>
    <title>Remorci</title>
    </head>

    <body>
        <div class="bmd-layout-container bmd-drawer-f-l" >
            <%@ include file="../includes/navbar_with_search.jsp"%>
            <main class="bmd-layout-content">
                <div class="container" style="background-color: #f2f2f2; overflow-x: scroll;">
                    <div class="row" style="margin-top: 10px">
<%--                        <div class="col-sm-9"></div>--%>
<%--                        <div class="col-sm-3">--%>
<%--                            <input type="text" id="myInput" onkeyup="searchTrails()" placeholder="Search for vehicle number..">--%>
<%--                        </div>--%>
                    </div>

                    <div class="row"></div>
                    <div class="row">
                        <table class="table table-striped" id="tableTrails" style="margin-top: 30px;">
                            <thead class=".thead-dark">
                            <tr>
                                <th scope="col">Optiuni</th>
                                <th scope="col">NrInmatriculareRemorca</th>
                                <th scope="col">NrInmatriculareMasina</th>
                                <th scope="col">AnulFabricatiei</th>
                                <th scope="col">ITP</th>

                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="remorca" items="${requestScope.TrailsTobeDisplayed}">
                                <tr>
                                    <td>

                                        <a href="?action=editRemorca&id=${remorca.nrInmatriculareRemorca} "data-toggle="tooltip" title="Editeaza" style="color: rgba(0, 0, 0, 0.54);align-content :center;  "><span class="material-icons">edit</span> </a>
                                        <a href="?action=deleteRemorca&id=${remorca.nrInmatriculareRemorca} "data-toggle="tooltip" title="Sterge" style="display: ${requestScope.displayAdmin};color: rgba(0, 0, 0, 0.54); "><span class="material-icons">delete</span></a>
                                        <!--<a href="?action=delete&id=${remorca.nrInmatriculareRemorca}">
                                            <button type="button" class="btn btn-danger">Delete</button>
                                        </a> -->

                                    </td>
                                    <th>${remorca.nrInmatriculareRemorca}</th>
                                    <th>${remorca.nrInmatriculareMasina}</th>
                                    <td>${remorca.anulFabricatiei}</td>
                                    <td>${remorca.itp}</td>
                                </tr>
                            </c:forEach>


                            </tbody>
                        </table>
                    </div>

                    <div class="row">
                        <div class="col-sm-12">
                            <a href="?action=addRemorca">
                                <button type="button" style="display: ${requestScope.displayAdmin};background-color: #660020; color:white; padding: 10px; margin: 20px;" >Adauga remorca</button>
                            </a>
                        </div>
                    </div>
                </div>
            </main>
        </div>

        <script>
            function searchFunction() {
                // Declare variables
                console.log("from search trails")
                var input, filter, table, tr, td, i, txtValue;
                input = document.getElementById("input");
                filter = input.value.toUpperCase();
                table = document.getElementById("tableTrails");
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
