public class Edge {
    private double weight;
    private Vertex firstVertex;
    private Vertex targetVertex;

    public Edge(double weight, Vertex firstVertex, Vertex targetVertex) {
        this.weight = weight;
        this.firstVertex = firstVertex;
        this.targetVertex = targetVertex;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setStartVertex(Vertex firstVertex) {
        this.firstVertex = firstVertex;
    }

    public void setTargetVertex(Vertex targetVertex) {
        this.targetVertex = targetVertex;
    }

    public double getWeight() {
        return weight;
    }

    public Vertex getStartVertex() {
        return firstVertex;
    }

    public Vertex getTargetVertex() {
        return targetVertex;
    }
}