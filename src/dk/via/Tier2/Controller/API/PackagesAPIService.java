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


    // make model Package mala by brat number of parts and string of model a urobit package z volnych partov dan0ho typu
    public void makeModelPackage(int numberOfParts, String model) {
        //     Part[] parts = getAllFreeParts();


//        for (Part part: parts) {
//            transferPartFromPalletToPackage(part, );
//        }

/*
        ArrayList<Part> allLegitObjects = getAllLegitObjectsFromPalletes(whatType);
        if (allLegitObjects != null) {
            if (!(allLegitObjects.size() < noOfObjects)) {
                for (int i = 0; i < noOfObjects; i++) {
                    transferPartFromPaletToPackage(allLegitObjects.get(i), aPackage, allLegitObjects.get(i).getPallet());
                }
            } else throw new NoPermissionException("There are not enough parts in the warehouse to form this package");
        }

        */


    }

    // make system package mala by brat number of parts and mode
    public void makeSystemPackage(int numberOfParts, String partType) {

    }

    // DELETE api/Packages/{id}
    public void deletePackage(Package pack) {
        super.deleteObject("Packages", pack);
    }

    private void transferPartFromPalletToPackage(Part part, Package pack) {
        part.setPalletId(0);
        part.setPalletId(pack.getId());


        //TODO upload this to server
    }

//    private Part[] getAllFreeParts(boolean modelParts, String value) {
//        List<Part> freeParts = new ArrayList<Part>();
//        Part[] allParts = new PartsAPIService().getAllParts();
//
//        for (Part part : allParts) {
//            if (part.getPackageId() == 0 || part.getPreviousPalletId() == 0) {
//                if () {
//                    if (part.getName())
//                }
//                freeParts.add(part);
//            }
//        }
//
//
//        return (Part[]) freeParts.toArray();
//
//    }

}
