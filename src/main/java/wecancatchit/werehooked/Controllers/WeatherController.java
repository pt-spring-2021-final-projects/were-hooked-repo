
package wecancatchit.werehooked.Controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherController {
    @GetMapping("/weather{latitude}{longitude}")
    public String getWeather(String latitude, String longitude) throws IOException {
        System.out.println("Getting weather for " + latitude + "," + longitude);
        String units = "us";
        String urlString = "https://api.forecast.io/forecast/d8f4a1ce8e7d5acad8d319e14d7c2a20/" + latitude + "," + longitude + "?exclude=minutely,hourly,daily,alerts,flags&units=" + units;
        URL url = new URL(urlString);
        URLConnection conn = url.openConnection();
        InputStream is = conn.getInputStream();
        return new BufferedReader(new InputStreamReader(is)).readLine();
    }
}