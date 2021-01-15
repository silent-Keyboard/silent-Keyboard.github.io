//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

public class ArrayStack {
    private String[] arrayStack;
    private int size;
    private int count;

    public ArrayStack() {
    }

    public void initStack(int n) {
        this.arrayStack = new String[n];
        this.size = n;
        this.count = 0;
    }

    public void push(String element) {
        if (this.count >= this.size) {
            String[] temp = new String[2 * this.size];

            for(int i = 0; i < this.size; ++i) {
                temp[i] = this.arrayStack[i];
            }

            this.size = 2 * this.size;
            this.arrayStack = temp;
        }

        this.arrayStack[this.count] = element;
        ++this.count;
    }

    public String pop() throws MyException {
        String str = "";
        if (this.count > 0) {
            str = this.arrayStack[this.count - 1];
            --this.count;
            return str;
        } else {
            throw new MyException("The Stack is empty!");
        }
    }

    public void output() {
        for(int i = 0; i < this.count; ++i) {
            System.out.println(this.arrayStack[i]);
        }

    }

    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack();
        stack.initStack(10);

        for(int i = 0; i < 12; ++i) {
            stack.push(i + "dolar");
        }

        try {
            stack.pop();
        } catch (MyException var3) {
            var3.printStackTrace();
        }

        stack.output();
    }
}
