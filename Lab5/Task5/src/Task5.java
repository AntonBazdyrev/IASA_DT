import java.io.*;
import java.util.*;

public class Task5 {
    public static void main(String[] args) throws FileNotFoundException {

        String[] lang = {"eng", "rus", "ukr"};
        for (String l: lang){
            System.out.println(l);
            Scanner s = new Scanner(new FileReader("Task5/text_" + l + ".txt"));
            List<String> array = new ArrayList<>();
            while (s.hasNext()) {
                String word = s.next();
                array.add(word);
            }
            array.sort(String::compareToIgnoreCase);
            System.out.println(array);
            System.out.println();
        }
    }
}