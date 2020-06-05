<%@ include file="../includes/jsp_jstl.jsp"%>
<html>
    <head>
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.6.0/Chart.min.js"></script>
         <%@ include file="../includes/head.jsp"%>
        <title>Grafic</title>
    </head>
    <body>
        <div class="bmd-layout-container bmd-drawer-f-l" >
            <%@ include file="../includes/navbar.jsp"%>
            <main class="bmd-layout-content">
                <div class="container">
                    <div class="row" style="margin-top: 20px;">
                        <div class="col-sm-6">
                            <canvas id="myChart1"></canvas>
                        </div>
                        <div class="col-sm-6">
                            <canvas id="myChart2"></canvas>
                        </div>

                    </div>
<%--                    <div class="row" style="margin-top: 20px;">--%>
<%--                        <canvas id="myChart2"></canvas>--%>
<%--                    </div>--%>
                    <div class="row" style="margin-top: 20px;">
                        <div class="col-sm-2"></div>
                        <div class="col-sm-8">
                            <canvas id="myChart3"></canvas>
                        </div>
                    </div>
                </div>
            </main>
        </div>

        <script>
            let myChart1 = document.getElementById('myChart1').getContext('2d');

            // Global Options
            Chart.defaults.global.defaultFontFamily = 'Lato';
            Chart.defaults.global.defaultFontSize = 18;
            Chart.defaults.global.defaultFontColor = '#777';

            let massPopChart1 = new Chart(myChart1, {
                type:'line', // bar, horizontalBar, pie, line, doughnut, radar, polarArea
                data:{

                    labels: [
                        <c:forEach var="inf" items="${requestScope.numberOfKM}">
                            '${inf.x}',
                        </c:forEach>
                    ],
                        datasets:[{
                            label:'Numarul de km',
                            data:[
                                <c:forEach var="inf" items="${requestScope.numberOfKM}">
                                    '${inf.y}',
                                </c:forEach>
                            ],

                            //backgroundColor:'green',
                            backgroundColor:[
                                'rgba(255, 99, 132, 0.6)',
                                'rgba(54, 162, 235, 0.6)',
                                'rgba(255, 206, 86, 0.6)',
                                'rgba(75, 192, 192, 0.6)',
                                'rgba(153, 102, 255, 0.6)',
                                'rgba(255, 159, 64, 0.6)',
                                'rgba(255, 99, 132, 0.6)'
                            ],
                            borderWidth:1,
                            borderColor:'#777',
                            hoverBorderWidth:3,
                            hoverBorderColor:'#000'
                        }]
                },
                options:{
                    title:{
                        display:true,
                        text:'Numarul de km',
                        fontSize:25
                    },
                    legend:{
                        display:false,
                        position:'right',
                        labels:{
                            fontColor:'#000'
                        }
                    },
                    layout:{
                        padding:{
                            left:50,
                            right:0,
                            bottom:0,
                            top:0
                        }
                    },
                    tooltips:{
                        enabled:true
                    }
                }
            });
        </script>

        <script>
            let myChart2 = document.getElementById('myChart2').getContext('2d');

            // Global Options
            Chart.defaults.global.defaultFontFamily = 'Lato';
            Chart.defaults.global.defaultFontSize = 18;
            Chart.defaults.global.defaultFontColor = '#777';

            let massPopChart2 = new Chart(myChart2, {
                type:'line', // bar, horizontalBar, pie, line, doughnut, radar, polarArea
                data:{

                    labels: [
                        <c:forEach var="inf" items="${requestScope.quantityOfFuel}">
                        '${inf.x}',
                        </c:forEach>
                    ],
                    datasets:[{
                        label:'Cantitatea de motorina',
                        data:[
                            <c:forEach var="inf" items="${requestScope.quantityOfFuel}">
                            '${inf.y}',
                            </c:forEach>
                        ],

                        //backgroundColor:'green',
                        backgroundColor:[
                            'rgba(255, 99, 132, 0.6)',
                            'rgba(54, 162, 235, 0.6)',
                            'rgba(255, 206, 86, 0.6)',
                            'rgba(75, 192, 192, 0.6)',
                            'rgba(153, 102, 255, 0.6)',
                            'rgba(255, 159, 64, 0.6)',
                            'rgba(255, 99, 132, 0.6)'
                        ],
                        borderWidth:1,
                        borderColor:'#777',
                        hoverBorderWidth:3,
                        hoverBorderColor:'#000'
                    }]
                },
                options:{
                    title:{
                        display:true,
                        text:'Cantitatea de motorina(l)',
                        fontSize:25
                    },
                    legend:{
                        display:false,
                        position:'right',
                        labels:{
                            fontColor:'#000'
                        }
                    },
                    layout:{
                        padding:{
                            left:50,
                            right:0,
                            bottom:0,
                            top:0
                        }
                    },
                    tooltips:{
                        enabled:true
                    }
                }
            });
        </script>

        <script>
            let myChart3 = document.getElementById('myChart3').getContext('2d');

            // Global Options
            Chart.defaults.global.defaultFontFamily = 'Lato';
            Chart.defaults.global.defaultFontSize = 18;
            Chart.defaults.global.defaultFontColor = '#777';

            let massPopChart3 = new Chart(myChart3, {
                type:'line', // bar, horizontalBar, pie, line, doughnut, radar, polarArea
                data:{

                    labels: [
                        <c:forEach var="inf" items="${requestScope.consumption}">
                        '${inf.x}',
                        </c:forEach>
                    ],
                    datasets:[{
                        label:'Consumul(%)',
                        data:[
                            <c:forEach var="inf" items="${requestScope.consumption}">
                            '${inf.y}',
                            </c:forEach>
                        ],

                        //backgroundColor:'green',
                        backgroundColor:[
                            'rgba(255, 99, 132, 0.6)',
                            'rgba(54, 162, 235, 0.6)',
                            'rgba(255, 206, 86, 0.6)',
                            'rgba(75, 192, 192, 0.6)',
                            'rgba(153, 102, 255, 0.6)',
                            'rgba(255, 159, 64, 0.6)',
                            'rgba(255, 99, 132, 0.6)'
                        ],
                        borderWidth:1,
                        borderColor:'#777',
                        hoverBorderWidth:3,
                        hoverBorderColor:'#000'
                    }]
                },
                options:{
                    title:{
                        display:true,
                        text:'Consumul',
                        fontSize:25
                    },
                    legend:{
                        display:false,
                        position:'right',
                        labels:{
                            fontColor:'#000'
                        }
                    },
                    layout:{
                        padding:{
                            left:50,
                            right:0,
                            bottom:0,
                            top:0
                        }
                    },
                    tooltips:{
                        enabled:true
                    }
                }
            });
        </script>
    </body>
</html>
