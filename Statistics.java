import java.util.HashMap;

public class Statistics{

    HistoricalDatas history = new HistoricalDatas();
    String[] loaded = history.loadData("HistoricalData.csv");
    int runCounter = loaded.length;

    public HashMap winStatistics(){
        HashMap<String,Integer> winingMap = new HashMap<String,Integer>();
        winingMap.put("Porsche 911",0);
        winingMap.put("BMW M5",0);
        winingMap.put("Aston Martin DB 11",0);
        winingMap.put("Volga",0);
        winingMap.put("Suzuki Swift Sport",0);
        for(int i = 0; i < runCounter; i++){
            if(winingMap.containsKey(loaded[i])){
                winingMap.put(loaded[i], winingMap.get(loaded[i]) + 1);
            }
        }
        return winingMap;
    }
}
    