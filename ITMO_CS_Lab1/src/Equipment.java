public class Equipment {
    String oven;
    String microwaveOven;
    String fridge;
    String dishwasher;
    String extractorHood;
    String hob;
    String sink;

    public Equipment() {
        oven = "WOLF";
        microwaveOven = "WOLF";
        fridge = "ASKO";
        dishwasher = "ASKO";
        extractorHood = "WOLF";
        hob = "WOLF";
        sink = "SMEG";
    }

    public void clean() {
        oven = "";
        microwaveOven = "";
        fridge = "";
        dishwasher = "";
        extractorHood = "";
        hob = "";
        sink = "";
    }

    public void editSink(String sink) {
        this.sink = sink;
    }

    public void editDishwasher(String dishwasher) {
        this.dishwasher = dishwasher;
    }

    public void editExtractorHood(String extractorHood) {
        this.extractorHood = extractorHood;
    }

    public void editFridge(String fridge) {
        this.fridge = fridge;
    }

    public void editHob(String hob) {
        this.hob = hob;
    }

    public void editMicrowaveOven(String microwaveOven) {
        this.microwaveOven = microwaveOven;
    }

    public void editOven(String oven) {
        this.oven = oven;
    }

    public void print() {
        System.out.println("   EQUIPMENT");
        System.out.println("Dishwasher: " + dishwasher);
        System.out.println("Extractor hood: " + extractorHood);
        System.out.println("Fridge: " + fridge);
        System.out.println("Hob: " + hob);
        System.out.println("Microwave oven: " + microwaveOven);
        System.out.println("Oven: " + oven);
        System.out.println("Sink: " + sink);
    }
}
