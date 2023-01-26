import org.json.JSONArray;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CreateJson {
    public static String createMap(String resultMap) throws Exception {
        Document doc = Jsoup.connect("https://skillbox-java.github.io/").get();

        JSONObject objParent = new JSONObject();
        JSONObject list = new JSONObject();
        JSONArray nameLines = new JSONArray();

        for (Element lines : doc.select(".js-depend")) {
            String line = lines.attr("data-depend-set").substring(6);
            String lineName = doc.getElementsByAttributeValue("data-line", line).get(0).text();

            JSONArray stations = new JSONArray();
            for (Element station : lines.select(".single-station")) {
                stations.put(station.text());
            }
            JSONObject linesInfo = new JSONObject();
            linesInfo.put("number", line);
            linesInfo.put("name", lineName);
            nameLines.put(linesInfo);
            list.put(lineName, stations);
        }

        objParent.put("stations",list);
        objParent.put("lines", nameLines);
        Files.write(Paths.get(resultMap), objParent.toString().getBytes(StandardCharsets.UTF_8));
        return objParent.toString();
    }

    public static String createStation (String resultStation) throws IOException {
        Document doc = Jsoup.connect("https://skillbox-java.github.io/").get();

        JSONObject mainObj = new JSONObject();
        JSONArray station = new JSONArray();

        for (Element stations : doc.select("span.js-metro-line.t-metrostation-list-header.t-icon-metroln")) {
            for (Element name : doc.select("p.single-station")) {
                String Line = stations.text();
                String Name = name.text();
                String connection = String.valueOf(name);

                Boolean connect = false;
                if (connection.contains("t-icon-metroln")) {
                    connect = true;
                }

                JSONObject linesInfo = new JSONObject();
                linesInfo.put("name", Name);
                linesInfo.put("line", Line);
                linesInfo.put("hasConnection", connect);
                station.put(linesInfo);
            }
        }

        mainObj.put("stations", station);

        Files.write(Paths.get(resultStation), mainObj.toString().getBytes(StandardCharsets.UTF_8));
        return resultStation;
    }
}
