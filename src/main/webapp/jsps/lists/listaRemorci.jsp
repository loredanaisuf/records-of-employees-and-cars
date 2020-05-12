<%@ include file="../includes/jsp_jstl.jsp"%>
<html>
    <head>
    <%@ include file="../includes/head.jsp"%>
    <title>Remorci</title>
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
                                <th scope="col">NrInmatriculareRemorca</th>
                                <th scope="col">NrInmatriculareMasina</th>
                                <th scope="col">AnulFabricatiei</th>
                                <th scope="col">ITP</th>
                                <th scope="col">Optiuni</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="remorca" items="${requestScope.TrailsTobeDisplayed}">
                                <tr>
                                    <th>${remorca.nrInmatriculareRemorca}</th>
                                    <th>${remorca.nrInmatriculareMasina}</th>
                                    <td>${remorca.anulFabricatiei}</td>
                                    <td>${remorca.itp}</td>

                                    <td>

                                        <a href="?action=editRemorca&id=${remorca.nrInmatriculareRemorca} "data-toggle="tooltip" title="Editeaza" style="color: rgba(0, 0, 0, 0.54);align-content :center;  "><span class="material-icons">edit</span> </a>
                                        <a href="?action=deleteRemorca&id=${remorca.nrInmatriculareRemorca} "data-toggle="tooltip" title="Sterge" style="display: ${requestScope.displayAdmin};color: rgba(0, 0, 0, 0.54); "><span class="material-icons">delete</span></a>
                                        <!--<a href="?action=delete&id=${remorca.nrInmatriculareRemorca}">
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
                            <a href="?action=addRemorca">
                                <button type="button" style="background-color: #660020; color:white; padding: 10px; margin: 20px;" >Adauga remorca</button>
                            </a>
                        </div>
                    </div>
                </div>
            </main>
        </div>
    </body>
</html>
