<%--
  Created by IntelliJ IDEA.
  User: Loredana Isuf
  Date: 3/24/2020
  Time: 12:00 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

    <title>Adaugare</title>
</head>
<body style="background-color: #f2f2f2 " >
<!-- style="background-image: url('./bg2.jpg');" #660020 -->
<div class="container" style="background-color: #f2f2f2;">
    <div class="row" style="align-items: center;">

        <div class="col-sm-12" style="background-color: #660020;" >
            <h2 style="text-align: center;margin: 15px; color:white">~Adaugare Masina~</h2>
        </div>

        <div class="col-sm-2" ></div>
        <div class="col-sm-8"  >
            <div style="align-items: center; background-color: #f2f2f2; padding: 15px;">
                <form method="post">
                    <div class="form-group">
                        <label for="nrInmatriculare" style="font-weight: bold; margin-top: 45px;">Numarul de inmatriculare</label>
                        <input type="text"class="form-control" id="nrInmatriculare"  name="nrInmatriculareMasina" placeholder="ex: GJ97YIL" value="${requestScope.CarToEdit.nrInmatriculare}">
                    </div>
                    <div class="form-group">
                        <label for="marca" style="font-weight: bold;">Marca</label>
                        <input type="text"class="form-control" id="marca"  name="marcaMasina" placeholder="ex: VOLVO" value="${requestScope.CarToEdit.marca}">
                    </div>
                    <div class="form-group" style="font-weight: bold;">
                        <label for="an">Anul fabricatiei</label>
                        <input type="text"class="form-control" id="an"  name="anMasina" placeholder="YYYY" value="${requestScope.CarToEdit.anulFabricatiei}">
                    </div>
                    <div class="form-group" style="font-weight: bold;">
                        <label for="itp"style="" >ITP valabil pana </label>
                        <input type="date"class="form-control" id="itp"  name="itpMasina" aria-describedby="emailHelp" value="${requestScope.CarToEdit.itp}>
                    </div>
                    <div class="form-group">
                        <label for="rca" style="font-weight: bold;">Asigurare RCA valabila pana</label>
                        <input type="date"class="form-control" id="rca"  name="rcaMasina" aria-describedby="emailHelp" value="${requestScope.CarToEdit.rca}">
                    </div>
                    <div class="form-group">
                        <label for="casco"style="font-weight: bold;" >Asigurare CASCO valabila pana</label>
                        <input type="date"class="form-control" id="casco"  name="cascoMasina" aria-describedby="emailHelp" value="${requestScope.CarToEdit.casco}">
                    </div>
                    <div class="form-group" style="font-weight: bold;">
                        <label for="rovignieta">Rovignieta valabila pana</label>
                        <input type="date" class="form-control" id="rovignieta" name="rovignietaMasina" value="${requestScope.CarToEdit.rovignieta}">
                    </div>

                     <button type="submit" class="btn btn-primary" style="background-color: #660020; width: 300px; color:white; padding: 10px; margin: 20px; align-items: center; margin-bottom: 60px;">${requestScope.UserToEdit eq null ? 'Adauga' : 'Edit'}</button>
                    <!--<button type="button" style="background-color: #660020; width: 300px; color:white; padding: 10px; margin: 20px; align-items: center; margin-bottom: 60px;" >Adauga</button> -->


                </form>
            </div>
        </div>
        <div class="col-sm-2" ></div>


    </div>

</div>

<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
</body>
</html>
