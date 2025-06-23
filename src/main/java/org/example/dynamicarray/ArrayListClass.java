package org.example.dynamicarray;

class ArrayListClass {

    // Stores our elements of integers
    private int[] arr;

    // Total storage of the array
    private int capacity;

    // Number of elements currently present in the array
    private int current;

    // Initialise the array to a capacity of 1
    public ArrayListClass() {
        arr = new int[1];
        capacity = 1;
        current = 0;
    }

    // Add element to last of the array
    void push(int data) {

        /*
        If current = capacity then we don't have space, so we have to create
        a new temporary array with double the capacity,
        otherwise just insert the data as normal
         */
        if (current == capacity) {
            int[] temp = new int[2 * capacity]; // Temporary array with double the capacity

            // Copy old array into new array
            for (int i = 0; i < capacity; i++)
                temp[i] = arr[i];

            capacity *= 2; // Set the new capacity value to double
            arr = temp; // Set the new array into the holder
        }

        // Inserting data
        arr[current] = data;
        current++; // Increment after inserting
    }

    // Add element to particular index
    void pushAtIndex(int data, int index) {
        // If inserting at the end of the array is the same as capacity then call the push(data) function
        if (index == capacity) {
            push(data);
        } else {
            arr[index] = data;
        }
    }

    int getElementAt(int index) {
        /*
        If index is within range return the element at the index,
        otherwise return -1
         */
        return index < current ? arr[index] : -1;
    }

    // Delete last element
    void pop() {
        current--;
    }

    int getSize() {
        return current;
    }

    int getCapacity() {
        return capacity;
    }

    // function to print ArrayList elements
    void printArrayElements() {
        for (int i = 0; i < current; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        System.out.println("-------------"); // Insert a new line after printing the elements
    }

    /*
    Array capacity effectively doubles 3x
    1 -> 2 -> 4 -> 8
     */
    public static void main(String[] args) {
        ArrayListClass v = new ArrayListClass();
        v.push(10);
        v.push(20);
        v.push(30);
        v.push(40);
        v.push(50);

        System.out.println("ArrayList size: " + v.getSize()); // 5
        System.out.println("ArrayList capacity: " + v.getCapacity()); // 8
        System.out.println("ArrayList elements: ");
        v.printArrayElements();

        v.pushAtIndex(100, 1);

        System.out.println("\nAfter updating 1st index");

        System.out.println("ArrayList elements: ");
        v.printArrayElements();
        System.out.println("Element at 1st index: " + v.getElementAt(1));

        v.pop();

        System.out.println("\nAfter deleting the" + " last element");

        System.out.println("ArrayList size: " + v.getSize());
        System.out.println("ArrayList capacity: " + v.getCapacity());

        System.out.println("ArrayList elements: ");
        v.printArrayElements();
    }
}