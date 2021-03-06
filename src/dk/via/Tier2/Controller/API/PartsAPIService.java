package dk.via.Tier2.Controller.API;

import com.google.gson.Gson;
import dk.via.Tier2.Model.Pallet;
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
        String url = SmallModels.BASE_URL + "Cars/" + part.getCarId() + "/Parts/" + part.getId();
        try {

            RequestBody formBody = new FormBody.Builder()
                    .add("Id", String.valueOf(part.getId()))
                    .add("Name", part.getName())
                    .add("Weight", String.valueOf(part.getWeight()))
                    .add("CarId", part.getCarId())
                    .add("PalletId", String.valueOf(part.getPalletId()))
                    .add("PreviusPalletId", String.valueOf(part.getPreviousPalletId()))
                    .add("PackageId", String.valueOf(part.getPackageId()))
                    .build();

            request = new Request.Builder()
                    .url(url)
                    .put(formBody)
                    .build();

            Response response = client.newCall(request).execute();
            System.out.println("Add part code:" + response.code());
            System.out.println(response.body().string());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // POST api/Parts
    public void addPart(Part part) {
        //TODO ostatne
        System.out.println("Zavolala sa funkcia app part s paramtetrami: " + part.toString());
        String url = SmallModels.BASE_URL + "Cars/" + part.getCarId() + "/Parts";
        Pallet suitablePallet = new PalletsAPIService().getSuitablePalletForPart(part);

        try {
            RequestBody formBody = new FormBody.Builder()
                    .add("Name", part.getName())
                    .add("Weight", String.valueOf(part.getWeight()))
                    .add("PalletId", String.valueOf(suitablePallet.getId()))
                    .add("CarId", part.getCarId())
                    .build();

            request = new Request.Builder()
                    .url(url)
                    .post(formBody)
                    .build();

            Response response = client.newCall(request).execute();
            System.out.println("executlo sa " + response.body().string());
            System.out.println("HTTP code: " + response.code());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Get Parts for Car api/Cars/{id}/Parts
    public Part[] getPartsForCar(String VIN) {
        Part[] parts = null;

        try {
            String url = SmallModels.BASE_URL + "Cars/" + VIN + "/Parts";
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
        } catch (IOException e) {
            e.printStackTrace();
        }

        return parts;
    }

    // Get Parts for Package
    public Part[] getPartsForPackage(int packageId) {
        Part[] parts = null;

        try {
            String url = SmallModels.BASE_URL + "Packages/" + packageId + "/Parts";
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

        } catch (IOException e) {
            e.printStackTrace();
        }
        return parts;
    }

    // PUT Assign Part to Car  api/Cars/{id}/Parts/{partId}
    public void assignPartToCar(String VIN, Part part) {
        //TODO
        String url = SmallModels.BASE_URL + "Cars/" + VIN + "/Parts/" + part.getId();
        request = new Request.Builder().url(url).build();
        Response response = null;
        try {
            response = client.newCall(request).execute();
            System.out.println(response.body().string());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    // PUT Assign Part to Package api/Packages/{id}/Parts
    public void assignPartsToPackage(Part[] parts, int packageId) {
        //TODO not implemented
    }

    // GET Parts for Pallet  api/Pallete/{id}/Parts
    public Part[] getPartsForPallet(int palletId) {
        Part[] parts = null;

        try {
            String url = SmallModels.BASE_URL + "Pallete/" + palletId + "/Parts";

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

    // PUT Part on Pallet api/Pallete/{id}/Parts
    public void putPartsOnPallet(Part[] parts, int palletId) {
        //TODO not implemented
    }

    // DELETE api/Parts/{id}
    public void deletePart(Part part) {
        super.deleteObject("Parts", part);
    }
}
