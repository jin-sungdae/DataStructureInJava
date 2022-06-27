package fastcampus_dataStructure.boublesort;

import java.util.*;

class BubbleSort{
    public ArrayList<Integer> sort(ArrayList<Integer> dataList) {
        for (int i = 0; i < dataList.size() - 1; i++){
            boolean swap = false;

            for (int j = 0; j < dataList.size() - 1 - i; j++) {
                if (dataList.get(j) > dataList.get(j + 1)){
                    Collections.swap(dataList, j, j + 1);
                    swap = true;
                }
            }

            if (swap == false)
                break;
        }
        return dataList;
    }
}

public class P2 {
    public static void main(String[] args) {
        ArrayList<Integer> testData = new ArrayList<>();
        for (int i = 0; i < 100; i++){
            testData.add((int)(Math.random()) * 100);
        }
        System.out.println(testData);
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.sort(testData);
        System.out.println(bubbleSort);
    }
}
