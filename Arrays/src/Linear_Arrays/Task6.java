package Linear_Arrays;

import java.io.*;

public class Task6 {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

    static int[] make_new_array(int n) {    //According the pattern
        int[] array = new int[n * n];
        int num = 1;
        int mod = n, count = 0;
        for (int i = (n * n) - 1; i > -1; i--) {
            array[i] = num;
            num++;
            if (mod != 0 && i % mod == 0) {
                num = 1;
                i -= count;
                mod--;
                count++;
            }
            if (mod == 0) num = 0;
        }
        return array;
    }

    static void print_Array(int[] array) {
        // printing the array. Is that something new?
        pw.print("[ ");
        for (int i = 0; i < array.length - 1; i++) {
            pw.print(array[i] + ", ");
        }
        pw.println(array[array.length - 1] + " ]");
    }

    public static void main(String[] args) throws IOException {
        pw.print("Please enter the number : ");
        pw.flush();
        int[] array = make_new_array(Integer.parseInt(br.readLine()));
        br.close();
        print_Array(array);
        pw.close();
    }
}
