package sorting;

public class LineSortingTool extends StringSortingTool{
    public void printMaxOccurrences() {
        longestStrings.sort(String::compareTo);
        System.out.println("Total lines: %d.".formatted(amount));
        System.out.println("The longest line:");
        longestStrings.forEach(System.out::println);
        System.out.println(" (%d time(s), %d%%).".formatted(longestStringOccurrences,
                (longestStringOccurrences*100)/amount));
    }
}
