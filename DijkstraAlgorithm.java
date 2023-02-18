
import java.util.*;
import java.util.Map.Entry;
public class DijkstraAlgorithm {
    public static void main(String[] args) throws Exception {
        
    }
}

class Node{
    private int distance;
    private String name;
    private LinkedList<Node> shortestPath;
    private Map<Node,Integer> adjVertices;

    public Node(String name) {
        this.name = name;
        this.distance = Integer.MAX_VALUE;
        this.shortestPath = new LinkedList<>();
        this.adjVertices = new HashMap<>();
    }
    
    public int getDistance() {
        return distance;
    }
    public void setDistance(int distance) {
        this.distance = distance;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public LinkedList<Node> getShortestPath() {
        return shortestPath;
    }
    public void setShortestPath(LinkedList<Node> shortestPath) {
        this.shortestPath = shortestPath;
    }
    public Map<Node, Integer> getAdjVertices() {
        return adjVertices;
    }
    public void setAdjVertices(Map<Node, Integer> adjVertices) {
        this.adjVertices = adjVertices;
    }
    public void addDestination(Node node, int distance){
        adjVertices.put(node,distance);
    }
}

class Graph{
    private Set<Node> nodes; 

    public Graph(){
        nodes = new HashSet<>();
    }
    public void addNode(Node node){
        nodes.add(node);
    }
    public Set<Node> getNodes() {
        return nodes;
    }
    public void setNodes(Set<Node> nodes) {
        this.nodes = nodes;
    }
}

class Dijkstra{
    public static void calculateMinimumDistance(Node sourceNode, 
                                                Node destiationNode,int distance){
        LinkedList<Node> newPath = new LinkedList<>(sourceNode.getShortestPath());
        int checkDistance = sourceNode.getDistance() + distance;

        if(checkDistance<destiationNode.getDistance()){
            destiationNode.setDistance(checkDistance);
            newPath.add(sourceNode);
            destiationNode.setShortestPath(newPath);      
        }
    }

    public static Graph calculateShortestPath(Graph graph, Node sourceNode){
        PriorityQueue<Node> unsettledNodes = new PriorityQueue<>(Comparator.comparingInt(n->n.getDistance()));
        Set<Node> settledNodes = new HashSet<>();

        sourceNode.setDistance(0);
        unsettledNodes.add(sourceNode);

        while(!(unsettledNodes.isEmpty())){
            Node currentNode = unsettledNodes.poll();
            for (Entry<Node, Integer> e : currentNode.getAdjVertices().entrySet()) {
                Node adj = e.getKey();
                Integer distance = e.getValue();

                if(!settledNodes.contains(adj)){
                    calculateMinimumDistance(currentNode, adj, distance);
                    unsettledNodes.add(adj);
                }
            }
            settledNodes.add(currentNode);
        }
        return graph;
    }
}