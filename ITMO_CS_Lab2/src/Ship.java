public class Ship {
    String title; //название судна
    String captainName; //название судна
    int port; //номер порта стоянки судна (целое число)
    char type; //тип судна (буква латинского алфавита)

    public void updateShipInfo(String title) {
        this.title = title;
        System.out.println("String title = " + title);
    }

    /* НЕДОПУСТИМ
    public void updateShipInfo(String captainName) {
    }
    */

    public void updateShipInfo(int port, String title) {
        this.port = port;
        this.title = title;
        System.out.println("int port = " + port + "; String title = " + title);
    }

    public void updateShipInfo(String captainName, int port) {
        this.port = port;
        this.captainName = captainName;
        System.out.println("int port = " + port + "; String captainName = " + captainName);
    }
}