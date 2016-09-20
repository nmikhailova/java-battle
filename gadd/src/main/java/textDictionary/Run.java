package textDictionary;

import java.util.Map;

public class Run {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Need to specify path to file in argument");
            System.exit(-1);
        }
        String path = args[0];
        CreateDictionary cd = new CreateDictionary(path);
        Map<String, Integer> dict = cd.getResult();
        for (Map.Entry<String, Integer> item : dict.entrySet()) {
            System.out.println(item.getKey() + " " + item.getValue());
        }
    }
}
