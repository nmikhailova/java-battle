package apache.commons;

import org.apache.commons.lang3.StringUtils;

public class LangStringUtils {
    public static void main(String[] args) {
        safeEqual();
        safeIsNotBlank();
        safeTrim();
        safeLowUpCase();
        repeat();
        safeSpitJoin();
        alphaNumerickCheck();
    }

    private static void alphaNumerickCheck() {
        System.out.println(StringUtils.isAlphanumeric("89gas78y89hGHt978t7"));
        System.out.println(StringUtils.isAlphanumeric("89gas78y89hGHt978t7-=_ "));
        System.out.println(StringUtils.isAlphanumeric(null));
    }

    private static void safeSpit() {

    }

    private static void repeat() {
        System.out.println(StringUtils.repeat("zu ", 10));
    }

    private static void safeLowUpCase() {
        System.out.println(StringUtils.lowerCase(null));
        System.out.println(StringUtils.lowerCase("TeXt"));
        System.out.println(StringUtils.upperCase(null));
        System.out.println(StringUtils.upperCase("TeXt"));
    }

    private static void safeTrim() {
        System.out.println(StringUtils.trim(null));
        System.out.println(StringUtils.trim(" \r zu \t\n"));
    }

    private static void safeSpitJoin() {
        System.out.println(StringUtils.join(new String[]{"1", "2", null, "4", "5", "6"}, ';'));
        String[] array = null;
        System.out.println(StringUtils.join(array, ';'));

        System.out.println(StringUtils.join(StringUtils.split("Some \ninteresting \ttext", ' '), '-'));
        System.out.println(StringUtils.join(StringUtils.split("Some \ninteresting \ttext", null), '-'));
        System.out.println(StringUtils.join(StringUtils.split(null, null), '-'));
    }

    private static void safeIsNotBlank() {
        seeNotBlank("zu");
        seeNotBlank(" ");
        seeNotBlank(" zu ");
    }

    private static void seeNotBlank(String text) {
        System.out.println("" + text + ": " + StringUtils.isNotBlank(text));
    }

    private static void safeEqual() {
        System.out.println(StringUtils.equals(null, null));
        System.out.println(StringUtils.equals(null, "some text"));
        System.out.println(StringUtils.equalsIgnoreCase("tExT", "text"));
    }
}
