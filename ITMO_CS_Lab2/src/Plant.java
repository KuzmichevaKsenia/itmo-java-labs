public class Plant {
    private String type;
    private String color;
    private String existanceArea;
    private boolean rare;

    public Plant() {
    }

    public Plant(String type, String color) {
        this.type = type;
        this.color = color;
    }

    public Plant(String type) {
        this.type = type;
    }

    public Plant(String existanceArea, boolean rare) {
        this.existanceArea = existanceArea;
        this.rare = rare;
    }

    public void print() {
        System.out.println("type: " + this.type + "; color: " + this.color + "; existanceArea: " + this.existanceArea + "; rare: " + this.rare);
    }
}
