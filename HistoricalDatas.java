import java.io.*;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.Writer;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;


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
            out.println(getFirstPlace());
        } catch (IOException e) {
            //exception handling left as an exercise for the reader
        }

        
        return intArray;

    }
    public  int rowCounter(String fileName) {
        String csvName = fileName;
        int i = 0;//line count of csv
        try {
            File file = new File(csvName);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()) {
                    ++i;
                    scanner.nextLine();
            }
        scanner.close();
        return i;
        }catch(FileNotFoundException e) {
            return 0;
        }
        
    }

    public String[] loadData(String fileName) {
        int i = rowCounter(fileName);
        String csvFile = fileName;
        String[] dataArray = new String[i];
        
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            for(int n = 0;n < i;n++){
                String line = br.readLine();
                    dataArray[n] = line; 
            }
            return dataArray;
        } catch (Exception e) {
            return dataArray;
        }
    }

    public void printOneRound(){
        System.out.println(race.car1.toString());
        System.out.println(race.car2.toString());
        System.out.println(race.car3.toString());
        System.out.println(race.car4.toString());
        System.out.println(race.car5.toString());
    }
    
    public void saveMoney(double yourMoney){
        try(FileWriter fw = new FileWriter("yourMoney.csv");
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw))
        {
            out.println(yourMoney);
        } catch (IOException e) {
            //exception handling left as an exercise for the reader
        }
    }

    public double loadMoney(String fileName) {
        int i = rowCounter(fileName);
        String csvFile = fileName;
        String[] dataArray = new String[i];
        
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            String line = br.readLine();
            return Double.parseDouble(line);
        } catch (Exception e) {

        }
        return 0.0;
    }
}