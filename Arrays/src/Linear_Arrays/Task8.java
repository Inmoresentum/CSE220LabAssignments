package Linear_Arrays;

import java.io.*;
import java.util.StringTokenizer;

public class Task8 {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
    static final int range = (int) 1e6 + 1;
    static int[] repetition_count = new int[range];

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

    static boolean same_number_of_repetition(int[] arr) {
        int max_element = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            repetition_count[arr[i]]++;
            if (arr[i] > max_element) max_element = arr[i];
        }
        boolean contains = false;
        for (int i = 0; i <= max_element; i++) {//Kind of a stupid solution, pretty inefficient.
            for (int j = 0; j <= max_element; j++) {
                if (repetition_count[i] == repetition_count[j] && repetition_count[i] > 1 && repetition_count[j] > 1 && i != j) {
                    contains = true;
                    break;
                }
            }
            if (contains) break;
        }
        return contains;
    }

    public static void main(String[] args) throws IOException {
        boolean check = same_number_of_repetition(readArray());
        br.close();
        pw.println(check);
        pw.close();
    }
}
