package Task1;

import java.io.BufferedOutputStream;
import java.io.PrintWriter;

//Task1
public class Tester {
    static final PrintWriter pw = new PrintWriter(new BufferedOutputStream(System.out));

    public static void main(String[] args) {
        //Todo: I Should put some more random test
        int[] test = {1, 2, 3, 9, 10, 6, 7, 8, 4, 5, -53454, -34, 0, 36, 545, 764, 90, 1010};
        pw.print("Before sorting the array : ");
        printArray(test);
        pw.print("After soring the array : ");
        Selection_sor_Recursively(test, 0, test.length);
        printArray(test);
        pw.close();
    }

    static void Selection_sor_Recursively(int[] array, int start, int end) {
        if (start == end) return;
        int min_index = give_me_min_index(array, start, end - 1);//This method will return min index
        if (min_index != start) {
            int tem = array[min_index];
            array[min_index] = array[start];
            array[start] = tem;
        }
        Selection_sor_Recursively(array, start + 1, end);
    }

    static int give_me_min_index(int[] array, int start, int end) {
        if (start == end) return start;
        int min_index = give_me_min_index(array, start + 1, end); //Recursively calling the method
        return array[min_index] > array[start] ? start : min_index;
    }

    static void printArray(int[] array) {
        if (array.length == 0) {
            pw.println("Empty Array");
            return;
        }
        pw.print("[");
        recursively_printArray(array, 0, array.length - 1); //I don't like recursion
        pw.println(array[array.length - 1] + "]");
    }

    static void recursively_printArray(int[] array, int start, int end) {
        if (start == end) return;
        pw.print(array[start] + ", ");
        recursively_printArray(array, start + 1, end);
    }
}
