<%--
  Created by IntelliJ IDEA.
  User: Loredana Isuf
  Date: 3/24/2020
  Time: 10:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
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
<body style="background-color:#660020 " >
<!-- style="background-image: url('./bg2.jpg');" -->
<div class="container">
    <div class="row" style="align-items: center; margin-top: 10px;">
        <div class="col-sm-3">
            <!-- <h1 style="align-items: center; flex-direction: row; color: #660020;">Logare</h2> -->
        </div>
        <div class="col-sm-6" style="background-color: #f2f2f2; margin-top: 100px;" >
            <h1 style="text-align: center; color: #660020; margin-top: 30px;">~Adaugare Remorca~</h1>
                <div style="align-items: center; background-color: #f2f2f2;">
                    <form method="post">
                        <div class="form-group">
                            <label for="nrInmatriculare" style="margin-top: 30px;" >Numarul de inmatriculare remorca</label>
                            <input type="text"class="form-control" id="nrInmatriculare"  name="nrInmatriculareRemorca" aria-describedby="emailHelp" value="${requestScope.TrailToEdit.nrInmatriculareRemorca}">
                        </div>
                        <div class="form-group" style="margin-bottom: 10px">
                            <label for="nrInmatriculareM" >Numarul de inmatriculare masina</label>
                            <input type="text"class="form-control" id="nrInmatriculareM"  name="nrInmatriculareMasina" aria-describedby="emailHelp" value="${requestScope.TrailToEdit.nrInmatriculareMasina}">
                        </div>
                        <div class="form-group">
                            <label for="anFabricatie" style="color: black;">Anul fabricatiei</label>
                            <input type="text"class="form-control" id="anFabricatie"  name="anFabricatieRemorca" aria-describedby="emailHelp" value="${requestScope.TrailToEdit.anulFabricatiei}">
                        </div>
                        <div class="form-group">
                            <label for="itp">ITP valabil pana la</label>
                            <input type="date"class="form-control" id="itp"  name="itpRemorca" aria-describedby="emailHelp" value="${requestScope.TrailToEdit.itp}">
                        </div>


                        <!-- <button type="button" class="btn btn-primary" style="margin-bottom: 60px;">${requestScope.TrailToEdit eq null ? 'Adauga' : 'Edit'}</button> -->
                        <button type="submit" style="background-color: #660020; width: 300px; color:white; padding: 10px; margin: 20px; align-items: center; margin-bottom: 50px;" >${requestScope.TrailToEdit eq null ? 'Adauga' : 'Editeaza'}</button>

                    </form>
                </div>

                <div class="col-sm-3">
                    <!-- <h1 style="align-items: center; flex-direction: row; color: #660020;">Logare</h2> -->
                </div>

        </div>
    </div>

</div>

<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
</body>
</html>

