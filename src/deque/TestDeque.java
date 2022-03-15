package deque;

public class TestDeque {
    public static void main(String[] args) {
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();
        arrayDeque.offerFirst(6);
        arrayDeque.offerLast(7);
        System.out.println(arrayDeque.peekFirst());
        System.out.println(arrayDeque.peekLast());
        System.out.println(arrayDeque.pollLast());
    }
}
