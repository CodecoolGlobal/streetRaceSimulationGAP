import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class HistoricalDatas{
    
    public void generateData(){
        try{
        String[] placementStrings = {"1", "2", "3", "4"};
        PrintWriter pw = new PrintWriter(new File("HistoricalData.csv"));
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<placementStrings.length; i++){
            sb.append(placementStrings[i]);
        }
        pw.write(sb.toString());
        pw.close();
        }catch(FileNotFoundException e){
            System.out.println("File not found");
        }
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