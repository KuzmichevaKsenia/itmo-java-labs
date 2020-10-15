package factory;

public class MainFactories {
    public static void customsHandling(CustomsFactory CF, Good good) {
        Customs customs = CF.getCustoms();
        customs.examine(good);
    }

    public static void main(String[] args) {
        Good good1 = new Good("Брошь", false, 6000000, 5000);
        customsHandling(new AirportFactory(), good1);
        System.out.println();
        Good good2 = new Good("Чайник", true, 15000, 7000);
        customsHandling(new PortFactory(), good2);
        System.out.println();
        Good good3 = new Good("Лотос", true, 300, 300);
        customsHandling(new RailStationFactory(), good3);
    }
}
