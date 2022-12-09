import java.util.*;

public class Dijkstra {
    public ArrayList<Vertex> getPath(Vertex source) {
        source.setMinDistance(0);
        PriorityQueue<Vertex> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(source);
        ArrayList<Vertex> vertexArr = new ArrayList<>();
        vertexArr.add(source);

        while (!priorityQueue.isEmpty()) {
            Vertex vertex = priorityQueue.poll();
            System.out.println(vertex.getMinDistance());

            for (Edge edge : vertex.getEdges()) {
                Vertex vertex2 = edge.getTargetVertex();
                double weight = edge.getWeight();
                double minDistance = vertex.getMinDistance() + weight;

                if (minDistance < vertex2.getMinDistance()) {
                    vertex2.setLastVertex(vertex);
                    vertex2.setMinDistance(minDistance);
                    priorityQueue.add(vertex2);
                    vertexArr.add(vertex2);
                }
                //System.out.println(vertex2.getMinDistance());
            }
        }
        return vertexArr;
    }

    public ArrayList<Vertex> getShortestPathTo(Vertex targetVertex) {
        ArrayList<Vertex> path = new ArrayList<>();

        for (Vertex vertex = targetVertex; vertex != null; vertex = vertex.getLastVertex()) {
            path.add(vertex);
        }

        Collections.reverse(path);
        return path;
    }
}
