import java.util.Scanner;
public class Task6 {
    public static void main(String[] args) {
        System.out.println("Input your string: ");
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        System.out.println(string.chars()
                .mapToObj(c -> (char)c)
                .reduce("", (s,c) -> c+s, (s1,s2) -> s2+s1)
        );
    }
}
