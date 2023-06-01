package kyu6;

public class TenMinWalk {
    public static boolean isValid(char[] walk) {
        if (walk.length != 10) {
            return false;
        }
        int longitude = 0;
        int latitude = 0;
        for (char c : walk) {
            switch (c) {
                case 'n' -> latitude++;
                case 's' -> latitude--;
                case 'w' -> longitude++;
                case 'e' -> longitude--;
                default -> throw new IllegalStateException();
            }
        }
        return longitude == 0 && longitude == latitude;
    }
}
