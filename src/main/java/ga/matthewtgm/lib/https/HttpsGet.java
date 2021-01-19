package ga.matthewtgm.lib.https;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpsGet {

    private String url;
    private boolean getWasSuccessful;

    public HttpsGet(String URL) {
        this.url = URL;
    }

    private int responseCode;
    private String responseCodeAsString;
    private String responseMessage;

    public String sendGet() {

        try {
            HttpURLConnection httpClient =
                    (HttpURLConnection) new URL(url).openConnection();
            httpClient.setRequestMethod("GET");
            httpClient.setRequestProperty("User-Agent", "GopineClient/b1.0");

            int responseCode = httpClient.getResponseCode();

            try (BufferedReader in = new BufferedReader(
                    new InputStreamReader(httpClient.getInputStream()))) {

                StringBuilder response = new StringBuilder();
                String line;

                while ((line = in.readLine()) != null) {
                    response.append(line);
                }

                if(httpClient.getResponseMessage() != null) {
                    this.responseMessage = httpClient.getResponseMessage();
                }
                if(httpClient.getResponseCode() != 0) {
                    this.responseCode = httpClient.getResponseCode();
                    this.responseCodeAsString = String.valueOf(httpClient.getResponseCode());
                }

                getWasSuccessful = true;
                return response.toString();

            }
        } catch(Exception e) {
            e.printStackTrace();
            getWasSuccessful = false;
            return null;
        }

    }

    public boolean wasSuccessful() {
        return getWasSuccessful;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public String getResponseCodeAsString() {
        return responseCodeAsString;
    }

}