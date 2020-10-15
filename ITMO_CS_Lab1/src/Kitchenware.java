public class Kitchenware {
    int plates;
    int bowls;
    int cups;
    int mugs;
    int spoons;
    int forks;
    int knifes;
    int glasses;
    int saucepans;
    int pans;

    public Kitchenware() {
        bowls = 2;
        cups = 2;
        forks = 2;
        glasses = 2;
        knifes = 3;
        mugs = 2;
        pans = 1;
        plates = 2;
        saucepans = 1;
        spoons = 2;
    }

    public void clean() {
        plates = 0;
        bowls  = 0;
        cups = 0;
        mugs = 0;
        spoons = 0;
        forks = 0;
        knifes = 0;
        glasses = 0;
        saucepans = 0;
        pans = 0;
    }

    public void editBowls(int bowls) {
        this.bowls = bowls;
    }

    public void editCups(int cups) {
        this.cups = cups;
    }

    public void editForks(int forks) {
        this.forks = forks;
    }

    public void editGlasses(int glasses) {
        this.glasses = glasses;
    }

    public void editKnifes(int knifes) {
        this.knifes = knifes;
    }

    public void editMugs(int mugs) {
        this.mugs = mugs;
    }

    public void editPans(int pans) {
        this.pans = pans;
    }

    public void editPlates(int plates) {
        this.plates = plates;
    }

    public void editSaucepans(int saucepans) {
        this.saucepans = saucepans;
    }

    public void editSpoons(int spoons) {
        this.spoons = spoons;
    }

    public void print() {
        System.out.println("   KITCHENWARE");
        System.out.println(bowls + " bowls");
        System.out.println(cups + " cups");
        System.out.println(forks + " forks");
        System.out.println(glasses + " glasses");
        System.out.println(knifes + " knifes");
        System.out.println(mugs + " mugs");
        System.out.println(pans + " pans");
        System.out.println(plates + " plates");
        System.out.println(saucepans + " saucepans");
        System.out.println(spoons + " spoons");
    }
}
