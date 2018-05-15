package dk.via.Tier2.Controller.API;

import com.google.gson.Gson;
import dk.via.Tier2.Model.Package;
import dk.via.Tier2.Model.SmallModels;
import okhttp3.FormBody;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import java.io.IOException;

public class PackagesAPIService extends APIService {

    // GET  api/Packages
    public Package[] getAllPackages() {
        Package[] packages = null;

        try {
            String url = SmallModels.BASE_URL + "Packages";
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

            packages = gson.fromJson(jsonData, Package[].class);

            for (Package pack : packages) {
                System.out.println(pack.toString());

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return packages;
    }


    // GET api/Packages/{id}
    public Package getPackage(int id) {
        Package pack = null;
        try {
            String url = SmallModels.BASE_URL + "Packages/" + id;
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
            pack = gson.fromJson(jsonData, Package.class);
            pack.toString();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return pack;
    }

    // PUT api/Packages/{id}
    public void updatePackage(Package pack) {
        //TODO treba spravit parts
        String url = SmallModels.BASE_URL + "Packages/" + pack.getId();
        try {
            RequestBody formBody = new FormBody.Builder()
                    .add("Repacking", String.valueOf(pack.getRepacking()))
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

    // POST api/Packages               Id:Integer, Repacking:Bool, Parts: Collection of Part
    public void addPackage(Package pack) {
        //TODO treba dorobit parts a id
        String url = SmallModels.BASE_URL + "Packages/";
        try {
            RequestBody formBody = new FormBody.Builder()
                    .add("Repacking", String.valueOf(pack.getRepacking()))
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


    // make model Package mala by brat number of parts and string of model
    public void makeModelPackage(int numberOfParts, String model) {

    }

    // make system package mala by brat number of parts and mode
    public void makeSystemPackage(int numberOfParts, String partType) {

    }

    // DELETE api/Packages/{id}
    public void deletePackage(Package pack) {
        super.deleteObject("Packages", pack);
    }

}
