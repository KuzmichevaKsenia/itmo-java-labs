package fourth;

public class Printer implements Peripheral {
    private String name;
    private boolean isConnected;
    private int paperSheets;

    public Printer(String name, int paperSheets) {
        this.name = name;
        isConnected = false;
        this.paperSheets = paperSheets;
    }

    @Override
    public void connect() {
        if (isConnected) System.out.println(name + " printer is already on\n");
        else {
            isConnected = true;
            System.out.println(name + " printer has been connected\n");
        }
    }

    @Override
    public void disconnect() {
        if (!isConnected) System.out.println(name + " printer is already off\n");
        else {
            isConnected = false;
            System.out.println(name + " printer has been disconnected\n");
        }
    }

    public void print(int pages) {
        if (isConnected && paperSheets >= pages) {
            paperSheets -= pages;
            System.out.println("print " + pages + " pages completed successfully\n");
        } else System.out.println("Error in printing\n");
    }

    public void replenishment(int paperSheets) {
        this.paperSheets += paperSheets;
    }
}
