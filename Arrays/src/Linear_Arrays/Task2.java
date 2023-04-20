package Linear_Arrays;

import java.io.*;
import java.util.StringTokenizer;

public class Task2 {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

    static int[] readArray() throws IOException {
        // to read array obviously
        pw.print("Please enter the elements of the array separated by a space : ");
        pw.flush();
        StringTokenizer tk = new StringTokenizer(br.readLine());
        int size = tk.countTokens();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = Integer.parseInt(tk.nextToken());
        }
        return array;
    }

    static void rotateLeft(int[] array, int cell) {
        int[] New_array = new int[array.length];
        int count = 0;
        for (int i = cell; i < array.length; i++) {
            New_array[count] = array[i];
            count++;
        }
        for (int i = 0; i < cell; i++) {
            New_array[count] = array[i];
            count++;
        }
        print_Array(New_array);
    }

    static void print_Array(int[] array) {
        // printing the array.
        pw.print("[ ");
        for (int i = 0; i < array.length - 1; i++) {
            pw.print(array[i] + ", ");
        }
        pw.println(array[array.length - 1] + " ]");
    }

    public static void main(String[] args) throws IOException {
        int[] source = readArray();
        pw.print("Please enter the cell number : ");
        pw.flush();
        int k = Integer.parseInt(br.readLine());//cell
        br.close();
        rotateLeft(source, k);
        pw.close();
    }
}