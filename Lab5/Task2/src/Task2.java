
import java.io.*;
import java.util.*;

public class Task2 {
    public static void main(String[] args){
        final String output_file = "Task2/Task2_output.txt";
        final int AlphaCapacty = 150;
        List<Integer> Alpha = new ArrayList<>();
        Random rand = new Random();
        for (int i = 0; i < AlphaCapacty; i++){
            Alpha.add(rand.nextInt(200) + 1);
        }
        List<Integer> Alpha_copy = new ArrayList<>(Alpha);
        Alpha_copy.sort(Comparator.reverseOrder());
        List<Integer> Beta = new ArrayList<>(Alpha_copy.subList(0,15));

        System.out.println(Beta.toString());
        try(FileWriter writer = new FileWriter(output_file)){
            writer.write(Beta.toString());
            writer.close();
        }
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
