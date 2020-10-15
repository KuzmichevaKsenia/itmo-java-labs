import static java.lang.Math.pow;

public class CryptoUser {
    public static final int p = 43;
    public static final int q = 61;
    private int privateKey;
    public int publicKey;
    public int msg;

    public CryptoUser(int ownKey) {
        this.privateKey = ownKey;
        publicKey = (int) pow(p, privateKey) % q;
    }

    public int combineKeys(CryptoUser other) {
        return (int) pow(other.publicKey, privateKey) % q;
    }

    public int readMSG(CryptoUser other) {
        return msg - combineKeys(other);
    }

    public void sendMSG(CryptoUser other, int msg) {
        other.msg = msg + combineKeys(other);
    }

    public static void main(String[] args) {
        CryptoUser Alice = new CryptoUser(3);
        CryptoUser Bob = new CryptoUser(2);

        System.out.println(Alice.combineKeys(Bob));
        System.out.println(Bob.combineKeys(Alice));

        Alice.sendMSG(Bob, 5);
        System.out.println(Bob.msg);
        System.out.println(Bob.readMSG(Alice));

        System.out.println("Alice's private key is " + Hack.hack(Alice));
    }
}
