const options = {
  enableHighAccuracy: true,
  timeout: 5000,
  maximumAge: 0
}

function success(position) {
  const coordinates = position.coords;
  fetch(`http://localhost:8080/weather?latitude=${coordinates.latitude}&longitude=${coordinates.longitude}`)
    .then(response => response.json())
    .then(data => {
      document.getElementById("temp").innerHTML = data.currently.temperature
      document.getElementById("weather-icon").innerHTML = `<i id='weather-icon' class='wi wi-forecast-io-${data.currently.icon}'></i>`
      document.getElementById("summary").innerHTML = data.currently.summary
    })
}

function error(error) {
  console.warn(`ERROR(${error.code}): ${error.message}`)
}

navigator.geolocation.getCurrentPosition(success, error, options)

function myFunction() {
  var x = document.getElementById("myTopnav");
  if (x.className === "topnav") {
    x.className += " responsive";
  } else {
    x.className = "topnav";
  }
}