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
        <title>Calendar</title>
    </head>
    <body>
         <div class="bmd-layout-container bmd-drawer-f-l" >
             <%@ include file="../includes/navbar.jsp"%>
             <main class="bmd-layout-content">
                <div class="container">

                    <div class="row" style="margin-top: 20px;">
                        <div id='wrap'>

                            <div id='calendar'></div>

                            <div style='clear:both'></div>
                        </div>
                    </div>

                </div>
             </main>
         </div>
    </body>
</html>
