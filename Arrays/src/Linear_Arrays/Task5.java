package Linear_Arrays;

import java.io.*;
import java.util.StringTokenizer;

public class Task5 {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

    static int[] readArray() throws IOException {
        // to read array obviously
        pw.print("Please enter all the elements of the array separated by a space : ");
        pw.flush();
        StringTokenizer tk = new StringTokenizer(br.readLine());
        int size = tk.countTokens();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = Integer.parseInt(tk.nextToken());
        }
        return array;
    }

    static boolean isPossible(int[] array) {
        long[] prefix_sum = make_prefix_sum(array);
        long left_part;
        for (int i = 0; i < prefix_sum.length; i++) {
            // add current sum of the elements to left part.
            left_part = prefix_sum[i];

            // find sum of rest array
            // elements (right_part)
            long right_part = prefix_sum[prefix_sum.length - 1] - prefix_sum[i];
            // if possible
            if (left_part == right_part && i + 1 < prefix_sum.length) {
                return true;
            }
        }
        return false;
    }

    static long[] make_prefix_sum(int[] arr) {
        long[] prefix_sum = new long[arr.length];
        long current = 0;
        for (int i = 0; i < arr.length; i++) {
            current += arr[i];
            prefix_sum[i] = current;
        }
        return prefix_sum;
    }

    public static void main(String[] args) throws IOException {
        int[] array = readArray();
        br.close();
        pw.println(isPossible(array));
        pw.close();
    }
}

