import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by gfitas on 30/11/15.
 */
public class UrlGetSymbol{
    private String url;
    private Logger logger;

    public UrlGetSymbol(String nom){
        this.logger = Logger.getLogger(this.getClass().getName());
        this.url = "https://s.yimg.com/aq/autoc?query=" + nom + "&region=FR&lang=fr-FR";
    }
    public List<Value> startRequest(){
        try{
            this.logger.log(Level.INFO, "Getting datas");
            URL url = new URL(this.url);
            URLConnection connection = url.openConnection();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            this.logger.log(Level.INFO, "Datas downloaded");
            StringBuilder content = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null)
            {
                content.append(line);
            }
            bufferedReader.close();
            this.logger.log(Level.INFO, "JSON parse");
            JSONObject obj = (new JSONObject(content.toString())).getJSONObject("ResultSet");
            JSONArray listOfResult = obj.getJSONArray("Result");
            List<Value> list = new ArrayList<Value>();
            for (int i = 0; i < listOfResult.length(); i++)
            {
                String symbol = listOfResult.getJSONObject(i).getString("symbol");
                String name = listOfResult.getJSONObject(i).getString("name");
                list.add(new Value(name,symbol));
            }
            return list;
        }
        catch (Exception e){
            this.logger.log(Level.SEVERE, "Erreur : "+e.getMessage());
        }
        return null;
    }
}
