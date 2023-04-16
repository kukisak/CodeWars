package kyu7;

public class SecondOcurrence {
    public static int secondSymbol(String str, char c) {
        int index = str.indexOf(c);
        if (index == -1) {
            return -1;
        }
        return str.indexOf(c, index+1);
    }
    public static int secondSymbolClever(String str, char c) {
        return str.indexOf(c, str.indexOf(c)+1);
    }
}
