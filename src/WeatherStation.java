import java.util.ArrayList;
import java.util.List;

public class WeatherStation implements ISubject{
    private int temperature;
    List<IObserver> observers;

    public WeatherStation() {
        observers = new ArrayList<>();
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
        notifyObeservers();
    }

    @Override
    public void addObserver(IObserver o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(IObserver o) {
        observers.remove(o);
    }

    @Override
    public void notifyObeservers() {
        for(IObserver observer : observers) {
            observer.update(temperature);
        }
    }
}
