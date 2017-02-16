import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class GettingTemp {
    private String linkFuture = "http://api.openweathermap.org/data/2.5/forecast?q=Oswiecim,pol&APPID=71ad073f87383bd799851e6388bfcc8a";
    private String linkNow = "http://api.openweathermap.org/data/2.5/weather?q=Oswiecim,pol&APPID=71ad073f87383bd799851e6388bfcc8a";

    private String apiNow = (new ReadingAPI(linkNow)).reading();
    private String apiFuture = (new ReadingAPI(linkFuture)).reading();

    private Map<Integer, Double> actualTemperature=new HashMap<>();
    private Map<Integer, Double> futureTemperature = new LinkedHashMap<>();

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
                key = key-(key%600);
            }
        }
        actualTemperature.put(key,value);
    }

    private void gettingFutureTemperature(){
        String[] arrayToList = apiFuture.split("\"list\":\\[\\{");
        String[] arrayCutingByDt = arrayToList[1].split("\"dt\":");
        int key=0;
        double value;
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
