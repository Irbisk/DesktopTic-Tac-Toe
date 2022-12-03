import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.*;

class BadWordsDetector {

    private static Stream<String> createBadWordsDetectingStream(String text, 
                                                                List<String> badWords) {
        List<String> list = List.of(text.split(" "));
        Predicate<String> badOnly = badWords::contains;
        List<String> newLIst = list.stream()
                .filter(badOnly)
                .sorted()
                .distinct()
                .collect(Collectors.toList());
        return newLIst.stream();
    }

    /* Do not change the code below */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] parts = scanner.nextLine().split(";");

        // the first part is a text
        String text = parts[0];

        // the second part is a bad words dictionary
        List<String> dict = parts.length > 1 ?
                Arrays.asList(parts[1].split(" ")) :
                Collections.singletonList("");

        System.out.println(createBadWordsDetectingStream(text, dict).collect(Collectors.toList()));
    }

}