package ga.matthewtgm.lib.https;

import ga.matthewtgm.lib.Constants;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.StringJoiner;

public class HttpsPost {

    private final HttpURLConnection http;
    private final String URL;
    private String JSONContent;
    private Map<String, String> params;
    private boolean postWasSuccessful;
    private int responseCode;
    private String responseCodeAsString;
    private String responseMessage;

    public HttpsPost(String URL) {
        this.URL = URL;
        this.http = (HttpURLConnection) connection(url(URL));
    }

    public HttpsPost(String URL, String JSONContent, Map<String, String> params) {
        this.URL = URL;
        this.http = (HttpURLConnection) connection(url(URL));
        this.JSONContent = JSONContent;
        this.params = params;
    }

    public URL url(String url) {
        try {
            return new URL(url);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private URLConnection connection(URL url) {
        try {
            return url(URL).openConnection();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void makePost() {
        try {
            assert http != null;
            http.setRequestMethod("POST");
            http.setDoOutput(true);
            if (params != null) {
                StringJoiner sj = new StringJoiner("&");
                for (Map.Entry<String, String> entry : params.entrySet()) {
                    sj.add(URLEncoder.encode(entry.getKey(), "UTF-8") + "=" + URLEncoder.encode(entry.getValue(), "UTF-8"));
                }
            }
            byte[] out = JSONContent.getBytes(StandardCharsets.UTF_8);
            int length = out.length;
            http.setFixedLengthStreamingMode(length);
            http.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            http.setRequestProperty("User-Agent", Constants.NAME + "/" + Constants.ID);
            http.setConnectTimeout(5000);
            http.connect();
            try (OutputStream os = http.getOutputStream()) {
                os.write(out);
            }
            if (http.getResponseMessage() != null && !http.getResponseMessage().isEmpty()) {
                this.responseMessage = http.getResponseMessage();
            }
            if (http.getResponseCode() != 0) {
                this.responseCode = http.getResponseCode();
                this.responseCodeAsString = String.valueOf(http.getResponseCode());
            }
            postWasSuccessful = true;
        } catch (Exception e) {
            e.printStackTrace();
            postWasSuccessful = false;
        }
    }

    public void makePost(String JSONContent) {
        try {
            assert http != null;
            http.setRequestMethod("POST");
            http.setDoOutput(true);
            if (params != null) {
                StringJoiner sj = new StringJoiner("&");
                for (Map.Entry<String, String> entry : params.entrySet()) {
                    sj.add(URLEncoder.encode(entry.getKey(), "UTF-8") + "=" + URLEncoder.encode(entry.getValue(), "UTF-8"));
                }
            }
            byte[] out = JSONContent.getBytes(StandardCharsets.UTF_8);
            int length = out.length;
            http.setFixedLengthStreamingMode(length);
            http.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            http.setConnectTimeout(5000);
            http.connect();
            try (OutputStream os = http.getOutputStream()) {
                os.write(out);
            }
            if (http.getResponseMessage() != null && !http.getResponseMessage().isEmpty()) {
                this.responseMessage = http.getResponseMessage();
            }
            if (http.getResponseCode() != 0) {
                this.responseCode = http.getResponseCode();
                this.responseCodeAsString = String.valueOf(http.getResponseCode());
            }
            postWasSuccessful = true;
        } catch (Exception e) {
            e.printStackTrace();
            postWasSuccessful = false;
        }
    }

    public void addRequestProperty(String key, String value) {
        http.addRequestProperty(key, value);
    }

    public String getURL() {
        return URL;
    }

    public boolean wasSuccessful() {
        return postWasSuccessful;
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