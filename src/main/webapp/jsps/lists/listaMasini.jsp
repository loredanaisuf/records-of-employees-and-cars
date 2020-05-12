<%@ include file="../includes/jsp_jstl.jsp"%>
<html>
    <head>
        <%@ include file="../includes/head.jsp"%>
        <title>Masini</title>
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
                        <table class="table table-striped" style="margin-top: 40px;">
                            <thead class=".thead-dark">
                            <tr>
                                <th scope="col">NrInmatriculare</th>
                                <th scope="col">Marca</th>
                                <th scope="col">AnFabricatie</th>
                                <th scope="col">ITP</th>
                                <th scope="col">AsigurareRCA</th>
                                <th scope="col">AsigurareCasco</th>
                                <th scope="col">Rovigieta</th>
                                <th scope="col">Optiuni</th>
                            </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="masina" items="${requestScope.CarsTobeDisplayed}">
                                    <tr>
                                        <th>${masina.nrInmatriculare}</th>
                                        <td>${masina.marca}</td>
                                        <td>${masina.anulFabricatiei}</td>
                                        <td>${masina.itp}</td>
                                        <td>${masina.rca}</td>
                                        <td>${masina.casco}</td>
                                        <td>${masina.rovignieta}</td>
                                        <td>
                                            <!-- <button type="button" class="btn btn-success" onclick="window.location.href='?action=edit&id=${utilizator.id}'">Edit</button> -->
                                            <a href="?action=editMasina&id=${masina.nrInmatriculare} "data-toggle="tooltip" title="Editeaza" style="color: rgba(0, 0, 0, 0.54); "><span class="material-icons">edit</span> </a>
                                            <a href="?action=deleteMasina&id=${masina.nrInmatriculare} "data-toggle="tooltip" title="Sterge" style="display: ${requestScope.displayAdmin};color: rgba(0, 0, 0, 0.54); align-content :center;  "><span class="material-icons">delete</span></a>
                                            <!--<a href="?action=delete&id=${utilizator.id}">
                                                <button type="button" class="btn btn-danger">Delete</button>
                                            </a> -->

                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                     </div>
                     <div class="row">
                        <div class="col-sm-12">
                            <a href="?action=addMasina">
                                <button type="button" style="background-color: #660020; color:white; padding: 10px; margin: 20px;" >Adauga masina</button>
                            </a>
                        </div>
                     </div>
                </div>
            </main>
        </div>

    </body>
</html>

