package Ok_Circular_Array;

import java.io.*;
import java.util.StringTokenizer;

public class Task2 {
    //This solution will only work for integers less than (1e6 + 4)
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static final int range = (int) 1e6 + 5;
    private static boolean[] check = new boolean[range];

    private static int[] readArray() throws IOException {
        // to read array obviously
        pw.print("Please enter all the elements of the array separated by a space : ");
        pw.flush();
        StringTokenizer tk = new StringTokenizer(br.readLine());
        int size = tk.countTokens();//size of the array
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = Integer.parseInt(tk.nextToken());
        }
        return array;
    }

    private static int[] common_elements(int[] arr1, int start1,
                                         int size1, int[] arr2,
                                         int start2, int size2) {
        for (int k : arr1) { //I just need two arrays
            if (k != 0) check[k] = true; // I don't need to care about zeros;
        }
        int length = 0; //to count the new length of new the array
        for (int k : arr2) {
            if (check[k]) {
                length++;
            }
        }

        int[] commonElements = new int[length];
        int c = 0;
        for (int k : arr2) {
            if (check[k]) {
                commonElements[c] = k;
                c++;
            }
        }
        return commonElements;
    }

    private static void printArray(int[] array) {
        if (array.length == 0) {
            pw.println("[empty]");
            return;
        }
        pw.print("[");
        for (int i = 0; i < array.length - 1; i++) {
            pw.print(array[i] + ",");
        }
        pw.println(array[array.length - 1] + "]");
    }

    public static void main(String[] args) throws IOException {
        int[] circular_array1 = readArray();
        pw.print("Please enter the start index and the size of the" +
                " first circular array separated by a space : ");
        pw.flush();
        StringTokenizer tk = new StringTokenizer(br.readLine());
        int start1 = Integer.parseInt(tk.nextToken()),
                size1 = Integer.parseInt(tk.nextToken());
        int[] circular_array2 = readArray();
        pw.print("Please enter the start index and the size of the" +
                " second circular array separated by a space : ");
        pw.flush();
        tk = new StringTokenizer(br.readLine());
        int start2 = Integer.parseInt(tk.nextToken()),
                size2 = Integer.parseInt(tk.nextToken());
        br.close();
        int[] linear_array_with_common_elements =
                common_elements(circular_array1, start1,
                        size1, circular_array2, start2, size2);
        printArray(linear_array_with_common_elements);
        pw.close();
    }
}
