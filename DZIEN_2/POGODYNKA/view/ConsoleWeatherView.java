package view;

import java.util.Scanner;

public class CosoleWeatherView implements WeatherView {
    private PresenterCallback callback;
    @Override
    public void showWeather(String city, String weather) {
        System.out.println("Miasto: "+city+"\nPogoda: "+weather);
    }

    @Override
    public void prompForCity() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Podaj miasto: ");
        String city = sc.nextLine();
        if(callback!=null){
            callback.onCityEntered(city);
        }
    }

    @Override
    public void setPresenterCallback(PresenterCallback callback) {
        this.callback = callback;
    }
}
