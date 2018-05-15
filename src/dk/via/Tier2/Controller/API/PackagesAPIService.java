package dk.via.Tier2.Controller.API;

import com.google.gson.Gson;
import dk.via.Tier2.Model.Package;
import dk.via.Tier2.Model.Part;
import dk.via.Tier2.Model.SmallModels;
import okhttp3.FormBody;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        String url = SmallModels.BASE_URL + "Packages";
        try {
            RequestBody formBody = new FormBody.Builder()
                    .add("Repacking", String.valueOf(pack.getRepacking()))
                    .add("Content", "TODO")
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


    // make model Package mala by brat number of parts and string of model a urobit package z volnych partov dan0ho typu
    public void makeModelPackage(int numberOfParts, String model) {
        PartsAPIService partsAPI = new PartsAPIService();

        List<Part> allParts = new ArrayList<>();
        allParts.addAll(Arrays.asList(partsAPI.getAllParts()));
        List<Part> suitableParts = new ArrayList<>();

        for (Part part : allParts) {
            if (part.getName().equals(model)) {
                if (part.getPackageId() == 0 || part.getPreviousPalletId() == 0) {
                    suitableParts.add(part);
                }
            }

        }

        if (numberOfParts <= suitableParts.size()) {
            Package pack = new Package(999, true);
            addPackage(pack);
            for (int i = 0; i < numberOfParts; i++) {
                transferPartFromPalletToPackage(suitableParts.get(i), pack);
            }
        } else {
            System.out.println("Not enough parts for packaging");
        }
    }

    // make system package mala by brat number of parts and mode
    public void makeSystemPackage(int numberOfParts, String partType) {
        PartsAPIService partsAPI = new PartsAPIService();

        List<Part> allParts = new ArrayList<>();
        allParts.addAll(Arrays.asList(partsAPI.getAllParts()));
        List<Part> suitableParts = new ArrayList<>();

        for (Part part : allParts) {
            if (part.getName().equals(partType)) {
                if (part.getPackageId() == 0 || part.getPreviousPalletId() == 0) {
                    suitableParts.add(part);
                }
            }
        }

        if (numberOfParts <= suitableParts.size()) {
            Package pack = new Package(999, false);
            addPackage(pack);
            for (int i = 0; i < numberOfParts; i++) {
                transferPartFromPalletToPackage(suitableParts.get(i), pack);
            }
        } else {
            System.out.println("Not enough parts for packaging");
        }

    }

    // DELETE api/Packages/{id}
    public void deletePackage(Package pack) {
        super.deleteObject("Packages", pack);
    }

    private void transferPartFromPalletToPackage(Part part, Package pack) {
        part.setPreviousPalletId(part.getPalletId());
        part.setPalletId(0);
        part.setPackageId(pack.getId());

        PartsAPIService partsAPI = new PartsAPIService();
        partsAPI.updatePart(part);

    }

}
