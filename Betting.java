import java.util.Scanner;
import java.util.Arrays;

public class Betting{
    Scanner scanner = new Scanner(System.in);
    HistoricalDatas history = new HistoricalDatas();
    AnotherRace race = new AnotherRace(); 
    
    private double yourMoney;
    private double bettedAmount;
    private double wonAmount;
    private String bettedCar;

    public void makeBet(double yourMoney){
        System.out.println("\nYou have " + yourMoney + "$ to bet! Choose the car you want to bet on, then the amount you want to bet with!");
        System.out.println(race.car1.getName() + "             Odds: " + race.car1.getOdds());
        System.out.println(race.car2.getName() + "                  Odds: " + race.car2.getOdds());
        System.out.println(race.car3.getName() + "      Odds: " + race.car3.getOdds());
        System.out.println(race.car4.getName() + "                   Odds: " + race.car4.getOdds());
        System.out.println(race.car5.getName() + "      Odds: " + race.car5.getOdds());
        System.out.print("\nType the car, you'd like to bet on: ");
        bettedCar = scanner.nextLine();
        System.out.print("\nType the amount, you'd like to bet: ");
        bettedAmount = scanner.nextDouble();
        scanner.nextLine();
        yourMoney = history.loadMoney("yourMoney.csv");
        Result winner = getFirstPlaceForBet();
        if(yourMoney > 0){
            if(bettedCar.equals(winner.getFirst())){
                wonAmount = bettedAmount * winner.getSecond();
                yourMoney += wonAmount;
                race.printOneRound();
                getFirstPlaceForBet().getFirst();
                System.out.println("\nYou won! The amount of money you have now is: " + yourMoney);
                history.saveMoney(yourMoney);
            }else{
                yourMoney -= bettedAmount;
                race.printOneRound();
                getFirstPlaceForBet().getFirst();
                System.out.println("\nYou lost! The amount of money you have now is: " + yourMoney);
                history.saveMoney(yourMoney);
            }
        }else{
            System.out.println("You don't have enough money to bet!");
        }
    }

    public Result getFirstPlaceForBet(){
        String firstPlace;
        double winnersodd;


        int[] intArray = {(int)race.car1.getOverall(),(int)race.car2.getOverall(),(int)race.car3.getOverall(),
            (int)race.car4.getOverall(),(int)race.car5.getOverall()};
        Arrays.sort(intArray);
        for(int i = 4; i < intArray.length; i++){
            if((int)race.car1.getOverall() == intArray[i]){
                firstPlace = race.car1.getName();
                winnersodd = race.car1.getOdds();
                Result winners = new Result(firstPlace, winnersodd);
                return winners;
            }else if ((int)race.car2.getOverall() == intArray[i]){
                firstPlace = race.car2.getName();
                winnersodd = race.car2.getOdds();
                Result winners = new Result(firstPlace, winnersodd);
                return winners;
            } else if ((int)race.car3.getOverall() == intArray[i]){
                firstPlace = race.car3.getName();
                winnersodd = race.car3.getOdds();
                Result winners = new Result(firstPlace, winnersodd);
                return winners;
            } else if ((int)race.car4.getOverall() == intArray[i]){
                firstPlace = race.car4.getName();
                winnersodd = race.car4.getOdds();
                Result winners = new Result(firstPlace, winnersodd);
                return winners;
            } else if ((int)race.car5.getOverall() == intArray[i]){
                firstPlace = race.car5.getName();
                winnersodd = race.car5.getOdds();
                Result winners = new Result(firstPlace, winnersodd);
                return winners;
            }
        }
        return null;
    }

    public void setMoney(double yourMoney){
        this.yourMoney = yourMoney;
    }

    public double getMoney(){
        return yourMoney;
    }

    public void addMoney(){
        this.yourMoney += wonAmount;
    }

    public void reduceMoney(){
        this.yourMoney -= bettedAmount;
    }

    public void freeMoney(double mani){
        mani += 500;
        history.saveMoney(mani);
    }
}
