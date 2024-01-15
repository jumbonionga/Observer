public class Main {
    public static void main(String[] args) {
        WeatherStation weatherStation = new WeatherStation();
        TemperatureDisplay temperatureDisplay = new TemperatureDisplay();
        WeatherWarning weatherWarning = new WeatherWarning();

        weatherStation.addObserver(temperatureDisplay);
        weatherStation.addObserver(weatherWarning);

        weatherStation.setTemperature(11);
        weatherStation.setTemperature(35);
    }
}
