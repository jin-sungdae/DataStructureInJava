package graph;

public class AdjacencyArray <T>{
    private int [][] adArray;
    private int size;
    public AdjacencyArray(int size){
        this.adArray = new int[size + 1][size + 1];
        this.size = size;
    }

    public void put(int vertex_y, int vertex_x, int weight){
        this.adArray[vertex_y][vertex_x] = this.adArray[vertex_x][vertex_y] = weight;
    }

    public void putSingle(int vertex_y, int vertex_x, int weight){
        this.adArray[vertex_y][vertex_x] = weight;
    }

    public void printGraph(){
        StringBuilder sb = new StringBuilder();
        sb.append("인접 행렬을 구현한 2차원 배열 내역\n");
        for (int i = 0; i < this.adArray.length; i++){
            for (int j = 0; j < this.adArray[i].length; j++){
                sb.append(this.adArray[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
