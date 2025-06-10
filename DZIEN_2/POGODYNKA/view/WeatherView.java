package view;

public interface WeatherView {
    void showWeather(String city, String weather);
    void prompForCity();
    void setPresenterCallback(PresenterCallback callback);
    interface PresenterCallback {
        void onCityEntered(String city);
    }
}
