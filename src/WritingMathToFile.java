import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class WritingMathToFile {
    public WritingMathToFile(){
        Map<Integer, Map<Integer, Double>> mathDone = new DoingMath().getDifferenceBetweenForecastAndActualTemp();
        try{
            FileWriter fileToWrite = new FileWriter("writtenMathData.txt");
            BufferedWriter out = new BufferedWriter(fileToWrite);

            for(int mathDoneKey: mathDone.keySet()){
                java.util.Date time = new java.util.Date((long)mathDoneKey*1000);
                out.write(time.toString()+" results: \n");
                for(int mathResultsKey: mathDone.get(mathDoneKey).keySet()){

                    out.write(mathResultsKey +" hour forecast : difference between temperature: " + mathDone.get(mathDoneKey).get(mathResultsKey)+" |");
                }
               out.write("\n");
            }
            out.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
