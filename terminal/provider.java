package terminal;
import java.util.Scanner;

public class provider {
    
    public void provider_main() {
        System.out.println("You are in the Provider's Terminal");
        int choice;
        do {
            choice = provider_menu();
            if (choice == 1) {
                System.out.println
                ("You are trying to print Provider's Directory");
            }
            else if (choice == 2) {
                System.out.println
                ("You are trying to bill ChocAn for a service");
            }
            else if (choice == 3) {
                System.out.println
                ("You are trying to print Provider's Report");
            }

        } while (choice != 4);       
        
        return;
    }

    public static int provider_menu(){
        int choice; 
        System.out.println("======================");
        System.out.println("Health Provider's Menu");  
        System.out.println("1. Print Provider's Directory");  
        System.out.println("2. Bill ChocAn for a service");  
        System.out.println("3. Print Provider's Report");  
        System.out.println("4. Quit");  
        System.out.println("======================");
        System.out.println("What would you like to do? ");
        Scanner input = new Scanner(System.in);
        String answer = input.nextLine();
        int parseInt = Integer.parseInt(answer);
        choice = parseInt;
        

        if (   choice != 1 && choice != 2 
            && choice != 3 && choice != 4) {
            System.out.println("Invalid input. Please try again");
            return provider_menu();
        }
        return choice;
    }

}