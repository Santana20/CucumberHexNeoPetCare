package http;

import com.google.gson.Gson;
import entities.RegistroCuidado;
import javafx.util.Pair;
import okhttp3.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class actualizarRCuidadoHTTP {
    private String url;
    private String path;
    private String method;
    private String idRegistroCuidado;
    private List<String> registrosCuidado;
    private List<Pair<Integer, String>> responseStatusCodesAndMessage;

    public actualizarRCuidadoHTTP() {
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

    public String getIdRegistroCuidado() {
        return idRegistroCuidado;
    }
    public void setIdRegistroCuidado(String idRegistroCuidado) {
        this.idRegistroCuidado = idRegistroCuidado;
    }

    public List<Pair<Integer, String>> getResponseStatusCodesAndMessage() {
        return responseStatusCodesAndMessage;
    }

    private String buildUrl() {
        return this.url + this.path + this.idRegistroCuidado;
    }

    public void actualizarRCuidado(RegistroCuidado rCuidado) throws IOException {
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
