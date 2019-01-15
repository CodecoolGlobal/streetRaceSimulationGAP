import java.util.Random;

public class Race{
    
    Random rand = new Random();
    Result result = new Result(1, "Porsche");

    Car car1 = new Car("Porsche 911", rand.nextInt(50) + 1, rand.nextInt(10) + 1, false);
    Car car2 = new Car("BMW M5",rand.nextInt(50) + 1, rand.nextInt(10) + 1, false);
    Car car3 = new Car("Aston Martin DB 11",rand.nextInt(50) + 1, rand.nextInt(10) + 1, false);
    Car car4 = new Car("Volga",rand.nextInt(50) + 1, rand.nextInt(10) + 1, false);
    Car car5 = new Car("Suzuki Swift Sport",rand.nextInt(50) + 1, rand.nextInt(10) + 1, false);
    
    
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
    }

}