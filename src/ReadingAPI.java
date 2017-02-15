import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class ReadingAPI {
    private String link = "http://api.openweathermap.org/data/2.5/forecast?q=Oswiecim,pol&APPID=71ad073f87383bd799851e6388bfcc8a";

    public String reading() {
        StringBuilder sb = new StringBuilder();
        try{
            URL url = new URL(link);

        BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
        String line;
        while ((line = br.readLine()) != null) {
            sb.append(line);
        }
        br.close();}
        catch(Exception e){
            e.printStackTrace();
        }
        return sb.toString();

    }
}


