package Ok_Circular_Array;

import java.io.*;
import java.util.StringTokenizer;

public class Task1 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    private static String[] readArray() throws IOException {
        // to read array obviously
        pw.print("Please enter all the elements of the array separated by a space : ");
        pw.flush();
        StringTokenizer tk = new StringTokenizer(br.readLine());
        int size = tk.countTokens();
        String[] array = new String[size];
        for (int i = 0; i < size; i++) {
            array[i] = tk.nextToken();
        }
        return array;
    }

    private static boolean isPalindrome(String[] array, int start, int size) {
        String[] normal_array = new String[size];
        String[] reversed_array = new String[size];
        int c = 0, i = start;
        while (c < size) {
            i %= array.length;
            normal_array[c] = array[i];
            c++;
            i++;
        }
        c = 0;
        i = size - 1 + start;
        i %= array.length;
        while (c < size) {
            if (i < 0) i = array.length - 1;
            reversed_array[c] = (array[i]);
            c++;
            i--;
        }
        for (int j = 0; j < size; j++) {
            if (!normal_array[i].equals(reversed_array[i])) return false;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        String[] array = readArray();
        pw.print("Please enter the start index of the circular array : ");
        pw.flush();
        int start = Integer.parseInt(br.readLine());
        pw.print("Please enter the size of the circular array : ");
        pw.flush();
        int size = Integer.parseInt(br.readLine());
        br.close();
        pw.println(isPalindrome(array, start, size));
        pw.close();
    }
}
