package sorting.printing;

import java.io.PrintStream;
import java.util.List;
import java.util.Map;

public class PrintingLines implements PrintingStrategy{
    @Override
    public <T> void print(PrintStream printStream, List<Map.Entry<T, Integer>> entries) {
        printStream.println("Sorted data:");
        entries.forEach((entry) -> printStream.println("%s ".formatted(entry.getKey()).repeat(entry.getValue())));
    }
}
