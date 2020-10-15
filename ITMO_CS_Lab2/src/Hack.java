import static java.lang.Math.log;
import static java.lang.Math.pow;

public class Hack {
    public static Integer hack(CryptoUser other) {
        CryptoUser me = new CryptoUser(3);
        int minK = Integer.MIN_VALUE / CryptoUser.q;
        int maxK = Integer.MAX_VALUE / CryptoUser.q;
        int ck = me.combineKeys(other);
        for (int k = minK; k <= maxK; ++k) {
            int curPossiblePk = (int) (log(other.publicKey + k * CryptoUser.q) / log (CryptoUser.p));
            if (ck == pow(me.publicKey, curPossiblePk) % CryptoUser.q) {
                return curPossiblePk;
            }
        }
        return null;
    }
}