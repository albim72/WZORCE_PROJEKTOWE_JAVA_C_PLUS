package model;

import view.WeatherView;

import java.util.HashMap;
import java.util.Map;

public class WeatherModel {
    private static final Map<String, String> weatherData = new HashMap<>();

    static {
        weatherData.put("Warszawa", "Słonecznie, 25 C");
        weatherData.put("Kraków", "Burze, 21 C");
        weatherData.put("Lublin", "Deszcz, 17 C");
        weatherData.put("Gdańsk", "Pochmurno, 19 C");
        weatherData.put("Wrocław", "Słonecznie, 27 C");
    }

    public  String getWeatherForCity(String city) {
        return weatherData.getOrDefault(city,"Brak danych pogodowych");
    }
}

