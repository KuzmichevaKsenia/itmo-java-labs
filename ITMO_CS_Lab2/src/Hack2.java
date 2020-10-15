import static java.lang.Math.pow;

public class Hack2 {
    public static int hack2(CryptoUser2 other) {
        int p = getP(other.n);
        int q = getQ(other.n, p);
        int f = getF(p, q);
        int d = getD(f, other.n, other.e);
        return powerMod(other.y, d, other.n);
    }

    public static int powerMod(int number, int power, int n) {
        if (power > 2) return (number * (powerMod(number, --power, n))) % n;
        else return (int) pow(number, power) % n;
    }

    public static int getP(int n) {
        for (int p = 3; p < n; ++p) {
            if (n % p == 0) {
                return p;
            }
        }
        return 1;
    }

    public static int getQ(int n, int q) {
        return n / q;
    }

    public static int getF(int p, int q) {
        return p * q - p - q + 1;
    }

    public static int getD(int f, int n, int e) {
        int d = 0;
        int minK = Integer.MIN_VALUE / f;
        int maxK = Integer.MAX_VALUE / f;
        for (int k = minK; k <= maxK; ++k) {
            for (d = 1; d <= n; ++d) {
                if (d * e + k * f == 1)
                    return d;
            }
        }
        return d;
    }
}
