public class Kitchen {
    Double area;
    String style;
    String color;
    Furniture furniture;
    Equipment equipment;
    Kitchenware kitchenware;

    public Kitchen() {
        area = 10.0;
        style = "empire";
        color = "white, gold, blue, brown";
        furniture = new Furniture();
        equipment = new Equipment();
        kitchenware = new Kitchenware();
    }

    public void delEquipment() {
        equipment.clean();
    }

    public void delKichenware() {
        kitchenware.clean();
    }

    public void delFurniture() {
        furniture.clean();
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    public void setFurniture(Furniture furniture) {
        this.furniture = furniture;
    }

    public void setKitchenware(Kitchenware kitchenware) {
        this.kitchenware = kitchenware;
    }

    public void editArea(Double area) {
        this.area = area;
    }

    public void editColor(String color) {
        this.color = color;
    }

    public void editStyle(String style) {
        this.style = style;
    }

    public void printFurniture() {
        furniture.print();
    }

    public void printEquipment() {
        equipment.print();
    }

    public void printKitchenware() {
        kitchenware.print();
    }

    public void printFeatures() {
        System.out.println("   |KITCHEN FEATURES|");
        System.out.println("Area: " + area + " square metres");
        System.out.println("Color: " + color);
        System.out.println("Style: " + style);
    }
}