
/**
 * @author silent-keyboard
 * DATA: 2021/01/12
 * Note: The element type of single-linked-list is int.
 * The aim of program: single-linkfrf-list's basic operation include :Ring detection、single linked list、inversion LRU
 *
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

    public Node queryByIndex(int index) throws MyException{
        Node temp = head;
        int i = 1;
        while( i < index && null != temp.next) {
            temp = temp.next;
            i = i + 1;
        }
        if (i == index) return temp.next;
        throw new MyException("index:" + index + " is not exists!");
    }

    public void addToHeader(int element) throws MyException {

        checkCapacity(length);

        Node temp = head;
        Node p = new Node(element, head.next);
        temp.next = p;
        head = temp;
        length = length + 1;
    }

    public void deleteByIndex(int index) throws MyException{
        if (isEmpty()) {
            throw new MyException("list is empty!");
        }
        checkCapacity(index);

        Node temp1 = queryByIndex(index);
        // the first is special!
        if (index == 1) {
            head.next = temp1.next;
        } else {
            Node temp2 = queryByIndex(index -1);
            temp2.next = temp1.next;
        }
        length = length - 1;
    }

    public void checkCapacity(int index) throws MyException {
        if (index > MAXLENGTH) {
            throw new MyException("index:" + index + "is greater than the single linked list's maximum capacity");
        }
    }

    /**
     *
     * @param element: the value of what you want to query
     * @return: the index of the first occurence of the element  in the single-linked-list represented by the object that
     * is greater than or equal to 1 , or 0 if the element does not occur.
     */
    public int isExistsValue(int element) {
        int index = 0;
        Node temp = head;
        while(null != temp.next) {
            if (temp.element == element) {
                return index;
            }
            index = index + 1;
            temp = temp.next;
        }
        return 0;
    }

    public boolean checkRing() {
        Node p = head.next;
        Node q = head.next;

        p = p.next;
        q = q.next.next;
        if (length > 2) {
            while(null != q.next && null != q.next.next) {
                if (p.element == q.element) {
                    return true;
                }
                p = p.next;
                q = q.next.next;

            }
        }
        return false;
    }

    public void checkRingTest() {
        for (int i = 1; i <= 7; i++) {
            try {
                addToHeader(i);
            } catch (MyException e) {
                System.out.println(e.getMessage());
            }
        }

        // Check that there is no ring: Comment out the try statement block
        try {
            Node p1 = queryByIndex(5);
            Node p2 = queryByIndex(7);
            p2.next = p1;
        } catch (MyException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(checkRing());
    }

    public void LRU(int element) {
        int index = isExistsValue(element);
        try {
            if (index > 0) {
                deleteByIndex(index);
            } else if (length == MAXLENGTH) {
                deleteByIndex(length);
            }
            addToHeader(element);
        } catch (MyException e) {
            System.out.println(e.getMessage());
        }
    }

    public void reverseLinkedList() {
        if (length == 0 || length == 1) {
            return;
        }else {
            Node p = head.next;
            Node q = head.next.next;
            p.next = null;
            while (null != q.next) {
                Node r = q.next;
                q.next = p;
                p = q;
                q = r;
            }
            q.next = p;
            head.next = q;
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
        // write down your test code int the next lines
        SingleLinkedList list = new SingleLinkedList();
//        for (int i = 1; i < 11; i++) {
//            try {
//                list.addToHeader(i);
//            } catch (MyException e) {
//                System.out.println(e.getMessage());
//            }
//        }
//        list.output();
//        list.LRU(12);
//        list.output();
        list.checkRingTest();
    }
}
