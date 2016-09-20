package apache.commons;

import org.apache.commons.lang3.Validate;

import java.util.ArrayList;

public class LangValidate {
    public static void main(String[] args) {
        try {
            Validate.isTrue(4 > 5, "boolean error!");
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            Validate.notEmpty(new ArrayList<>(), "empty collection error!");
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            Validate.notNull(null, "null check error!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
