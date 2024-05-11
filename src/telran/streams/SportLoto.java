package telran.streams;

import java.util.Random;
import java.util.stream.Collectors;

public class SportLoto {
    public static void main(String[] args) {
        final int min = 1;
        final int max = 49;
        final int count = 7; 

        String result = new Random().ints(min, max + 1)
                                    .distinct()
                                    .limit(count)
                                    .boxed()
                                    .map(String::valueOf)
                                    .collect(Collectors.joining(", "));

        System.out.println(result);
    }
}
