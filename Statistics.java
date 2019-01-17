import java.util.HashMap;

public class Statistics{

    HistoricalDatas history = new HistoricalDatas();
    String[] loaded = history.loadData("HistoricalData.csv");
    int runCounter = loaded.length;
    

    public HashMap<String,Float> winStatistics(){
        HashMap<String,Float> winingMap = new HashMap<String,Float>();
        winingMap.put("Porsche 911",0.0f);
        winingMap.put("BMW M5",0.0f);
        winingMap.put("Aston Martin DB 11",0.0f);
        winingMap.put("Volga",0.0f);
        winingMap.put("Suzuki Swift Sport",0.0f);
        for(int i = 0; i < runCounter; i++){
            if(winingMap.containsKey(loaded[i])){
                winingMap.put(loaded[i], winingMap.get(loaded[i]) + 1);
            }
        }
        return winingMap;
    }
    public String winRate(String carType, int runCounter){
        HashMap winMap = winStatistics();
        float win = (float)winMap.get(carType);
        float run = runCounter;
        float pWinRate = (win / run) * 100;
        String pRate = String.format("%.2f", pWinRate);
        return pRate;
    }
}
    