package sorting;

import sorting.printing.PrintOneLine;
import sorting.printing.PrintingLines;
import sorting.printing.PrintingOccurrence;
import sorting.printing.PrintingStrategy;
import sorting.reading.LineReader;
import sorting.reading.LongReader;
import sorting.reading.Reader;
import sorting.reading.WordReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.*;

public class Main {
    public static void main(final String[] args) throws FileNotFoundException {
        boolean byOccurrence = false;
        boolean argsAreCorrect = true;
        String dataType = "word";
        Set<String> dataTypeOptions = Set.of("word", "long", "line");
        Set<String> sortingTypeOptions = Set.of("natural", "byCount");
        Set<String> argumentsOptions = Set.of("-sortingType", "-dataType", "-inputFile", "-outputFile");

        SortingContext sortingContext = new SortingContext();
        Reader reader = new WordReader();
        Scanner scanner = new Scanner(System.in);
        PrintStream printStream = System.out;
        PrintingStrategy printingStrategy = new PrintOneLine();


        for (int i = 0; i < args.length - 1; i++){
            if (!argumentsOptions.contains(args[i])){
                argsAreCorrect = false;
                System.out.println("\"%s\" is not a valid parameter. It will be skipped.".formatted(args[i]));
                break;
            }

            if (args[i].equals("-sortingType") ) {
                if (i+1 >= args.length || !sortingTypeOptions.contains(args[i+1])) {
                    argsAreCorrect = false;
                    System.out.println("No sorting type defined!");
                    break;
                } else {
                    if ("byCount".equals(args[i + 1])) {
                        byOccurrence = true;

                    }
                    i++;
                }
            }


            if (args[i].equals("-dataType") ){
                if (i + 1 >= args.length || !dataTypeOptions.contains(args[i + 1])){
                    argsAreCorrect = false;
                    System.out.println("No data type defined!");
                    break;
                } else {
                    dataType = args[i + 1];
                    i++;
                }
            }

            if (args[i].equals("-inputFile")){
                if (i + 1 >= args.length){
                    argsAreCorrect = false;
                    break;
                } else {
                    String filename = args[i + 1];
                    scanner = new Scanner(new File(filename));
                    i++;
                }
            }

            if (args[i].equals("-outputFile")){
                if (i + 1 >= args.length){
                    argsAreCorrect = false;
                    break;
                } else {
                    String filename = args[i + 1];
                    printStream = new PrintStream(filename);
                    i++;
                }
            }


        }
        if (!argsAreCorrect) return;

        if ("long".equals(dataType)){
            reader = new LongReader();

        }
        else if ("line".equals(dataType)) {
            reader = new LineReader();
            printingStrategy = new PrintingLines();
        }


        sortingContext.setScanner(scanner);
        sortingContext.setReader(reader);
        sortingContext.setByOccurrence(byOccurrence);
        if (byOccurrence) printingStrategy = new PrintingOccurrence();

        sortingContext.setPrintingStrategy(printingStrategy);
        sortingContext.setPrintStream(printStream);

        sortingContext.doWork();




    }


}
