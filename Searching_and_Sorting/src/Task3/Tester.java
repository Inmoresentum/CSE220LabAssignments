package Task3;

import java.io.BufferedOutputStream;
import java.io.PrintWriter;

//Task3
public class Tester {
    static final PrintWriter pw = new PrintWriter(new BufferedOutputStream(System.out));

    public static void main(String[] args) {
        int[] test1 = {45245, -452354, 234, 0, 1, 3, 6, 10, 5430, 2345};
        MyList list1 = new MyList(test1);
        pw.print("Before sorting the Linked List : ");
        pw.flush();
        list1.printList();
        sortList(list1);
        pw.print("After sorting the linked list : ");
        pw.flush();
        list1.printList();
        pw.close();
    }

    static void sortList(MyList list) {     //Bubble sort but not optimized
        int size = list.length();
        Goto:
        {
            if (size < 2) break Goto;
            for (int i = 0; i < size; i++) {
                Node cur = list.head;
                Node nextNode = list.head.next;
                for (int j = 0; j < size - 1; j++) {
                    if ((int) cur.data > (int) nextNode.data) {
                        int temp = (int) cur.data;
                        cur.data = nextNode.data;
                        nextNode.data = temp;
                    }
                    cur = nextNode;
                    nextNode = nextNode.next;
                }
            }
        }
    }
}

class MyList {
    final PrintWriter pw = new PrintWriter(new BufferedOutputStream(System.out));
    Node head;

    //creates a list from an array
    MyList(int[] a) {
        if (a.length == 0) throw new RuntimeException("array can't be empty");
        head = new Node(a[0], null);
        Node current = head;
        for (int i = 1; i < a.length; i++) {
            current.next = new Node(a[i], null); //Connecting them together
            current = current.next;
        }
    }

    //prints the linked list
    void printList() {
        Node cur_element = head;
        if (cur_element == null) {
            pw.println("Empty list");
            pw.flush();
            return;
        }
        while (cur_element.next != null) {
            pw.print(cur_element.data + " -> ");
            cur_element = cur_element.next;
        }
        pw.println(cur_element.data);
        pw.flush();
    }

    int length() {
        int c = 0;
        Node cur = head;
        while (cur != null) {
            c++;
            cur = cur.next;
        }
        return c;
    }
}

class Node {
    // reference to the next element
    Node next;//By default null

    Object data;

    @SuppressWarnings("unused")
    public Node(Object dataValue, Node nextValue) {
        next = nextValue;
        data = dataValue;
    }
}