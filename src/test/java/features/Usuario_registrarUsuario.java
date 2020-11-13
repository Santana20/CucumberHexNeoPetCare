package features;

import entities.Usuario;
import http.registrarUsuarioHTTP;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import javafx.util.Pair;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertTrue;

public class Usuario_registrarUsuario {

    private registrarUsuarioHTTP registrarUsuarioHTTP;

    private void init() {
        this.registrarUsuarioHTTP = new registrarUsuarioHTTP();
    }

    @Given("que ingreso al API {string} para registrarme")
    public void queIngresoAlAPIParaRegistrarme(String arg0) {
        this.init();
        this.registrarUsuarioHTTP.setUrl(arg0);
    }

    @And("me ubico en la ruta {string} para registrarme")
    public void meUbicoEnLaRutaParaRegistrarme(String arg0) {
        this.registrarUsuarioHTTP.setPath(arg0);
    }

    @And("mediante el metodo {string} para registrarme")
    public void medianteElMetodoParaRegistrarme(String arg0) {
        this.registrarUsuarioHTTP.setMethod(arg0);
    }

    @And("tengo los siguientes datos como usuario")
    public void tengoLosSiguientesDatosComoUsuario(DataTable dataTable) throws IOException {
        List<Map<String, String>> lista = dataTable.asMaps(String.class, String.class);

        for (int i = 0; i < lista.size(); ++i) {
            Usuario usuario = new Usuario();

            usuario.setNombre(lista.get(i).get("nombre"));
            usuario.setApellido(lista.get(i).get("apellido"));
            usuario.setDireccion(lista.get(i).get("direccion"));
            usuario.setCorreo(lista.get(i).get("correo"));
            usuario.setCelular(lista.get(i).get("celular"));
            usuario.setUsername(lista.get(i).get("username"));
            usuario.setPassword(lista.get(i).get("password"));

            this.registrarUsuarioHTTP.registrarUsuario(usuario);
        }
    }

    @When("envio la peticion para registrarme")
    public void envioLaPeticionParaRegistrarme() throws IOException {
        this.registrarUsuarioHTTP.makeRequest();
    }

    @Then("me registre como usuario")
    public void meRegistreComoUsuario() {
        List<Pair<Integer, String>> codes = this.registrarUsuarioHTTP.getResponseStatusCodesAndMessage();

        for (int i = 0; i < codes.size(); ++i) {
            System.out.println(codes.get(i));
            assertTrue(codes.get(i).getKey() == 200);
        }
    }

    @Then("recibo un mensaje de error de registro {string}")
    public void reciboUnMensajeDeErrorDeRegistro(String arg0) {
        List<Pair<Integer, String>> codes = this.registrarUsuarioHTTP.getResponseStatusCodesAndMessage();

        for (int i = 0; i < codes.size(); ++i) {
            System.out.println(codes.get(i));
            assertTrue(codes.get(i).getKey() == 400);
            //assertEquals(codes.get(i).getValue(), messageError);
        }
    }
}
