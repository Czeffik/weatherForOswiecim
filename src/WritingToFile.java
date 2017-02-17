import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class WritingToFile {


    public WritingToFile(){
        GettingTemp nowy = new GettingTemp();
        Map<Integer, Double> now = nowy.getActualTemperature();
        Map<Integer, Double> forecast = nowy.getFutureTemperature();
        try{
            FileWriter fileToWrite = new FileWriter("writtenData.txt", true);
            BufferedWriter out = new BufferedWriter(fileToWrite);

            out.write(String.valueOf(now)+"\n");
            out.write(String.valueOf(forecast)+ "\n");
            out.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
