package Task6;

public class Binary_Search_Recursive {
    static int Binary_Search(int[] array, int search_value, int lower, int upper) {
        int mid = (lower + upper) >> 1; // Same as ((lower + upper) / 2) but a bit faster
        if (upper < lower) {
            return -1;
        }

        if (search_value == array[mid]) {
            return mid;
        } else if (search_value < array[mid]) {
            return Binary_Search(array, search_value, lower, upper - 1);
        } else {
            return Binary_Search(array, search_value, mid + 1, upper);
        }
    }
}
