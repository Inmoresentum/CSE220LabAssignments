package Task1;

import java.io.BufferedOutputStream;
import java.io.PrintWriter;

//Task1
public class Tester {
    static final PrintWriter pw = new PrintWriter(new BufferedOutputStream(System.out));

    public static void main(String[] args) {
        int[] array1 = {1, 2, 2, 3, 2, 3, 4, 5, -5, 5, 5, 5, 5, 6, 6, 6, 67, 7, -24, -77, -4354, (int) 1e5};
        pw.print("Printing the original array : ");
        printArray(array1);
        KeyIndex test1 = new KeyIndex(array1);
        pw.println("Does (-24) exits in the array : " + test1.search(-24));//True
        pw.println("Does 5 exits in the array : " + test1.search(5));//True
        pw.println("Does (-999) exits in the array : " + test1.search(-999));//False
        pw.println("Does (-554) exits in the array : " + test1.search(-544));//False
        int[] sorted1 = test1.sort();
        pw.print("Printing the sorted version of the array : ");
        printArray(sorted1);
        pw.close();
    }

    static void printArray(int[] array) {
        if (array.length == 0) {
            pw.println("Empty array");
            return;
        }
        pw.print("[");
        for (int i = 0; i < array.length - 1; i++) {
            pw.print(array[i] + ", ");
        }
        pw.println(array[array.length - 1] + "]");
    }
}

class KeyIndex {
    int[] k;
    int maximum;

    KeyIndex(int[] array) {
        int minimum = give_me_min(array);
        maximum = give_me_max(array);
        int max_element = Math.max(Math.abs(minimum), maximum);
        k = new int[max_element * 4 + 1];
        //Todo: Write the building part
        for (int j : array) {
            if (j >= 0) k[j]++;
            else k[maximum + Math.abs(j) + 1]++;
        }
    }

    boolean search(int val) {
        //Todo: Properly implement.
        if (val < 0) {
            int index = maximum + Math.abs(val) + 1;
            return index < k.length && index > maximum && k[index] > 0;
        } else return val <= maximum && k[val] > 0;
    }

    int[] sort() {
        //Todo: First need to find the length of the array.
        int length = 0;
        for (int j : k) if (j > 0) length += j;
        int[] sorted = new int[length];
        //Todo: First take care of the negative numbers.
        int index = 0;
        for (int i = k.length - 1; i > maximum; i--) {
            if (k[i] != 0) {
                int add = k[i];
                while (add-- > 0) {
                    sorted[index] = -(i - maximum - 1);
                    index++;
                }
            }
        }
        for (int i = 0; i <= maximum; i++) {
            if (k[i] != 0) {
                int add = k[i];
                while (add-- > 0) {
                    sorted[index] = i;
                    index++;
                }
            }
        }
        return sorted;
    }

    int give_me_max(int[] array) {
        int max = Integer.MIN_VALUE;
        for (int j : array) {
            max = Math.max(max, j);
        }
        return max;
    }

    int give_me_min(int[] array) {
        int min = Integer.MAX_VALUE;
        for (int j : array) {
            min = Math.min(min, j);
        }
        return min;
    }

}
