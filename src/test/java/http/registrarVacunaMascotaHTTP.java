package http;

import com.google.gson.Gson;
import entities.Mascota;
import entities.VacunaMascota;
import javafx.util.Pair;
import okhttp3.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class registrarVacunaMascotaHTTP {

    private String url;
    private String path;
    private String method;
    private String idMascota;
    private List<String> vacunaMascotas;
    private List<Pair<Integer, String>> responseStatusCodesAndMessage;

    public registrarVacunaMascotaHTTP() {
        this.vacunaMascotas = new ArrayList<String>();
        this.responseStatusCodesAndMessage = new ArrayList<Pair<Integer, String>>();
    }

    public String getMethod() {
        return method;
    }

    public List<Pair<Integer, String>> getResponseStatusCodesAndMessage() {
        return responseStatusCodesAndMessage;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public void setIdMascota(String idMascota) {
        this.idMascota = idMascota;
    }

    private String buildUrl() {
        return this.url + this.path + this.idMascota;
    }

    public void registrarVacunaMascota(VacunaMascota vacunaMascota) throws IOException {
        Gson gson = new Gson();
        this.vacunaMascotas.add(gson.toJson(vacunaMascota, VacunaMascota.class));
    }

    public void makeRequest() throws IOException {
        OkHttpClient client = new OkHttpClient().newBuilder().build();
        MediaType mediaType = MediaType.parse("application/json");

        System.out.println(this.vacunaMascotas);
        for (int i = 0; i < this.vacunaMascotas.size(); ++i) {
            RequestBody body = RequestBody.create(this.vacunaMascotas.get(i), mediaType);

            Request request = new Request.Builder()
                    .url(this.buildUrl())
                    .addHeader("Content-Type", "application/json")
                    .method(this.getMethod(), body)
                    .build();

            Response response = client.newCall(request).execute();
            this.responseStatusCodesAndMessage.add(new Pair<Integer, String>(response.code(), response.message()));
        }
    }
}
