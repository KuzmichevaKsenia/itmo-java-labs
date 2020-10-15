package fourth;

public class ComputerMonitor implements Peripheral{
    private String name;
    private boolean isConnected;
    private int screenBrightness = 50;

    public ComputerMonitor(String name) {
        this.name = name;
        isConnected = false;
    }

    @Override
    public void connect() {
        if (isConnected) System.out.println(name + " monitor is already on\n");
        else {
            isConnected = true;
            System.out.println(name + " monitor has been connected\n");
        }
    }

    @Override
    public void disconnect() {
        if (!isConnected) System.out.println(name + " monitor is already off\n");
        else {
            isConnected = false;
            System.out.println(name + " monitor has been disconnected\n");
        }
    }

    public void setScreenBrightness(int percent) {
        if (isConnected && percent >= 0 && percent <= 100) {
            screenBrightness = percent;
            System.out.println("You set the screen brightness to " + percent + "%\n");
        } else System.out.println("Error in setting screen brightness for monitor\n");
    }
}