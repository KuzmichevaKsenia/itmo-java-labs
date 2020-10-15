public class ShipTest {
    public static void main(String[] args) {
        Ship ship = new Ship();
        ship.updateShipInfo("The Black Pearl");
        ship.updateShipInfo(1,"The flying Dutchman");
        ship.updateShipInfo("Jack Sparrow", 2);
    }
}
