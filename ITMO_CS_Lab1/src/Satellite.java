public class Satellite {
    String name;
    Double radius;
    Double period;

    public Satellite(String name, Double radius, Double period) {
        this.name = name;
        this.radius = radius;
        this.period = period;
    }

    public Double getPeriod() {
        return period;
    }

    public Double getPeriodInDays() {
        return this.period / 24;
    }

    public void print() {
        System.out.println("Name: " + this.name);
        System.out.println("Radius: " + this.radius);
        System.out.println("Period: " + this.period);
    }
}
