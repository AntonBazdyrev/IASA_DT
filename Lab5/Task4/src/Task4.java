import java.util.Random;
import java.util.Scanner;

public class Task4{

    public static void main(String[] args){
        Random rand = new Random();
        Scanner scan = new Scanner(System.in);
        int max = 100, min = 0;
        boolean victory = false;
        int answer = rand.nextInt(101);
        int number;
        while (!victory){
            System.out.println("Input your number!");
            try {
                number = Integer.parseInt(scan.nextLine());
            }
            catch (NumberFormatException err){
                System.out.println("Input your INTEGER number!");
                continue;
            }
            if(number == answer){
                System.out.println("CONGRATULATIONS! Your guess is correct");
                victory = true;
            }
            else{
                if(number > max || number < min){
                    System.out.println("You number is not in interval [" + min + "; " + max + "].");
                }
                else{
                    if(number > answer){
                        max = number - 1;
                    }
                    else{
                        min = number + 1;
                    }
                    System.out.println("Try in interval [" + min + "; " + max + "].");
                }
            }
        }
    }
}