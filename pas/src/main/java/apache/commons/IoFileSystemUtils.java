package apache.commons;

import org.apache.commons.io.FileSystemUtils;

public class IoFileSystemUtils {

    public static void main(String[] args) throws Exception {
        System.out.println(FileSystemUtils.freeSpaceKb());
        System.out.println(FileSystemUtils.freeSpaceKb("C:\\"));
    }

}
