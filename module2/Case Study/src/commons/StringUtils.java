package commons;

public class StringUtils {
    public static final String COMMA = ",";
    public static final String CSV = ".csv";

    public static String concat(String[] content, String characters) {
        StringBuffer outStr = new StringBuffer(content[0]);
        for (int i = 1; i < content.length; i++) {
            outStr.append(characters);
            outStr.append(content[i]);
        }

        return outStr.toString();
    }



}
