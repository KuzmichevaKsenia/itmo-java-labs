package factory;

public class Port implements Customs {
    double portBank;
    static final double tariff = 0.5;
    public Port() {
        portBank = 0;
    }
    @Override
    public void examine(Good good) {
        if (!good.legality || good.arrested) arrest(good);
        else {
            if (!good.paid) payment(good);
            if (good.paid) System.out.println("Товар " + good.name.toUpperCase() + " прошел проверку. Отправка кораблем разрешена!");
        }
    }
    @Override
    public void payment(Good good) {
        if (good.paid) {
            System.out.println("Оплата таможенной пошлины товара " + good.name.toUpperCase() + " в порте успешно проведена. Ваш остаток: " + good.customsDuty + "руб.");
            return;
        }
        if (good.customsDuty >= tariff * good.value) {
            good.customsDuty -= tariff * good.value;
            portBank += tariff * good.value;
            good.paid = true;
            System.out.println("Оплата таможенной пошлины товара " + good.name.toUpperCase() + " в порте успешно проведена. Ваш остаток: " + good.customsDuty + "руб.");
        } else System.out.println("Не удалось оплатить таможенную пошлину товара " + good.name.toUpperCase() + " в порте.");
    }
    @Override
    public void arrest (Good good) {
        System.out.println("Груз " + good.name.toUpperCase() + " был арестован! Отправка кораблем невозможна!");
        good.arrested = true;
    }
}
