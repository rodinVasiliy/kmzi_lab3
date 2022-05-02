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
        System.out.println("minus one = " + MINUS_ONE);

        for (int i = 0; i < k; ++i) {
            BigInteger a = prevRandomBigInteger(n);

            BigInteger t = a.modPow(p, n);
            listOfT.add(t);
        }
        for (BigInteger bigInteger : listOfT) {
            System.out.println(bigInteger);
            if (!(bigInteger.equals(ONE) || bigInteger.equals(MINUS_ONE))) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        BigInteger bigInteger = new BigInteger(
                "374548630572308673462356437548674367548658753502312438573465293752368236723065128563409712342363632787696790678457784659786756574685867452523967349732937236349923852936523906743076349673296523957237693476293652370582403673703846512");
        BigInteger prime = bigInteger.nextProbablePrime();
        boolean result = run(prime, 10);
        System.out.println("result is " + result);
    }

}
