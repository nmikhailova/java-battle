package apache.commons;

import org.apache.commons.lang3.math.NumberUtils;

public class LangNumericUtils {
    public static void main(String[] args) {
        System.out.println(NumberUtils.max(5, 3, 77));
        System.out.println(NumberUtils.isNumber("4e5"));
        System.out.println(NumberUtils.isNumber("0x5abc"));
        System.out.println(NumberUtils.createBigDecimal(null));
        System.out.println(NumberUtils.createBigDecimal("-5.4"));
        System.out.println(NumberUtils.toInt("-5.4", 3));
        System.out.println(NumberUtils.toInt(null, 3));
    }

}
