package http;

import com.google.gson.Gson;
import entities.Mascota;
import entities.RegistroCuidado;
import javafx.util.Pair;
import okhttp3.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class registrarRCuidadoHTTP {
    private String url;
    private String path;
    private String method;
    private String idMascota;
    private List<String> registrosCuidado;
    private List<Pair<Integer, String>> responseStatusCodesAndMessage;

    public registrarRCuidadoHTTP() {
        this.registrosCuidado = new ArrayList<String>();
        this.responseStatusCodesAndMessage = new ArrayList<Pair<Integer, String>>();
    }

    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }

    public String getPath() {
        return path;
    }
    public void setPath(String path) {
        this.path = path;
    }

    public String getMethod() {
        return method;
    }
    public void setMethod(String method) {
        this.method = method;
    }

    public String getIdMascota() {
        return idMascota;
    }
    public void setIdMascota(String idMascota) {
        this.idMascota = idMascota;
    }

    public List<Pair<Integer, String>> getResponseStatusCodesAndMessage() {
        return responseStatusCodesAndMessage;
    }

    private String buildUrl() {
        return this.url + this.path + this.idMascota;
    }

    public void registrarRCuidado(RegistroCuidado rCuidado) throws IOException {
        Gson gson = new Gson();
        this.registrosCuidado.add(gson.toJson(rCuidado, RegistroCuidado.class));
    }

    public void makeRequest() throws IOException {
        OkHttpClient client = new OkHttpClient().newBuilder().build();
        MediaType mediaType = MediaType.parse("application/json");

        System.out.println(this.registrosCuidado);
        for (int i = 0; i < this.registrosCuidado.size(); ++i) {
            RequestBody body = RequestBody.create(this.registrosCuidado.get(i), mediaType);

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
