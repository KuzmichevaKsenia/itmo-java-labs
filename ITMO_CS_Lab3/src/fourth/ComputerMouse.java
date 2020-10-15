package fourth;

public class ComputerMouse implements Peripheral{
    private String name;
    private boolean isConnected;
    private String glowColor = "white";

    public ComputerMouse(String name) {
        this.name = name;
        isConnected = false;
    }

    @Override
    public void connect() {
        if (isConnected) System.out.println(name + " mouse is already on\n");
        else {
            isConnected = true;
            System.out.println(name + " mouse has been connected\n");
        }
    }

    @Override
    public void disconnect() {
        if (!isConnected) System.out.println(name + " mouse is already off\n");
        else {
            isConnected = false;
            System.out.println(name + " mouse has been disconnected\n");
        }
    }

    public void setGlowColor(String color) {
        if (isConnected && (color.equals("white") || color.equals("blue") || color.equals("green") || color.equals("red") || color.equals("off"))) {
            glowColor = color;
            System.out.println("You set '" + color + "' glow color for mouse\n");
        } else System.out.println("Error in setting glow color for mouse\n");
    }
}
