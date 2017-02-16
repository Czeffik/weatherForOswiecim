import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class WritingToFile {

    public WritingToFile(){
        int i=0;
        GettingTemp nowy = new GettingTemp();
        Map<Integer, Double> now = nowy.getActualTemperature();
        Map<Integer, Double> forecast = nowy.getFutureTemperature();
        try{
            while(i<10){
                FileWriter fileToWrite = new FileWriter("data.txt", true);
                BufferedWriter out = new BufferedWriter(fileToWrite);

                out.write(String.valueOf(now)+"\n");
                out.write(String.valueOf(forecast)+ "\n");
                out.close();
                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
