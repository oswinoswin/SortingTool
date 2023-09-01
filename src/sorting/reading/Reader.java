package sorting.reading;

import java.util.Map;
import java.util.Scanner;

public interface Reader<T> {
    Map<T, Integer> readInput(Scanner scanner);

    default void processSingleInput(T item, Map<T, Integer> itemsAndOccurrences){
        if (itemsAndOccurrences.containsKey(item)){
            int old = itemsAndOccurrences.get(item);
            itemsAndOccurrences.replace(item, ++old);
        } else {
            itemsAndOccurrences.put(item, 1);
        }
    }

    default <T> int totalAmount(Map<T, Integer> entries){
        int amount = 0;
        for (var entry: entries.entrySet()) amount += entry.getValue();
        return amount;
    }
}
