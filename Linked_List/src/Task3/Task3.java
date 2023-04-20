package Task3;

import java.io.*;
import java.util.StringTokenizer;

public class Task3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
        //Todo: Creating a list from an array and then will call the method which will return another list
        //containing even numbers.
        pw.print("Please enter the elements of the list separated by a space : ");
        pw.flush();
        StringTokenizer tk = new StringTokenizer(br.readLine());
        int[] test1 = new int[tk.countTokens()];
        for (int i = 0; i < test1.length; i++) {
            test1[i] = Integer.parseInt(tk.nextToken());
        }
        //Alternatively an empty list can be created and then new elements of the list can be
        //inserted at the tail of the list but its pretty inefficient since I can't create tail
        //as a class variable. That's why I am making it like this.
        MyList list1 = new MyList(test1);
        MyList list_containing_even_numbers = list1.even();
        list_containing_even_numbers.showList();
        //End
        //Todo: Writing an method to find if an element is present at the list or not.
        pw.print("Please enter the elements of the list separated by a space : ");
        pw.flush();
        tk = new StringTokenizer(br.readLine());
        int[] test2 = new int[tk.countTokens()];
        for (int i = 0; i < test2.length; i++) {
            test2[i] = Integer.parseInt(tk.nextToken());
        }
        MyList list2 = new MyList(test2);
        pw.print("Please enter the element which you would like to check : ");
        pw.flush();
        int check = Integer.parseInt(br.readLine());
        pw.println(list2.contains(check) ? "True" : "False");
        pw.flush();
        //End
        //Todo: Writing an method to reverse an list.
        pw.print("Please enter the elements of the list separated by a space : ");
        pw.flush();
        tk = new StringTokenizer(br.readLine());
        int[] test3 = new int[tk.countTokens()];
        for (int i = 0; i < test3.length; i++) {
            test3[i] = Integer.parseInt(tk.nextToken());
        }
        MyList list3 = new MyList(test3);
        list3.reverse();
        list3.showList();
        //End
        //Todo: Writhing an method to sort the list.
        pw.print("Please enter the elements of the list separated by a space : ");
        pw.flush();
        tk = new StringTokenizer(br.readLine());
        int[] test4 = new int[tk.countTokens()];
        for (int i = 0; i < test4.length; i++) {
            test4[i] = Integer.parseInt(tk.nextToken());
        }
        MyList list4 = new MyList(test4);
        list4.sortMyList();
        list4.showList();
        //End
        //Todo: Writing an method inside MyList class to calculate the sum
        pw.print("Please enter the elements of the list separated by a space : ");
        pw.flush();
        tk = new StringTokenizer(br.readLine());
        int[] test5 = new int[tk.countTokens()];
        for (int i = 0; i < test5.length; i++) {
            test5[i] = Integer.parseInt(tk.nextToken());
        }
        MyList list5 = new MyList(test5);
        pw.println(list5.sum());
        pw.flush();
        //Todo: Writing an method inside MyList class to rotate left or right according to the user.
        pw.print("Please enter the elements of the of the list separated by a space : ");
        pw.flush();
        tk = new StringTokenizer(br.readLine());
        int[] test6 = new int[tk.countTokens()];
        for (int i = 0; i < test6.length; i++) {
            test6[i] = Integer.parseInt(tk.nextToken());
        }
        MyList list6 = new MyList(test6);
        pw.print("Please enter the way you want to rotate the list, left or right : ");
        pw.flush();
        String left_or_right = br.readLine();
        pw.print("Please enter the cell number : ");
        pw.flush();
        int k = Integer.parseInt(br.readLine());//cell
        br.close();
        list6.rotate(left_or_right, k);
        list6.showList();
        pw.close();
    }
}

class MyList {
    Node head;

    //Default constructor
    MyList() {

    }

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
    void showList() {
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
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

    //Insert an element at the end of the list
    void insert(Node newElement) {
        if (head == null) {
            head = newElement;
            return;
        }
        newElement.next = null;
        Node last = head;
        while (last.next != null)//iterating till the last node
            last = last.next;

        last.next = newElement;
    }

    MyList even() {
        MyList list_with_even_numbers = new MyList();
        Node cur = head;
        while (cur != null) {
            if (cur.data % 2 == 0) {
                list_with_even_numbers.insert(new Node(cur.data));
            }
            cur = cur.next;
        }
        return list_with_even_numbers;
    }

    //checks if an element is present in the linked list
    boolean contains(Object ele) {
        Node cur = head;
        while (cur != null) {
            if (cur.data.equals(ele)) return true;
            cur = cur.next;
        }
        return false;
    }

    void reverse() {
        Node previous = null, cur = head, next;
        while (cur != null) {
            next = cur.next;
            cur.next = previous;
            previous = cur;
            cur = next;
        }
        head = previous;
    }

    void sortMyList() {
        if (head == null) {
            return;
        }
        Node cur = head, cur_index;
        int tem;
        //ToDo: Implementing Bubble sort. It's not efficient but will do the job because I am too
        // lazy to implement merge sort or even quickSort.
        while (cur != null) {
            cur_index = cur.next;
            while (cur_index != null) {
                if (cur.data > cur_index.data) {
                    tem = cur.data;
                    cur.data = cur_index.data;
                    cur_index.data = tem;
                }
                cur_index = cur_index.next;
            }
            cur = cur.next;
        }
    }

    long sum() {
        long result = 0;
        Node cur = head;
        while (cur != null) {
            result += cur.data;
            cur = cur.next;
        }
        return result;
    }

    void rotate(String check, int k) {
        boolean left = check.equals("left");
        Node cur = head;
        //ToDo: Initial Idea is basically making linked list circular and then adjusting it.
        if (k == 0) {
            return;  //Don't need to do anything
        }
        if (left) {
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = head;
            cur = head;
            int c = 0;
            while (c < k - 1) {
                c++;
                cur = cur.next;
            }
        } else {
            int length = 1;
            while (cur.next != null) {
                length++;
                cur = cur.next;
            }
            k = k > length ? k % length : k;
            k = Math.abs(length - k);
            if (k == 0) {
                return;
            }
            cur.next = head;
            while (k-- > 0) {
                cur = cur.next;
            }
        }
        head = cur.next;
        cur.next = null;
    }
}

class Node {
    // reference to the next element
    Node next;//By default null :) if there is none

    Integer data;//can be anything ^^

    // Node constructor
    public Node(Integer dataValue) {
        next = null;
        data = dataValue;
    }

    @SuppressWarnings("unused")
    public Node(Integer dataValue, Node nextValue) {
        next = nextValue;
        data = dataValue;
    }
}