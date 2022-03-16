package graph;

import arraylist.ArrayList;

public class AdjacencyList {
    private static class Node{
        private int vertex;
        private int weight;

        public Node(int vertex, int weight){
            this.vertex = vertex;
            this.weight = weight;
        }

        public int getVertex(){
            return this.vertex;
        }

        public int getWeight(){
            return this.weight;
        }
    }

    private ArrayList<ArrayList<Node>> adList;
    private int size;
    public AdjacencyList(int initSize){
        this.adList = new ArrayList<ArrayList<Node>>();
        this.size = initSize;
        for (int i = 0; i < initSize + 1; i++){
            this.adList.add(new ArrayList<Node>());
        }
    }

    public void put (int vertex_x, int vertex_y, int weight){
        this.adList.get(vertex_x).add(new Node(vertex_y, weight));
        this.adList.get(vertex_y).add(new Node(vertex_x, weight));
    }

    public void putSingleDirect(int vertex_x, int vertex_y, int weight){
        this.adList.get(vertex_x).add(new Node(vertex_y,weight));
    }

    public ArrayList<ArrayList<Node>> getGraph(){
        return this.adList;
    }

    public ArrayList<Node> getVertex(int idx){
        return this.adList.get(idx);
    }

    public int getWeight(int vertex_x, int vertex_y){
        return this.adList.get(vertex_x).get(vertex_y).getWeight();
    }

    public void printGraph(int startIdx){
        StringBuilder sb = new StringBuilder();
        for (int i = startIdx; i <= this.size; i++){
            sb.append("정점 ").append(i).append("의 인접 정점 리스트");
            for (int j = 0; j < this.adList.get(i).size(); j++){
                sb.append(" -> ").append(this.adList.get(i).get(j).getVertex());
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
