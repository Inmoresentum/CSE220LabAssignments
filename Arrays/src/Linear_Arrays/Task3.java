package Linear_Arrays;

import java.io.*;
import java.util.StringTokenizer;

public class Task3 {
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

    static void remove(int[] array, int size, int index) {
        int[] New_array = new int[array.length];
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (i == index) continue;
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
        pw.print("Please enter the size of the array : ");
        pw.flush();
        int size = Integer.parseInt(br.readLine());
        pw.print("Please enter the index of the array to be removed from the array : ");
        pw.flush();
        int index = Integer.parseInt(br.readLine());
        br.close();
        remove(source, size, index);
        pw.close();
    }
}
