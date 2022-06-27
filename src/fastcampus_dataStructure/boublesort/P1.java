package fastcampus_dataStructure.boublesort;

import java.util.ArrayList;
import java.util.Collections;

public class P1 {
    public static void main(String[] args) {
        ArrayList<Integer> dataList = new ArrayList<>();
        dataList.add(9);
        dataList.add(2);
        dataList.add(4);

        for(int index = 0; index < dataList.size() - 1; index++){
            if (dataList.get(index) > dataList.get(index + 1)){
                Collections.swap(dataList, index, index + 1);
            }
        }



        System.out.println(dataList);
    }

}
