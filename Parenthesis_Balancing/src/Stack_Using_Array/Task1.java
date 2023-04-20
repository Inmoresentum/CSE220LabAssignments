package Stack_Using_Array;

import java.io.*;

public class Task1 {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final PrintWriter pw = new PrintWriter(new BufferedOutputStream(System.out));

    public static void main(String[] args) throws IOException {
        pw.print("Please enter the expression that you want to check : ");
        pw.flush();
        String s = br.readLine();//Taking input from the user
        br.close();//Closing the input stream
        is_In_Correct_Order(s);
    }

    static void is_In_Correct_Order(String s) { //This method will check if the expression is correct or not
        outer:
        {
            if (s.length() == 0) {
                pw.println("Empty Expression");
                break outer;
            }
            Stack_With_Array MyStack = new Stack_With_Array();
            //Obvious way is to use pairs to store indexes along with the value. But since it's stack assignment
            //I guess I gotta use stack :(
            Stack_With_Array Indexes = new Stack_With_Array();//To store indexes
            int c = 0;  //index where error occurred if error occurred
            boolean Not_Closed = false, Not_Opened = false;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '[' || s.charAt(i) == '{' || s.charAt(i) == '(') {
                    MyStack.push(s.charAt(i));
                    Indexes.push(i + 1);
                    continue;
                }
                if ((s.charAt(i) == ']' || s.charAt(i) == '}' || s.charAt(i) == ')')) {
                    if (!MyStack.is_Empty()) {
                        char current = (char) MyStack.pop();
                        c = (int) Indexes.pop();
                        if ((s.charAt(i) == ')' && current == '(' || s.charAt(i) == '}' && current == '{' || s.charAt(i) == ']' && current == '[')) {
                            continue;
                        } else {
                            Not_Closed = true;
                            break;
                        }
                    } else if (MyStack.is_Empty()) {
                        c = i + 1;
                        Not_Opened = true;
                        break;
                    }
                }
            }
            pw.println(s);
            if (Not_Closed)
                pw.println("This expression is NOT correct.\nError at character # " + c + ".'" + s.charAt(c - 1) + "'- not closed.");
            else if (!MyStack.is_Empty()) {
                c = (int) Indexes.pop();
                pw.println("This expression is NOT correct.\nError at character # " + c + ".'" + s.charAt(c - 1) + "'- not closed.");
            } else if (Not_Opened) {
                pw.println("This expression is NOT correct.\nError at character # " + c + ".'" + s.charAt(c - 1) + "'- not opened.");
            } else pw.println("This expression is correct.");
        }
        pw.close();//Closing the output stream
    }
}

class Stack_With_Array {    //Array Based Stack
    final int size = (int) 1e7 + 10000;//Size of the array
    Object[] array = new Object[size];//Lower memory might give heap overflow so change the size if this happens on your device.
    int current_size = 0;

    boolean is_Empty() {
        return current_size == 0;
    }

    boolean is_Full() {
        return current_size == size;
    }

    void push(Object value) {
        if (is_Full()) throw new StackOverflowException("Stack is full");
        array[current_size] = value;
        current_size++;
    }

    Object pop() {
        if (is_Empty()) throw new StackUnderflowException("Stack is empty");
        Object value = array[current_size - 1];
        array[current_size - 1] = null;
        current_size--;
        return value;
    }

    Object peek() { //For this task this method is not useful at all :(
        if (is_Empty()) throw new StackUnderflowException("Stack is empty");
        return array[current_size - 1];
    }
}

class StackUnderflowException extends RuntimeException {
    StackUnderflowException() {
        super();
    }

    StackUnderflowException(String message) {
        super(message);
    }
}

class StackOverflowException extends RuntimeException {
    StackOverflowException() {
        super();
    }

    StackOverflowException(String message) {
        super(message);
    }
}