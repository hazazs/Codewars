import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Codewars {

    /*
    An English Twist on a Japanese Classic
     */
    public static List<String> theGame(List<String> words) {
        int i = 0;
        while (i < words.size() && isValidWord(words, i)) {
            i++;
        }
        return words.subList(0, i);
    }
    public static boolean isValidWord(List<String> w, int i) {
        return !w.get(i).isEmpty() && (i == 0 || w.get(i - 1).endsWith(String.valueOf(w.get(i).charAt(0))));
    }

    /*
    Descending Order
     */
    public static int sortDesc(final int num) {
        int tmp = num;
        List<Integer> list = new ArrayList<>();
        while (tmp != 0) {
            list.add(tmp % 10);
            tmp /= 10;
        }
        list.sort((num1, num2) -> Integer.compare(num1, num2));
        int max = 0;
        for (int i = 0; i < list.size(); i++)
            max += list.get(i) * Math.pow(10, i);
        return max;
    }

    /*
    Square Every Digit
     */
    public int squareDigits(int n) {
        StringBuilder builder = new StringBuilder(String.valueOf(n).length());
        while (n != 0) {
            builder.insert(0, Math.round(Math.pow(n%10, 2)));
            n /= 10;
        }
        return Integer.parseInt(builder.toString());
    }
    public static BigInteger easyLine(int n) {
        return new BigInteger(String.valueOf(Math.pow(2, n)));
    }
    
    /*
    Ones and Zeros
     */
    public static int ConvertBinaryArrayToInt(List<Integer> binary) {
        return IntStream.range(0, binary.size())
                        .map(i -> binary.get(i) * (int) Math.pow(2, binary.size()-i-1))
                        .sum();
    }
    
}