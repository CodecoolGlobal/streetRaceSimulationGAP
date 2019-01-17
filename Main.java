import java.util.Scanner;
import java.util.Date;

public class Main{
    
    public static void main(String[] args){
        Betting betting = new Betting();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number, where you'd like to go!");
        System.out.println("    1. Generate n rounds of the race!");
        System.out.println("    2. Show one round of the race!");
        System.out.println("    3. Show statistics!");
        System.out.println("    4. Betting and generating the race!");
        int menuOptions = scanner.nextInt();
        scanner.nextLine();
        int rounds;
        HistoricalDatas history = new HistoricalDatas();
        Logger log = new Logger();

        
        switch(menuOptions){
            case 1: System.out.println("How many runs would you like to create?");
                    rounds = scanner.nextInt();
                    scanner.nextLine();
                    Date currentDate = new Date(); 
                    for(int i = 0; i<rounds; i++){
                        HistoricalDatas runningHistory = new HistoricalDatas();
                        runningHistory.generateData();
                    }
                    Date currentDate2 = new Date();
                    log.timeDiffInSeconds(currentDate, currentDate2);
                    break;
            case 2: System.out.println("Showing one test run!\n");
                    history.printOneRound();
                    String oneRoundWinner = history.getFirstPlace();
                    System.out.println("\nThe winner of this round is: " + oneRoundWinner);
                    break;
            case 3: System.out.println("Showing statistics!");
                    //Printing useful stats!
            case 4: System.out.println("Betting and generating the race:");
                    betting.makeBet(1000);
        }
    }
    
}