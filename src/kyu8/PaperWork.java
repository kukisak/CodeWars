package kyu8;

public class PaperWork {
    public static int paperWork(int n, int m)
    {
        if (n < 0) {
            return 0;
        } else if (m < 0) {
            return 0;
        } else {
            return n * m;
        }

    }
}
