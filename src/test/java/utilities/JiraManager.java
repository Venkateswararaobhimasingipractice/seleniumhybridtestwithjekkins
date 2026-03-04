package utilities;


import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Base64;


public class JiraManager {

	    private static final String JIRA_BASE_URL = "https://venkatesh-pratice.atlassian.net";
	    private static final String EMAIL = "srinu19773@gmail.com";
	    private static final String API_TOKEN = "ATATT3xFfGF0Oa2mjSpq-PL71wKPiUrbP4nllVDynir8qNQugaxRIjfOMYNF_P8W78wdtEEUVAWtnYxef83AcLHDLD1Kcp4XIRNkLG49hzmB5OcBYjTUM4Zg2ss6QY7WCFfsAPLZzmFyPcMsvlIAtlNBI0EbgLWJbK-9qF3vuzs8oDdtW2f6Nfo=3981870B";

	    public static void moveIssueToDone(String issueKey) {

	        try {

	            String transitionId = "31";   // Done transition ID

	            URL url = new URL(JIRA_BASE_URL + "/rest/api/3/issue/" + issueKey + "/transitions");
	            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

	            conn.setRequestMethod("POST");
	            conn.setDoOutput(true);
	            conn.setRequestProperty("Content-Type", "application/json");

	            String auth = EMAIL + ":" + API_TOKEN;
	            String encodedAuth = Base64.getEncoder().encodeToString(auth.getBytes());
	            conn.setRequestProperty("Authorization", "Basic " + encodedAuth);

	            String jsonInput = "{ \"transition\": { \"id\": \"" + transitionId + "\" } }";

	            OutputStream os = conn.getOutputStream();
	            os.write(jsonInput.getBytes());
	            os.flush();
	            os.close();

	            int responseCode = conn.getResponseCode();

	            if (responseCode == 204) {
	                System.out.println("Jira issue moved to DONE successfully.");
	            } else {
	                System.out.println("Failed to move Jira issue. Response Code: " + responseCode);
	            }

	            conn.disconnect();

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	}
