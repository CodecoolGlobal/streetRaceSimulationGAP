public class Car{

    private String name;
    private int performance;
    private int driverSkill;
    private boolean isCrashed;
    //private int chanceToCrash;

    public Car(String name, int performance, int driverSkill, boolean isCrashed){
        this.name = name;
        this.performance = performance;
        this.driverSkill = driverSkill;
        this.isCrashed = false;
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
}