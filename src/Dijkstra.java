import java.util.*;

public class Dijkstra {
    private static final int NO_PARENT = -1;

    public static void dijkstra(int vertexAmount, ArrayList<ArrayList<Vertex.VertexList> > arrVertex, int source)
    {
        // distance[] holds the shortest distance between source and target
        int[] distance = new int[vertexAmount];
        // parents[] holds path tree
        int[] parents = new int[vertexAmount];

        // distances[] initialised to infinite before using it
        for (int i = 0; i < vertexAmount; i++){
            distance[i] = Integer.MAX_VALUE;
        }

        // distance of source vertex from itself will be 0
        distance[source] = 0;
        // source vertex will not have a parent so -1
        parents[source] = NO_PARENT;

        // PriorityQueue is used here to hold vertices in a natural order, comparing the edge weights
        // adds source as first element in PriorityQueue
        PriorityQueue<Vertex.VertexList> pq = new PriorityQueue<>(
                Comparator.comparingInt(Vertex.VertexList::getWeight));
        pq.add(new Vertex.VertexList(source, 0));

        // continue looping while PriorityQueue has elements
        while (pq.size() > 0) {
            // create a new Vertex list current
            // .poll() will retrieve the head of the PriorityQueue and place it to current
            // then removes it from PriorityQueue
            Vertex.VertexList current = pq.poll();
            int nearestVertex;

            // for loop to loop until arrVertex list is empty
            for (Vertex.VertexList v : arrVertex.get(current.getVertex())) {
                // if the distance of the current vertex is less than the distance of the iterated vertex
                if (distance[current.getVertex()] + v.getWeight() < distance[v.getVertex()]) {
                    // nearestVertex equals the current vertex
                    nearestVertex = current.getVertex();
                    // distance of the iterated vertex equals the distance of the current vertex
                    distance[v.getVertex()] = v.getWeight() + distance[current.getVertex()];
                    // add this iterated vertex to the PriorityQueue and its short distance
                    pq.add(new Vertex.VertexList(v.getVertex(), distance[v.getVertex()]));
                    // add the current vertex to parents[] as a vertex part of the path
                    parents[v.getVertex()] = nearestVertex;
                }
            }
        }

        // initialise a new variable with holds distance length
        int nVertices = distance.length;
        System.out.print("Vertex\t  Distance\tPath");

        // for loop to output all vertices, their distance from source, and their path
        for (int vertexIndex = 0; vertexIndex < nVertices; vertexIndex++)
        {
            // only output when vertexIndex does not equal source
            if (vertexIndex != source)
            {
                System.out.print("\n" + source + " -> ");
                System.out.print(vertexIndex + " \t\t ");

                // if statement to check if source cannot reach vertexIndex
                // if not / distance equals 2147483647 then print null
                // otherwise print distance
                if(distance[vertexIndex] == 2147483647){
                    String s = null;
                    System.out.print(s + "\t");
                }else{
                    System.out.print(distance[vertexIndex] + "\t\t");
                }

                printPath(vertexIndex, parents);
            }
        }
    }

    public static void printPath(int currentVertex, int[] parents)
    {
        // if currentVertex equals -1 return nothing
        if (currentVertex == NO_PARENT)
        {
            return;
        }
        printPath(parents[currentVertex], parents);
        System.out.print(currentVertex + " ");
    }
}
