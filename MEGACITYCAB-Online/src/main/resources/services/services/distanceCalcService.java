package services;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;

public class distanceCalcService {
    private static final String API_KEY = "AIzaSyBxcPPVZ60I81VDu48tlVCkOnd2lfoDlaI";
    private static final String BASE_URL = "https://maps.googleapis.com/maps/api/distancematrix/json";

    public static String getDistance(String origin, String destination) throws Exception {
        OkHttpClient client = new OkHttpClient();

        String url = BASE_URL + "?origins=" + origin + "&destinations=" + destination + "&key=" + API_KEY;
        System.out.println(url);
        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
            return response.body().string();
        }
    }
    
    public static String parseDistance(String jsonResponse) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode rootNode = mapper.readTree(jsonResponse);
        JsonNode rowsNode = rootNode.path("rows");
        JsonNode elementsNode = rowsNode.get(0).path("elements");
        JsonNode distanceNode = elementsNode.get(0).path("distance");
        return distanceNode.path("text").asText();
    }
}
