package fourth;

public class CPU implements ComputerCase {
    private String name = "CPU";

    public CPU() {
    }

    @Override
    public void getInfo() {
        System.out.println("CPU name is " + name + '\n');
    }

    public void setName(String name) {
        this.name = name;
    }
}
