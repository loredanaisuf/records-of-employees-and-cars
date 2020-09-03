<%@ include file="../includes/jsp_jstl.jsp"%>
<!doctype html>
<html lang="en">
    <head>
        <%@ include file="../includes/head.jsp"%>
        <title>Logare</title>
    </head>

    <body style="background-color: #660020">
<!--   style="background-image: url('./bordo1.jpg');" ></body>-->
        <div class="bmd-layout-container bmd-drawer-f-l" >
<%--            <%@ include file="../includes/navbar.jsp"%>--%>
            <main class="bmd-layout-content">
                <div class="container">
                    <div class="row" style="align-items: center; margin-top: 3%;">
<%--                        <div class="col-sm-12" style="background-color: #660020;" >--%>
<%--                            <h2 style="text-align: center;margin: 15px; color:white">~Logare~</h2>--%>
<%--                        </div>--%>
                        <div class="col-md-4 col-sm-2" >
                            <!-- <h1 style="align-items: center; flex-direction: row; color: #660020;">Logare</h2>
                         style="background-color: #f2f2f2;"
                             background-color: #f2f2f2;

                     -->
<%--                            style="margin: 7% 5%;border-style: outset; padding: 10px; background-color: #f2f2f2"--%>
                        </div>
                        <div class="col-md-4 col-sm-8"  style="background-color: #f2f2f2; margin-top: 3%;">
                            <div >
                                <form  method="post" name="logare">
                                    <div class="alert alert-danger" style="color: red;display: <c:out value="${requestScope.display}"/>">
                                        <c:out value="${requestScope.error}"/>
                                    </div>
                                    <div class="form-group">
                                        <label for="utilizator" style="font-weight:bold; color: #660020;  margin-top: 20%; text-align: left" >Email</label>
                                        <input type="text"class="form-control" id="utilizator"  name="numeUtilizator"  style="border-bottom: 2px solid white; background-color: inherit;">
                                    </div>
                                    <div class="form-group">
                                        <label for="parola" style="font-weight:bold; color: #660020; text-align: left;">Parola</label>
                                        <input type="password" class="form-control" id="parola"  name="parolaUtilizator" style="border-bottom: 2px solid white; background-color: inherit;">
                                    </div>

                                    <!-- <button type="submit" class="btn btn-primary" style="margin-bottom: 60px;">${requestScope.UserToEdit eq null ? 'Adauga' : 'Edit'}</button> -->
                                    <button type="button" onclick="submitLogin()" style=" align-content: center; background-color: #660020; width: 100%; color:white; padding: 10px;"  >Logare </button>

                                </form>
                            </div>
                            <div style="text-align: center; margin-top: 60px; margin-bottom: 45px;">
                                <span style="color: black;  margin: 30px;"> SAU</span>

                            </div>

                            <div style="text-align: center;  margin-top: 30px;">
        <%--                        <span style="color: white;  margin: 30px;"> Companie :</span>--%>
                                <a href="${pageContext.request.contextPath}/inregistrareCompanie">
                                    <button type="button" style="padding: 10px; background-color: #660030; width: 100%; color:white;" >Inregistrare Companie</button>
                                </a>
                            </div>

                            <div style="text-align: center;margin-top: 10px; margin-bottom: 25%;">
        <%--                        <span style="color: white;  margin: 30px;"> Utilizator : </span>--%>
                                <a href="${pageContext.request.contextPath}/inregistrare">
                                    <button type="button" style="background-color: #660000; padding: 10px; width: 100%; color:white;">Inregistrare Angajat</button>
                                </a>
                            </div>
                        </div>
                        <div class="col-md-4 col-sm-2">
                            <!-- <h1 style="align-items: center; flex-direction: row; color: #660020;">Logare</h2> -->
                        </div>
                    </div>

                </div>
            </main>
        </div>

        <script>
            function submitLogin() {
                $("form[name=logare]").submit();

            }
        </script>
        <jsp:include page="../includes/scripts_body.jsp"/>
    </body>
</html>
