import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Anagrams {

    public static List<String> loadWords(String filePath) {
    List<String> words = new ArrayList<>();
    try {
        // Read all lines into a List<String>
        List<String> lines = Files.readAllLines(Paths.get(filePath),java.nio.charset.StandardCharsets.UTF_8);

        for (String line : lines) {
            String word = line.trim().toLowerCase();
            if (!word.isEmpty()) {
                words.add(word);
            }
        }
    } catch (IOException e) {
        System.err.println("Error reading file: " + e.getMessage());
    }
    return words;
    }

    // Sorts the letters of the word alphabetically
    public static String sortString(String input) {
        char[] chars = input.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    public static Map<String, List<String>> groupAnagrams(List<String> words) {
        Map<String, List<String>> anagrams = new HashMap<>();
        for (String word : words) {
            String sortedWord = sortString(word);
            // If the key doesn't exist, create a new list
            // if (!anagrams.containsKey(sortedWord)) {
            //     anagrams.put(sortedWord, new ArrayList<>());
            // }
            anagrams.putIfAbsent(sortedWord, new ArrayList<>());
            anagrams.get(sortedWord).add(word);
        }
        return anagrams;
    }

    // Prints groups of anagrams (only if more than one word in the group)
    public static void printAnagramGroups(Map<String, List<String>> anagramMap) {
        // Optional: store lines in a list if you want to sort the output
        List<String> outputLines = new ArrayList<>();

        for (List<String> group : anagramMap.values()) {
            if (group.size() > 1) {
                Collections.sort(group);
                String line = String.join(" ", group);
                outputLines.add(line);
            }
        }

        // Sort the output lines alphabetically by the first word
        Collections.sort(outputLines);

        // Print all lines
        for (String line : outputLines) {
            System.out.println(line);
        }
    }
    
    public static void main(String[] args) {
        String filePath = "../words-utf8.txt";
        List<String> words = loadWords(filePath);
        // Group anagrams
        Map<String, List<String>> anagramMap = groupAnagrams(words);
        // Print anagram groups
        printAnagramGroups(anagramMap);
    }

}