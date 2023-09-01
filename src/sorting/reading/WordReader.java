package sorting.reading;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class WordReader implements Reader<String> {
    @Override
    public Map<String, Integer> readInput(Scanner scanner) {
        Map<String, Integer> itemsAndOccurrences = new HashMap<>();
        while (scanner.hasNext()){
            processSingleInput(scanner.next(), itemsAndOccurrences);
        }
        scanner.close();
        System.out.println("Total words: %d.".formatted(totalAmount(itemsAndOccurrences)));
        return itemsAndOccurrences;
    }
}
