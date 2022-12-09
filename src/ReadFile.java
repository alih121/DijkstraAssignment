import java.io.*;
import java.util.*;

public class ReadFile {
    public static void main(String args[]) throws IOException{
        Dijkstra dijkstra = new Dijkstra();
        String filename = "graph";
        WriteFile writeFile = new WriteFile();
        writeFile.Write(filename);

        int scanSame;
        int scanTarget;
        Vertex sameVertex;
        Vertex targetVertex;
        double weight;

        File file = new File(filename + ".txt");

        List<Vertex> arrVertex = new ArrayList<>();
        Scanner scan = new Scanner(file);

        int source = scan.nextInt();
        scan.nextLine();

        String typeGraph = scan.next();

        if(typeGraph.equals("A")){
            scan.nextLine();
            int vertexAmount = scan.nextInt();

            for(int i = source; i <= vertexAmount; i++){
                arrVertex.add(new Vertex(i));
            }

            scan.nextLine();
            scan.nextLine();

            while(scan.hasNext()){
                scanSame = scan.nextInt();
                sameVertex = new Vertex(scanSame);

                for(int i = source; i <= vertexAmount; i++){
                    if(arrVertex.get(i).getVertex() == scanSame){
                        scanTarget = scan.nextInt();
                        targetVertex = new Vertex(scanTarget);
                        weight = scan.nextInt();
                        arrVertex.get(i).addNeighbour(new Edge(weight, sameVertex, targetVertex));
                    }
                }
            }

            for(int i = source; i <= vertexAmount; i++){
                sameVertex = new Vertex(arrVertex.get(i).getVertex());
                dijkstra.getPath(sameVertex);

                for(int j = source; j <= vertexAmount; j++) {
                    targetVertex = new Vertex(arrVertex.get(j).getVertex());
                    System.out.println(dijkstra.getShortestPathTo(targetVertex));
                }
            }
        }

//        for (int i = 0; i < arrVertex.size();i++)
//        {
//            System.out.println(arrVertex.get(i).getVertex());
//        }
    }
}
