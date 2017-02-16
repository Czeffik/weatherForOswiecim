import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class ReadingAPI {
    private String link;
    public ReadingAPI(String link){
        this.link = link;
    }

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


