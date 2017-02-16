import java.util.LinkedHashMap;
import java.util.Map;

public class DoingMath {
    private Map<Map<Integer, Double>, Map<Integer, Double>> collectedData = new ReadingFile().getMapMap();
    private Map<Integer, Map<Integer, Double>> differenceBetweenForecastAndActualTemp = new LinkedHashMap<>();
    private int i;

    public Map<Integer, Map<Integer, Double>> getDifferenceBetweenForecastAndActualTemp() {
        this.doingMath();
        return differenceBetweenForecastAndActualTemp;
    }

    private void doingMath() {
        Map<Integer,Double> timeAndDifference;
        int keyToDifference;
        double valueToDifference;
        for (Map key: collectedData.keySet()){
            for(Object keyActualTemp: key.keySet()) {
                timeAndDifference = new LinkedHashMap<>();
                for (Map key1 : collectedData.keySet()) {
                    for (Object keyFutureTemp : collectedData.get(key1).keySet()) {
                        for (Object keyActualTime : key1.keySet()) {
                            i=(int)keyActualTemp;
                            if (keyActualTemp.equals(keyFutureTemp)) {

                                keyToDifference = ((int)keyActualTemp-(int)keyActualTime)/3600;
                                valueToDifference = (double)key.get(keyActualTemp) - (double)collectedData.get(key1).get(keyActualTemp);
                                timeAndDifference.put(keyToDifference,valueToDifference);

                            }
                        }
                    }
                }
                if(timeAndDifference.size()>0) {
                    differenceBetweenForecastAndActualTemp.put(i, timeAndDifference);
                }
            }
        }
        System.out.println(differenceBetweenForecastAndActualTemp);
    }
}


