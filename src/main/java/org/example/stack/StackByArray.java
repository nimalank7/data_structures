package org.example.stack;

import java.util.NoSuchElementException;

public class StackByArray {
    private int[] stack;

    // To track the filled elements
    private int top;

    public StackByArray(int capacity) {
        stack = new int[capacity];
        top = -1; // Start at -1 so incrementing the first will give you 0
    }

    public void push(int x) {
        if (isFull()) {
            throw new IllegalStateException();
        }

        stack[++top] = x;
    }

    public int pop() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        return stack[top--];
    }

    public int peek() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        return stack[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == stack.length - 1; // If pointer is at the last index then return true
    }

    public int size() {
        return top + 1;
    }

    public static void main(String[] args) {
        StackByArray myStack = new StackByArray(3);
        myStack.push(4);
        myStack.push(2);
        myStack.push(5);

        System.out.println(myStack.peek()); // 5
        System.out.println(myStack.pop()); // 5
        System.out.println(myStack.peek()); // 2

        System.out.println(myStack.size()); // 2
        System.out.println(myStack.isEmpty()); // false
        System.out.println(myStack.isFull()); // false
    }
}
