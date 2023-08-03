package sorting;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LongSortingTool implements SortingTool{
    int totalNumbers = 0;
    long maxNumber = Long.MIN_VALUE;
    int maxNumberOccurrences = 0;
    List<Long> items = new ArrayList<>();
    @Override
    public void readInput() {

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLong()) {
            long number = scanner.nextLong();
            if (number == maxNumber){
                maxNumberOccurrences++;
            }
            if (number > maxNumber){
                maxNumber = number;
                maxNumberOccurrences = 1;
            }
            items.add(number);
            totalNumbers++;
        }
    }

    @Override
    public void printMaxOccurrences() {
        System.out.println("Total numbers: " + totalNumbers);
        System.out.println("The greatest number: %d (%d time(s), %d%%).".formatted(maxNumber,
                maxNumberOccurrences,
                (maxNumberOccurrences*100)/totalNumbers ));
    }

    @Override
    public void printSorted() {
        System.out.println("Total numbers: %d.".formatted(totalNumbers));
        items.sort(Long::compareTo);
        System.out.print("Sorted data:");
        items.forEach((it) -> System.out.print(" " + it));
    }
}
