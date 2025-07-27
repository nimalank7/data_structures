package org.example.dataStructure.hashtable;

import java.util.LinkedList;

/*
Hash table has an array which contains a LinkedLists whose element is a Entry<K, V>
Collisions are handled used chaining
 */
public class HashTableGPT<K, V> {

    // Array with each element as a LinkedList<Entry<K, V>>
    private LinkedList<Entry<K, V>>[] table;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;

    public HashTableGPT() {
        this.table = new LinkedList[DEFAULT_CAPACITY];
    }

    private int generateIndexFromHash(K key) {
        /*
        Generate hash value of the key then take the modulus to return the index
         */
        int hashCode = key.hashCode();
        return Math.abs(hashCode % table.length);
    }

    public int getSize() {
        return size;
    }

    public void put(K key, V value) {
        // Get the index of where the data is stored
        int index = generateIndexFromHash(key);
        /*
        If the array is empty then create a new linked list and add the key-value pair at the first bit
         */
        if (table[index] == null) {
            table[index] = new LinkedList<>();
        }

        /*
        Scenario 1: Entry doesn't exist
        If condition is never met so exit the loop and add the entry at the head

        Scenario 2: Other entries exist
        If condition is never met so exit the loop and add it at the end of the linkedlist

        Scenario 3: Entry exists
        If condition is met and update the value to meet it
         */
        for (Entry<K, V> entry : table[index]) {
            if (entry.getKey().equals(key)) {
                entry.setValue(value);
                return;
            }
        }
        table[index].add(new Entry<>(key, value));
        size++;
    }

    /*
    Retrieve the value associated with the key.
    Iterate through the linkedlist to find the corresponding entry
     */
    public V get(K key) {
        int index = generateIndexFromHash(key);
        if (table[index] != null) {
            for (Entry<K, V> entry : table[index]) {
                if (entry.getKey().equals(key)) {
                    return entry.getValue();
                }
            }
        }
        return null;
    }

    /*
    Find the index location based off the key
    Iterate through the linkedlist until we find the entry then remove it and decrement the size
     */
    public void remove(K key) {
        int index = generateIndexFromHash(key);
        if (table[index] != null) {
            for (Entry<K, V> entry : table[index]) {
                if (entry.getKey().equals(key)) {
                    table[index].remove(entry);
                    size--;
                    return;
                }
            }
        }
    }
}
