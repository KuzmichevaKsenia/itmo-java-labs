package factory;

public class Airport implements Customs {
    double airportBank;
    static final double tariff = 0.7;
    public Airport() {
        airportBank = 0;
    }
    @Override
    public void examine(Good good) {
        if (!good.legality || good.arrested) arrest(good);
        else {
            if (!good.paid) payment(good);
            if (good.paid)
                System.out.println("Товар " + good.name.toUpperCase() + " прошел проверку. Отправка самолетом разрешена!");
        }
    }
    @Override
    public void payment(Good good) {
        if (good.paid) {
            System.out.println("Оплата таможенной пошлины товара " + good.name.toUpperCase() + " в аэропорте успешно проведена. Ваш остаток: " + good.customsDuty + "руб.");
            return;
        }
        if (good.customsDuty >= tariff * good.value) {
            good.customsDuty -= tariff * good.value;
            airportBank += tariff * good.value;
            good.paid = true;
            System.out.println("Оплата таможенной пошлины товара " + good.name.toUpperCase() + " в аэропорте успешно проведена. Ваш остаток: " + good.customsDuty + "руб.");
        } else System.out.println("Не удалось оплатить таможенную пошлину товара " + good.name.toUpperCase() + " в аэропорте.");
    }
    @Override
    public void arrest (Good good) {
        System.out.println("Груз " + good.name.toUpperCase() + " был арестован! Отправка самолетом невозможна!");
        good.arrested = true;
    }
}
