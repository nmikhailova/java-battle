package apache.commons;

import org.apache.commons.lang3.ObjectUtils;

public class LangObjectUtils {
    public static void main(String[] args) {
        System.out.println(ObjectUtils.firstNonNull(null, null, "zu"));
        System.out.println(ObjectUtils.identityToString(null));
        System.out.println(ObjectUtils.hashCode(null));
        System.out.println(ObjectUtils.toString(null, "you entered null"));
        System.out.println(ObjectUtils.NULL);
    }

}
