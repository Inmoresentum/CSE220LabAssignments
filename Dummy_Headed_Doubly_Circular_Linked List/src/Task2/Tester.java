package Task2;

import java.io.BufferedOutputStream;
import java.io.PrintWriter;
import java.util.NoSuchElementException;

public class Tester {
    static final PrintWriter pw = new PrintWriter(new BufferedOutputStream(System.out));

    public static void main(String[] args) {
        //Todo: for now it seems fine but later I will  try properly check it.
        int[] test1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] empty_array = {};
        int[] test4 = {2};
        pw.print("Creating a list from an array of integers : ");
        pw.flush();
        DoublyList list1 = new DoublyList(test1);
        list1.showList();
        Node test2 = new Node(100_000, null, null);
        pw.print("Inserting " + test2.data + " at the tail of the list : ");
        pw.flush();
        list1.insert(test2);
        list1.showList();
        pw.print("Inserting value 50 at index 4 in the list : ");
        pw.flush();
        list1.insert(50, 4);/* 0 Based index**/
        list1.showList();
        pw.print("Removing the element at position 2 in the list : ");
        pw.flush();
        list1.remove(2);
        list1.showList();
        pw.print("Removing the element " + list1.removeKey(7) + " from the list : ");
        pw.flush();
        list1.showList();
        //Creating a list with a single value of 2 and then removing it.
        DoublyList list3 = new DoublyList(test4);
        list3.removeKey(2);
        list3.showList();//should print empty list.
        //Todo: Below tests should throw runtime error exception.
        //DoublyList list2 = new DoublyList(empty_array);
        //list1.insert(-4, 50);
        //list1.insert(50, -4);
        //list3.removeKey(500); //Since this list is empty this should throw no such element exists exception.
        //list3.remove(18); //This list is empty so it should throw index out of bound exception.
        pw.close();
    }
}

class DoublyList {
    Node head;

    DoublyList(int[] array) {
        if (array.length == 0) throw new RuntimeException("Array can't be empty");
        head = new Node(Integer.MIN_VALUE, null, null);//Integer.MIN_VALUE is my dummy node;
        Node cur = head;
        for (int k : array) {
            Node temp = new Node(k, null, null);
            cur.next = temp;
            temp.previous = cur;
            cur = cur.next;
        }
        cur.next = head; // Making it circular
        head.previous = cur;
    }

    void showList() {
        Node cur = head.next;
        if (cur == head) {
            print("Empty list\n"); //Dear me If I am ever wondering why print....... I have declared a method to do so because
            return;                //I am too lazy and if the code doesn't work on other projects you know why..
        }
        print("↻ ");
        while (cur.next != head) {
            print(cur.data + " ⇄ ");
            cur = cur.next;
        }
        print(cur.data + " ↺\n");
    }

    void insert(Node newElement) {
        if (exists_or_not(newElement.data)) {
            print("This value can't be inserted because this value already exists in the list\n");
            return;
        }
        Node tail = head.previous;
        tail.next = newElement;//adding at the end
        newElement.previous = tail;
        newElement.next = head;//connecting
        head.previous = newElement;//making circular
    }

    void insert(int newElement, int index) {
        if (head.next == null) throw new RuntimeException("List can't be empty");
        int size = count();
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException("index : " + index + " invalid index for list which has a size of " + size);
        }
        if (exists_or_not(newElement)) {
            print("This value can't be inserted because this value already exists in the list\n");
            return;
        }
        Node cur = head;//:)
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        Node tem = new Node(newElement, null, null);
        tem.previous = cur;
        tem.next = cur.next;
        cur.next.previous = tem;
        cur.next = tem;
    }

    void remove(int index) {
        if (null != head.next) {
            int size = count();//A method to count the number of elements present in the linked list
            if (index < 0 || index > size - 1) {
                throw new IndexOutOfBoundsException("index : " + index + " invalid index for list which has a size of " + size);
            }
            //Just need to travel to the previous of the node which I will have to remove then
            //isolate it and connect (index - 1) with (index  + 1) and disconnect the node which I will have to remove;
            Node cur = head;//:)
            for (int i = 0; i < index; i++) {
                cur = cur.next;
            }
            Node remove = cur.next, tem = cur.next.next;
            tem.previous = cur;
            cur.next = tem;
            remove.previous = null;//isolating it
            remove.next = null;
        } else {
            throw new RuntimeException("List can't be empty");
        }
    }

    int removeKey(int deleteKey) {
        if (!exists_or_not(deleteKey)) {
            throw new NoSuchElementException("There is no such key " + deleteKey + " exists in the list");
        }
        Node cur = head.next;
        while (cur.next.data != deleteKey) {
            cur = cur.next;
        }
        Node remove = cur.next, tem = cur.next.next;
        tem.previous = cur;
        cur.next = tem;
        remove.previous = null;//isolating it
        remove.next = null;
        return remove.data;
    }

    int count() {
        int c = 0;
        Node cur = head.next;
        while (cur != head) {
            c++;
            cur = cur.next;
        }
        return c;
    }

    boolean exists_or_not(Object check) {
        Node cur = head.next;
        while (cur != head) {
            if ((cur.data).equals(check)) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    void print(Object whatever) {
        PrintWriter pw = new PrintWriter(new BufferedOutputStream(System.out)); //Don't know why I am doing this.
        pw.print(whatever.toString());
        pw.flush();
    }
}

class Node {
    Integer data;
    Node next;//reference to the next element
    Node previous;//reference to the previous element

    @SuppressWarnings("unused")
    Node(Integer value, Node current, Node prev) { //Constructor
        data = value;
        next = current;
        previous = prev;
    }
}