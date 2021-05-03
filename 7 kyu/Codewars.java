import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

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
        for (int i = 0; i < list.size(); i++) {
            max += list.get(i) * Math.pow(10, i);
        }
        return max;
    }

    /*
    Square Every Digit
     */
    public int squareDigits(int n) {
        StringBuilder builder = new StringBuilder(String.valueOf(n).length());
        while (n != 0) {
            builder.insert(0, Math.round(Math.pow(n % 10, 2)));
            n /= 10;
        }
        return Integer.parseInt(builder.toString());
    }

    /*
    Ones and Zeros
     */
    public static int ConvertBinaryArrayToInt(List<Integer> binary) {
        return IntStream.range(0, binary.size())
                .map(i -> binary.get(i) * (int) Math.pow(2, binary.size() - i - 1))
                .sum();
    }

    /*
    Easy Line
     */
    public static BigInteger easyLine(int n) {
        return IntStream.range(0, n + 1)
                .mapToObj(k -> nChooseK(n, k).pow(2))
                .reduce(BigInteger::add)
                .get();
    }

    public static BigInteger nChooseK(int n, int k) {
        return fact(n).divide(fact(k).multiply(fact(n - k)));
    }

    public static BigInteger fact(int n) {
        return n < 2 ? BigInteger.ONE : BigInteger.valueOf(n).multiply(fact(n - 1));
    }

    /*
    Reverse a Number
     */
    public static int reverse(int number) {
        return Integer.signum(number) * Integer.parseInt(new StringBuilder(0).append(Math.abs(number)).reverse().toString());
    }

    /*
    Count the divisors of a number
     */
    public long numberOfDivisors(int n) {
        return Long.signum(n) + LongStream.rangeClosed(1, n / 2)
                .filter(i -> n % i == 0)
                .count();
    }

    /*
    Bumps in the Road
     */
    public static String bumps(final String road) {
        return road.chars().filter(i -> i == 110).count() > 15 ? "Car Dead" : "Woohoo!";
    }

    /*
    Disemvowel Trolls
     */
    public static String disemvowel(String str) {
        return str.codePoints()
                .filter(i -> !Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U').contains((char) i))
                .mapToObj(i -> String.valueOf((char) i))
                .collect(Collectors.joining());
    }

    /*
    Speed Control
     */
    public static int gps(int s, double[] x) {
        return IntStream.range(0, x.length - 1)
                .map(i -> (int) (3600 * (x[i + 1] - x[i]) / s))
                .max()
                .orElse(0);
    }

    /*
    Switcheroo
     */
    public static String switcheroo(String x) {
        return x.codePoints()
                .mapToObj(i -> i == 'a' ? "b" : (i == 'b' ? "a" : "c"))
                .collect(Collectors.joining());
    }

    /*
    Harvest Festival
     */
    public static String plant(char seed, int water, int fert, int temp) {
        StringBuilder plant = new StringBuilder(2);
        for (int cluster = 0; cluster < water; cluster++) {
            for (int stem = 0; stem < water; stem++) {
                plant.append("-");
            }
            if (temp >= 20 && temp <= 30) {
                for (int flower = 0; flower < fert; flower++) {
                    plant.append(seed);
                }
            }
        }
        return temp < 20 || temp > 30 ? plant.append(seed).toString() : plant.toString();
    }

    /*
    All Star Code Challenge #22
     */
    public static String toTime(int seconds) {
        int hours = seconds / 3600;
        int minutes = (seconds - hours * 3600) / 60;
        return hours + " hour(s) and " + minutes + " minute(s)";
    }

    /*
    Small enough? - Beginner
     */
    public static boolean smallEnough(int[] a, int limit) {
        return IntStream.of(a).allMatch(i -> i <= limit);
    }

    /*
    Robinson Crusoe
     */
    public static double[] crusoe(int n, double d, double ang, double distmult, double angmult) {
        double[] coor = new double[2];
        for (int i = 0; i < n; i++) {
            coor[0] += d * Math.cos(Math.toRadians(ang));
            coor[1] += d * Math.sin(Math.toRadians(ang));
            d *= distmult;
            ang *= angmult;
        }
        return coor;
    }

    /*
    Count the Digit
     */
    public static int nbDig(int n, int d) {
        int count = 0;
        for (int i = 0; i <= n; i++) {
            count += String.valueOf(i * i).codePoints()
                    .filter(ch -> ch == Character.forDigit(d, 10))
                    .count();
        }
        return count;
    }

    /*
    Mumbling
     */
    public static String accum(String s) {
        return IntStream.range(0, s.length())
                .mapToObj(i -> s.substring(i, i + 1).repeat(i + 1))
                .map(str -> str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase())
                .collect(Collectors.joining("-"));
    }

    /*
    Moves in squared strings (I)
     */
    public static String vertMirror(String strng) {
        return Arrays.stream(strng.split("\n"))
                .map(str -> new StringBuilder(str).reverse().toString())
                .collect(Collectors.joining("\n"));
    }

    public static String horMirror(String strng) {
        return Arrays.stream(strng.split("\n"))
                .sorted((str1, str2) -> -1)
                .collect(Collectors.joining("\n"));
    }

    public static String oper(UnaryOperator<String> operator, String s) {
        return operator.apply(s);
    }
    
    /*
    Highest and Lowest
     */
    public static String highAndLow(String numbers) {
        List<Integer> list = Arrays.stream(numbers.split(" "))
                .mapToInt(Integer::parseInt)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        return String.format("%d %d", list.get(0), list.get(list.size() - 1));
    }
    
    /*
    Vowel Count
     */
    public static int getCount(String str) {
        return (int) str.codePoints()
                .filter(i -> List.of('a', 'e', 'i', 'o', 'u').contains((char) i))
                .count();
    }
    
    /*
    Isograms
     */
    public static boolean isIsogram(String str) {
        return str.toLowerCase().codePoints()
                .collect(HashSet::new, Set::add, Set::addAll)
                .size() == str.length();
    }

    /*
    Map over a list of lists
     */
    public static <T,R> R[][] gridMap(Function<T,R> fn, T[][] list) {
        R[][] R = (R[][]) Array.newInstance(list.getClass().getComponentType(), list.length);
        for (int i = 0; i < list.length; i++) {
            R[i] = (R[]) Array.newInstance(list[i].getClass().getComponentType(), list[i].length);
            for (int j = 0; j < list[i].length; j++) {
                R[i][j] = fn.apply(list[i][j]);
            }
        }
        return R;
    }
    
    /*
    Get the Middle Character
     */
    public static String getMiddle(String word) {
        if (word.length() % 2 == 0) {
            return word.substring(word.length() / 2 - 1, word.length() / 2 + 1);
        }
        return String.valueOf(word.charAt(word.length() / 2));
    }
    
    /*
    You're a square!
     */
    public static boolean isSquare(int n) {
        return Math.round(Math.sqrt(n)) == Math.sqrt(n);
    }
    
    /*
    Shortest Word
     */
    public static int findShort(String s) {
        return Arrays.stream(s.split(" "))
                .min((s1, s2) -> Integer.compare(s1.length(), s2.length()))
                .get()
                .length();
    }
    
    /*
    Jaden Casing Strings
     */
    public String toJadenCase(String phrase) {
  	if (phrase == null || phrase.isEmpty()) {
            return null;
        }
  	return Arrays.stream(phrase.split(" "))
                .map(s -> s.substring(0, 1).toUpperCase().concat(s.substring(1)))
                .collect(Collectors.joining(" "));
    }
    
}