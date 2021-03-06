package deque;

import interfacepackage.Queue;

import java.util.Arrays;
import java.util.Comparator;
import java.util.NoSuchElementException;

public class ArrayDeque<E> implements Queue<E> {
    private static final int DEFAULT_CAPACITY = 64;
    private Object[] array;
    private int size;

    private int front;
    private int rear;
    public ArrayDeque(){
        this.array = new Object[DEFAULT_CAPACITY];
        this.size = 0;
        this.front = 0;
        this.rear = 0;
    }

    public ArrayDeque(int capacity){
        this.array = new Object[capacity];
        this.size = 0;
        this.front = 0;
        this.rear = 0;
    }

    private void resize(int newCapacity){
        int arrayCapacity = array.length;
        Object[] newArray = new Object[newCapacity];
        for (int i = 1, j = front + 1; i <= size; i++, j++){
            newArray[i] = array[j % arrayCapacity];
        }
        this.array = null;
        this.array = newArray;

        front = 0;
        rear = size;
    }

    @Override
    public boolean offer(E e) {
        return offerLast(e);
    }

    public boolean offerLast(E e){
        if ((rear + 1) % array.length == front){
            resize(array.length * 2);
        }
        rear = (rear + 1) % array.length;
        array[rear] = e;
        size++;
        return true;
    }

    public boolean offerFirst(E e){
        if ((front - 1 + array.length) % array.length == rear){
            resize(array.length * 2);
        }
        array[front] = e;
        front = (front - 1 + array.length) % array.length;
        size++;
        return true;
    }

    @Override
    public E poll() {
        return pollFirst();
    }

    public E pollFirst(){
        if (size == 0){
            return null;
        }
        front = (front + 1) % array.length;
        @SuppressWarnings("unchecked")
        E item = (E) array[front];
        array[front] = null;
        size--;

        if (array.length > DEFAULT_CAPACITY && size < (array.length / 4)){
            resize(Math.max(DEFAULT_CAPACITY, array.length / 2));
        }
        return item;
    }

    public E remove(){
        return removeFirst();
    }

    public E removeFirst(){
        E item = pollFirst();

        if (item == null){
            throw new NoSuchElementException();
        }

        return item;
    }

    public E pollLast(){
        if (size == 0){
            return null;
        }
        @SuppressWarnings("unchecked")
                E item = (E) array[rear];
        array[rear] = null;

        rear = (rear - 1 + array.length) % array.length;
        size--;

        if (array.length > DEFAULT_CAPACITY && size < (array.length / 4)){
            resize(Math.max(DEFAULT_CAPACITY, array.length / 2));
        }
        return item;
    }

    public E removeLast(){
        E item = pollLast();
        if (item == null){
            throw new NoSuchElementException();
        }
        return item;
    }

    @Override
    public E peek() {
        return peekFirst();
    }

    public E peekFirst(){
        if (size == 0){
            return null;
        }

        @SuppressWarnings("unchecked")
                E item = (E) array[(front + 1) % array.length];
        return item;
    }

    public E peekLast(){
        if (size == 0){
            return null;
        }

        @SuppressWarnings("unchecked")
                E item = (E) array[(rear)];
        return item;
    }

    public E element(){
        return getFirst();
    }

    public E getFirst(){
        E item = peek();
        if (item == null) {
            throw new NoSuchElementException();
        }
        return item;
    }

    public E getLast() {
        E item = peekLast();
        if (item == null){
            throw new NoSuchElementException();
        }
        return item;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0 ? true : false;
    }

    public boolean contains(Object value){
        int start = (front + 1) % array.length;
        for (int i = 0, idx = start; i < size; i++, idx = (idx + 1) % array.length){
            if (array[idx].equals(value)){
                return true;
            }
        }
        return false;
    }

    public void clear(){
        for (int i = 0; i < array.length; i++){
            array[i] = null;
        }
        front = rear = size = 0;
    }

    public Object[] toArray(){
        return toArray(new Object[size]);
    }

    @SuppressWarnings("unchecked")
    public <T> T[] toArray(T[] a){
        final T[] res;
        if (a.length < size){
            if (front <= rear){
                return (T[]) Arrays.copyOfRange(array, front + 1, rear + 1, a.getClass());
            }
            res = (T[])Arrays.copyOfRange(array, 0, size, a.getClass());
            int rearlength = array.length - 1 - front;
            if (rearlength > 0){
                System.arraycopy(array, front + 1, res, 0, rearlength);
            }
            System.arraycopy(array, 0, res, rearlength, rear + 1);
            return res;
        }
        if (front <= rear){
            System.arraycopy(array, front + 1, a, 0, size);
        } else {
            int rearlength = array.length - 1 - front;
            if (rearlength > 0){
                System.arraycopy(array, front + 1, a, 0, rearlength);
            }
            System.arraycopy(array, 0, a, rearlength, rear + 1);
        }
        return a;
    }
    @Override
    public Object clone(){
        try{
            @SuppressWarnings("unchecked")
            ArrayDeque<E> clone = (ArrayDeque<E>) super.clone();
            clone.array = Arrays.copyOf(array, array.length);
            return clone;
        } catch (CloneNotSupportedException e){
            throw new Error(e);
        }
    }

    public void sort(){
        sort(null);
    }

    @SuppressWarnings("unchecked")
    public void sort(Comparator<? super E> c){
        Object[] res = toArray();
        Arrays.sort((E[]) res, 0, size, c);
        clear();
        System.arraycopy(res, 0, array, 1, res.length);
        this.rear = this.size = res.length;
    }
}
