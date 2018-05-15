package dk.via.Tier2.Controller.API;

import com.google.gson.Gson;
import dk.via.Tier2.Model.Car;
import dk.via.Tier2.Model.SmallModels;
import okhttp3.FormBody;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import java.io.IOException;

public class CarsAPIService extends APIService {

    // GET  api/Cars
    public Car[] getAllCars() {
        Car[] cars = null;

        try {
            String url = SmallModels.BASE_URL + "Cars";

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
            cars = gson.fromJson(jsonData, Car[].class);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return cars;
    }

    // GET api/Cars/{id}
    public Car getCar(String VIN) {
        Car car = null;
        try {
            String url = SmallModels.BASE_URL + "Cars/" + VIN;
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
            car = gson.fromJson(jsonData, Car.class);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return car;
    }

    // PUT api/Cars/{id}
    public void updateCar(Car car) {
        String url = SmallModels.BASE_URL + "Cars/" + car.getVIN();
        try {
            RequestBody formBody = new FormBody.Builder()
                    .add("VIN", car.getVIN())
                    .add("Model", car.getModel())
                    .add("Weight", String.valueOf(car.getWeight()))
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

    // POST api/Cars                VIN:string, Model:string, Weight: decimal number, Parts:Collection of Part
    public void addCar(Car car) {
        String url = SmallModels.BASE_URL + "Cars/";
        try {
            RequestBody formBody = new FormBody.Builder()
                    .add("VIN", car.getVIN())
                    .add("Model", car.getModel())
                    .add("Weight", String.valueOf(car.getWeight()))
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

    // DELETE api/Cars/{id}
    public void deleteCar(Car car) {
        String url = SmallModels.BASE_URL + "Cars/" + car.getVIN();
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
