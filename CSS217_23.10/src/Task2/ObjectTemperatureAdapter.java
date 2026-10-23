package Task2;

public class ObjectTemperatureAdapter implements MetricTemperatureSensor {
    private FahrenheitSensor sensor;

    public ObjectTemperatureAdapter(FahrenheitSensor sensor) {
        this.sensor = sensor;
    }

    public double getTemperatureCelsius() {
        return (sensor.readFahrenheit() - 32) * 5.0 / 9.0;
    }
}