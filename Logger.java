import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.HashMap;
import java.lang.*;

public class Logger{
    
    Betting betting = new Betting();
    Scanner scanner = new Scanner(System.in);
    Statistics win = new Statistics();
    HashMap winMap = win.winStatistics();
    Race race = new Race();
    Output output = new Output();
    
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
        boolean notQuit = true;  
        while (notQuit){
            System.out.println();
            System.out.println("    1. Generate n rounds of the race!");
            System.out.println("    2. Show one round of the race!");
            System.out.println("    3. Show statistics!");
            System.out.println("    4. Betting and generating the race!");
            System.out.println("    5. Redeem a free coupon worth of 500$!");
            System.out.println("    6. Print out the money I have left!");
            System.out.println("    7. Give me a tip!");
            System.out.println("    8. Quit");

            int menuOptions = handleInputInt("\nEnter a number, where you'd like to go:");

            switch(menuOptions){
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
                        HistoricalDatas history = new HistoricalDatas();
                        history.printOneRound();
                        String oneRoundWinner = history.getFirstPlace();
                        System.out.println("\nThe winner of this round is: " + oneRoundWinner);
                        break;
                case 3: System.out.println("Showing statistics!");
                        Statistics win = new Statistics();
                        System.out.println("The " + race.car1.getName() + " wins " + winMap.get("Porsche 911").toString().replace(".0", "") + " times out of " + win.runCounter + " WinRate: " + win.winRate("Porsche 911",win.runCounter) + "%");
                        System.out.println("The " + race.car2.getName() + " wins " + winMap.get("BMW M5").toString().replace(".0", "") + " times out of " + win.runCounter + " WinRate: " + win.winRate("BMW M5",win.runCounter) + "%");
                        System.out.println("The " + race.car3.getName() + " wins " + winMap.get("Aston Martin DB 11").toString().replace(".0", "") + " times out of " + win.runCounter + " WinRate: " + win.winRate("Aston Martin DB 11",win.runCounter) + "%");
                        System.out.println("The " + race.car4.getName() + " wins " + winMap.get("Volga").toString().replace(".0", "") + " times out of " + win.runCounter + " WinRate: " + win.winRate("Volga",win.runCounter) + "%");
                        System.out.println("The " + race.car5.getName() + " wins " + winMap.get("Suzuki Swift Sport").toString().replace(".0", "") + " times out of " + win.runCounter + " WinRate: " + win.winRate("Suzuki Swift Sport",win.runCounter) + "%");
                        break;
                case 4: System.out.println("Betting and generating the race:");
                        Betting betting2 = new Betting();
                        double money = betting2.history.loadMoney("yourMoney.csv");
                        betting2.makeBet(money);
                        break;
                case 5: System.out.println("Redeeming free coupon worth of 500$");
                        double mani = betting.history.loadMoney("yourMoney.csv");
                        betting.freeMoney(mani);
                case 6: double gettingMoney = betting.history.loadMoney("yourMoney.csv");
                        System.out.println("The amount of money you have now: " + gettingMoney);
                        break;
                case 7: System.out.println("Give me a tip!");
                        float bestTip = output.solution();
                        Object name = output.getKeyFromValue(winMap,bestTip);
                        System.out.println(bestTip);
                        System.out.println("The " + name + " has the most wins,so bet this car!");
                        break;
                case 8: notQuit = false;
                        break;
            }
        }
    }
}