package fourth;

public class MyComputer {
    public static void main(String[] args) {

        ComputerBus bus = new ComputerBus();
        bus.setName("ISA");
        bus.getInfo();

        CPU cpu = new CPU();
        cpu.setName("INTEL Core i3 8100");
        cpu.getInfo();

        HDD hdd = new HDD();
        hdd.setCapacity(320);
        hdd.setSpindleSpeed(5400);
        hdd.getInfo();

        RAM ram = new RAM();
        ram.setCapacity(2);
        ram.getInfo();

        ComputerMonitor monitor = new ComputerMonitor("AOC e970Swn");
        monitor.connect();
        monitor.connect();
        monitor.setScreenBrightness(80);

        ComputerMouse mouse = new ComputerMouse("DEXP Rage");
        mouse.setGlowColor("blue");
        mouse.connect();
        mouse.setGlowColor("blue");

        Keyboard keyboard = new Keyboard("DEXP Rage");
        keyboard.disconnect();
        keyboard.connect();
        keyboard.setGlowColor("green");

        Printer printer = new Printer("CANON PIXMA iP2840", 5);
        printer.connect();
        printer.print(6);
        printer.replenishment(1);
        printer.print(6);
    }
}