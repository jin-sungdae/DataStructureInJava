package heap;

import java.util.Random;

public class TestMain {
    public static void main(String[] args) {
        Heap<Integer> heap = new Heap<>();

        Random random = new Random();

        for (int i = 0; i < 15; i++){
            heap.add(random.nextInt(100));
        }

        System.out.print("내부 배열 상태 : ");
        for (Object val : heap.toArray()){
            System.out.print(val + " ");
        }
        System.out.println();

        System.out.print("힙 요소 뽑기 : \t");
        while (!heap.isEmpty()){
            System.out.print(heap.remove() + " ");
        }
    }
}
