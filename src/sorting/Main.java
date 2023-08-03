package sorting;

import java.util.*;

public class Main {
    public static void main(final String[] args) {
        SortingTool sortingTool = new WordSortingTool();
        if (args.length > 0 && Set.of(args).contains("-sortIntegers")){
            sortingTool = new LongSortingTool();
            sortingTool.readInput();
            sortingTool.printSorted();
        } else {
            if (args.length >= 2){
                if(args[1].equals("long")) sortingTool = new LongSortingTool();
                if(args[1].equals("line")) sortingTool = new LineSortingTool();
            }
            sortingTool.readInput();
            sortingTool.printMaxOccurrences();
        }
    }
}
