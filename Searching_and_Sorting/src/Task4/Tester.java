package Task4;

import java.io.BufferedOutputStream;
import java.io.PrintWriter;

//Task4
public class Tester {
    static final PrintWriter pw = new PrintWriter(new BufferedOutputStream(System.out));

    public static void main(String[] args) {
        int[] test1 = {-345, -4324, -10000, 54, 64, 9, 54, 2345, 0, 1, 65, 2};
        MyList list1 = new MyList(test1);
        pw.print("Before sorting the Linked List : ");
        pw.flush();
        list1.printList();
        pw.print("After sorting the Linked List : ");
        pw.flush();
        sortList(list1);//Sorting the linked list using selection sort.
        list1.printList();//printing the list
        pw.close();//Closing the output stream
    }

    static void sortList(MyList list) {
        //Todo: I will only swap the data not the node itself which is easy.
        Node cur = list.head;
        while (cur != null) {
            Node cur_min = cur;
            Node nextNode = cur.next;
            while (nextNode != null) {
                if ((int) cur_min.data > (int) nextNode.data) cur_min = nextNode;
                nextNode = nextNode.next;
            }
            int tem = (int) cur.data; //Just swapping the data
            cur.data = cur_min.data;
            cur_min.data = tem;
            cur = cur.next;//Continuing to the next node.
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
            current.next = new Node(a[i], null);
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