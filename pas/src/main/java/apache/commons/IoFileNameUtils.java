package apache.commons;

import org.apache.commons.io.FilenameUtils;

public class IoFileNameUtils {

    public static void main(String[] args) throws Exception {
        String filename = "c:\\zzz\\z.txt";
        System.out.println(FilenameUtils.getExtension(filename));
        System.out.println(FilenameUtils.getBaseName(filename));
        System.out.println(FilenameUtils.getName(filename));
        System.out.println(FilenameUtils.getFullPath(filename));
        System.out.println(FilenameUtils.getPath(filename));
        System.out.println(FilenameUtils.getPathNoEndSeparator(filename));
        System.out.println(FilenameUtils.normalize(filename));
        System.out.println(FilenameUtils.separatorsToUnix(filename));
        System.out.println(FilenameUtils.directoryContains("C:\\", FilenameUtils.normalize("c:\\  pagefile.sys        ")));
    }

}
