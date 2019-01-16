import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;

public class HistoricalDatas{
    Race race = new Race();
    
    public String generateData(){
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
    
    public String saveData(int round){
        String generated ="";
        try{
            PrintWriter pw = new PrintWriter(new File("HistoricalData.csv"));
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < round; i++){
                generated = generateData();
                sb.append(generated);
                sb.append("\n");
            }
            pw.write(sb.toString());
            pw.close();
            return generated;
        } 
        catch(FileNotFoundException e) {
            System.out.println("Error:" + e);
        }
        
        return null;
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