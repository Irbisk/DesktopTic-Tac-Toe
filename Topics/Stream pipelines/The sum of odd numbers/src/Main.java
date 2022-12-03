import java.util.Scanner;
import java.util.stream.LongStream;
import java.util.stream.Stream;

class Main {

    /**
     * The method calculates the sum of odd numbers in the given range
     *
     * @param start of a range, start >= 0
     * @param end of a range (inclusive), end >= start
     *
     * @return sum of odd numbers
     */
    public static long sumOfOddNumbersInRange(long start, long end) {
        return LongStream.rangeClosed(start, end)
                .filter(x -> x % 2 != 0)
                .sum();
    }

    // Don't change the code below
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] line = scanner.nextLine().trim().split(" ");

        long start = Integer.parseInt(line[0]);
        long end = Integer.parseInt(line[1]);

        System.out.println(sumOfOddNumbersInRange(start, end));
    }
}