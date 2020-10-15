public class FourthClass {
    public static void main(String[] args) {
        int p = 0;
        for (int i = 0; i < 30; i++) {
            if (i % 2 == 0) {
                double d = (double) i / 4;
                System.out.print(d + "; "); // вывод в одну строку
            }
        }
        System.out.println();
        int year = 2015;
        switch (year) {
            case 2014:
                System.out.println("You're 3rd year student");
                break;
            case 2015:
                System.out.println("You're 2nd year student");

            case 2016:
                System.out.println("You're 1st year student");

        }

        tableDo();
        System.out.println();
        tableFor();
        System.out.println();
        tableWhile();

        for (int i = 0; i < 130; ++i) {
            if (i % 7 == 0) System.out.print(i + " ");
            if (i / 23 == 3) break;
        }
    }

    public static int boolToInt(boolean bool) {
        return bool ? 1 : 0;
    }

    public static void tableDo() {
        System.out.println("X|Y|Z|F");
        int d, f, w;
        boolean x, y, z;
        x = false;
        d = 0;
        do {
            y = false;
            f = 0;
            do {
                z = false;
                w = 0;
                do {
                    System.out.println(boolToInt(x) + "|" + boolToInt(y) + "|" + boolToInt(z) + "|" + boolToInt(x & y | !z));
                    ++w;
                    z = !z;
                } while (w < 2);
                ++f;
                y = !y;
            } while (f < 2);
            ++d;
            x = !x;
        } while (d < 2);
    }

    public static void tableFor() {
        System.out.println("X|Y|Z|F");
        int d, f, w;
        boolean x, y, z;
        x = false;
        d = 0;
        for (; d < 2; ++d, x = !x) {
            y = false;
            f = 0;
            for (; f < 2; ++f, y = !y) {
                z = false;
                w = 0;
                for (; w < 2; ++w, z = !z) {
                    System.out.println(boolToInt(x) + "|" + boolToInt(y) + "|" + boolToInt(z) + "|" + boolToInt(x & y | !z));
                }
            }
        }
    }

    public static void tableWhile() {
        System.out.println("X|Y|Z|F");
        int d, f, w;
        boolean x, y, z;
        x = false;
        d = 0;
        while (d < 2) {
            y = false;
            f = 0;
            while (f < 2) {
                z = false;
                w = 0;
                while (w < 2) {
                    System.out.println(boolToInt(x) + "|" + boolToInt(y) + "|" + boolToInt(z) + "|" + boolToInt(x & y | !z));
                    ++w;
                    z = !z;
                }
                ++f;
                y = !y;
            }
            ++d;
            x = !x;
        }
    }
}