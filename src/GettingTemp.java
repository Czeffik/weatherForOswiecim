import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class GettingTemp {
    private String apiNow = (new ReadingAPIWeatherNow()).reading();
    private String apiFuture = (new ReadingAPI()).reading();
    private LinkedList<String> listOfWords = new LinkedList<>();
    private Map<Integer, Double> actualTemperature=new HashMap<>();
    private Map<Integer, Double> futureTemperature = new HashMap<>();

    public Map<Integer, Double> getActualTemperature() {
        this.gettingActualTemperature();
        return actualTemperature;
    }

    public Map<Integer, Double> getFutureTemperature() {
        this.gettingFutureTemperature();
        return futureTemperature;
    }

    private void gettingActualTemperature(){
        String[] arraySplitedByCommaNow = apiNow.split(",");
        double value=0;
        int key = 0;
        for(String sth:arraySplitedByCommaNow){
            if(sth.contains("\"temp\"")){
                String [] arrayContainsTemp = sth.split(":");
                value = Double.parseDouble(arrayContainsTemp[2]);
            }
            if(sth.contains("\"dt\":")){
                String [] arrayContainsDt = sth.split(":");
                key = Integer.parseInt(arrayContainsDt[1]);
            }
        }
        actualTemperature.put(key,value);

    }

    private void gettingFutureTemperature(){
        String[] arrayToList = apiFuture.split("\"list\":\\[\\{");
        String[] arrayCutingByDt = arrayToList[1].split("\"dt\":");
        int key=0;
        double value = 0;
        for (String sth : arrayCutingByDt){
            String[] arrayCutingByComma = sth.split(",");
            if(arrayCutingByComma[0].length()>0) {
                key = Integer.parseInt(arrayCutingByComma[0]);
            }
            for(String something:arrayCutingByComma){
                if (something.contains("\"temp\"")){
                    String[] arrayCutingByColon = something.split(":");

                    value = Double.parseDouble(arrayCutingByColon[2]);
                    futureTemperature.put(key, value);
                }

            }
        }


    }





}
