import java.io.*;
import java.util.*;

public class ReadFile {
    public static void main(String args[]) throws IOException{
        Scanner scanInput = new Scanner(System.in);
        String filename = "";

        System.out.print("Would you like to create a graph or use the set one? (1 to create | 2 to use set graph): ");
        int input = scanInput.nextInt();

        if(input == 1){
            filename = "graph";
            WriteFile writeFile = new WriteFile();
            writeFile.Write(filename);
        }else if(input == 2){
            filename = "graph2";
        }

        File file = new File(filename + ".txt");

        ArrayList<ArrayList<Vertex.VertexList> > arrVertex = new ArrayList<>();
        Scanner scan = new Scanner(file);

        int source = scan.nextInt();
        //System.out.println(source);
        String typeGraph = scan.next();

        if(typeGraph.equals("A")){
            int vertexAmount = scan.nextInt();
            //System.out.println(vertexAmount);
            for(int i = 0; i < vertexAmount; i++){
                arrVertex.add(new ArrayList<>());
            }

            while(scan.hasNext()){
                int from = scan.nextInt();
                //System.out.println(from);
                int target = scan.nextInt();
                //System.out.println(target);
                int weight = scan.nextInt();
                //System.out.println(weight);
                //System.out.println();
                arrVertex.get(from).add(new Vertex.VertexList(target, weight));
            }

            Dijkstra.dijkstra(vertexAmount, arrVertex, source);
        }else{
            System.out.println("No type of file!");
        }
    }
}
