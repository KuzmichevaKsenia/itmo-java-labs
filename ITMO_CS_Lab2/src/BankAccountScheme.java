public class BankAccountScheme {
    public static void main(String[] args) {
        DollarAccount usd = new DollarAccount(1, 1000);
        EuroAccount eur = new EuroAccount(2, 1000);

        usd.payIn(500);
        usd.payOut(200);
        usd.check();

        eur.payIn(800);
        eur.payOut(500);
        eur.check();
    }
}
