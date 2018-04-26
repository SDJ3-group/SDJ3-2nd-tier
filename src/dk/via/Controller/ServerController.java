package dk.via.Controller;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class ServerController {

    private OkHttpClient client;
    private String baseURL = "https://jsonplaceholder.typicode.com/posts";


    public ServerController() {
        client = new OkHttpClient();
    }


    public String run(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();

        Response response = client.newCall(request).execute();
        return response.body().string();
    }
}
