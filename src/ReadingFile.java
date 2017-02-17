import javafx.util.Pair;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class ReadingFile {
    private Map<Pair<Integer, Double>, Map<Integer, Double>> mapMap;

    public Map<Pair<Integer, Double>, Map<Integer, Double>> getMapMap() {
        return mapMap;
    }

    public ReadingFile(){
        WritingToFile makingFile = new WritingToFile();
        mapMap = new LinkedHashMap<>();
        try{
            FileReader czytak = new FileReader("writtenData.txt");
            BufferedReader br = new BufferedReader(czytak);

            String line;

            Map<Integer,Double> futureValueMap= new LinkedHashMap<Integer,Double>();
            Pair<Integer,Double> actualValuePair = null;

            while((line = br.readLine())!=null){
                line = line.replace("{","").replace("}","").replace(" ","");

                if(! line.contains(",")){
                        String[] actualArray1 = line.split("=");
                        int key = Integer.parseInt(actualArray1[0]);
                        double value = Double.parseDouble(actualArray1[1]);
                        actualValuePair = new Pair<>(key, value);
                }
                else{
                    String [] futureArray = line.split(",");

                    for(String element: futureArray){
                        String[] futureArray2 = element.split("=");
                        int key = Integer.parseInt(futureArray2[0]);
                        double value = Double.parseDouble(futureArray2[1]);
                        futureValueMap.put(key, value);
                    }
                    mapMap.put(actualValuePair, futureValueMap);
                    futureValueMap=new LinkedHashMap<>();
                }
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
