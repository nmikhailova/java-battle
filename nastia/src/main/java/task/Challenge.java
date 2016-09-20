package task;

import java.util.LinkedHashSet;

public class Challenge {
    private synchronized boolean check1(long i) {
        LinkedHashSet setOfNumbers = new LinkedHashSet();
        String str = String.valueOf(i);
        for (int j = 0; j < str.length(); j++){
            setOfNumbers.add(str.charAt(j));
        }
        return str.length() == setOfNumbers.size();
    }

    private synchronized boolean check2(long i) {
        for (int j = 10; j >= 1; j--){
            if (i%j != 0){
                return false;
            }
            else {
                i /= 10;
            }
        }
        return true;
    }

    public synchronized long startCheck (long firstNumber, long lastNumber) {
        for (long i = firstNumber; i <= lastNumber; i += 10 ){
            if (check1(i)){
                if (check2(i)){
                    System.out.println("number " + i);
                    return(i);
                }
            }
        }
        return 0;
    }
}
