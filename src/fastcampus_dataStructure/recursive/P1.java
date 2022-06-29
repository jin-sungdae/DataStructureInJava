package fastcampus_dataStructure.recursive;

class Factorial{
    public static int factorialFucn(int n){
        if (n ==0) {
            return 1;
        } else if (n == 1){
            return 2;
        }
        String [][]board = {{"hello", "hi"},{"hi","hellO"}};
        int k = factorialFucn(n - 1) + factorialFucn(n - 2);
        return k;

    }
}



public class P1 {
    public static void main(String[] args) {
        System.out.println(Factorial.factorialFucn(7));
    }
}
