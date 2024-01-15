public class WeatherWarning implements IObserver{
    private int temperature;
    @Override
    public void update(int temp) {
        temperature = temp;
        if(temperature > 20) {
            System.out.println("Advertencia de temperatura. Actualmente es: "+ temperature);
        }
    }
}
