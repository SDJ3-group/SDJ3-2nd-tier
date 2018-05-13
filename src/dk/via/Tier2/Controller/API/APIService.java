package dk.via.Tier2.Controller.API;

import dk.via.Tier2.Model.BaseModel;
import dk.via.Tier2.Model.SmallModels;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public abstract class APIService {

    OkHttpClient client = new OkHttpClient();
    Request request;

    APIService() {
        client = new OkHttpClient();
    }

    void deleteObject(String type, BaseModel object) {
        String url = SmallModels.BASE_URL + type + object.getId();
        try {
            request = new Request.Builder()
                    .url(url)
                    .delete()
                    .build();

            Response response = client.newCall(request).execute();
            System.out.println(response.body().string());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
