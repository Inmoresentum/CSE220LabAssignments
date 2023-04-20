package Linear_Arrays;

import java.io.*;
import java.util.StringTokenizer;

public class Task7 {
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

    static int give_me_Max_Bunch_Count(int[] array) {
        int max = Integer.MIN_VALUE;
        int check = array[0], count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == check) {
                count++;
            } else {
                if (count > max) max = count;
                check = array[i];
                count = 1;
            }
        }
        if (count > max) max = count; //guss I can't use this :( max = Math.max(count, max);
        return (max > 1 ? max : 0);
    }

    public static void main(String[] args) throws IOException {
        int result = give_me_Max_Bunch_Count(readArray());
        br.close();
        pw.println(result);
        pw.close();
    }
}
