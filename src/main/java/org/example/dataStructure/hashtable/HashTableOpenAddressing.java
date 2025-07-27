package org.example.dataStructure.hashtable;

/*
Uses open addressing and linear probing
 */
public class HashTableOpenAddressing<K, V> {

    // Array with each element as a LinkedList<Entry<K, V>>
    private Entry<K, V>[] table;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;
    private static final int MAX_NAME = 256;

    public HashTableOpenAddressing() {
        this.table = new Entry[DEFAULT_CAPACITY];
    }

    private int generateIndexFromHash(K key) {
        /*
        Generate hash value of the key then take the modulus to return the index
         */
        int hashCode = key.hashCode();
        return Math.abs(hashCode % table.length);
    }

    boolean insert(Entry<K, V> entry) {
        if (entry == null) {
            return false;
        }

        int index = generateIndexFromHash(entry.getKey());

        for (int i = 0; i < DEFAULT_CAPACITY; i++) {
            // Initially i = 0 which means try = index
            int attempt = (i + index) % DEFAULT_CAPACITY;

            // If the pointer is null then the space is free otherwise try again
            if (table[attempt] == null) {
                table[attempt] = entry;
                return true;
            }
        }

        // Entire array is full so we can't put any more items in
        return false;
    }

    Entry<K, V> lookup(K k) {
        int index = generateIndexFromHash(k);

        // If the initial try with index = 0 doesn't work then iterate through
        for (int i = 0; i < DEFAULT_CAPACITY; i++) {
            int attempt = (index + i) % DEFAULT_CAPACITY;
            // If the pointer isn't null and the retrieved value's name matches then return it
            if (table[attempt] != null && table[attempt].getKey().equals(k)) {
                return table[attempt];
            }
        }

        return null;
    }

    void printTable() {
        System.out.println("Start");
        for (int i = 0; i < DEFAULT_CAPACITY; i++) {
            if (table[i] == null) {
                System.out.println("\t"+ i + "\t---");
            } else {
                System.out.println("\t"+ i + "\t" + table[i].getValue().toString());
            }
        }
        System.out.println("End");
    }

    Entry<K, V> delete(K k) {
        int index = generateIndexFromHash(k);
        // If the initial try with index = 0 doesn't work then iterate through
        for (int i = 0; i < DEFAULT_CAPACITY; i++) {
            int attempt = (index + i) % DEFAULT_CAPACITY;
            // If the pointer isn't null and the retrieved value's name matches then return it
            if (table[attempt] != null && table[attempt].getKey().equals(k)) {
                Entry<K, V> tmp = table[attempt];
                table[attempt] = null;
                return tmp;
            }
        }

        return null;
    }

    public int getSize() {
        return size;
    }

    public static void main(String[] args) {
        HashTableOpenAddressing<String, String> hashTable = new HashTableOpenAddressing<>();
        hashTable.insert(new Entry<>("key", "value"));
        hashTable.insert(new Entry<>("anotherKey", "value"));
        hashTable.printTable();
        hashTable.delete("anotherKey");
        System.out.println(hashTable.lookup("key").getValue());
        hashTable.printTable();
    }
}
