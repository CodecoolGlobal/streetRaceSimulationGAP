import java.util.Random;

public class AnotherRace{

    Random rand = new Random();
    Car car1 = new Car("Porsche 911", rand.nextInt(50) + 23, rand.nextInt(10) + 1, false,0, 1.7);
    Car car2 = new Car("BMW M5",rand.nextInt(50) + 25, rand.nextInt(10) + 1, false,0, 1.5);
    Car car3 = new Car("Aston Martin DB 11",rand.nextInt(50) + 25, rand.nextInt(10) + 1, false,0, 1.5);
    Car car4 = new Car("Volga",rand.nextInt(50) + 5, rand.nextInt(10) + 1, false,0, 5);
    Car car5 = new Car("Suzuki Swift Sport",rand.nextInt(50) + 10, rand.nextInt(10) + 1, false,0, 4);
    
    {
    if(car1.getPerformance() >= 40 && car1.chanceToCrash() > 80){
        car1.setIsCrashed(true);
    }else if(car2.getPerformance() >= 40 && car2.chanceToCrash() > 80){
        car2.setIsCrashed(true);
    }else if(car3.getPerformance() >= 40 && car3.chanceToCrash() > 80){
        car3.setIsCrashed(true);
    }else if(car4.getPerformance() >= 40 && car4.chanceToCrash() > 80){
        car4.setIsCrashed(true);
    }else if(car5.getPerformance() >= 40 && car5.chanceToCrash() > 80){
        car5.setIsCrashed(true);
    }
    
        car1.setOverall(car1.getPerformance() + car1.getDriverSkill());
        car2.setOverall(car2.getPerformance() + car2.getDriverSkill());
        car3.setOverall(car3.getPerformance() + car3.getDriverSkill());
        car4.setOverall(car4.getPerformance() + car4.getDriverSkill());
        car5.setOverall(car5.getPerformance() + car5.getDriverSkill());
    }
    public void printOneRound(){
        System.out.println(car1.toString());
        System.out.println(car2.toString());
        System.out.println(car3.toString());
        System.out.println(car4.toString());
        System.out.println(car5.toString());
    }
}