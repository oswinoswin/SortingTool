package sorting;

import java.util.*;

public class Main {
    public static void main(final String[] args) {
        DataType dataType = DataType.WORD;
        if (args.length == 2){
            if(args[1].equals("long")) dataType = DataType.LONG;
            if(args[1].equals("line")) dataType = DataType.LINE;
        }
        Menu menu = new Menu(dataType);
        menu.readInput();
    }
}
