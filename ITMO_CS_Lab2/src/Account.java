public class Account {
    int number;
    int limit;
    int balance;
    static final String name = "Miller";

    public Account(int number, int limit) {
        this.number = number;
        this.limit = limit;
        balance = 0;
    }

    public void check() {
        System.out.println(balance);
    }

    public void payIn(int value) {
        if (withinLimit(value)) {
            balance += value;
        } else System.out.println("Operation failed");
    }

    public void payOut(int value) {
        if (withinLimit(value)) {
            balance -= value;
        } else System.out.println("Operation failed");
    }

    private boolean withinLimit(int value) {
        if (value > 0 && value < limit) return true;
        return false;
    }
}
