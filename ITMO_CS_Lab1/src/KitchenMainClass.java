public class KitchenMainClass {
    public static void main(String[] args) {
        Furniture funiture1 = new Furniture();
        funiture1.editCabinet("DETOLF");
        funiture1.editCabinets(2);
        funiture1.editChair("HENRIKSDAL");
        funiture1.editChairs(6);
        funiture1.editTable("BJURSTA");
        funiture1.editTables(1);

        Equipment equipment1 = new Equipment();
        equipment1.editOven("MUMSIG");
        equipment1.editMicrowaveOven("LAGAN");
        equipment1.editFridge("NUTID");
        equipment1.editDishwasher("RENLIG");
        equipment1.editExtractorHood("LUFTIG");
        equipment1.editHob("ELDIG");
        equipment1.editSink("BOHOLMEN");

        Kitchenware kitchenware1 = new Kitchenware();
        kitchenware1.editPlates(6);
        kitchenware1.editBowls(6);
        kitchenware1.editCups(6);
        kitchenware1.editMugs(6);
        kitchenware1.editSpoons(6);
        kitchenware1.editKnifes(3);
        kitchenware1.editGlasses(6);
        kitchenware1.editSaucepans(3);
        kitchenware1.editPans(2);
        kitchenware1.editForks(6);

        Kitchen kitchen1 = new Kitchen();
        kitchen1.editArea(14.0);
        kitchen1.editColor("black, white");
        kitchen1.editStyle("modern");

        kitchen1.setEquipment(equipment1);
        kitchen1.setFurniture(funiture1);
        kitchen1.setKitchenware(kitchenware1);

        kitchen1.printFeatures();

        kitchen1.printEquipment();
        kitchen1.printFurniture();
        kitchen1.printKitchenware();

        kitchen1.delEquipment();
        kitchen1.delFurniture();
        kitchen1.delKichenware();

        System.out.println();
        kitchen1.printEquipment();
        kitchen1.printFurniture();
        kitchen1.printKitchenware();
    }
}
