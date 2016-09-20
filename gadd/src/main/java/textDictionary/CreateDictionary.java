package textDictionary;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.HashSet;
import java.util.Set;

public class CreateDictionary {
    private String filePath;

    public CreateDictionary(String filePath) {
        this.filePath = filePath;
    }

    public Map <String, Integer> getResult() {
        try {
            List<String> wordsList = getWordsFromFile();
            Set<String> wordsSet = convertToSet(wordsList);
            return countWords(wordsSet, wordsList);
        } catch (java.io.FileNotFoundException e) {
            System.out.println("File not found");
            System.exit(-1);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }
        return null;
    }

    private List<String> getWordsFromFile() throws IOException {
        List<String> wordsArray = new ArrayList<>();
        FileReader fr = new FileReader(filePath);
        BufferedReader textReader = new BufferedReader(fr);
        String textLine;
        while ((textLine = textReader.readLine()) != null) { // to the end of file
            String[] wordsInLine = textLine.split(" "); // split string to words
            for (String i : wordsInLine) {
                if (i.length() > 0) {
                    String stripWord = strip(i);
                    if (stripWord.length() > 0) {
                        wordsArray.add(strip(i));
                    }
                }
            }
        }
        return wordsArray;
    }

    private String strip(String word) { // delete non-alphabetic characters from word
        StringBuilder wordSB = new StringBuilder(word);
        while (wordSB.length() > 0 && !Character.isAlphabetic(wordSB.charAt(0))) { // delete non-alphabetic characters from the beginning
            wordSB.deleteCharAt(0);
        }
        while (wordSB.length() > 0 && !Character.isAlphabetic(wordSB.charAt(wordSB.length() - 1))) { // delete non-alphabetic characters from the end
            wordSB.deleteCharAt(wordSB.length() - 1);
        }
        return wordSB.toString();

    }

    private Set<String> convertToSet(List<String> wordsArrayList) {
        Set<String> wordsSet = new HashSet<>();
        for (String i : wordsArrayList) {
            wordsSet.add(i);
        }
        return wordsSet;
    }

    private Map <String, Integer> countWords(Set<String> wordsSet, List<String> wordsList) {
        Map<String, Integer> result = new HashMap<>();
        for (String checkingWord : wordsSet) {
            for (String i : wordsList) {
                if (checkingWord.equals(i)) {
                    int count;
                    if (result.containsKey(checkingWord)) {
                        count = (int) result.get(checkingWord) + 1;
                    } else {
                        count = 1;
                    }
                    result.put(checkingWord, count);
                }
            }
        }
        return result;
    }
}
