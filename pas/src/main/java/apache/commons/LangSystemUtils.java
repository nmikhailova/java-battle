package apache.commons;

import org.apache.commons.lang3.SystemUtils;

public class LangSystemUtils {
    public static void main(String[] args) {
        System.out.println(SystemUtils.getJavaHome());
        System.out.println(SystemUtils.FILE_SEPARATOR);
        System.out.println(SystemUtils.getUserHome());
        System.out.println(SystemUtils.IS_JAVA_1_7);
        System.out.println(SystemUtils.IS_OS_WINDOWS);
        System.out.println(SystemUtils.OS_VERSION);
        System.out.println(SystemUtils.FILE_ENCODING);
        System.out.println(SystemUtils.JAVA_CLASS_PATH);
        System.out.println(SystemUtils.LINE_SEPARATOR);
        System.out.println(SystemUtils.USER_TIMEZONE);
        System.out.println(SystemUtils.USER_NAME);
    }

}
