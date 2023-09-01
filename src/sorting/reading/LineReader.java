package sorting.reading;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LineReader implements Reader<String>{
    @Override
    public Map<String, Integer> readInput(Scanner scanner) {
        Map<String, Integer> itemsAndOccurrences = new HashMap<>();
        while (scanner.hasNextLine()){
            processSingleInput(scanner.nextLine(), itemsAndOccurrences);
        }
        scanner.close();
        System.out.println("Total lines: %d.".formatted(totalAmount(itemsAndOccurrences)));
        return itemsAndOccurrences;
    }

}
