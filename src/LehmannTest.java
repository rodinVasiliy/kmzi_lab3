import java.math.BigInteger;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import static java.math.BigInteger.ZERO;
import static java.math.BigInteger.ONE;
import static java.math.BigInteger.TWO;

public class LehmannTest {

    public static BigInteger prevRandomBigInteger(BigInteger n) {
        Random rand = new Random();
        return new BigInteger(n.bitLength() - 1, rand);
    }

    public static boolean run(BigInteger n, int k) {

        if (n.equals(TWO) || n.equals(BigInteger.valueOf(3L))) {
            return true;
        }

        // если n < 2 или n четное - возвращаем false
        if (n.equals(ZERO) || n.equals(ONE) || n.remainder(TWO).equals(ZERO)) {
            return false;
        }

        List<BigInteger> listOfT = new LinkedList<>();
        BigInteger p = n.subtract(ONE).divide(TWO);
        BigInteger MINUS_ONE = n.subtract(ONE);
        // System.out.println("minus one = " + MINUS_ONE);

        for (int i = 0; i < k; ++i) {
            BigInteger a = prevRandomBigInteger(n);

            BigInteger t = a.modPow(p, n);
            listOfT.add(t);
        }
        for (BigInteger bigInteger : listOfT) {
            // System.out.println(bigInteger);
            if (!(bigInteger.equals(ONE) || bigInteger.equals(MINUS_ONE))) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        BigInteger bigInteger = new BigInteger(
                "37454863057230867346235643754867436754865875350231243857346529375236823672306512856340971234236363278769679067845778465978675657468586745252396734973293723634992385293652390674307634967329652395723769347629365237058240367370384651");
        BigInteger prime = bigInteger.nextProbablePrime();
        int k = 10;
        boolean result = run(prime, k);
        String resultString;
        if(!result){
            resultString = "this number is composite";
        }
        else{
            double probability = 1/(Math.pow(2, k));
            resultString = "this is a prime number with a probability of error " + probability;
        }
        System.out.println(resultString);
    }

}
