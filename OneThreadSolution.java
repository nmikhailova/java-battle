import java.util.HashSet;
import java.util.Set;

/**
 * Created by user on 02.04.2016.
 */
public class OneThreadSolution {

    private boolean hasDifferentDigits(long l) {
        int digit;
        Set<Integer> digits = new HashSet<>();
        digits.add(0);
        while (l > 0) {
            digit = (int) l % 10;
            l /= 10;
            digits.add(digit);
        }
        return digits.size() == 10;
    }

    private boolean canBeDivided(long l) {
        int[] digits = new int[10];
        int i = 1;
        while (l > 0) {
            digits[10 - i] = (int) l % 10;
            l /= 10;
            i++;
        }

        i = 1;
        long number = 0;
        while (i < 10) {
            number = number * 10 + digits[i];
            if (number % i > 0) {
                return false;
            }
            i++;
        }
        return true;
    }

    public void solve(long start, long fin) {
        long timeBegin = System.currentTimeMillis();
        for (long l = start; l <= fin; l += 2) {

            if (hasDifferentDigits(l) && canBeDivided(l)) {
                System.out.println("The result is " + l + "0");
                long timeEnd = System.currentTimeMillis();
                System.out.print(timeEnd - timeBegin);
                System.out.println(" ms");
                return;
            }
        }
        System.out.println("No solution is found");
        long timeEnd = System.currentTimeMillis();
        System.out.print(timeEnd - timeBegin);
        System.out.println(" ms");
    }


}
