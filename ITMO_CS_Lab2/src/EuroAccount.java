public final class EuroAccount extends Account {

    public EuroAccount(int number, int limit) {
        super(number, limit);
    }

    @Override
    public void check() {
        System.out.println(balance + "€");
    }
}
