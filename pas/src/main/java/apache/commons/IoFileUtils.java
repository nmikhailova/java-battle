package apache.commons;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.ArrayUtils;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.CRC32;
import java.util.zip.Checksum;

public class IoFileUtils {

    public static void main(String[] args) throws Exception {
        //construct file name:
        String tempDirectoryPath = FileUtils.getTempDirectoryPath();
        System.out.println(tempDirectoryPath);
        String fileName = "test.txt";
        File file = FileUtils.getFile(tempDirectoryPath, fileName);
        //write to file:
        List<String> lines = new ArrayList<>();
        lines.add("zu");
        lines.add("some test text");
        FileUtils.writeLines(file, lines);
        //read from file:
        System.out.println(FileUtils.sizeOf(file));
        System.out.println(ArrayUtils.toString(FileUtils.readFileToByteArray(file)));
        System.out.println(FileUtils.readFileToString(file, StandardCharsets.UTF_8));
        System.out.println(FileUtils.readLines(file, StandardCharsets.UTF_8));
        //checksum:
        Checksum checksum = new CRC32();
        System.out.println(checksum.getValue());
        checksum = FileUtils.checksum(file, checksum);
        System.out.println(checksum.getValue());
        //delete file:
        FileUtils.forceDeleteOnExit(file);
    }

}
