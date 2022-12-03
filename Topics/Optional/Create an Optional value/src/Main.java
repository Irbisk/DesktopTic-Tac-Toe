import java.util.Optional;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        InputStringReader reader = new InputStringReader();        
        Optional<String> value = reader.getValue();
        if (value.isPresent()) {
            System.out.println("Value is present: " + value.get());
        } else {
            System.out.println("Value is empty");
        }
    }
}

class InputStringReader {
    Scanner scanner =  new Scanner(System.in);
    String value = scanner.next();
    public Optional<String> getValue() {
        if (value.equals("empty")) {
            return Optional.empty();
        } else {
            return Optional.of(value);
        }
    }
}