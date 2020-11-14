package features;

import entities.VacunaMascota;
import http.registrarVacunaMascotaHTTP;
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

import static org.junit.Assert.assertTrue;

public class RegistroVacunas {
    private registrarVacunaMascotaHTTP registrarVacunaMascotaHTTP;

    @Before
    private void init() { this.registrarVacunaMascotaHTTP = new registrarVacunaMascotaHTTP(); }

    @Given("que ingreso al API {string} para registrar vacuna a mascota")
    public void que_ingreso_al_API_para_registrar_vacuna_a_mascota(String string) {
        this.init();
        this.registrarVacunaMascotaHTTP.setUrl(string);
    }

    @And("me ubico en la ruta {string} para registrar vacuna a mascota")
    public void meUbicoEnLaRutaParaRegistrarVacunaAMascota(String arg0) {
        this.registrarVacunaMascotaHTTP.setPath(arg0);
    }

    @And("teniendo como codigo de mi mascota {string} para registrar vacuna a mascota")
    public void teniendoComoCodigoDeMiMascotaParaRegistrarVacunaAMascota(String arg0) {
        this.registrarVacunaMascotaHTTP.setIdMascota(arg0);
    }

    @And("mediante el metodo {string} para registrar vacuna a mascota")
    public void medianteElMetodoParaRegistrarVacunaAMascota(String arg0) {
        this.registrarVacunaMascotaHTTP.setMethod(arg0);
    }

    @And("tengo la siguiente lista de vacunas para registrar")
    public void tengoLaSiguienteListaDeVacunasParaRegistrar(DataTable dataTable) throws IOException {
        List<Map<String, String>> lista = dataTable.asMaps(String.class, String.class);
        for (int i = 0; i < lista.size(); ++i) {
            VacunaMascota vacunaMascota = new VacunaMascota();
            vacunaMascota.setFechaRegistro(lista.get(i).get("fechaRegistro"));

            vacunaMascota.setIdVacuna(
                    (lista.get(i).get("idVacuna") == null) ? null : Long.parseLong(lista.get(i).get("idVacuna"))
            );
            this.registrarVacunaMascotaHTTP.registrarVacunaMascota(vacunaMascota);
        }
    }

    @When("envio la peticion para registrar vacuna a mascota")
    public void envioLaPeticionParaRegistrarVacunaAMascota() throws IOException {
        this.registrarVacunaMascotaHTTP.makeRequest();
    }

    @Then("se insertaron las vacunas para mi mascota")
    public void seInsertaronLasVacunasParaMiMascota() {
        List<Pair<Integer, String>> codes = this.registrarVacunaMascotaHTTP.getResponseStatusCodesAndMessage();

        for (int i = 0; i < codes.size(); ++i) {
            System.out.println(codes.get(i));
            assertTrue(codes.get(i).getKey() == 200);
        }
    }

    @Then("recibo un mensaje de error por registrar vacuna a mascota {string}")
    public void reciboUnMensajeDeErrorPorRegistrarVacunaAMascota(String arg0) {
        List<Pair<Integer, String>> codes = this.registrarVacunaMascotaHTTP.getResponseStatusCodesAndMessage();

        for (int i = 0; i < codes.size(); ++i) {
            System.out.println(codes.get(i));
            assertTrue(codes.get(i).getKey() == 400);
        }
    }
}
