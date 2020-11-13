package features;

import entities.Mascota;
import http.registrarMascotaHTTP;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import javafx.util.Pair;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Mascota_registrarMascota {
    private registrarMascotaHTTP registrarMascotaHTTP;

    @Before
    private void init() {
        this.registrarMascotaHTTP = new registrarMascotaHTTP();
    }

    @Given("que ingreso al API {string} para registrar mascota")
    public void queIngresoAlAPIParaRegistrarMascota(String string) {
        this.init();
        this.registrarMascotaHTTP.setUrl(string);
    }

    @And("me ubico en la ruta {string} para registrar mascota")
    public void meUbicoEnLaRutaParaRegistrarMascota(String string) {
        this.registrarMascotaHTTP.setPath(string);
    }

    @And("teniendo como codigo de usuario {string} para registrar mascota")
    public void teniendoComoCodigoDeUsuarioParaRegistrarMascota(String string) {
        this.registrarMascotaHTTP.setCodUsuario(string);
    }

    @And("mediante el metodo {string} para registrar mascota")
    public void medianteElMetodoParaRegistrarMascota(String string) {
        this.registrarMascotaHTTP.setMethod(string);
    }

    @And("tengo la siguiente lista de mascotas para registrar mascota")
    public void tengoLaSiguienteListaDeMascotasParaRegistrarMascota(DataTable dataTable) throws IOException {
        List<Map<String, String>> lista = dataTable.asMaps(String.class, String.class);

        for (int i = 0; i < lista.size(); ++i) {
            System.out.println(lista.get(i));
            Mascota mascota = new Mascota();
            mascota.setNombre(lista.get(i).get("nombre"));
            mascota.setEdad(Integer.parseInt(lista.get(i).get("edad").equals("") ? "0" : lista.get(i).get("edad")));
            mascota.setPeso(Double.parseDouble(lista.get(i).get("peso").equals("") ? "0.0" : lista.get(i).get("peso")));

            if (lista.get(i).get("idtipomascota") == null)
                mascota.setIdtipomascota(null);
            else mascota.setIdtipomascota(Long.parseLong(lista.get(i).get("idtipomascota")));

            System.out.println(mascota);
            this.registrarMascotaHTTP.registrarMascota(mascota);
        }
    }

    @When("envio la peticion para registrar mascota")
    public void envioLaPeticionParaRegistrarMascota() throws IOException {
        this.registrarMascotaHTTP.makeRequest();
    }

    @Then("se insertaron mis mascotas")
    public void se_insertaron_mis_mascotas() {
        List<Pair<Integer, String>> codes = this.registrarMascotaHTTP.getResponseStatusCodesAndMessage();

        for (int i = 0; i < codes.size(); ++i) {
            System.out.println(codes.get(i));
            assertTrue(codes.get(i).getKey() == 200);
        }
    }

    @Then("recibo un mensaje de error al registrar mascota {string}")
    public void reciboUnMensajeDeErrorAlRegistrarMascota(String arg0) {
        List<Pair<Integer, String>> codes = this.registrarMascotaHTTP.getResponseStatusCodesAndMessage();

        for (int i = 0; i < codes.size(); ++i) {
            System.out.println(codes.get(i));
            assertTrue(codes.get(i).getKey() == 400);
            //assertEquals(codes.get(i).getValue(), messageError);
        }
    }
}
