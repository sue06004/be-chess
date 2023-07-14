package utils;

public class StringUtils {

    public static final String NEWLINE = System.getProperty("line.separator");

    private StringUtils() {
    }

    public static String appendNewLine(String str) {
        return str + NEWLINE;
    }

    public static String createStringPosition(int file, int rank){
        return (char)('a'+file)+String.valueOf(rank);
    }
}
