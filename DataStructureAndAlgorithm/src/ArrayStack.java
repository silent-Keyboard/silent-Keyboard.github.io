//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.util.Map;

public class ArrayStack {
    private Object[] arrayStack;
    private int top;

    public ArrayStack( int MAXSIZE) {
        this.arrayStack = new Object[MAXSIZE];
        this.top = 0;
    }

    public boolean isEmpty() {
        return this.top == 0 ? true : false;
    }
    public void push(Object element) {
        this.arrayStack[top] = element;
        top = top + 1;
    }

    public Object pop() throws MyException{
        if (!isEmpty()) {
            this.top = this.top - 1;
            return this.arrayStack[top];
        } else {
            throw new MyException("The Stack is Empty!");
        }
    }

    public Object peek() throws MyException{
        if (!isEmpty()) {
            return this.arrayStack[top -1];
        } else {
            throw new MyException("The Stack is Empty!");
        }

    }
    public void output() {
        for(int i = 0; i < this.top; ++i) {
            System.out.println(this.arrayStack[i]);
        }
    }

    // Four simple operations: + - * /
    public static void calculateExpression(ArrayStack number, ArrayStack operator, String exp) {
        String[] numbers = exp.split("\\+|-|\\*|/");

        for (int i = 0; i < numbers.length; i++) {
            number.push(numbers[i]);
            System.out.println(numbers[i]);
        }

        for (int i = 0; i < exp.length(); i++) {
            if ('+' == (exp.charAt(i)) || '-' == (exp.charAt(i)) || '*' == (exp.charAt(i)) || '/' == (exp.charAt(i))) {
                operator.push(exp.substring(i, i+1));
                System.out.println(exp.substring(i, i+1));
            }
        }

        char[] cur = exp.toCharArray();
        for (int i = 0; i < cur.length; i++) {
            if (Character.isDigit(cur[i])) {
                StringBuffer str = new StringBuffer();
                while(i < cur.length && Character.isDigit(cur[i])) {
                    str.append(cur[i]);
                    i = i + 1;
                }
                i = i -1;
                number.push(Integer.parseInt(str.toString()));
            }
        }
    }

    public static void main(String[] args) {
        // 泛型栈 数据转型
        ArrayStack stack1 = new ArrayStack(10);
        ArrayStack stack2 = new ArrayStack(10);
        ArrayStack cur = new ArrayStack(10);
        calculateExpression(stack1, stack2,  "123+6*7-10/2");
    }
}
