package heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.NoSuchElementException;

public class Heap<E> {
    private final Comparator<? super E> comparator;
    private static final int DEFAULT_CAPACITY = 10;

    private int size; // 요소의 개수

    private Object[] arry; // 요소를 담을 배열

    // 생성자 Type 1 (초기 공간 할당 X)
    public Heap(){
        this(null);
    }

    public Heap(Comparator<? super E> comparator){
        this.arry = new Object[DEFAULT_CAPACITY];
        this.size =0;
        this.comparator = comparator;
    }

    // 생성자 Type 2 (초기 공간 할당 0)
    public Heap(int capacity){
        this(capacity, null);
    }

    public Heap (int capacity, Comparator<? super E> comparator){
        this.arry = new Object[capacity];
        this.size = 0;
        this.comparator = comparator;
    }

    // 받은 인덱스의 부모 인덱스 반환
    public int getParent(int index){
        return index / 2;
    }

    // 받은 인덱스의 왼쪽 자식 인덱스 반환
    public int getLeftChild(int index){
        return index * 2;
    }

    // 받은 인덱스의 오른쪽 자식 인덱스 반환
    public int getRightChild(int index){
        return index * 2 + 1;
    }

    private void reSize(int newCapacity){
        // 새로 만들 배
        Object [] newArray = new Object[newCapacity];

        // 새 배열에 기존 배열에 있는 값들을 복사해 준다.
        for (int i = 0; i <= size; i++){
            newArray[i] = arry[i];
        }
        this.arry = null;
        this.arry = newArray;
    }

    public void add(E value){
        // 배열용적이 꽉 차있을 경우 용적을 두 배로 늘려준다.
        if (size + 1 == arry.length){
            reSize(arry.length * 2);
        }

        siftUp(size + 1, value); // 가장 마지막에 추가 되는 위치와 넣을 값(타겟)을 넘겨줌
        size++;     // 정상적으로 재배치가 끝나면 사이즈 증가
    }

    private void siftUp(int idx, E target){
        // comparator가 존재할 경우 comparator을 인자로 넘겨준다.
        if (comparator != null){
            siftUpComparator(idx, target, comparator);
        } else {
            siftUpComparable(idx, target);
        }
    }

    // Comparator 를 이용한 sift-up
    @SuppressWarnings("unchecked")
    private void siftUpComparator(int idx, E target, Comparator<? super E> comparator){
        // root 노드보다 클 때 까지만 탐색한다.
        while (idx > 1){
            int parent = getParent(idx);        // 삽입노드의 부모 인덱스 구하기
            Object parentVal = arry[parent];    // 부모노드의 값

            // 타겟 노드 값이 부모노드보다 크면 반복문 종료
            if (comparator.compare(target, (E)parentVal) >= 0){
                break;
            }
            arry[idx] = parentVal;
            idx = parent;
        }
    }

    // 삽입 할 객체의 Comparable을 이용한 sign-up
    @SuppressWarnings("unchecked")
    private void siftUpComparable(int idx, E target){

        // 타겟 노드가 비교 될 수 있도록 한 변수를 만든다.
        Comparable<? super E> comp = (Comparable<? super E>) target;

        while (idx > 1){
            int parent = getParent(idx);
            Object parentVal = arry[parent];
            if (comp.compareTo((E)parentVal) >= 0){
                break;
            }
            arry[idx] = parentVal;
            idx = parent;
        }
        arry[idx] = comp;
    }

    public E remove(){
        if (arry[1] == null){
            throw new NoSuchElementException();
        }

        E result = (E) arry[1];     // 삭제된 요소를 반환하기 위한 임시 변수
        E target = (E) arry[size];  // 타겟이 될 요소
        arry[size] = null; // 타겟 노드를 비운다.

        //삭제할 노드의 인덱스와 이후 재배치 할 타겟 노드를 넘겨준다.
        siftDown(1, target);        // 루트 노드가 삭제되므로 1을 넘겨준다.
        return result;
    }

    private void siftDown(int idx, E target) {
        // comparator가 존재할 경우 comparator 을 인자로 넘겨준다.
        if(comparator != null) {
            siftDownComparator(idx, target, comparator);
        }
        else {
            siftDownComparable(idx, target);
        }
    }

    // Comparator을 이용한 sift-dwon
    @SuppressWarnings("unchecked")
    private void siftDownComparator(int idx, E target, Comparator<? super E> comp){

        arry[idx] = null; //삭제할 인데스의 노드 삭제
        size--;

        int parent = idx; //삭제노드부터 시작 할 부모를 가리키는 변수
        int child; // 교환 될 자식을 가리키는 변수

        // 왼쪽 자식 노드의 인덱스가 요소의 개수보다 작을 때 까지 반복
        while ((child = getLeftChild(parent)) <= size){
            int right = getRightChild(parent); //오른쪽 자식 인덱스

            Object childVal = arry[child];
            /*
             *  오른쪽 자식 인덱스가 size를 넘지 않으면서
             *  왼쪽 자식이 오른쪽 자식보다 큰 경우
             *  재배치 할 노드는 작은 자식과 비교해야하므로 child와 childVal을
             *  오른쪽 자식으로 바꿔준다.
             */
            if (right <= size && comp.compare((E) childVal, (E) arry[right]) > 0){
                child = right;
                childVal = arry[child];
            }

            // 재배치 할 노드가 자식 노드보다 작을 경우 반복문을 종료한다.
            if (comp.compare(target, (E) childVal) <= 0){
                break;
            }
            /*
             *  현재 부모 인덱스에 자식 노드 값을 대체해주고
             *  부모 인덱스를 자식 인덱스로 교체
             */
            arry[parent] = childVal;
            parent = child;
        }
        // 최종적으로 재배치 되는 위치에 타겟이 된 값을 넣어준다.
        arry[parent] = target;
        /*
         *  용적의 사이즈가 최소 용적보다는 크면서 요소의 개수가 전체 용적의 1/4일경우
         *  용적을 반으로 줄임(단, 최소용적보단 커야함)
         */
        if (arry.length > DEFAULT_CAPACITY && size < arry.length / 4){
            reSize(Math.max(DEFAULT_CAPACITY, arry.length / 2));
        }
    }

    // Comparable을 이용한 sift-down
    @SuppressWarnings("unchecked")
    private void siftDownComparable(int idx, E target){
        Comparable<? super E> comp = (Comparable<? super E>) target;

        arry[idx]= null;
        size--;

        int parent = idx;
        int child;

        while ((child = getLeftChild(parent)) <= size){
            int right = getRightChild(parent);

            Object childVal = arry[child];
            if (right <= size && ((Comparable<? super E>)childVal).compareTo((E)arry[right]) > 0){
                child = right;
                childVal = arry[right];
            }

            if (comp.compareTo((E) childVal) <= 0){
                break;
            }
            arry[parent]  = childVal;
            parent = child;
        }
        arry[parent] = comp;

        if (arry.length > DEFAULT_CAPACITY && size < arry.length / 4){
            reSize(Math.max(DEFAULT_CAPACITY, arry.length) /2);
        }
    }

    public int size() {
        return this.size;
    }

    @SuppressWarnings("unchecked")
    public E peek() {
        if(arry[1] == null) {
            throw new NoSuchElementException();
        }
        return (E)arry[1];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public Object[] toArray() {
        return Arrays.copyOf(arry, size + 1);
    }
}
