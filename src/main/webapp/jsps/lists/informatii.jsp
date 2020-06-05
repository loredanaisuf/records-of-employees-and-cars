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
        <div class="container" style="margin-top: 10%;">
            <div class="row">
                <div class="col-sm-2"></div>
                <div class="col-sm-8" style="background-color: #f2f2f2; padding-top: 20px; padding-bottom: 20px; ">
                    <h2>${requestScope.nrInmatriculare} </h2>
                    <table class="table table-bordered">
                        <thead>
                        <tr>
                            <td scope="row">Data</td>
                            <td scope="row">Numarul de km</td>
                            <td scope="row">Cantitatea de motorina</td>
                            <td scope="row">Consumul</td>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="inf" items="${requestScope.information}">
                            <tr>
                                <td>${inf.data}</td>
                                <td>${inf.numarKm}</td>
                                <td>${inf.cantitate}</td>
                                <td>${inf.consum}</td>
                            </tr>
                        </c:forEach>

                        </tbody>
                    </table>

<%--                    <form method="post" class="form-inline" name="informatiiForm">--%>
<%--                        <span style="font-weight: bold">Numarul de km parcursi de la--%>
<%--                            <input class="form-control mr-sm-2" type="date" name="km-from">--%>
<%--                            pana la--%>
<%--                            <input class="form-control mr-sm-2" type="date"  name="km-to">--%>
<%--                            <button type="submit" class="btn btn-primary" style="color: #660020">Vezi</button>--%>
<%--                        </span>--%>
<%--                    </form>--%>
<%--                    <h6 style="display: ${displayKm};">Numarul de km de la data ${requestScope.firstDateKm} la data ${requestScope.secondDateKm} este: ${requestScope.numberOfKms} </h6>--%>

<%--                    <form method="post" class="form-inline" name="informatiiForm">--%>
<%--                        <span style="font-weight: bold">Cantitatea de motorina consumata de la--%>
<%--                            <input class="form-control mr-sm-2" type="date" name="f-from">--%>
<%--                            pana la--%>
<%--                            <input class="form-control mr-sm-2" type="date"  name="f-to">--%>
<%--                            <button type="submit" class="btn btn-primary" style="color: #660020">Vezi</button>--%>
<%--                        </span>--%>
<%--                    </form>--%>
<%--                    <h5 style="display: ${displayF};">Cantitatea de motorina consumata de la data ${requestScope.firstDateF} la data ${requestScope.secondDateF} este: ${requestScope.fuel} </h5>--%>

<%--                    <form method="post" class="form-inline" name="informatiiForm">--%>
<%--                        <span style="font-weight: bold">Cantitatea de motorina consumata de la--%>
<%--                            <input class="form-control mr-sm-2" type="date" name="f-from">--%>
<%--                            pana la--%>
<%--                            <input class="form-control mr-sm-2" type="date"  name="f-to">--%>
<%--                            <button type="submit" class="btn btn-primary" style="color: #660020">Vezi</button>--%>
<%--                        </span>--%>
<%--                    </form>--%>
<%--                    <h5 style="display: ${displayC};">Cantitatea de motorina consumata de la data ${requestScope.firstDateC} la data ${requestScope.secondDateC} este: ${requestScope.consumption} </h5>--%>

                </div>
            </div>
            <div class="col-sm-2"></div>
        </div>
    </main>
</div>
<script>
    function show() {
        $("form[name=informatiiForm]").submit();
        $('#showNrOfKms').css("display","block");
    }
</script>
</body>
</html>
