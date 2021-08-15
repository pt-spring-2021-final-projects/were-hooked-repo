//fetch json data from api
// console.log(fetch('http://localhost:8080/api/waters')
//     .then(response => response.json()))

//take string of coordinates and return array of coordinates


const coordsToArray = (coords) => {

async function fetchWaters() {
    try {
        const response = await fetch(`/api/waters/`, {
            method: 'GET',
            credentials: 'same-origin'
        })
        const waters = await response.json()
        return waters
    } catch (error) {
        console.error(error);
    }
}

async function mapWaters(map) {
    const waters = await fetchWaters()
    //for each water in waters
    for (let water of waters) {
        //create a marker
        L.marker([water.latitude, water.longitude]).addTo(map)
    // const marker = L.marker([40, -84]).addTo(map)
     marker.bindPopup(`<b>${water.name}</b><br> suck it`).openPopup();
        const marker = new google.maps.Marker({
            position: {
                lat: water.latitude,
                lng: water.longitude
            },
            map: map,
            title: water.name,
            icon: {
                path: google.maps.SymbolPath.CIRCLE,
                fillColor: water.color,
                fillOpacity: 1,
                scale: 8,
                strokeColor: water.color,
                strokeWeight: 1
            }
        })
        //add marker to array
        markers.push(marker)
    }
}


// N 40° 18.559 W 082° 41.535

// Init Open Street Maps
function initmap() {
    const centerOfOhio = [40.367474, -82.996216]
    var corner1 = L.latLng(42, -80),
        corner2 = L.latLng(38, -85),
        bounds = L.latLngBounds(corner1, corner2);

    // set up the map
    const map = new L.Map('map').setView(centerOfOhio, 12);

    L.tileLayer('https://api.mapbox.com/styles/v1/{id}/tiles/{z}/{x}/{y}?access_token={accessToken}', {
        attribution: 'Map data &copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors, Imagery © <a href="https://www.mapbox.com/">Mapbox</a>',
        maxZoom: 18,
        id: 'mapbox/outdoors-v11',
        tileSize: 512,
        zoomOffset: -1,
        accessToken: 'pk.eyJ1IjoiemNhc3NpbmkiLCJhIjoiY2tzM2t0ZWd3MG9oZTJvbXR4bWc0eXpseCJ9.nY0uXdRiSG1TYWWP0Qj24Q'
    }).addTo(map)
    map.setMaxBounds(bounds)

    mapWaters(map)

    // const lat = 39.4952704
    // const long = -84.3251712
    // const marker = L.marker([40, -84]).addTo(map)
    // marker.bindPopup("<b>Tony has never been here!</b><br> suck it").openPopup();
}

initmap()
mapWaters()