import java.util.stream.*;

class QuadraticSum {
    public static long rangeQuadraticSum(int fromIncl, int toExcl) {

        return LongStream.rangeClosed(fromIncl, toExcl - 1)
                .reduce(0, (x, y) -> x + y * y);
    }
}