package Task7;

import java.io.BufferedOutputStream;
import java.io.PrintWriter;
import java.math.BigInteger;

//Task7
public class Tester {
    static final PrintWriter pw = new PrintWriter(new BufferedOutputStream(System.out));
    static final int size = (int) 1e4 + 1;//This solution will only work for input <= 10^4 otherwise stackoverflow^^
    static BigInteger[] fib = new BigInteger[size];//To prevent the integer overflow I am using BigInteger

    static void generate_Fibonacci_Numbers(int i) {
        if (i > size - 1) return;
        fib[i] = fib[i - 1].add(fib[i - 2]);//fib[i - 1] + fib[i - 2]
        generate_Fibonacci_Numbers(i + 1);//Recursively calling the method
    }

    public static void main(String[] args) {
        fib[0] = BigInteger.ZERO;//Base case
        fib[1] = BigInteger.ONE;//Base case
        generate_Fibonacci_Numbers(2);//This method will generate fibonacci numbers and will store them in fib array.
        //Todo: Adding some test cases
        //It should print the first 100 fibonacci numbers.
        for (int i = 1; i < 100; i++) {
            pw.print(fib[i - 1] + " ");
        }
        pw.println(fib[99]);//100 - 1 = 99
        pw.close();//Closing the output stream.
    }

}
