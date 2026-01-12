package Examples.zadanie;

 class TemperatureSensors {

    public double getKelvin() {
        return 300.0;
    }

    public double getFahrenheit() {
        return 86.0;
    }
}

public class TemperatureAdapter {

    private TemperatureSensors sensors;

    public TemperatureAdapter(TemperatureSensors sensors) {
        this.sensors = sensors;
    }

    public double getCelsiusFromKelvin() {
        return sensors.getKelvin() - 273.15;
    }

    public double getCelsiusFromFahrenheit() {
        return (sensors.getFahrenheit() - 32) * 5 / 9;
    }

    public static void main(String[] args) {

        TemperatureSensors sensors = new TemperatureSensors();
        TemperatureAdapter adapter = new TemperatureAdapter(sensors);

        System.out.println("Temperatura z Kelvina: " + adapter.getCelsiusFromKelvin() + " °C");
        System.out.println("Temperatura z Fahrenheita: " + adapter.getCelsiusFromFahrenheit() + " °C");
    }
}

