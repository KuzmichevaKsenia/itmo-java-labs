package factory;

public class Good { // груз
    String name = ""; // название товара
    boolean legality; // легальность
    int value; // стоимость товара
    int customsDuty; // денежная сумма для оплаты пошлины
    boolean paid; // метка оплаты пошлины
    boolean arrested; // метка ареста

    public Good(String name, boolean legality, int value, int customsDuty) {
        this.name += name;
        this.legality = legality;
        this.value = value;
        this.customsDuty = customsDuty;
        this.paid = false;
        this.arrested = false;
    }
}
