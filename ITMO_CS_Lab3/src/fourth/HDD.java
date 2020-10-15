package fourth;

public class HDD implements ComputerCase {
    private int spindleSpeed;
    private int capacity;

    public HDD() {
    }

    @Override
    public void getInfo() {
        System.out.println("HDD performance characteristics:\nCapacity: " + capacity + "gb | Spindle speed: " + spindleSpeed + "rpm\n");
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setSpindleSpeed(int spindleSpeed) {
        this.spindleSpeed = spindleSpeed;
    }
}
