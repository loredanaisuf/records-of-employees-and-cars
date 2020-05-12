<%@ include file="../includes/jsp_jstl.jsp"%>
<!doctype html>
<html lang="en">
    <head>
        <%@ include file="../includes/head.jsp"%>
        <title>Logare</title>
    </head>

    <body style="background-color:#660020">
<!--   style="background-image: url('./bordo1.jpg');" ></body>-->
        <div class="container">
            <div class="row" style="align-items: center; margin-top: 100px;">
                <div class="col-md-3 col-sm-2">
                    <!-- <h1 style="align-items: center; flex-direction: row; color: #660020;">Logare</h2>
                 style="background-color: #f2f2f2;"
                     background-color: #f2f2f2;

             -->

                </div>
                <div class="col-md-6 col-sm-8"  >
                    <h2 style="text-align: center; color: white; margin: 30px;">~  Logare  ~</h2>
                    <div style="align-items: center;  margin:auto;">
                        <form method="post">
                            <div class="alert alert-danger" style="color: red;display: <c:out value="${requestScope.display}"/>">
                                <c:out value="${requestScope.error}"/>
                            </div>
                            <div class="form-group">
                                <label for="utilizator" style="color:white;  margin-top: 20px;" >Email</label>
                                <input type="text"class="form-control" id="utilizator"  name="numeUtilizator"  aria-describedby="emailHelp" style="border-bottom: 2px solid white; background-color: inherit;">
                            </div>
                            <div class="form-group">
                                <label for="parola" style="color:white; ">Parola</label>
                                <input type="text" class="form-control" id="parola" name="parolaUtilizator" style="border-bottom: 2px solid white; background-color: inherit;">
                            </div>

                            <!-- <button type="submit" class="btn btn-primary" style="margin-bottom: 60px;">${requestScope.UserToEdit eq null ? 'Adauga' : 'Edit'}</button> -->
                            <button type="submit"  >Logare</button>

                        </form>
                    </div>
                    <div style="text-align: center; margin-top: 60px; margin-bottom: 30px;">
                        <span style="color: white;  margin: 30px;"> Nu ai cont?</span>
                        <a href="${pageContext.request.contextPath}/inregistrare">
                             <button type="submit" >Inregistreaza-te</button>
                        </a>
                    </div>

                </div>
                <div class="col-md-3 col-sm-2">
                    <!-- <h1 style="align-items: center; flex-direction: row; color: #660020;">Logare</h2> -->
                </div>
            </div>

        </div>
        <jsp:include page="../includes/scripts_body.jsp"/>
    </body>
</html>
