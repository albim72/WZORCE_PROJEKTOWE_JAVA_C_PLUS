package presenter;

import model.WeatherModel;
import view.WeatherView;

public class WeatherPresenter implements WeatherView.PresenterCallback {
    private final WeatherModel model;
    private final WeatherView view;

    public WeatherPresenter(WeatherModel model, WeatherView view) {
        this.model = model;
        this.view = view;
        this.view.setPresenterCallback(this);
    }

    @Override
    public void onCityEntered(String city) {
        String weather = model.getWeatherForCity(city);
        view.showWeather(city, weather);
    }
    
    public void start(){
        view.prompForCity();
    }
}
