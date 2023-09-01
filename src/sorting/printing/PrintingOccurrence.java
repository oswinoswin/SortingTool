package sorting.printing;

import java.io.PrintStream;
import java.util.List;
import java.util.Map;

public class PrintingOccurrence implements PrintingStrategy{
    @Override
    public <T> void print(PrintStream printStream, List<Map.Entry<T, Integer>> entries) {
        int amount = totalAmount(entries);
        for (var entry: entries){
            printStream.println(entry.getKey() + ": "+ entry.getValue() +
                    " time(s), " + calculatePercent(amount, entry.getValue()) + "%");
        }
    }

    private static int calculatePercent(int totalAmount, int value){
        return (value*100)/totalAmount;
    }

    private <T> int totalAmount(List<Map.Entry<T, Integer>> entries){
        int amount = 0;
        for (var entry: entries) amount += entry.getValue();
        return amount;
    }
}
