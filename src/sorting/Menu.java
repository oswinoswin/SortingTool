package sorting;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private DataType dataType;
    private Scanner scanner;

    public Menu(DataType dataType) {
        this.dataType = dataType;
        scanner = new Scanner(System.in);
    }
    
    public void readInput(){
        switch (dataType){
            case LINE -> readLines();
            case LONG -> readLongs();
            case WORD -> readWords();
        }
    }

    private void readWords() {
        int amount = 0;
        List<String> longestWords = new ArrayList<>();
        int longest = -1;
        int longestWordOccurrences = 0;
        while (scanner.hasNext()){
            String word = scanner.next();
            if (word.length() == longest){
                longestWords.add(word);
                longestWordOccurrences++;
            }
            else if (word.length() > longest){
                longestWords = new ArrayList<>();
                longestWords.add(word);
                longest = word.length();
                longestWordOccurrences = 1;
            }
            amount++;
//            longestWords.forEach(System.out::println);
        }
        longestWords.sort(String::compareTo);
        System.out.println("Total words: %d.".formatted(amount));
        System.out.print("The longest word:");
        longestWords.forEach((word) -> System.out.print(" " + word));
        System.out.print(" (%d time(s), %d%%).".formatted(longestWordOccurrences, (longestWordOccurrences*100)/amount));
    }

    private void readLongs() {
        int totalNumbers = 0;
        long maxNumber = Long.MIN_VALUE;
        int maxNumberOccurences = 0;
        while (scanner.hasNextLong()) {
            long number = scanner.nextLong();
            if (number == maxNumber){
                maxNumberOccurences++;
            }
            if (number > maxNumber){
                maxNumber = number;
                maxNumberOccurences = 1;
            }

            totalNumbers++;
        }

        System.out.println("Total numbers: " + totalNumbers);
        System.out.println("The greatest number: %d (%d time(s), %d%%).".formatted(maxNumber, maxNumberOccurences, (maxNumberOccurences*100)/totalNumbers ));
    }

    private void readLines() {
        int amount = 0;
        List<String> longestWords = new ArrayList<>();
        int longest = -1;
        int longestWordOccurrences = 0;
        while (scanner.hasNext()){
            String word = scanner.nextLine();
            if (word.length() == longest){
                longestWords.add(word);
                longestWordOccurrences++;
            }
            else if (word.length() > longest){
                longestWords = new ArrayList<>();
                longestWords.add(word);
                longest = word.length();
                longestWordOccurrences = 1;
            }
            amount++;
//            longestWords.forEach(System.out::println);
        }
        longestWords.sort(String::compareTo);
        System.out.println("Total lines: %d.".formatted(amount));
        System.out.println("The longest line:");
        longestWords.forEach(System.out::println);
        System.out.println("(%d time(s), %d%%).".formatted(longestWordOccurrences, (longestWordOccurrences*100)/amount));
    }
}
