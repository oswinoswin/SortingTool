package sorting;

public enum DataType {
    LONG("long"),
    LINE("line"),
    WORD("word");
    private String typeName;
    DataType(String typeName) {
        this.typeName = typeName;
    }
}
