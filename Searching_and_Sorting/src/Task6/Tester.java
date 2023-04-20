package Task6;

import java.io.BufferedOutputStream;
import java.io.PrintWriter;

//Task6
public class Tester {
    static final PrintWriter pw = new PrintWriter(new BufferedOutputStream(System.out));

    public static void main(String[] args) {
        int[] test = {1, 24, 24, 26, 29, 30, 4000, 10000};//Array in sorted order.
        int search_value1 = 10000;//The value which will be checked
        //Binary_Search_Lower_Bound method will always return and valid index even if the
        //value doesn't exits in the array. So, it needs to be checked if search_value == array[index]
        int index1 = Binary_Search_Lower_Bound(test, search_value1, -1, test.length);
        pw.println(test[index1] == search_value1 ? "Value " + search_value1 + " exits in the array and the index is " + index1 : "Value " + search_value1 + " Does not exits in the array");
        int search_value2 = -3434;//This value doesn't exits
        int index2 = Binary_Search_Lower_Bound(test, search_value2, -1, test.length);
        pw.println(test[index2] == search_value2 ? "Value " + search_value2 + " exits in the array and the index is " + index2 : "Value " + search_value2 + " Does not exits in the array");
        pw.close();
    }

    //Todo: If there are multiple same value then this method will return the index where this value occurred first
    static int Binary_Search_Lower_Bound(int[] array, int search_value, int low, int high) { //Binary Search But lower bound
        if (low + 1 >= high) return high;
        int mid = (low + high) >>> 1; //unsigned right shift which is an equivalent of (low + high) / 2 but here sign doesn't matter.
        if (array[mid] >= search_value)
            return Binary_Search_Lower_Bound(array, search_value, low, mid);
        else return Binary_Search_Lower_Bound(array, search_value, mid, high);
    }
}
