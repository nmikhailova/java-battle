package findNumber;

import java.util.HashSet;


public class NumberFinderNoThreads {

    protected boolean checkDifferentDigits(long numberToCheck) {
        String numberString = Long.toString(numberToCheck); // convert number to string
        char[] numberArray = numberString.toCharArray(); // convert string to array
        HashSet numberSet = new HashSet();
        for (char ch : numberArray) {
            numberSet.add(ch);
        }
        // all digits are differ, if lengths of array and set are equal
        return numberString.length() == numberSet.size();
    }

    protected boolean checkRule(long numberToCheck) {
        for (int i = 1; i < 10; i++) {
            if ((numberToCheck / (int) Math.pow(10, i)) % (10 - i) != 0) {
                return false;
            }
        }
        return true;
    }


    protected long go(long startNumber, long stopNumber) {
        for (long i = startNumber; i <= stopNumber; i += 10) {
            if (checkDifferentDigits(i)) {
                if (checkRule(i)) {
                    return (i);
                }
            }
        }
        return 0;
    }


}

