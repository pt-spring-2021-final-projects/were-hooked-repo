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

    const lat = 39.4952704
    const long = -84.3251712
    const marker = L.marker([40, -84]).addTo(map)
    marker.bindPopup("<b>Tony has never been here!</b><br> suck it").openPopup();
}

console.log("add map")
initmap();