public class TemperatureDisplay implements IObserver{
    private int temperature;
    @Override
    public void update(int temp) {
        temperature = temp;
        System.out.println("La nueva temperatura es " + temperature);
    }
}
