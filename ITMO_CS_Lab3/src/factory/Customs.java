package factory;

public interface Customs { // Таможня
    void examine(Good good); // проверить груз
    void payment(Good good); // оплатить пошлину
    void arrest(Good good); // арестовать груз
}
