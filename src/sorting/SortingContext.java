package sorting;

import sorting.printing.PrintingStrategy;
import sorting.reading.Reader;

import java.io.PrintStream;
import java.util.*;

public class SortingContext<T extends Comparable> {
    private Reader reader;
    private Scanner scanner;
    private boolean byOccurrence = false;
    private PrintingStrategy printingStrategy;
    private PrintStream printStream;

    private Comparator comparator;


    public void setReader(Reader reader) {
        this.reader = reader;
    }

    public void setByOccurrence(boolean byOccurrence) {
        this.byOccurrence = byOccurrence;
        comparator = byOccurrence ? new OccurrenceComparator() : Map.Entry.comparingByKey();
    }

    public void setPrintingStrategy(PrintingStrategy printingStrategy) {
        this.printingStrategy = printingStrategy;
    }


    public void setPrintStream(PrintStream printStream) {
        this.printStream = printStream;
    }
    public void doWork(){
        Map<T, Integer> itemsAndOccurrences = reader.readInput(scanner);
        List<Map.Entry<T, Integer>> entryList = new ArrayList<>(itemsAndOccurrences.entrySet());
        entryList.sort(comparator);
        printingStrategy.print(printStream, entryList);

    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }


    class OccurrenceComparator implements Comparator<Map.Entry<T, Integer>> {

        @Override
        public int compare(Map.Entry<T, Integer> e1, Map.Entry<T, Integer> e2) {
            if (e1.getValue().compareTo(e2.getValue()) != 0) return e1.getValue().compareTo(e2.getValue());
            else return e1.getKey().compareTo(e2.getKey());
        }
    }

}
