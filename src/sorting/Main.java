package sorting;

import java.util.*;

public class Main {
    public static void main(final String[] args) {
        Scanner scanner = new Scanner(System.in);
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

        System.out.print("Total numbers: " + totalNumbers);
        System.out.print("The greatest number: %d (%d time(s)).".formatted(maxNumber, maxNumberOccurences));
    }
}
