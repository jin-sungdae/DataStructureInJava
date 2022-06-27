package fastcampus_dataStructure.insertsort;



import java.util.ArrayList;
import java.util.Collections;

class insertsort{
    public ArrayList<Integer> sort(ArrayList<Integer> dataList){
        for (int index = 0; index < dataList.size() - 1; index++){
            for (int index2 = index + 1; index2 > 0; index--){
                if (dataList.get(index2) < dataList.get(index2 - 1)){
                    Collections.swap(dataList, index2, index2 - 1);
                } else {
                    break;
                }
            }
        }
        return dataList;
    }
}

public class P1 {
    public static void main(String[] args) {
        ArrayList<Integer> testData = new ArrayList<>();

        for (int i = 0; i < 100; i++){
            testData.add((int)Math.random() * 100);
        }

        System.out.println(testData);
        insertsort insertsort= new insertsort();
        insertsort.sort(testData);

        System.out.println(insertsort.toString());
    }
}
