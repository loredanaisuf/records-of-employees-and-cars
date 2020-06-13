<%@ include file="../includes/jsp_jstl.jsp"%>
<html>
<head>
    <%@ include file="../includes/head.jsp"%>
    <title>Locatii</title>
    <meta name="viewport" content="initial-scale=1.0, user-scalable=no">
    <meta charset="utf-8">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/gh/openlayers/openlayers.github.io@master/en/v6.3.1/css/ol.css" type="text/css">
    <style>
        .map {
            height: 700px;
            width: 100%;
        }
        .ol-popup {
            position: absolute;
            background-color: white;
            box-shadow: 0 1px 4px rgba(0,0,0,0.2);
            padding: 15px;
            border-radius: 10px;
            border: 1px solid #cccccc;
            bottom: 12px;
            left: -50px;
            min-width: 280px;
        }
        .ol-popup:after, .ol-popup:before {
            top: 100%;
            border: solid transparent;
            content: " ";
            height: 0;
            width: 0;
            position: absolute;
            pointer-events: none;
        }
        .ol-popup:after {
            border-top-color: white;
            border-width: 10px;
            left: 48px;
            margin-left: -10px;
        }
        .ol-popup:before {
            border-top-color: #cccccc;
            border-width: 11px;
            left: 48px;
            margin-left: -11px;
        }
        .ol-popup-closer {
            text-decoration: none;
            position: absolute;
            top: 2px;
            right: 8px;
        }
        .ol-popup-closer:after {
            content: "x";
        }

        .form-check-label{
            font-weight: bold;
            color: #660020;
            margin-bottom: 10px;
            size: 20px;
        }
        .form-check{
            margin-left: 20px;
        }
    </style>
    <script src="https://cdn.polyfill.io/v2/polyfill.min.js?features=fetch,requestAnimationFrame,Element.prototype.classList,URL"></script>
    <script src="https://cdn.jsdelivr.net/gh/openlayers/openlayers.github.io@master/en/v6.3.1/build/ol.js"></script>

</head>
<body>
<div class="bmd-layout-container bmd-drawer-f-l" >
    <%@ include file="../includes/navbar.jsp"%>
    <main class="bmd-layout-content" style="overflow-y: scroll">
        <div class="container">
            <div class="row">
                <div class="col-sm-3" style=" padding: 15px; margin-top:15px;">
                    <p class="form-check-label"> Selecteaza masinile: </p>
                    <form method="post" class="form-check">
                        <c:forEach var="car" items="${requestScope.carsList}">
                            <input class="form-check-input" type="checkbox" value="true" name=${car.numarInmatriculare}  id=${car.numarInmatriculare}>
                            <label class="form-check-label" for=${car.numarInmatriculare}  >
                                    ${car.numarInmatriculare}
                            </label>
                            <span id=${car.index}> grd</span><br>
                        </c:forEach>
                        <div style="margin-left: -20px;">
                            <label for="fromData" style="font-weight: bold; color: #660020; margin-top: 10px">De la data: </label>
                            <input type="date" class="form-control" id="fromData" name="fromData"> <br>

                            <label for="toData" style="font-weight: bold ; color: #660020">pana la data: </label>
                            <input type="date" class="form-control" id="toData" name="toData"> <br>
                        </div>
                        <button type="submit" style="background-color: #660020; color:white; padding: 10px" >Submit</button>
                    </form>

                    <div id="indexOfCars" > <c:out value="${requestScope.indexOfCars}" /> </div>
                    <c:forEach items="${requestScope.coordinatesListForCars}" var="entry">
                        Key: <c:out value="${entry.key}"/>
                        Value: " <c:out value="${entry.value}"/>

                    </c:forEach>
                </div>
                <div class="col-sm-9" >
                    <div id="map" class="map"></div>
                    <div id="popup" class="ol-popup">
                        <a href="#" id="popup-closer" class="ol-popup-closer"></a>
                        <div id="popup-content"></div>
                    </div>

                    <select id="layer-select" style="display: none">
                        <option value="normal.day" selected>Normal Day</option>
                        <option value="normal.day.transit">Normal Day Transit</option>
                        <option value="pedestrian.day">Pedestrian Day</option>
                        <option value="terrain.day">Terrain Day</option>
                        <option value="satellite.day">Satellite Day</option>
                        <option value="hybrid.day">Hybrid Day</option>
                    </select>

                </div>
            </div>

        </div>


    </main>
</div>

<script type="text/javascript">



    var appId = 'BBQliC8sgdFG6KzWfhLW';
    var appCode = 'C3RH7vdWfcfqNLCUIWrudw';
    var hereLayers = [
        {
            base: 'base',
            type: 'maptile',
            scheme: 'normal.day',
            app_id: appId,
            app_code: appCode
        },
        {
            base: 'base',
            type: 'maptile',
            scheme: 'normal.day.transit',
            app_id: appId,
            app_code: appCode
        },
        {
            base: 'base',
            type: 'maptile',
            scheme: 'pedestrian.day',
            app_id: appId,
            app_code: appCode
        },
        {
            base: 'aerial',
            type: 'maptile',
            scheme: 'terrain.day',
            app_id: appId,
            app_code: appCode
        },
        {
            base: 'aerial',
            type: 'maptile',
            scheme: 'satellite.day',
            app_id: appId,
            app_code: appCode
        },
        {
            base: 'aerial',
            type: 'maptile',
            scheme: 'hybrid.day',
            app_id: appId,
            app_code: appCode
        }
    ];
    var urlTpl = 'https://{1-4}.{base}.maps.cit.api.here.com' +
        '/{type}/2.1/maptile/newest/{scheme}/{z}/{x}/{y}/256/png' +
        '?app_id={app_id}&app_code={app_code}';
    var layers = [];
    var i, ii;
    for (i = 0, ii = hereLayers.length; i < ii; ++i) {
        var layerDesc = hereLayers[i];
        layers.push(new ol.layer.Tile({
            visible: false,
            preload: Infinity,
            source: new ol.source.XYZ({
                url: createUrl(urlTpl, layerDesc),
                attributions: 'Map Tiles &copy; ' + new Date().getFullYear() + ' ' +
                    '<a href="http://developer.here.com">HERE</a>'
            })
        }));
    }

    function createUrl(tpl, layerDesc) {
        console.log(layerDesc.app_id);
        return tpl
            .replace('{base}', layerDesc.base)
            .replace('{type}', layerDesc.type)
            .replace('{scheme}', layerDesc.scheme)
            .replace('{app_id}', layerDesc.app_id)
            .replace('{app_code}', layerDesc.app_code);
    }

    var select = document.getElementById('layer-select');
    function onChange() {
        var scheme = select.value;
        for (var i = 0, ii = layers.length; i < ii; ++i) {
            layers[i].setVisible(hereLayers[i].scheme === scheme);
        }
    }
    select.addEventListener('change', onChange);
    onChange();


    var map = new ol.Map({
        target: 'map',
        layers: layers,
        // layers: [
        //     new ol.layer.Tile({
        //         source: new ol.source.OSM()
        //     })
        // ],
        view: new ol.View({
            center: ol.proj.fromLonLat([24.247, 45.817]),
            zoom: 7
        })
    });

    var iconStyle = new ol.style.Style({
        image : new ol.style.Icon(({
            scale : 0.08,
            anchor : [ 0.5, 46 ],
            anchorXUnits : 'fraction',
            anchorYUnits : 'pixels',
            opacity : 1,
            src : 'resources/images/icon.png',
        }))
    });


    var layer = new ol.layer.Vector({
        source: new ol.source.Vector({
            features: [
                <c:forEach var="elem" items="${requestScope.list}">
                new ol.Feature({
                    geometry: new ol.geom.Point(ol.proj.fromLonLat([${elem.longitudine}, ${elem.latitudine}])),
                    name: '${elem.nume},  ${elem.nrInmatriculare}'
                }),
                </c:forEach>
            ]
        }),
        style : iconStyle
    });
    map.addLayer(layer);


    var container = document.getElementById('popup');
    var content = document.getElementById('popup-content');
    var closer = document.getElementById('popup-closer');

    var overlay = new ol.Overlay({
        element: container,
        autoPan: true,
        autoPanAnimation: {
            duration: 250
        }
    });
    map.addOverlay(overlay);

    closer.onclick = function() {
        overlay.setPosition(undefined);
        closer.blur();
        return false;
    };

    map.on('singleclick', function (event) {
        console.log("In function");
        var feature = map.forEachFeatureAtPixel(event.pixel, function(feature) {
            console.log(feature);
            console.log(feature.get('name'));
            console.log(event.coordinate);
            return feature;
        });


        if (feature) {
            console.log("Popups: " + map.popups);
            // $(container).popover('destroy');
            console.log("destroy added in if");
            console.log('Name from if: ' + feature.get('name'));
            var coordinate = event.coordinate;

            //content.innerHTML = feature.get('name');
            content.innerHTML = feature.get('name');
            overlay.setPosition(coordinate);

        } else {
            overlay.setPosition(undefined);
        }
    });

    var colors = ['#eb4034','#f5ed11', '#41c70c', '#0cc776','#0cc7b7', '#0c89c7', '#0c3bc7', '#790cc7', '#c70ca2', '#1f0208' ];

    var indexOfCars = [
        <c:forEach var="car" items="${requestScope.carsList}">
            [${car.index}, ${car.selectat}],
        </c:forEach>
    ];
    console.log("lista de indexi: " + indexOfCars);
    var culori;
    for(var k = 0; k < 100; k++){
        culori = [0];
    }
    var indexCulori = 0;
    for( i=0; i < indexOfCars.length; i++){
        if(indexOfCars[i][1] == 1 ){
            culori[indexCulori++] = indexOfCars[i][0];
        }
    }
    console.log("lista de indexi pentru masinile selectate: " + culori);

    for( i=0; i < indexOfCars.length; i++){
        var id = "#" + i;
        $(id).css("color", colors[i]);
        $(id).css("background-color", colors[i]);
    }


    var points = [
        <c:forEach var="c" items="${requestScope.coordinatesList}">
            [${c.longitudine}, ${c.latitudine}],
        </c:forEach>
    ];
    console.log("lista de coordonate pentru o masina este: " + points);

    var allPoints = [
        <c:forEach var="c" items="${requestScope.allCoordinatesList}">
        [${c.longitudine}, ${c.latitudine}],
        </c:forEach>
    ];
    console.log("lista de coordonate pentru toate masinile este : " + allPoints);

    var l = 0;
    var puncte;
    for(var k = 0; k < 100; k++){
        puncte = [0, 0];
    }

    indexCulori = 0;
    for(var k = 0; k < allPoints.length; k++){
        if( allPoints[k][1] != "0") {
            puncte[l]= allPoints[k];
            l++;
        }else{
            console.log("punctele: " + puncte)
            for (var i = 0; i < puncte.length; i++) {
                puncte[i] = ol.proj.transform(puncte[i], 'EPSG:4326', 'EPSG:3857');
            }

            var featureLine = new ol.Feature({
                geometry: new ol.geom.LineString(puncte)
            });

            var vectorLine = new ol.source.Vector({});
            vectorLine.addFeature(featureLine);

            var vectorLineLayer = new ol.layer.Vector({
                source: vectorLine,
                style: new ol.style.Style({
                    fill: new ol.style.Fill({ color: colors[culori[indexCulori]], weight: 4 }),
                    stroke: new ol.style.Stroke({
                        color: colors[culori[indexCulori++]],
                        width: 2
                    })
                })
            });

            map.addLayer(vectorLineLayer);
            l = 0;
        }
    }
    console.log("puncte: " + puncte);


    //code for one line
    // for (var i = 0; i < points.length; i++) {
    //     points[i] = ol.proj.transform(points[i], 'EPSG:4326', 'EPSG:3857');
    // }
    //
    // var featureLine = new ol.Feature({
    //     geometry: new ol.geom.LineString(points)
    // });
    //
    // var vectorLine = new ol.source.Vector({});
    // vectorLine.addFeature(featureLine);
    //
    // var vectorLineLayer = new ol.layer.Vector({
    //     source: vectorLine,
    //     style: new ol.style.Style({
    //         fill: new ol.style.Fill({ color: '#d12710', weight: 4 }),
    //         stroke: new ol.style.Stroke({
    //             color: '#d12710',
    //             width: 2
    //         })
    //     })
    // });
    //
    // map.addLayer(vectorLineLayer);

    // var lonlat = ol.proj.fromLonLat([23.16653019720152, 45.13226916828158]);
    // var location2 = ol.proj.fromLonLat([25.16653019720152, 45.13226916828158]);
    //
    // var linie2style = [
    //     // linestring
    //     new ol.style.Style({
    //         stroke: new ol.style.Stroke({
    //             color: '#d12710',
    //             width: 2
    //         })
    //     })
    // ];
    //
    // var linie2 = new ol.layer.Vector({
    //     source: new ol.source.Vector({
    //         features: [new ol.Feature({
    //             geometry: new ol.geom.LineString([lonlat, location2]),
    //             name: 'Line',
    //         })]
    //     })
    // });
    //
    // linie2.setStyle(linie2style);
    // map.addLayer(linie2);
</script>
</body>
</html>
