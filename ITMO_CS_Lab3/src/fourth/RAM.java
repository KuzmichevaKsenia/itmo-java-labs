package fourth;

public class RAM implements ComputerCase {
    private int capacity;

    public RAM() {
    }

    @Override
    public void getInfo() {
        System.out.println("RAM performance characteristics:\nCapacity: " + capacity + "gb\n");
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
