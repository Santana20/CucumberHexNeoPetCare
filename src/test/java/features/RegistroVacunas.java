package features;

import http.registrarVacunaMascotaHTTP;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RegistroVacunas {
    private registrarVacunaMascotaHTTP registrarVacunaMascotaHTTP;

    @Given("que ingreso al API {string} para registrar vacuna a mascota")
    public void que_ingreso_al_API_para_registrar_vacuna_a_mascota(String string) {

    }

    @And("me ubico en la ruta {string} para registrar vacuna a mascota")
    public void meUbicoEnLaRutaParaRegistrarVacunaAMascota(String arg0) {
    }

    @And("teniendo como codigo de mi mascota {string} para registrar vacuna a mascota")
    public void teniendoComoCodigoDeMiMascotaParaRegistrarVacunaAMascota(String arg0) {
    }

    @And("mediante el metodo {string} para registrar vacuna a mascota")
    public void medianteElMetodoParaRegistrarVacunaAMascota(String arg0) {
    }

    @And("tengo la siguiente lista de vacunas para registrar")
    public void tengoLaSiguienteListaDeVacunasParaRegistrar() {
    }

    @When("envio la peticion para registrar vacuna a mascota")
    public void envioLaPeticionParaRegistrarVacunaAMascota() {
    }

    @Then("se insertaron las vacunas para mi mascota")
    public void seInsertaronLasVacunasParaMiMascota() {
    }

    @Then("recibo un mensaje de error por registrar vacuna a mascota {string}")
    public void reciboUnMensajeDeErrorPorRegistrarVacunaAMascota(String arg0) {
    }
}
