package telran.streams;

import java.util.Random;

public class SportLoto {
    public static void main(String[] args) {
        if (args.length < 3) {
            System.out.println("Usage: java SportLoto <min> <max> <count>");
            return;
        }

        int min, max, count;
        try {
            min = Integer.parseInt(args[0]);
            max = Integer.parseInt(args[1]);
            count = Integer.parseInt(args[2]);
        } catch (NumberFormatException e) {
            System.out.println("Error: All arguments must be valid integers.");
            return;
        }

        if (min > max) {
            System.out.println("Error: Minimum value cannot be greater than maximum value.");
            return;
        }

        if (count > (max - min + 1)) {
            System.out.println("Error: Requested number count exceeds the range of unique values.");
            return;
        }

        new Random().ints(min, max + 1).distinct().limit(count)
                    .forEach(n -> System.out.print(n + " "));
    }
}
