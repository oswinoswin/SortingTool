package sorting;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class StringSortingTool implements SortingTool{
    int amount = 0;
    List<String> longestStrings = new ArrayList<>();
    int longest = -1;
    int longestStringOccurrences = 0;
    private final Scanner scanner = new Scanner(System.in);

    void processSingleInput(String string){
        if (string.length() == longest){
            longestStrings.add(string);
            longestStringOccurrences++;
        }
        else if (string.length() > longest){
            longestStrings = new ArrayList<>();
            longestStrings.add(string);
            longest = string.length();
            longestStringOccurrences = 1;
        }
    }
    @Override
    public void readInput() {
        while (scanner.hasNextLine()){
            String string = scanner.nextLine();
            processSingleInput(string);
            amount++;
        }
    }
    public abstract void printMaxOccurrences();
    @Override
    public void printSorted() {

    }
}
