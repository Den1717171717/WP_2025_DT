package Examples.zadanie;

 class PowerSource {

    public int get230V() {
        return 230;
    }

    public int get110V() {
        return 110;
    }
}

class PowerAdapter {

    private PowerSource source;

    public PowerAdapter(PowerSource source) {
        this.source = source;
    }

    public int get5VFrom230() {
        return source.get230V() / 46;
    }

    public int get5VFrom110() {
        return source.get110V() / 22;
    }

    public static void main(String[] args) {

        PowerSource source = new PowerSource();
        PowerAdapter adapter = new PowerAdapter(source);

        System.out.println("Zasilanie z 230V: " + adapter.get5VFrom230() + "V");
        System.out.println("Zasilanie z 110V: " + adapter.get5VFrom110() + "V");
    }
}
