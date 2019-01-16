import java.util.Scanner;


public class Main{
    
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number, where you'd like to go!");
        int menuOptions = scanner.nextInt();
        scanner.nextLine();
        int rounds = 10000;
        
        switch(menuOptions){
            case 1: System.out.println("First case: Show the best probability!");
                    for(int i = 0; i<rounds; i++){
                        HistoricalDatas history = new HistoricalDatas();
                        Statistics stat = new Statistics();
                        System.out.println(history.race.car1.toString());
                        System.out.println(history.race.car2.toString());
                        System.out.println(history.race.car3.toString());
                        System.out.println(history.race.car4.toString());
                        System.out.println(history.race.car5.toString());
                        history.generateData();
                        stat.winStatistics();
                    }
                    break;
            case 2: System.out.println("Second case: Generate data");
                    break;
        }
    }   
}