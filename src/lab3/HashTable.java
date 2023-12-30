import java.util.ArrayList;
import java.util.LinkedList;

class HashTable<K, V> {
    private LinkedList<Pair<K, V>>[] table;
    private int capacity;
    private int size;

    public HashTable(int capacity) {
        this.capacity = capacity;
        this.table = new LinkedList[capacity];
        this.size = 0;
        for (int i = 0; i < capacity; i++) {
            table[i] = new LinkedList<>();
        }
    }

    public String[] view() {
        String[] arr = new String[16];
        for (int i = 0; i < table.length; i++) {
            ArrayList ar1 = new ArrayList<>();
            if (table[i] == null) {
                continue;
            }
            for (Pair<K, V> entry: table[i]) {
                ar1.add(String.valueOf(entry.getKey()) + " " + String.valueOf(entry.getValue().toString()));
            }
            arr[i] = ar1.toString();
        }
        return arr;
    }

    public void put(K key, V value) {
        int index = Math.abs(key.hashCode()) % capacity;
        LinkedList<Pair<K, V>> list = table[index];
        for (Pair<K, V> node : list) {
            if (node.getKey().equals(key)) {
                node.setValue(value);
                return;
            }
        }
        list.add(new Pair<>(key, value));
        size++;
    }

    public V get(K key) {
        int index = Math.abs(key.hashCode()) % capacity;
        LinkedList<Pair<K, V>> list = table[index];
        for (Pair<K, V> node : list) {
            if (node.getKey().equals(key)) {
                return node.getValue();
            }
        }
        return null;
    }

    public void remove(K key) {
        int index = Math.abs(key.hashCode()) % capacity;
        LinkedList<Pair<K, V>> list = table[index];
        for (Pair<K, V> node : list) {
            if (node.getKey().equals(key)) {
                list.remove(node);
                size--;
                return;
            }
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
