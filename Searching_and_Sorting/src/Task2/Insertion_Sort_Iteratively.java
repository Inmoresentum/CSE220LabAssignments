package Task2;

import java.io.BufferedOutputStream;
import java.io.PrintWriter;
import java.util.Arrays;

public class Insertion_Sort_Iteratively {
    static final PrintWriter pw = new PrintWriter(new BufferedOutputStream(System.out));

    public static void main(String[] args) {
        int[] test = {11, 13, 15, 12, 14};//Using it answer quiz xD)
        pw.println("Before sorting the array : " + Arrays.toString(test));
        Selection_Sort(test);
        pw.println("After sorting the array : " + Arrays.toString(test));
        pw.close();
    }

    static void Selection_Sort(int[] array) {
        for (int i = 1; i < array.length; i++) { //We start from the second index
            int current_value = array[i];
            int j = i;
            while (j > 0 && array[j - 1] > current_value) { //Basically sort the sub-array;
                array[j] = array[j - 1];
                j--;
            }
            array[j] = current_value;
            pw.println(Arrays.toString(array));
        }
    }
}
