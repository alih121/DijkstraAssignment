import java.util.*;

public class Vertex implements Comparable<Vertex> {
    private int vertex;
    private boolean visited;
    private double minDistance = Double.MAX_VALUE;
    private List<Edge> edges;
    private Vertex lastVertex;

    public Vertex(int vertex) {
        this.vertex = vertex;
        this.edges = new ArrayList<>();
    }

    public void addNeighbour(Edge edge) {
        this.edges.add(edge);
    }

    public void setEdges(List<Edge> edges) {
        this.edges = edges;
    }

    public void setMinDistance(double minDistance) {
        this.minDistance = minDistance;
    }

    public void setLastVertex(Vertex lastVertex) {
        this.lastVertex = lastVertex;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public Vertex getLastVertex() {
        return lastVertex;
    }

    public List<Edge> getEdges() {
        return edges;
    }

    public double getMinDistance() {
        return minDistance;
    }

    public boolean isVisited() {
        return visited;
    }

    public int getVertex(){
        return vertex;
    }

    @Override
    public int compareTo(Vertex compareVertex) {
        return Double.compare(this.minDistance, compareVertex.minDistance);
    }
}
