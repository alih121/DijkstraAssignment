import java.io.*;
import java.nio.file.*;
import java.util.*;

public class WriteFile {
    public void Write(String filename){
        Path target = Paths.get(filename + ".txt");
        Scanner scan = new Scanner(System.in);
        Random random = new Random();

        String text = "";
        int weight;
        int vertex;
        int source;
        int to;
        int from;

        System.out.print("Input Source node: ");
        source = scan.nextInt();
        text += source + "\n";

        scan.nextLine();

        text += "A\n"; // edge weighted graph

        System.out.print("Input Vertex amount: ");
        vertex = scan.nextInt();
        scan.close();
        text += vertex + "\n\n";

        try{
            for(int i = source; i < vertex; i++){
                from = random.nextInt(vertex - source) + source;
                //text += from + "\t";

                do{
                    if(from != source && i == source){
                        from = random.nextInt(vertex - source) + source;
                    }
                }while(from != source && i == source);
                text += from + "\t";

                to = random.nextInt(vertex - source) + source;
                text += to + "\t";

                weight = random.nextInt(vertex - source) + source;
                text += weight + "\n";
            }
            Files.write(target, text.getBytes());
        }
        catch(IOException e){
            System.err.println(e);
        }
    }
}
