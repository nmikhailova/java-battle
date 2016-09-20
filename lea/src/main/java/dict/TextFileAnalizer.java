package dict;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * Created by user on 11.04.2016.
 */
public class TextFileAnalizer {
    private String filename;

    public TextFileAnalizer(String filename) {
        this.filename = filename;
    }

    public void getText() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            Map<String, Integer> dict = new HashMap<String, Integer>();
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
                String[] words = line.toLowerCase().split("\\W");
                for (String s : words) {
                    if (dict.containsKey(s)) {
                        int val = dict.get(s).intValue() + 1;
                        dict.put(s, val);
                    } else {
                        dict.put(s, 1);
                    }

                }
            }
            br.close();
            for (String s : dict.keySet()) {
                System.out.println(s + " -> " + dict.get(s));
            }
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

    }
}
