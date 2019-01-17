import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.HashMap;

public class Logger{
    HistoricalDatas history = new HistoricalDatas();
    Betting betting = new Betting();
    Scanner scanner = new Scanner(System.in);
    Statistics win = new Statistics();
    HashMap winMap = win.winStatistics();

    //Methods
    public void log(String type, String errorMessage){
        Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM.dd @ HH:mm:ss");

        System.out.println(dateFormat.format(currentDate) + "\t" + type + "\t" + errorMessage);
    }
    
    public void timeDiffInSeconds(Date date1, Date date2){
        double diffTime = date1.getTime()-date2.getTime();
        double diffTimeInSeconds =  Math.abs(diffTime/1000);
        
        System.out.println("The task was finished in " + diffTimeInSeconds + " second(s).");
    }

    public int handleInputInt(String outputMessage){
        System.out.print(outputMessage + " ");
        int userInput = scanner.nextInt();
        scanner.nextLine();
        System.out.println();
        return userInput;
    }

    public String handleInputString(String outputMessage){
        System.out.print(outputMessage  + " ");
        String userInput = scanner.next();
        scanner.nextLine();
        System.out.println();
        return userInput;
    }

    public void menu(){

        System.out.println("\n\t0. Quit");
        System.out.println("    1. Generate n rounds of the race!");
        System.out.println("    2. Show one round of the race!");
        System.out.println("    3. Show statistics!");
        System.out.println("    4. Betting and generating the race!");
        System.out.println("    5. Redeem a free coupon worth of 500$!");
        System.out.println("    6. Print out the money I have left!");
    

        boolean notQuit = true;
        while (notQuit){
            int menuOptions = handleInputInt("\nEnter a number, where you'd like to go:");
            switch(menuOptions){
                case 0: notQuit = false;
                        break;
                case 1: int rounds = handleInputInt("How many runs would you like to create?");
                        Date currentDate1 = new Date(); 
                        for(int i = 0; i<rounds; i++){
                            HistoricalDatas runningHistory = new HistoricalDatas();
                            runningHistory.generateData();
                        }                    
                        Date currentDate2 = new Date();
                        timeDiffInSeconds(currentDate1, currentDate2);
                        break;
                case 2: System.out.println("Showing one test run!\n");
                        history.printOneRound();
                        String oneRoundWinner = history.getFirstPlace();
                        System.out.println("\nThe winner of this round is: " + oneRoundWinner);
                        break;
                case 3: System.out.println("Showing statistics!");
                        System.out.println(win.winStatistics());
                        //System.out.println((Arrays.toString(history.rowCounter("HistoricalData.csv"))));
                        //Printing useful stats!
                        break;
                case 4: System.out.println("Betting and generating the race:");
                        double money = betting.history.loadMoney("yourMoney.csv");
                        betting.makeBet(money);
                        break;
                case 5: System.out.println("Redeeming free coupon worth of 500$");
                        double mani = betting.history.loadMoney("yourMoney.csv");
                        betting.freeMoney(mani);
                case 6: double gettingMoney = betting.history.loadMoney("yourMoney.csv");
                        System.out.println("The amount of money you have now: " + gettingMoney);
            }
        }
    }
}