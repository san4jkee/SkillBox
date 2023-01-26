import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.apache.commons.io.FileUtils;

import javax.swing.text.Document;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        CloseableHttpClient httpclient = HttpClients.createDefault();

        HttpGet httpget = new HttpGet("https://lenta.ru");
        CloseableHttpResponse response = httpclient.execute(httpget);
        HttpEntity entity = response.getEntity();
        String content = EntityUtils.toString(entity, "utf-8");

        Document doc = Jsoup.parse(content);
        Elements img = doc.select("img");

        for (int i = 0; i < img.size(); i++){
            Element element = img.get(i);
            String url = element.attr("src");

            try {
                HttpGet PicturehttpGet = new HttpGet(url);
                CloseableHttpResponse pictureResponse = httpclient.execute(PicturehttpGet);
                HttpEntity pictureEntity = pictureResponse.getEntity();
                InputStream inputStream = pictureEntity.getContent();
                FileUtils.copyToFile(inputStream, new File("C://Skillbox//images//" + i + ".jpg"));
                pictureResponse.close();
            }
            catch (ClientProtocolException cl){
                cl.getMessage();
            }


        }
        response.close();
        httpclient.close();
    }
}
