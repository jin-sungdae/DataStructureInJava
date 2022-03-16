package graph;

public class GraphTest {
    public static void main(String[] args) {
        int initSize = 5;
        AdjacencyList adjacencyList = new AdjacencyList(initSize);
        adjacencyList.put(1, 2, 1);
        adjacencyList.put(1, 4, 1);
        adjacencyList.put(2, 3, 1);
        adjacencyList.put(2, 5, 1);
        adjacencyList.put(4, 5, 1);
        adjacencyList.printGraph(1);

        AdjacencyArray adjacencyArray = new AdjacencyArray(initSize);
        adjacencyArray.put(1, 2, 1);
        adjacencyArray.put(1, 4, 1);
        adjacencyArray.put(2, 3, 1);
        adjacencyArray.put(2, 5, 1);
        adjacencyArray.put(4, 5, 1);
        adjacencyArray.printGraph();

    }
}
