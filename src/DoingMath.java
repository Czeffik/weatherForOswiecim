import javafx.util.Pair;

import java.util.LinkedHashMap;
import java.util.Map;

public class DoingMath {
    private Map<Integer, Map<Integer, Double>> differenceBetweenForecastAndActualTemp = new LinkedHashMap<>();

    public Map<Integer, Map<Integer, Double>> getDifferenceBetweenForecastAndActualTemp() {
        return differenceBetweenForecastAndActualTemp;
    }

    public DoingMath() {
        Map<Pair<Integer, Double>, Map<Integer, Double>> collectedData = new ReadingFile().getMapMap();
        Map<Integer, Double> timeAndDifference;

        int i = 0;
        int keyToDifference;
        double valueToDifference;

        for (Pair actualValuePair : collectedData.keySet()) {
            timeAndDifference = new LinkedHashMap<>();
            for (Pair actualOtherValuePair : collectedData.keySet()) {
                for (int futureValueMapKey : collectedData.get(actualOtherValuePair).keySet()) {
                    i = (int) actualValuePair.getKey();
                    if (i == futureValueMapKey) {
                        keyToDifference = (i - (int)actualOtherValuePair.getKey() ) / 3600;
                        valueToDifference = (double) actualValuePair.getValue() - collectedData.get(actualOtherValuePair).get(futureValueMapKey);
                        timeAndDifference.put(keyToDifference, valueToDifference);

                    }
                }
                if (timeAndDifference.size() > 0) {
                    differenceBetweenForecastAndActualTemp.put(i, timeAndDifference);
                }
            }
        }
//        System.out.println(differenceBetweenForecastAndActualTemp);
    }
}


