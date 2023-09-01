package sorting.printing;

import java.io.PrintStream;
import java.util.List;
import java.util.Map;

public interface PrintingStrategy {
    <T> void print(PrintStream printStream, List<Map.Entry<T, Integer>> entryList);
}
