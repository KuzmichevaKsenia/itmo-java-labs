public class StaticCheck {
    public static void main(String[] args) {
        for(;;) {
            StaticContainer.operation();
            if (StaticContainer.counter > 100) break;
        }
        System.out.println(StaticContainer.counter);
    }
}
