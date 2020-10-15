public final class DollarAccount extends Account {

    public DollarAccount(int number, int limit) {
        super(number, limit);
    }

    @Override
    public void check() {
        System.out.println(balance + "$");
    }
}
