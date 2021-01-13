import org.omg.CosNaming.NamingContextPackage.NotFound;

/**
 * @author silent-keyboard
 * DATA: 2021/01/12
 * Note: The element type of single-linked-list is int.
 * The aim of program: single-linkfrf-list's basic operation
 */

public class SingleLinkedList {
    // the first element of single linked list is -1, exactly equals null. Head is Sentinel node.
    private Node head = new Node(-1,null);
    private int length = 0;
    private final int MAXLENGTH = 10;

    public int getLength() {
        return length;
    }

    public boolean isEmpty() {
        return getLength() == 0;
    }

    public Node queryByValue(int element) throws myException {
        Node temp = head;
        while(null != temp.next) {
            if (temp.element == element) {
                return temp;
            }
            temp = temp.next;
        }
        throw  new myException("value:" + element + ":is not exists!");
    }

    public Node queryByIndex(int index) throws myException{
        Node temp = head;
        int i = 1;
        while( i < index && null != temp.next) {
            temp = temp.next;
            i = i + 1;
        }
        if (i == index) return temp.next;
        throw new myException("index:" + index + " is not exists!");
    }

    public void addToHeader(int element) throws myException {

        checkCapacity(length);

        Node temp = head;
        Node p = new Node(element, head.next);
        temp.next = p;
        head = temp;
        length = length + 1;
    }

    public void checkCapacity(int index) throws myException {
        if (index >= MAXLENGTH) {
            throw new myException("The single linked list has reached the maximum capacity");
        }
    }

    public void output() {
        Node temp = head.next;
        if (isEmpty()) {
            System.out.println("list is empty!");
        } else {
            while(null != temp) {
                System.out.print(temp.element + " ");
                temp = temp.next;
            }
            System.out.println("\n");
        }
    }

    public class Node {
        private int element;
        private Node next;
        Node(int element, Node next){
            this.element = element;
            this.next = next;
        }
        public int getData(Node p) {
            return p.element;
        }
    }

    public class myException extends Exception {
        myException(String msg) {
            super(msg);
        }
    }

    public static void main(String[] args) {
        SingleLinkedList list = new SingleLinkedList();
        for (int i = 1; i < 13; i++) {
            try {
                list.addToHeader(i);
            } catch (myException e) {
                System.out.println(e.getMessage());
                break;
            }
        }

        list.output();

        try {
            Node temp1 = list.queryByIndex(1);
            Node temp2 = list.queryByValue(8);
            System.out.println(temp1.element);
        } catch (myException myException) {
            System.out.println(myException.getMessage());
        }
    }
}
