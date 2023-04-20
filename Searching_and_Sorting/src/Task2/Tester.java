package Task2;

import java.io.BufferedOutputStream;
import java.io.PrintWriter;

//Task2
public class Tester {
    static final PrintWriter pw = new PrintWriter(new BufferedOutputStream(System.out));

    public static void main(String[] args) {
        int[] test1 = {54545, -5454, 100000, 1, 3, 2, 56, 74};
        pw.print("Before sorting the array : ");
        printArray(test1);
        Selection_Sort_recursively(test1, 0, test1.length);
        pw.print("After sorting the array : ");
        printArray(test1);
        pw.close();
    }

    static void Selection_Sort_recursively(int[] array, int start, int end) {
        if (start == end) return;
        int current_value = array[start];
        int i = start;
        //Sorting the sbu-array
        while (i > 0 && array[i - 1] > current_value) {
            array[i] = array[i - 1];
            i--;
        }
        array[i] = current_value;
        Selection_Sort_recursively(array, start + 1, end);
    }

    static void printArray(int[] array) {
        if (array.length == 0) {
            pw.println("Empty Array");
            return;
        }
        pw.print("[");
        recursively_printArray(array, 0, array.length - 1); //I don't like recursion that much
        pw.println(array[array.length - 1] + "]");
    }

    static void recursively_printArray(int[] array, int start, int end) {
        if (start == end) return;
        pw.print(array[start] + ", ");
        recursively_printArray(array, start + 1, end);
    }
}
