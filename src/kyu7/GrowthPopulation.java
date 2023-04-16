package kyu7;

public class GrowthPopulation {
    public static int nbYear(int p0, double percent, int aug, int p) {
        int currentPopulation = p0;
        int numberOfYears = 0;
        double percentage = percent / 100;
        while (currentPopulation < p && numberOfYears < Integer.MAX_VALUE) {
            currentPopulation += currentPopulation * percentage + aug;
            numberOfYears++;
        }
        return numberOfYears;
    }
}
