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
        <div class="container" style="background-color: #f2f2f2; overflow-x: scroll;">
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
                            <th scope="col">8</th>
                            <th scope="col">9</th>
                            <th scope="col">10</th>
                            <th scope="col">11</th>
                            <th scope="col">12</th>
                            <th scope="col">13</th>
                            <th scope="col">14</th>
                            <th scope="col">15</th>
                            <th scope="col">16</th>
                            <th scope="col">17</th>
                            <th scope="col">18</th>
                            <th scope="col">19</th>
                            <th scope="col">20</th>
                            <th scope="col">21</th>
                            <th scope="col">22</th>
                            <th scope="col">23</th>
                            <th scope="col">24</th>
                            <th scope="col">25</th>
                            <th scope="col">26</th>
                            <th scope="col">27</th>
                            <th scope="col">28</th>
                            <th scope="col">29</th>
                            <th scope="col">30</th>
                            <th scope="col">31</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="utilizator" items="${requestScope.UsersTobeDisplayed}">
                            <tr>
                                <form >
                                <th>${utilizator.nume}</th>
                                <td>
                                    <div class="form-group">
                                        <input  style="width: 30px;" type = "text" name="P_${utilizator.id}_1">
                                    </div>

                                </td>
                                <td><form >
                                    <div class="form-group" >
                                        <input style="width: 30px;" type = "text" name="P_${utilizator.id}_2">
                                    </div>
                                </form>
                                </td>
                                <td><form >
                                    <div class="form-group">
                                        <input style="width: 30px;" type = "text" name="3">
                                    </div>
                                </form>
                                </td>
                                <td><form >
                                    <div class="form-group">
                                        <input style="width: 30px;" type = "text" name="4">
                                    </div>
                                </form>
                                </td>
                                <td><form  >
                                    <div class="form-group">
                                        <input style="width: 30px;" type = "text" name="5">
                                    </div>
                                </form>
                                </td>
                                <td><form >
                                    <div class="form-group">
                                        <input style="width: 30px;" type = "text" name="6">
                                    </div>
                                </form>
                                </td>
                                <td><form >
                                    <div class="form-group">
                                        <input style="width: 30px;" type = "text" name="7">
                                    </div>
                                    </form>
                                </td>
                                <td><form>
                                    <div class="form-group">
                                        <input style="width: 30px;" type = "text" name="8">
                                    </div>
                                </form>
                                </td>
                                <td><form  >
                                    <div class="form-group">
                                        <input style="width: 30px;" type = "text" name="9">
                                    </div>
                                </form>
                                </td>
                                <td><form>
                                    <div class="form-group">
                                        <input style="width: 30px;" type = "text" name="10">
                                    </div>
                                </form>
                                </td>
                                <td><form >
                                    <div class="form-group">
                                        <input style="width: 30px;" type = "text" name="11">
                                    </div>
                                </form>
                                </td>
                                <td><form >
                                    <div class="form-group">
                                        <input style="width: 30px;" type = "text" name="12">
                                    </div>
                                </form>
                                </td>
                                <td><form >
                                    <div class="form-group">
                                        <input style="width: 30px;" type = "text" name="13">
                                    </div>
                                </form>
                                </td>
                                <td><form >
                                    <div class="form-group">
                                        <input style="width: 30px;" type = "text" name="14">
                                    </div>
                                </form>
                                </td>
                                <td><form >
                                    <div class="form-group">
                                        <input  style="width: 30px;" type = "text" name="15">
                                    </div>
                                </form>
                                </td>
                                <td><form >
                                    <div class="form-group" >
                                        <input style="width: 30px;" type = "text" name="16">
                                    </div>
                                </form>
                                </td>
                                <td><form >
                                    <div class="form-group">
                                        <input style="width: 30px;" type = "text" name="17">
                                    </div>
                                </form>
                                </td>
                                <td><form >
                                    <div class="form-group">
                                        <input style="width: 30px;" type = "text" name="18">
                                    </div>
                                </form>
                                </td>
                                <td><form  >
                                    <div class="form-group">
                                        <input style="width: 30px;" type = "text" name="19">
                                    </div>
                                </form>
                                </td>
                                <td><form >
                                    <div class="form-group">
                                        <input style="width: 30px;" type = "text" name="20">
                                    </div>
                                </form>
                                </td>
                                <td><form >
                                    <div class="form-group">
                                        <input style="width: 30px;" type = "text" name="21">
                                    </div>
                                </form>
                                </td>
                                <td><form>
                                    <div class="form-group">
                                        <input style="width: 30px;" type = "text" name="22">
                                    </div>
                                </form>
                                </td>
                                <td><form  >
                                    <div class="form-group">
                                        <input style="width: 30px;" type = "text" name="23">
                                    </div>
                                </form>
                                </td>
                                <td><form>
                                    <div class="form-group">
                                        <input style="width: 30px;" type = "text" name="24">
                                    </div>
                                </form>
                                </td>
                                <td><form >
                                    <div class="form-group">
                                        <input style="width: 30px;" type = "text" name="25">
                                    </div>
                                </form>
                                </td>
                                <td><form >
                                    <div class="form-group">
                                        <input style="width: 30px;" type = "text" name="26">
                                    </div>
                                </form>
                                </td>
                                <td><form >
                                    <div class="form-group">
                                        <input style="width: 30px;" type = "text" name="27">
                                    </div>
                                </form>
                                </td>
                                <td><form >
                                    <div class="form-group">
                                        <input style="width: 30px;" type = "text" name="28">
                                    </div>
                                </form>
                                </td>
                                <td><form >
                                    <div class="form-group">
                                        <input style="width: 30px;" type = "text" name="29">
                                    </div>
                                </form>
                                </td>
                                <td><form >
                                    <div class="form-group">
                                        <input style="width: 30px;" type = "text" name="30">
                                    </div>
                                </form>
                                </td>
                                <td>
                                    <div class="form-group">
                                        <input style="width: 30px;" type = "text" name="31">
                                    </div>

                                </td>
                                </form>
                            </tr>

                        </c:forEach>

                            <select name="months">
                                <option value="Ianuarie">Ianuarie</option>
                                <option value="Februarie">Februarie</option>
                                <option value="Martie">Martie</option>
                            </select>
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


<%--//        Utilizator authenticatedUser = (Utilizator) req.getSession().getAttribute("authenticatedUser");--%>
<%--//        Administrator authenticatedAdmin = (Administrator) req.getSession().getAttribute("authenticatedAdmin");--%>
<%--//--%>
<%--//        String numeFirma = (null == authenticatedAdmin) ? authenticatedUser.getFirma() : authenticatedAdmin.getFirma();--%>
<%--//        List<Utilizator> utilizatori = this.serviceUtilizator.getUsers(numeFirma);--%>
<%--//        for(Utilizator utilizator:utilizatori){--%>
<%--//            String one = req.getParameter("P_" +utilizator.getId() + "_1" );--%>
<%--//            System.out.println("1: " +one);--%>
<%--//        }--%>
<%--//--%>
<%--//        String month = req.getParameter("months");--%>
<%--//        System.out.println("Luna: " + month);--%>