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
        </style>
        <script src="https://cdn.polyfill.io/v2/polyfill.min.js?features=fetch,requestAnimationFrame,Element.prototype.classList,URL"></script>
        <script src="https://cdn.jsdelivr.net/gh/openlayers/openlayers.github.io@master/en/v6.3.1/build/ol.js"></script>

    </head>
    <body>
        <div class="bmd-layout-container bmd-drawer-f-l" >
            <%@ include file="../includes/navbar.jsp"%>
            <main class="bmd-layout-content">
                <div id="map" class="map">
                    <div id="popup" class="ol-popup">
                        <a href="#" id="popup-closer" class="ol-popup-closer"></a>
                        <div id="popup-content"></div>
                    </div>
                </div>

                <select id="layer-select">
                    <option value="normal.day" selected>Normal Day</option>
                    <option value="normal.day.transit">Normal Day Transit</option>
                    <option value="pedestrian.day">Pedestrian Day</option>
                    <option value="terrain.day">Terrain Day</option>
                    <option value="satellite.day">Satellite Day</option>
                    <option value="hybrid.day">Hybrid Day</option>
                </select>
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
                    $(content).popover('destroy');
                    console.log("destroy added in if");
                    console.log('Name from if: ' + feature.get('name'));
                    var coordinate = event.coordinate;
                    overlay.setPosition(coordinate);
                    //content.innerHTML = feature.get('name');
                    $(container).popover({
                        placement: 'top',
                        html: true,
                        content:  feature.get('name')
                    });
                    console.log('Name from if2: ' + feature.get('name'));
                    $(container).popover('show');

                } else {
                    $(container).popover('destroy');
                }
            });

            // change mouse cursor when over marker
            map.on('pointermove', function(e) {
                if (e.dragging) {
                    $(content).popover('hide');
                    return;
                }
                // var pixel = map.getEventPixel(e.originalEvent);
                // var hit = map.hasFeatureAtPixel(pixel);
                // map.getTarget().style.cursor = hit ? 'pointer' : '';
            });
        </script>
    </body>
</html>