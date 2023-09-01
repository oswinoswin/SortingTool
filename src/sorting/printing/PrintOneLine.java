package sorting.printing;

import java.io.PrintStream;
import java.util.List;
import java.util.Map;

public class PrintOneLine implements PrintingStrategy{
    @Override
    public <T> void print(PrintStream printStream, List<Map.Entry<T, Integer>> entries) {
        printStream.print("Sorted data:");
        entries.forEach((entry) -> printStream.print(" %s".formatted(entry.getKey()).repeat(entry.getValue())));
    }
}
