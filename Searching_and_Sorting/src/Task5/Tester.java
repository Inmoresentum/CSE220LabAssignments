package Task5;

import java.io.BufferedOutputStream;
import java.io.PrintWriter;

//Task5
public class Tester {
    static final PrintWriter pw = new PrintWriter(new BufferedOutputStream(System.out));

    public static void main(String[] args) {
        int[] test1 = {-3434, -5345, 9, 0, 2345, 356634, 245345, 2, 10, 11, 645, 111};
        MyList list = new MyList(test1);
        pw.print("Before sorting doubly linked list : ");
        printList(list);
        pw.print("Printing the linked list in reverse order using previous link : ");
        printListReverseOrder(list);//Printing in reverse order to check if everything is connected properly
        pw.print("After sorting the doubly linked list : ");
        insertionSort(list);//This method will sort my list using insertion sort.
        printList(list);
        pw.print("Printing the linked list in reverse order using previous link : ");
        printListReverseOrder(list);//Printing in reverse order to check if everything is connected properly
        pw.close();//Closing the output Stream.
    }

    //Method to sort a doubly linked list using insertion sort
    static void insertionSort(MyList list) {
        //Todo: Basically creating a newNode where all the elements will be in sorted order.
        Node sorted = null;
        //Todo: Traverse the entire list and insert each element into the sorted list.
        Node cur = list.head;
        while (cur != null) {
            Node tem = cur.next;//Storing tem to continue the iteration
            cur.previous = cur.next = null; //Removing link
            sorted = sortedInsert(sorted, cur);
            cur = tem;//continuing the iteration.
        }
        list.head = sorted; //Finally updating the list head
    }

    static Node sortedInsert(Node sorted_head, Node newNode) {
        //Todo: Handle the base cases
        if (sorted_head == null) sorted_head = newNode;
        else if ((int) sorted_head.data >= (int) newNode.data) {
            newNode.next = sorted_head;
            newNode.next.previous = newNode;
            sorted_head = newNode;
        } else {
            Node cur = sorted_head; //To traverse the sorted list and find the proper position of the inserted node.
            while (cur.next != null && (int) cur.next.data < (int) newNode.data)
                cur = cur.next;
            //Todo: Properly connect the nodes accordingly
            newNode.next = cur.next;
            if (cur.next != null)
                newNode.next.previous = newNode; //If the inserted node isn't inserted at the end of the sorted list
            cur.next = newNode;
            newNode.previous = cur;
        }
        return sorted_head;
    }

    static void printList(MyList list) { //Using next;
        Node cur = list.head;
        while (cur.next != null) {
            pw.print(cur.data + " -> ");
            cur = cur.next;
        }
        pw.println(cur.data);
    }

    static void printListReverseOrder(MyList list) {
        //Todo: will traverse to the end of the list then will start printing from that node using previous
        // and also need to check if the elements are in non increasing order while reverse printing.
        Node cur = list.head;
        while (cur.next != null) cur = cur.next;
        while (cur.previous != null) {
            pw.print(cur.data + " -> ");
            cur = cur.previous;
        }
        pw.println(cur.data);
    }
}

class MyList {
    Node head;

    MyList(int[] array) {
        head = new Node(array[0], null, null);
        Node cur = head;
        for (int i = 1; i < array.length; i++) {
            Node temp = new Node(array[i], null, null);
            cur.next = temp;
            temp.previous = cur;
            cur = cur.next;
        }
    }
}

class Node {
    // The element that we want to put in the list
    Object data;
    // The reference to the next node in the list
    Node next;
    // The reference to the previous node in the list
    Node previous;

    @SuppressWarnings("unused")
    Node(Object value, Node current, Node prev) {
        data = value;
        next = current;
        previous = prev;
    }
}
