package commons;

public class ConvertString {
    public static String covertFirstCharToUp(String str){
        StringBuffer stringBuffer = new StringBuffer(str.substring(0,1).toUpperCase());
        stringBuffer.append(str.substring(1).toLowerCase());
        return stringBuffer.toString();
    }
}
