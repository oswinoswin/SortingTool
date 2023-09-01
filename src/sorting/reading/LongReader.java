package sorting.reading;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LongReader implements Reader<Long>{
    @Override
    public Map<Long, Integer> readInput(Scanner scanner) {
        Map<Long, Integer> itemsAndOccurrences = new HashMap<>();
        while (scanner.hasNextLong()){
            processSingleInput(scanner.nextLong(), itemsAndOccurrences);
        }
        scanner.close();
        System.out.println("Total numbers: %d.".formatted(totalAmount(itemsAndOccurrences)));
        return itemsAndOccurrences;
    }
}
