<%@ include file="../includes/jsp_jstl.jsp"%>
<html>
    <head>
        <link href='resources/fullcalendar/core/main.css' rel='stylesheet' />
        <link href='resources/fullcalendar/daygrid/main.css' rel='stylesheet' />

        <script src='resources/fullcalendar/core/main.js'></script>
        <script src='resources/fullcalendar/daygrid/main.js'></script>

        <script>

            document.addEventListener('DOMContentLoaded', function() {
                var calendarEl = document.getElementById('calendar');

                var calendar = new FullCalendar.Calendar(calendarEl, {
                    events: [
                        <c:forEach var="event" items="${requestScope.events}">
                        {
                            id: '${event.id}',
                            title: '${event.title}',
                            start: '${event.date}',
                        },
                        </c:forEach>
                    ],
                    plugins: [ 'dayGrid' ]
                });

                calendar.render();
            });

        </script>

        <%@ include file="../includes/head.jsp"%>
        <title>Calendar</title>
    </head>
    <body>
        <%@ include file="../includes/navbar.jsp"%>
        <div class="container">

            <div class="row" style="margin-top: 20px;">
                <div id='wrap'>

                    <div id='calendar'></div>

                    <div style='clear:both'></div>
                </div>
            </div>

        </div>
<%--        <jsp:include page="../includes/scripts_body.jsp"/>--%>
    </body>
</html>
