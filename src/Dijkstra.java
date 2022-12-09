import java.util.*;

public class Dijkstra {
    public void getPath(Vertex source) {
        source.setMinDistance(0);
        PriorityQueue<Vertex> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(source);

        while (!priorityQueue.isEmpty()) {
            Vertex vertex = priorityQueue.poll();

            for (Edge edge : vertex.getEdges()) {
                Vertex vertex2 = edge.getTargetVertex();
                double weight = edge.getWeight();
                double minDistance = vertex.getMinDistance() + weight;

                if (minDistance < vertex2.getMinDistance()) {
                    priorityQueue.remove(vertex);
                    vertex2.setLastVertex(vertex);
                    vertex2.setMinDistance(minDistance);
                    priorityQueue.add(vertex2);
                }
            }
        }
    }

    public List<Vertex> getShortestPathTo(Vertex targetVertex) {
        List<Vertex> path = new ArrayList<>();

        for (Vertex vertex = targetVertex; vertex != null; vertex = vertex.getLastVertex()) {
            path.add(vertex);
        }

        Collections.reverse(path);
        return path;
    }
}
