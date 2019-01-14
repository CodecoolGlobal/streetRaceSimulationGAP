public class Logger{

    //Constructor
    // public Logger (String type, String errorMessage){
    //     this.type = type;
    //     this.errorMessage = errorMessage;
    // }

    //Methods
    public void log(String type, String errorMessage){
        Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM.dd @ T");

        System.out.println(dateFormat.format(currentDate) + "\t" + type + "\t" + errorMessage);
    }
}