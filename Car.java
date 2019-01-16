import java.util.Random;

public class Car{

    private String name;
    private int performance;
    private int driverSkill;
    private boolean isCrashed;
    private int Overall;

    Random rand = new Random();

    public Car(String name, int performance, int driverSkill, boolean isCrashed, int Overall){
        this.name = name;
        this.performance = performance;
        this.driverSkill = driverSkill;
        this.isCrashed = isCrashed;
        this.Overall = Overall;
    }

    public int chanceToCrash(){
        int chance = rand.nextInt(100) + 1;
        return chance;
    }

    public String getName(){
        return name;
    }

    public int getPerformance(){
        return performance;
    }

    public int getDriverSkill(){
        return driverSkill;
    }

    public boolean getIsCrashed(){
        return isCrashed;
    }

    public void setIsCrashed(boolean isCrashed){
        this.isCrashed = isCrashed;
    }

    public int getOverall() {
        return Overall;
    }
   
    public void setOverall(int overall) {
        this.Overall = overall;
    }


    @Override
    public String toString(){
        return "Type: " + this.getName() + " Performance: " + this.getPerformance() +
        " Driving Skill: " + this.getDriverSkill() + " Is Crashed?: " + this.getIsCrashed() + " Overall: " + this.getOverall();
    }
}   