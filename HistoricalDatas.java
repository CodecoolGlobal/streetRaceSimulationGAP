import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.Writer;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.io.FileWriter;
import java.lang.Object;
import java.io.BufferedWriter;
import java.io.FileReader;


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

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] historicalData = line.split(cvsSplitBy);

                for(int i = 0; i<historicalData.length; i++){
                    System.out.println(historicalData[i]);
                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return historicalData;
    }

}