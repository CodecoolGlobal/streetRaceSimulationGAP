import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class HistoricalDatas{
    Race race = new Race();
    
    public String[] generateData(){
        int[] intArray = {(int)race.car1.getOverall(),(int)race.car2.getOverall(),(int)race.car3.getOverall(),
            (int)race.car4.getOverall(),(int)race.car5.getOverall()};
        Arrays.sort(intArray);
        
        String[] stringArray = (String)intArray;
        
        return intArray;

        //PrintWriter pw = new PrintWriter(new File("HistoricalData.csv"));
        //StringBuilder sb = new StringBuilder();
       // for(int i = 0; i<placementStrings.length; i++){
         //   sb.append(placementStrings[i]);
       // }
      //  pw.write(sb.toString());
       // pw.close();
        
    }

    public void loadData(){
        String csvFile = "HistoricalData.csv";
        String line = "";
        String cvsSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] country = line.split(cvsSplitBy);

                for(int i = 0; i<country.length; i++){
                    System.out.println(country[i]);
                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}