package Task1;

import java.io.BufferedOutputStream;
import java.io.PrintWriter;
import java.util.Arrays;

public class Selection_Sort_Iteratively {
    static final PrintWriter pw = new PrintWriter(new BufferedOutputStream(System.out));

    public static void main(String[] args) {
        int[] test = {545, -4543, 3455, 0, 2, 6, 5, 3, 2, 2999};
        pw.println("Before sorting : " + Arrays.toString(test));
        Selection_Sort_Iterative(test);
        pw.println("After sorting : " + Arrays.toString(test));
        pw.close();
    }

    static void Selection_Sort_Iterative(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int min_index = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[min_index]) min_index = j;
            }
            //Swap part
            //Todo: I will have to complete this part soon xd:)
            if (min_index != i) {
                int tem = array[min_index];
                array[min_index] = array[i];
                array[i] = tem;
            }
        }
    }

}
