import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.Writer;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;


public class HistoricalDatas{
    Race race = new Race();
    
    public String getFirstPlace(){
        String firstPlace = "";
        int[] intArray = {(int)race.car1.getOverall(),(int)race.car2.getOverall(),(int)race.car3.getOverall(),
            (int)race.car4.getOverall(),(int)race.car5.getOverall()};
        Arrays.sort(intArray);
        for(int i = 4; i < intArray.length; i++){
            if((int)race.car1.getOverall() == intArray[i]){
                firstPlace = race.car1.getName();
                return firstPlace;
            }else if ((int)race.car2.getOverall() == intArray[i]){
                firstPlace = race.car2.getName();
                return firstPlace;
            } else if ((int)race.car3.getOverall() == intArray[i]){
                firstPlace = race.car3.getName();
                return firstPlace;
            } else if ((int)race.car4.getOverall() == intArray[i]){
                firstPlace = race.car4.getName();
                return firstPlace;
            } else if ((int)race.car5.getOverall() == intArray[i]){
                firstPlace = race.car5.getName();
                return firstPlace;
            }
        }
        return null;
    }

    public int[] generateData(){
        int[] intArray = {(int)race.car1.getOverall(),(int)race.car2.getOverall(),(int)race.car3.getOverall(),
            (int)race.car4.getOverall(),(int)race.car5.getOverall()};
        Arrays.sort(intArray);
        try(FileWriter fw = new FileWriter("HistoricalData.csv", true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw))
        {
            //out.println(intArray[4]);
            out.println(getFirstPlace());
        } catch (IOException e) {
            //exception handling left as an exercise for the reader
        }

        
        return intArray;

        //PrintWriter pw = new PrintWriter(new File("HistoricalData.csv"));
        //StringBuilder sb = new StringBuilder();
       // for(int i = 0; i<placementStrings.length; i++){
         //   sb.append(placementStrings[i]);
       // }
      //  pw.write(sb.toString());
       // pw.close();
        
    }

    public String[] loadData(){
        String csvFile = "HistoricalData.csv";
        String line = "";
        String cvsSplitBy = ",";
        String[] historicalData = {""};

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            while ((line = br.readLine()) != null) {

                // use comma as separator
                historicalData = line.split(cvsSplitBy);

            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        return historicalData;
    }

    public void printOneRound(){
        System.out.println(race.car1.toString());
        System.out.println(race.car2.toString());
        System.out.println(race.car3.toString());
        System.out.println(race.car4.toString());
        System.out.println(race.car5.toString());
    }

}