package utilities;


import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Base64;

public class TestRailManager {

    static String BASE_URL = "https://venkatauto.testrail.io";
    static String USER = "srinu515880@gmail.com";
    static String API_KEY = "9RCXVFBFwkZdJxGzOnvb-TzlT4TFaEiErXpudz.5u";
    static String RUN_ID = System.getenv("RUN_ID"); // Jenkins will pass this

    public static void updateResult(String caseId, int statusId) {
        try {
            String endpoint = BASE_URL + "/index.php?/api/v2/add_result_for_case/"
                    + RUN_ID + "/" + caseId;

            URL url = new URL(endpoint);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setDoOutput(true);

            String auth = USER + ":" + API_KEY;
            String encodedAuth = Base64.getEncoder().encodeToString(auth.getBytes());
            conn.setRequestProperty("Authorization", "Basic " + encodedAuth);
            conn.setRequestProperty("Content-Type", "application/json");

            String payload = "{\"status_id\":" + statusId + "}";

            OutputStream os = conn.getOutputStream();
            os.write(payload.getBytes());
            os.flush();
            os.close();

            conn.getResponseCode();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
