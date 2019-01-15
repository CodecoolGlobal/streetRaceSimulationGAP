import java.util.Scanner;

public class Main{
    
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number, where you'd like to go!");
        int menuOptions = scanner.nextInt();
        scanner.nextLine();
        HistoricalDatas history = new HistoricalDatas();
        Race race = new Race();
        switch(menuOptions){
            case 1: System.out.println("First case: Show the best probability!");
                    System.out.println("Type: " + race.car1.getName() + " Performance: " + race.car1.getPerformance() +
                    " Driving Skill: " + race.car1.getDriverSkill() + " Is Crashed?: " + race.car1.getIsCrashed());
                    }
                    
                    break;
            case 2: System.out.println("Second case: Generate data");
                    break;
        }
    }
   
}