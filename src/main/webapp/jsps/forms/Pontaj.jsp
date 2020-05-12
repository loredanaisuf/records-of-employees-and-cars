<%@ include file="../includes/jsp_jstl.jsp"%>
<html>

<head>
    <%@ include file="../includes/head.jsp"%>
    <title>Pontaj</title>
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
                            <th scope="col">1</th>
                            <th scope="col">2</th>
                            <th scope="col">3</th>
                            <th scope="col">4</th>
                            <th scope="col">5</th>
                            <th scope="col">6</th>
                            <th scope="col">7</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="utilizator" items="${requestScope.UsersTobeDisplayed}">
                            <tr>
                                <th>${utilizator.nume}</th>
                                <td><form class="pontaj">
                                    <input name="1">
                                </form>
                                </td>
                                <td><form class="pontaj">
                                    <input name="2">
                                </form>
                                </td>
                                <td><form class=pontaj">
                                    <input name="3">
                                </form>
                                </td>
                                <td><form class="pontaj">
                                    <input name="4">
                                </form>
                                </td>
                                <td><form class="pontaj" >
                                    <input name="5">
                                </form>
                                </td>
                                <td><form class="form-inline" style="width: 10px;">
                                    <input class=name="6">
                                </form>
                                </td>
                                <td><form class="form-inline" style="width: 10px;">
                                        <input name="7">
                                    </form>
                                </td>
                            </tr>
                        </c:forEach>


                        </tbody>
                    </table>
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

</body>
</html>
