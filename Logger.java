import java.util.Date;
import java.text.SimpleDateFormat;

public class Logger{

    //Constructor
    // public Logger (String type, String errorMessage){
    //     this.type = type;
    //     this.errorMessage = errorMessage;
    // }

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
}