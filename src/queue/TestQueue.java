package queue;

public class TestQueue {
    public static void main(String[] args) {
        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
        arrayQueue.offer(3);
        arrayQueue.offer(5);
        arrayQueue.offer(6);
        System.out.println(arrayQueue.peek());
        System.out.println(arrayQueue.peek());System.out.println(arrayQueue.peek());

        System.out.println(arrayQueue.poll());
        System.out.println(arrayQueue.poll());
        System.out.println(arrayQueue.poll());
        System.out.println(arrayQueue.peek());
        System.out.println(arrayQueue.peek());System.out.println(arrayQueue.peek());


//        while (arrayQueue.isEmpty()){
//            System.out.println(arrayQueue.peek());
//        }
    }
}
