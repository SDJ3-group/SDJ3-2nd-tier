package dk.via.Tier2.Controller.API;

import com.google.gson.Gson;
import dk.via.Tier2.Model.Part;
import dk.via.Tier2.Model.SmallModels;
import okhttp3.FormBody;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import java.io.IOException;

public class PartsAPIService extends APIService {

    // GET  api/Parts
    public Part[] getAllParts() {
        Part[] parts = null;

        try {
            String url = SmallModels.BASE_URL + "Parts";

            request = new Request.Builder().url(url).build();

            Response responses = null;

            try {
                responses = client.newCall(request).execute();
            } catch (IOException e) {
                e.printStackTrace();
            }

            String jsonData = responses.body().string();

            Gson gson = new Gson();
            gson.toJson(jsonData);

            parts = gson.fromJson(jsonData, Part[].class);

            for (Part part : parts) {
                System.out.println(part.getName());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return parts;
    }

    // GET api/Parts/{id}
    public Part getPart(int id) {
        Part part = null;
        try {
            String url = SmallModels.BASE_URL + "Parts/" + id;
            request = new Request.Builder().url(url).build();
            Response responses = null;

            try {
                responses = client.newCall(request).execute();
            } catch (IOException e) {
                e.printStackTrace();
            }

            String jsonData = responses.body().string();
            Gson gson = new Gson();
            gson.toJson(jsonData);
            part = gson.fromJson(jsonData, Part[].class)[0];
            part.toString();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return part;
    }

    // PUT api/Parts/{id}
    public void updatePart(Part part) {
        //TODO dalsie parametre
        String url = SmallModels.BASE_URL + "Parts/" + part.getId();
        try {
            RequestBody formBody = new FormBody.Builder()
                    .add("Name", part.getName())
                    .add("Weight", String.valueOf(part.getWeight()))
                    .build();

            request = new Request.Builder()
                    .url(url)
                    .put(formBody)
                    .build();

            Response response = client.newCall(request).execute();
            System.out.println(response.body().string());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // POST api/Parts                Id:Integer, Name: String, Weight: decimal number, Car: car, Pallet: Pallet, Package: Package
    public void addPartToCar(String carVIN, Part part) {
        //TODO ostatne
        String url = SmallModels.BASE_URL + "Cars/" + carVIN + "/Parts";
        try {
            RequestBody formBody = new FormBody.Builder()
                    .add("Name", part.getName())
                    .add("Weight", String.valueOf(part.getWeight()))
                    .build();

            request = new Request.Builder()
                    .url(url)
                    .post(formBody)
                    .build();

            Response response = client.newCall(request).execute();
            System.out.println(response.body().string());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Get Parts for Car

    // Get Parts for Package

    // PUT Assign Part to Car

    // PUT Assign Part to Package

    // GET Parts for Pallet

    // PUT Part on Pallet

    // DELETE api/Parts/{id}
    public void deletePart(Part part) {
        super.deleteObject("Parts", part);
    }
}
