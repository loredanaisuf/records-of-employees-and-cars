<%@ include file="../includes/jsp_jstl.jsp"%>
<!doctype html>
<html lang="en">
<head>
    <%@ include file="../includes/head.jsp"%>
    <title>Informatii</title>
</head>
<body >
<div class="container"  style="background-color: #f2f2f2;">
    <div class="row" style="align-items: center; margin-top: 10px;">

        <div class="col-sm-12" style="background-color: #660020;" >
            <h2 style="text-align: center;margin: 15px; color:white">~Adaugare informatii~</h2>
        </div>

        <div class="col-sm-2" ></div>
        <div class="col-sm-8" >
            <div style="align-items: center; background-color: #f2f2f2;">
                <form method="post">
                    <div class="form-group" style="margin-bottom: 10px">
                        <label for="data" style="margin-top: 30px;">Data</label>
                        <input type="date" placeholder="Introdu data" id="data" name="data" required>
                    </div>

                    <div class="form-group" style="margin-bottom: 10px">
                        <label for="nr_km" style="margin-top: 30px;">Numarul de km</label>
                        <input type="text" placeholder="Introdu nr de km" id="nr_km" name="numar_km" required>
                    </div>

                    <div class="form-group" style="margin-bottom: 10px">
                        <label for="cant" style="margin-top: 30px;">Litri de motorina</label>
                        <input type="text" placeholder="Introd cantitatea de motorina" id="cant" name="cantitate" required>
                    </div>
                    <button type="submit" style="background-color: #660020; width: 300px; color:white; padding: 10px; margin: 20px; align-items: center; margin-bottom: 50px;"  class="btn">Adauga</button>
<%--                    <button type="button" class="btn cancel" onclick="closeForm()">Inchide</button>--%>
                </form>

            </div>

            <div class="col-sm-2" ></div>
        </div>
    </div>

</div>
<jsp:include page="../includes/scripts_body.jsp"/>

</body>
</html>

