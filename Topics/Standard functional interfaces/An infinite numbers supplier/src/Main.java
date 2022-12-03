import java.util.function.*;

class FunctionUtils {

    public static Supplier<Integer> getInfiniteRange() {
        return new Supplier<Integer>() {
            int n;
            @Override
            public Integer get() {
                return n++;
            }
        };
    }

}