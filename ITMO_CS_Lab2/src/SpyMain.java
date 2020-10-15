public class SpyMain {
    public static void main(String[] args) {
        Spy n = new Spy();

        n.setName("Martens");
        n.setRealName("Philby");
        n.setSquad(1);

        System.out.println("Name: " + n.getName());
        System.out.println("Real name: " + n.getRealName());
        System.out.println("Squad: " + n.getSquad());

        System.out.println("Spy information: " + n.getPrivateSpyInf());

        n.print();
    }
}
