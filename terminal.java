import java.util.Scanner;

class terminal {
    // Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        int choice;
        do {
            choice = terminal_main();
            if (choice == 1) provider_main();
            else if (choice == 2) manager_main();

        } while (choice != 3);
        return;        
    }

    public static int terminal_main(){
        int choice; 
        System.out.println("======================");
        System.out.println("Acme Main Terminal");  
        System.out.println("1. Provider's Termnial");  
        System.out.println("2. Manager's Termnial");  
        System.out.println("3. Exit");  
        System.out.println("======================");
        System.out.println("What would you like to do? ");
        Scanner input = new Scanner(System.in);
        String answer = input.nextLine();
        int parseInt = Integer.parseInt(answer);
        choice = parseInt;
        

        if (choice != 1 && choice != 2 && choice != 3){
            System.out.println("Invalid input. Please try again");
            return terminal_main();
        }
        return choice;
    }

    public static void provider_main() {
        System.out.println("You are int the Provider's Terminal");
        return;
    }

    public static void manager_main() {
        System.out.println("You are in the Manager's Terminal");
        return;
    }
}

