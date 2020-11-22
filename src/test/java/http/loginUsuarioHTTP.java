package http;

import com.google.gson.Gson;
import entities.Usuario;
import javafx.util.Pair;
import okhttp3.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class loginUsuarioHTTP {
    private String url;
    private String path;
    private String method;
    private List<String> usuarios;
    private List<Pair<Integer, String>> responseStatusCodesAndMessage;

    public loginUsuarioHTTP() {
        this.usuarios = new ArrayList<String>();
        this.responseStatusCodesAndMessage = new ArrayList<Pair<Integer, String>>();
    }

    public void setUrl(String url) {
        this.url = url;
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

    public List<Pair<Integer, String>> getResponseStatusCodesAndMessage() {
        return responseStatusCodesAndMessage;
    }

    private String buildUrl() {
        return this.url + this.path;
    }

    public void loginUsuario(Usuario usuario) {
        Gson gson = new Gson();
        usuario.equals(gson.toJson(usuarios, Usuario.class));
    }

    public void makeRequest() throws IOException {
        OkHttpClient client = new OkHttpClient().newBuilder().build();
        MediaType mediaType = MediaType.parse("application/json");

        for (int i = 0; i < this.usuarios.size(); ++i) {
            RequestBody body = RequestBody.create(this.usuarios.get(i), mediaType);

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

