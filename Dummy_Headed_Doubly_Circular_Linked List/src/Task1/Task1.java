package Task1;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class Task1 {
    public static void main(String[] args) {
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
        DoublyList list = new DoublyList();
        //Random test
        pw.println(list.head);//Should print null
        pw.close();
    }
}

class DoublyList {
    Node head;
}

class Node {
    Integer data;
    Node next;
    Node previous;
}