console.log("hello nurse!")

const options = {
    enableHighAccuracy: true,
    timeout: 5000,
    maximumAge: 0
  }
  
function success(position) {
    const coordinates = position.coords;
  
    console.log('Your current position is:')
    console.log(`Latitude : ${coordinates.latitude}`)
    console.log(`Longitude: ${coordinates.longitude}`)
    console.log(`More or less ${coordinates.accuracy} meters.`)
   
    fetch(`http://localhost:8080/weather?latitude=${coordinates.latitude}&longitude=${coordinates.longitude}`)
    .then (response => response.json())
    .then (data => {
        // console.log()
      console.log(data)
      console.log(`The temperature is currently: ${data.currently.temperature}`)
    })
}

  
function error(error) {
    console.warn(`ERROR(${error.code}): ${error.message}`)
}
  
navigator.geolocation.getCurrentPosition(success, error, options)


