import model.WeatherModel;
import presenter.WeatherPresenter;
import view.ConsoleWeatherView;


public class Main {
    public static void main(String[] args) {
        WeatherModel model = new WeatherModel();
        ConsoleWeatherView view = new ConsoleWeatherView();
        WeatherPresenter presenter = new WeatherPresenter(model, view);
        presenter.start();
    }
}
