public class Stack<T> {
    private T[] data;
    private int size;
    private int capacity;

    public Stack(int capacity) {
        this.capacity = capacity;
        data = (T[]) new Object[capacity];
        size = 0;
    }

    public void push(T element) {
        if (size == capacity) {
            // Если стек полон, увеличиваем его размер
            capacity *= 2;
            T[] newData = (T[]) new Object[capacity];
            System.arraycopy(data, 0, newData, 0, size);
            data = newData;
        }
        data[size] = element;
        size++;
    }

    public T pop() {
        if (size == 0) {
            throw new IllegalStateException("Stack is empty");
        }
        T element = data[size - 1];
        size--;
        return element;
    }

    public T peek() {
        if (size == 0) {
            throw new IllegalStateException("Stack is empty");
        }
        return data[size - 1];
    }
}
