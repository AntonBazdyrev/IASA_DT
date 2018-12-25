import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task3 {
    private static boolean isPath(String path){
        return path.matches("^.+\\.txt$");
    }

    private final static String default_filepath_i = "Task3/default_input.txt";

    private final static String default_filepath_o = "Task3/default_output.txt";

    private static List<Worker> add(List<Worker> list, String record) {
        String[] records_parts = record.trim().split("\\|");
        if (records_parts[0].equals("hourly")) {
            list.add(new HourlySalaryWorker(
                    records_parts[1],
                    Integer.parseInt(records_parts[2]),
                    Double.parseDouble(records_parts[3]))
            );
        }
        if (records_parts[0].equals("fixed")) {
            list.add(new FixedSalaryWorker(
                    records_parts[1],
                    Integer.parseInt(records_parts[2]),
                    Double.parseDouble(records_parts[3]))
            );
        }
        return list;
    }

    private static boolean test_record(String record){
        return record.matches("^(hourly|fixed)\\|[\\w\\s]+\\|\\d+\\|\\d+(\\.\\d{1,2})?$");
    }

    private static List<Worker> read(String filepath) {
        List<Worker> list = new ArrayList<>();
        try(Scanner cin = new Scanner(new FileReader(filepath))){
            while (cin.hasNext()){
                String record = cin.nextLine();
                if(test_record(record)) {
                    list = add(list, record);
                }
            }
        }
        catch (Exception ex){
            print(ex.getMessage());
        }
        return list;
    }

    private static void write(String filepath, List<Worker> list){
        try(FileWriter cout = new FileWriter(filepath)){
            for(Worker record : list)
                cout.write(record.toString()+"\n");
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    private static void print(Object obj){
        System.out.println(obj.toString().trim());
    }

    public static void main(String args[]){
        Scanner cin = new Scanner(System.in);
        List<Worker> list;
        final int n_1 = 5;
        final int n_2 = 3;

        print("Input name of file: ");
        String filepath = cin.nextLine();
        if (isPath(filepath)){
            list = read(filepath);
        }
        else{
            list = read(default_filepath_i);
            print("Input file isn't a text file!(Opened default file)");
            print("");
        }
        print(list.toString());
        print("");
        if(!list.isEmpty()){
            list.sort(Worker::compareTo);
            write(default_filepath_o, list);
            print(" First " + n_1 + "name:");
            for (int i = 0; i < Integer.min(n_1, list.size()); i++)
                print(list.get(i).getName());
            print("");
            print("Last " + n_2 + "id:");
            for (int i = 1; i <= Integer.min(n_2, list.size()); i++)
                print(list.get(list.size() - i).getId());
        }
    }
}
