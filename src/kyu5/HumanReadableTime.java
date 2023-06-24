package kyu5;

public class HumanReadableTime {
    public static String makeReadable(int seconds) {
        int hours = seconds / (60 * 60);
        seconds -= hours * 60 * 60;
        int minutes = seconds / 60;
        seconds -= minutes * 60;
        return String.format("%1$02d:%2$02d:%3$02d", hours, minutes, seconds);
    }
    public static String makeReadableClever(int seconds) {
        return String.format("%1$02d:%2$02d:%3$02d", seconds / (60*60), seconds % 3600 / 60, seconds % 60);
    }
}
