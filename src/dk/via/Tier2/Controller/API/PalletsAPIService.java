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

public class PalletsAPIService extends APIService {

    // GET  api/Pallets
    public Pallet[] getAllPallets() {
        Pallet[] pallets = null;

        try {
            String url = SmallModels.BASE_URL + "Pallets";
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
            pallets = gson.fromJson(jsonData, Pallet[].class);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return pallets;
    }


    // GET api/Pallets/{id}
    public Pallet getPallet(int id) {
        Pallet pallet = null;
        try {
            String url = SmallModels.BASE_URL + "Pallets/" + id;
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
            pallet = gson.fromJson(jsonData, Pallet[].class)[0];
            System.out.println(pallet.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }

        return pallet;
    }

    // PUT api/Pallets/{id}
    public void updatePallet(Pallet pallet) {
        //TODO collection type
        String url = SmallModels.BASE_URL + "Pallets/" + pallet.getId();
        try {
            RequestBody formBody = new FormBody.Builder()
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

    // POST api/Pallets             id: Integer, Parts: Collection of Part
    public void addPallet(Pallet pallet) {
        String url = SmallModels.BASE_URL + "Pallets/";
        try {
            RequestBody formBody = new FormBody.Builder()
                    .add("Id", String.valueOf(pallet.getId()))
                    .add("MaximumCapacity", String.valueOf(pallet.getMaximumCapacity()))
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

    // DELETE api/Pallets/{id}
    public void deletePallet(Pallet pallet) {
        super.deleteObject("Pallets", pallet);
    }

    public Pallet getSuitablePalletForPart(Part part) {
        Pallet[] allPallets = getAllPallets();
        PartsAPIService partsAPI = new PartsAPIService();

        for (Pallet pallet : allPallets) {
            Part[] parts = partsAPI.getPartsForPallet(pallet.getId());
            try {
                pallet.setParts(parts);
            } catch (NullPointerException e) {
                e.printStackTrace();
            }
        }

        for (Pallet pallet : allPallets) {
            if (pallet.getParts() == null) {
                return pallet;
            }
            if (pallet.getParts().get(0).getName().equals(part.getName())) {
                if ((pallet.getMaximumCapacity() - pallet.currentCapacity()) >= part.getWeight()) {
                    return pallet;
                }
            }
        }

        Pallet newPallet = new Pallet(999, 1000);
        addPallet(newPallet);

        return newPallet;
    }
}
