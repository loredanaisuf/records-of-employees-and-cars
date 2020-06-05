<%@ include file="../includes/jsp_jstl.jsp"%>
<html>
<head>
    <%@ include file="../includes/head.jsp"%>

    <link href='resources/fullcalendar/core/main.css' rel='stylesheet' />
    <link href='resources/fullcalendar/daygrid/main.css' rel='stylesheet' />

    <script src='resources/fullcalendar/core/main.js'></script>
    <script src='resources/fullcalendar/daygrid/main.js'></script>

    <script>

        document.addEventListener('DOMContentLoaded', function() {
            var calendarEl = document.getElementById('calendar');

            var calendar = new FullCalendar.Calendar(calendarEl, {
                events: [
                    <c:forEach var="event" items="${requestScope.listOfDates}">
                    {
                        id: '${event.idAngajat}',
                        title: '     ${event.numarOre}',
                        start: '${event.data}',
                    },
                    </c:forEach>
                ],
                plugins: [ 'dayGrid' ]
            });

            calendar.render();
        });

    </script>

    <title>Calendar</title>
</head>
<body>
<div class="bmd-layout-container bmd-drawer-f-l" >
    <%@ include file="../includes/navbar.jsp"%>
    <main class="bmd-layout-content">
        <div class="container">

            <div class="row" style="margin-top: 5%;">
                <div class="col-sm-1"></div>
                <div class="col-sm-4">
                     <h2>${requestScope.angajat.nume} ${requestScope.angajat.prenume}</h2>

                    <form method="post">
                        <div class="form-group">
                            <label for="exampleInputEmail1" style="font-weight: bold">Data</label>
                            <input type="date" class="form-control" id="exampleInputEmail1" name="data">
                        </div>
                        <div class="form-group">
                            <label for="exampleInputPassword1" style="font-weight: bold">Numarul de ore</label>
                            <input type="number" class="form-control" id="exampleInputPassword1" name="nrOre">
                        </div>
                        <button type="submit" class="btn btn-primary" style="color: #660020">Adauga</button>
                    </form>

                    <button type="button" onclick="show()" class="btn btn-primary" style="color: #660020">Numarul de ore in luna curenta</button>
                    <div id="showNrOfHours" style="display: none; margin-right: 10px; color: #660020; font-weight: bold">${requestScope.numberOfHours}</div>

                </div>
                <div class="col-sm-1"></div>
                <div class="col-sm-6">
                    <div id='wrap'>

                        <div id='calendar'></div>

                        <div style='clear:both'></div>
                    </div>
                </div>
            </div>
<%--            <div class="row" style="margin: 5% 5%">--%>
<%--                <div class="col-sm-1"></div>--%>
<%--                <div class="col-sm-4">--%>
<%--                    <button type="button" onclick="show()" class="btn btn-primary" style="color: #660020">Numarul de ore in luna curenta</button>--%>
<%--                    <div id="showNrOfHours" style="display: none; margin-right: 10px; color: #660020; font-weight: bold">${requestScope.numberOfHours}</div>--%>
<%--                </div>--%>
<%--            </div>--%>
        </div>
    </main>
</div>
<script>
    function show() {
        $('#showNrOfHours').css("display","block");
    }
</script>
</body>
</html>
