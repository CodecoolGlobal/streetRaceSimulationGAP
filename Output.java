import java.util.HashMap;

public class Output{

    Statistics win = new Statistics();
    HashMap winMap = win.winStatistics();
    float[] floatArray = {(float)winMap.get("Porsche 911"),(float)winMap.get("BMW M5"),(float)winMap.get("Aston Martin DB 11"),
    (float)winMap.get("Volga"),(float)winMap.get("Suzuki Swift Sport")};
    float max = 0.0f;
    public float solution(){
        for(int i = 0; i < floatArray.length; i++){
            if(floatArray[i] > max){
                max = floatArray[i];
            }
        }
        return max;
    }
    public Object getKeyFromValue(HashMap winMap, float value) {
        for (Object name : winMap.keySet()) {
          if (winMap.get(name).equals(value)) {
            return name;
          }
        }
        return null;
    }
}
