package Task2;

public class ClassTemperatureAdapter extends FahrenheitSensor implements MetricTemperatureSensor {
    public double getTemperatureCelsius() {
        return (readFahrenheit() - 32) * 5.0 / 9.0;
    }
}