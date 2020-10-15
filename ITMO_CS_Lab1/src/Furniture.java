public class Furniture {
    String table;
    String chair;
    String cabinet;

    int tables;
    int chairs;
    int cabinets;

    public Furniture() {
        table = "DORYA";
        tables = 1;
        chair = "DORYA";
        chairs = 2;
        cabinet = "DORYA";
        cabinets = 1;
    }

    public void clean() {
        table = "";
        tables = 0;
        chair = "";
        chairs = 0;
        cabinet = "";
        cabinets = 0;
    }

    public void editChair(String chair) {
        this.chair = chair;
    }

    public void editChairs(int chairs) {
        this.chairs = chairs;
    }

    public void editCabinet(String cabinet) {
        this.cabinet = cabinet;
    }

    public void editCabinets(int cabinets) {
        this.cabinets = cabinets;
    }

    public void editTable(String table) {
        this.table = table;
    }

    public void editTables(int tables) {
        this.tables = tables;
    }

    public void print() {
        System.out.println("   FURNITURE");
        System.out.println(cabinets + " " + cabinet + " cabinets");
        System.out.println(chairs + " " + chair + " chairs");
        System.out.println(tables + " " + table + " tables");
    }
}
