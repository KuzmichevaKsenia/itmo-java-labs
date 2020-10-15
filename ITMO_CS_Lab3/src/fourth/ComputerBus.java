package fourth;

public class ComputerBus implements ComputerCase {
    private String name = "Bus";

    public ComputerBus() {
    }

    @Override
    public void getInfo() {
        System.out.println("Bus name is " + name + '\n');
    }

    public void setName(String name) {
        this.name = name;
    }
}