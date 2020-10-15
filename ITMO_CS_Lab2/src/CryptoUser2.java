import static java.lang.Math.pow;

public class CryptoUser2 {
    private final int p = 43;
    private final int q = 61;
    private final int f = p * q - p - q + 1;
    private int d;
    public int y; //зашифрованное сообщение
    public int e;
    public final int n = p * q;

    public CryptoUser2(int e) {
        this.e = e;
        calcD();
    }

    private void calcD() {
        int minK = Integer.MIN_VALUE / f;
        int maxK = Integer.MAX_VALUE / f;
        for (int k = minK; k <= maxK; ++k) {
            for (d = 1; d <= n; ++d) {
                if (d * e + k * f == 1) return;
            }
        }
    }

    public int powerModN(int number, int power)
    {
        if (power > 2) return (number * (powerModN(number, --power))) % n;
        else return (int) pow(number, power) % n;
    }

    public int readMSG() {return powerModN(y, d);}

    public void sendMSG(CryptoUser2 other, int x) {
        other.y = powerModN(x, other.e);
    }

    public static void main(String[] args) {
        CryptoUser2 Bob = new CryptoUser2(23);
        CryptoUser2 Alice = new CryptoUser2(13);
        Alice.sendMSG(Bob, 784);

        System.out.println("Bob's message is " + Bob.readMSG());
        System.out.println("Bob's message is " + Hack2.hack2(Bob));
    }
}