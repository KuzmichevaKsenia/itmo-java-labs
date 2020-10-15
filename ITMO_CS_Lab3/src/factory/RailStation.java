package factory;

public class RailStation implements Customs {
    double RailStationBank;
    static final double tariff = 0.3;
    public RailStation() {
        RailStationBank = 0;
    }
    @Override
    public void examine(Good good) {
        if (!good.legality || good.arrested) arrest(good);
        else {
            if (!good.paid) payment(good);
            if (good.paid) System.out.println("Товар " + good.name.toUpperCase() + " прошел проверку. Отправка поездом разрешена!");
        }
    }
    @Override
    public void payment(Good good) {
        if (good.paid) {
            System.out.println("Оплата таможенной пошлины товара " + good.name.toUpperCase() + " на железнодорожной станции успешно проведена. Ваш остаток: " + good.customsDuty + "руб.");
            return;
        }
        if (good.customsDuty >= tariff * good.value) {
            good.customsDuty -= tariff * good.value;
            RailStationBank += tariff * good.value;
            good.paid = true;
            System.out.println("Оплата таможенной пошлины товара " + good.name.toUpperCase() + " на железнодорожной станции успешно проведена. Ваш остаток: " + good.customsDuty + "руб.");
        } else System.out.println("Не удалось оплатить таможенную пошлину товара " + good.name.toUpperCase() + " на железнодорожной станции.");
    }
    @Override
    public void arrest (Good good) {
        System.out.println("Груз " + good.name.toUpperCase() + " был арестован! Отправка поездом невозможна!");
        good.arrested = true;
    }
}
