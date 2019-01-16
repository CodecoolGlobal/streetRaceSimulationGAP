import java.util.Scanner;

public class Main{
    
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number, where you'd like to go!");
        System.out.println("    1. Generate n rounds of the race!");
        System.out.println("    2. Show one round of the race!");
        System.out.println("    3. Show statistics!");
        int menuOptions = scanner.nextInt();
        scanner.nextLine();
        int rounds;
        HistoricalDatas history = new HistoricalDatas();

        
        switch(menuOptions){
            case 1: System.out.println("How many runs would you like to create?");
                    rounds = scanner.nextInt();
                    scanner.nextLine();
                    for(int i = 0; i<rounds; i++){
                        HistoricalDatas runningHistory = new HistoricalDatas();
                        runningHistory.generateData();
                    }
                    break;
            case 2: System.out.println("Showing one test run!\n");
                    history.printOneRound();
                    String oneRoundWinner = history.getFirstPlace();
                    System.out.println("\nThe winner of this round is: " + oneRoundWinner);
                    break;
            case 3: System.err.println("Showing statistics!");
                    //Printing useful stats!
        }
    }
    
}