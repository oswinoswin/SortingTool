package sorting;

import java.util.Scanner;

public class WordSortingTool extends StringSortingTool{
    Scanner scanner = new Scanner(System.in);
    @Override
    public void readInput() {
        while (scanner.hasNext()){
            String string = scanner.next();
            processSingleInput(string);
            amount++;
        }
    }

    @Override
    public void printMaxOccurrences() {
        longestStrings.sort(String::compareTo);
        System.out.println("Total words: %d.".formatted(amount));
        System.out.print("The longest word:");
        longestStrings.forEach((word) -> System.out.print(" " + word));
        System.out.println(" (%d time(s), %d%%).".formatted(longestStringOccurrences,
                (longestStringOccurrences*100)/amount));
    }
}
