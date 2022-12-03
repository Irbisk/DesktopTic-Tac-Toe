import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        List<String> list = List.of(text.replaceAll("[.,?!:;]", "").toLowerCase().split("\\W+"));

        LinkedHashMap<String, Long> map = list.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));

        List<Word> sorted = new LinkedList<>();
        map.entrySet().stream()
                        .forEach(x -> sorted.add(new Word(x.getKey(), x.getValue())));

        sorted.stream()
                        .sorted(Comparator.comparing(Word::getCount).reversed().thenComparing(Word::getWord))
                                .limit(10)
                                        .forEach(x -> System.out.println(x.getWord()));
    }

    static class Word {
        public String word;
        public long count;

        public Word(String word, long count) {
            this.word = word;
            this.count = count;
        }

        public void setWord(String word) {
            this.word = word;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public String getWord() {
            return word;
        }

        public long getCount() {
            return count;
        }
    }
}