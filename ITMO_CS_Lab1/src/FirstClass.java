public class FirstClass {
    public static void main(String[] args) {
        int i = 5;
        i += 7;
        System.out.println("i = " + i);
        double d = (double) i / 8;
        System.out.println("d = " + d);
        char c1 = 'n';
        char c2 = 110;
        char c3 = 111;
        System.out.println("c1=" + c1 + " & " + "c2=" + c2);
        boolean b1 = (c1 == c2);
        boolean b2 = (c1 == c3);
        System.out.println(b1);
        System.out.println(b2);
        int year = 2000;
        double div = year / 5;
        System.out.println(div);

        boolean l1 = true;
        boolean l2 = false;
        System.out.println(l1 & l2);
        System.out.println(l1 && l2);
        System.out.println(l1 | l2);
        System.out.println(l1 || l2);
        System.out.println(l1 ^ l2);
        System.out.println(!l1);
        System.out.println(!l2);
        System.out.println(l1 == l2);
        System.out.println(l1 != l2);

    }
}