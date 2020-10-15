public class SecondClass {
    public static void main(String[] args) {
        String s = "13.7";
        Double a = new Double(s);
        char c = "qwe".charAt(2); // символ со 2-й позиции
        System.out.println(a);
        System.out.println(c);

        Integer iS1 = new Integer("123");
        System.out.println(iS1);
        Integer iS2 = Integer.valueOf("123");
        System.out.println(iS2);

        String s1 = "Java is one of the best languages!";
        System.out.println(s1.charAt(5));
        System.out.println(s1.equals("Java is one of the most beautiful languages!"));
        System.out.println(s1.contains("best"));

        System.out.println(s1.compareTo("Java is one of the most beautiful languages!"));
    }
}