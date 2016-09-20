import org.junit.Assert;
import org.junit.Test;

import textDictionary.CreateDictionary;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;


public class textDictionaryTest {
    @Test
    public void runTest() {
        Map<String, Integer> check = new HashMap<>();
        for (int i = 0; i < 12; i++) {
            check.put("The", 1);
            check.put("string", 2);
            check.put("tokenizer", 1);
            check.put("class", 1);
            check.put("allows", 1);
            check.put("an", 1);
            check.put("application", 1);
            check.put("to", 1);
            check.put("break", 1);
            check.put("a", 1);
            check.put("into", 1);
            check.put("tokens", 1);
        }
        Path path = Paths.get(System.getProperty("user.dir"), "src", "test", "java", "resources", "testfile.txt");
        String filepath = path.toString();
        CreateDictionary cd = new CreateDictionary(filepath);
        Map<String, Integer> result = cd.getResult();
        Assert.assertEquals(result, check);
    }
}
