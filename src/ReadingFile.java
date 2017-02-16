import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class ReadingFile {
    private Map<Map<Integer, Double>, Map<Integer, Double>> mapMap = new LinkedHashMap<>();

    public Map<Map<Integer, Double>, Map<Integer, Double>> getMapMap() {
        this.readingFile();
        return mapMap;
    }

    private void readingFile(){
        try{
            FileReader czytak = new FileReader("temp1.txt");
            BufferedReader br = new BufferedReader(czytak);

            String line;

            Map<Integer,Double> futureValueMap= new LinkedHashMap<Integer,Double>();
            Map<Integer,Double> actualValueMap= new LinkedHashMap<Integer,Double>();

            LinkedHashMap<Integer,Double> keyMap;
            LinkedHashMap<Integer,Double> valueMap;

            while((line = br.readLine())!=null){
                line = line.replace("{","").replace("}","").replace(" ","");

                if(! line.contains(",")){

                        String[] actualArray1 = line.split("=");
                        int key = Integer.parseInt(actualArray1[0]);
                        double value = Double.parseDouble(actualArray1[1]);
                        actualValueMap.put(key,value);

                }
                else{

                    String [] futureArray = line.split(",");

                    for(String element: futureArray){
                        String[] futureArray2 = element.split("=");
                        int key = Integer.parseInt(futureArray2[0]);
                        double value = Double.parseDouble(futureArray2[1]);
                        futureValueMap.put(key, value);
                    }

                    mapMap.put(actualValueMap, futureValueMap);

                    actualValueMap=new LinkedHashMap<>();
                    futureValueMap=new LinkedHashMap<>();
                }

            }
//            System.out.println(mapMap);

            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
