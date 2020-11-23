package features;

import entities.Usuario;
import http.loginUsuarioHTTP;
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

public class Usuario_login {
    private loginUsuarioHTTP loginUsuarioHTTP;
    private void init() { this.loginUsuarioHTTP = new loginUsuarioHTTP(); }

    @Given("que ingreso al API {string} para loguearme")
    public void queIngresoAlAPIParaLoguearme(String arg0) {
        this.init();
        this.loginUsuarioHTTP.setUrl(arg0);
    }

    @And("me ubico en la ruta {string} para loguearme")
    public void meUbicoEnLaRutaParaLoguearme(String arg0) {
        this.loginUsuarioHTTP.setPath(arg0);
    }

    @And("mediante el metodo {string} para loguearme")
    public void medianteElMetodoParaLoguearme(String arg0) {
        this.loginUsuarioHTTP.setMethod(arg0);
    }

    @And("tengo los siguientes datos como usuario")
    public void tengoLosSiguientesDatosComoUsuario(DataTable dataTable) throws IOException {
        List<Map<String, String>> lista = dataTable.asMaps(String.class, String.class);

        for (int i = 0; i < lista.size(); ++i) {
            Usuario usuario = new Usuario();

            lista.get(i).get("correo");
            lista.get(i).get("password");

            this.loginUsuarioHTTP.loginUsuario(usuario);
        }
    }

    @When("envio la peticion para loguearme")
    public void envioLaPeticionParaLoguearme() throws IOException {
        this.loginUsuarioHTTP.makeRequest();
    }

    @Then("accedi a mi cuenta como usuario")
    public void loginComoUsuario() {
        List<Pair<Integer, String>> codes = this.loginUsuarioHTTP.getResponseStatusCodesAndMessage();

        for (int i = 0; i < codes.size(); ++i) {
            System.out.println(codes.get(i));
            assertTrue(codes.get(i).getKey() == 200);
        }
    }

    @Then("recibo un mensaje de error de login {string}")
    public void reciboUnMensajeDeErrorDeLogin(String arg0) {
        List<Pair<Integer, String>> codes = this.loginUsuarioHTTP.getResponseStatusCodesAndMessage();

        for (int i = 0; i < codes.size(); ++i) {
            System.out.println(codes.get(i));
            assertTrue(codes.get(i).getKey() == 400);
            //assertEquals(codes.get(i).getValue(), messageError);
        }
    }


}
