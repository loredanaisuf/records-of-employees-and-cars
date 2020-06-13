var myVar = setInterval(function(){
    geoFindMe();
}, 30000);

function geoFindMe() {

        console.log("from geoFindMe");
        const status = document.querySelector('#status');
        const mapLink = document.querySelector('#map-link');

        mapLink.href = '';
        mapLink.textContent = '';

        function success(position) {
            const latitude  = position.coords.latitude;
            const longitude = position.coords.longitude;

            status.textContent = '';
            mapLink.href = `https://www.openstreetmap.org/#map=18/${latitude}/${longitude}`;
            mapLink.textContent = `Latitude: ${latitude} °, Longitude: ${longitude} °`;

            const coordinates = latitude + ";" + longitude;
            console.log("coordinates: " + coordinates)
            const validateUserPath = "utilizatori?action=coordinates&coordinates=" + coordinates;
            console.log(validateUserPath);

            var xhttp = new XMLHttpRequest();
            xhttp.open("GET", validateUserPath, true);
            xhttp.send();
        }


        function error() {
            status.textContent = 'Unable to retrieve your location';
        }

        if(!navigator.geolocation) {
            status.textContent = 'Geolocation is not supported by your browser';
        } else {
            status.textContent = 'Locating…';
            navigator.geolocation.getCurrentPosition(success, error);
        }



}

//document.querySelector('#find-me').addEventListener('click', geoFindMe);
// window.addEventListener('load',geoFindMe);
window.addEventListener('load',myVar);

