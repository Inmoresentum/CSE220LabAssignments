package Task2;

import java.io.BufferedOutputStream;
import java.io.PrintWriter;

//Task2
public class Task2 {
    static final PrintWriter pw = new PrintWriter(new BufferedOutputStream(System.out, 0b100000000));
    static final int size = 9;
    static final String[] hashing = new String[size];//Hashtable

    public static void main(String[] args) {
        //Todo: Give it some formal testcases and remove these random ones.
        String[] tester = {"WHAT84545TH565EHEL5655L656ARE656YOU69029", "OKIDOKI24857BOOMBOOM", "JAPANESE161829BAD78APPLE67", "VIETNAMESE456AREIMABA654", "BDOASDFSDFAS02457348905FSADFSDFSDF7234953245", "KLSDFGHASJLFH72634893JASDHFJAKDFH", "SADJKFHDFHJF45723643534785SJDFHD", "AJSDHFJIASD654SDKF454HSDUIFH74562347895648", "HF07234SDF78024HTJKWSDHF9PWQERHIF"};
        pw.print("After hashing ");
        make_Hashtable(tester);
        printArray();
        pw.close();
    }

    static void printArray() {
        pw.print("Index and values : [");
        for (int i = 0; i < hashing.length - 1; i++) {
            pw.print("(" + i + ", " + hashing[i] + "), ");
        }
        pw.println("(" + (hashing.length - 1) + ", " + hashing[hashing.length - 1] + ")]");
    }

    static void make_Hashtable(String[] arr) {
        for (String k : arr) {
            pair together = consonants_plus_sum_of_digits(k);
            long index = ((together.total_number_of_consonants * 3L) + together.sum_of_digits_in_the_string) % 9;
            //Todo: Properly implement Linear probing.
            if (hashing[(int) index] != null) {
                int i = (int) index + 1;
                while (i != (int) index) {
                    i %= 9;
                    if (hashing[i] == null) {
                        hashing[i] = k;
                        break;
                    }
                    i++;
                }
            } else {
                hashing[(int) index] = k;
            }
        }
    }

    static pair consonants_plus_sum_of_digits(String s) {
        pair keypair = new pair();//User defined pair class
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                //pw.println((int) s.charAt(i) - '0');
                keypair.sum_of_digits_in_the_string += (int) s.charAt(i) - '0';
                continue;
            }
            if (s.charAt(i) != 'A' && s.charAt(i) != 'E' && s.charAt(i) != 'I' && s.charAt(i) != 'O' && s.charAt(i) != 'U')
                keypair.total_number_of_consonants++;
        }
        return keypair;
    }

    static class pair {

        int total_number_of_consonants;
        int sum_of_digits_in_the_string;//Assuming sum of digits won't cause any integer overflow

        pair() {
            total_number_of_consonants = 0;
            sum_of_digits_in_the_string = 0;
        }
    }
}
