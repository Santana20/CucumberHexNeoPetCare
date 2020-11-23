package features;

import entities.RegistroCuidado;
import http.registrarRCuidadoHTTP;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import javafx.util.Pair;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import static org.junit.Assert.assertTrue;

public class RegistroCuidado_actualizarRegistro {

    public class RegistroCuidado_registrarCuidado
    {
        private http.registrarRCuidadoHTTP registrarRCuidadoHTTP;

        public Date toDate(String date) throws ParseException {
            DateFormat format = new SimpleDateFormat("yyyy.MM.dd", Locale.ENGLISH);
            Date ndate = format.parse(date);
            return ndate;
        }
        @Before
        private void init() { this.registrarRCuidadoHTTP = new registrarRCuidadoHTTP();}

        //Scenario: El usuario registra un cuidado para su mascota
        @Given("que ingreso al API {string} para actualizar")
        public void que_ingreso_al_API_para_actualizar(String string)
        {
            this.init();
        }

        @Given("me ubico en la ruta {string} para registrar")
        public void me_ubico_en_la_ruta_para_registrar(String  string)
        {
            this.registrarRCuidadoHTTP.setPath(string);
        }

        @Given("teniendo como codigo de mascota {string} para registrar")
        public void teniendo_como_codigo_de_mascota_para_registrar(String string)
        {
            this.registrarRCuidadoHTTP.setIdMascota(string);
        }

        @Given("mediante el metodo {string} para registrar")
        public void mediante_el_metodo_para_registrar(String string) {
            this.registrarRCuidadoHTTP.setMethod(string);
        }

        @Given("tengo la siguiente lista de registros de cuidados para registrar")
        public void tengo_la_siguiente_lista_de_registrosC_para_registrar(DataTable dataTable) throws IOException, ParseException {
            List<Map<String, String>> lista = dataTable.asMaps(String.class, String.class);

            for (int i = 0; i < lista.size(); ++i)
            {
                Date fechaReg = toDate(lista.get(i).get("FechadeRegistro"));
                Date fechaRea = toDate(lista.get(i).get("FechadeRealizacion"));
                System.out.println(lista.get(i));
                RegistroCuidado registroCuidado = new RegistroCuidado();
                registroCuidado.setFechaRegistro(fechaReg);
                registroCuidado.setFechaRealizado(fechaRea);
                registroCuidado.setStatus(Boolean.parseBoolean(lista.get(i).get("Estado")));

                if (lista.get(i).get("idCuidado") == null)
                    registroCuidado.setIdCuidado(null);
                else registroCuidado.setIdCuidado(Long.parseLong(lista.get(i).get("idCuidado")));

                System.out.println(registroCuidado);
                this.registrarRCuidadoHTTP.registrarRCuidado(registroCuidado);
            }
        }

        @When("envio la peticion para registrar")
        public void envio_la_peticion_para_registrar() throws IOException
        {
            this.registrarRCuidadoHTTP.makeRequest();
        }

        @Then("se insertaron mis registros")
        public void se_insertaron_mis_registros()
        {
            List<Pair<Integer, String>> codes = this.registrarRCuidadoHTTP.getResponseStatusCodesAndMessage();

            for (int i = 0; i < codes.size(); ++i)
            {
                System.out.println(codes.get(i));
                assertTrue(codes.get(i).getKey() == 200);
            }
        }

        @Then("recibo un mensaje de error {string}")
        public void reciboUnMensajeDeError(String messageError)
        {
            List<Pair<Integer, String>> codes = this.registrarRCuidadoHTTP.getResponseStatusCodesAndMessage();

            for (int i = 0; i < codes.size(); ++i)
            {
                System.out.println(codes.get(i));
                assertTrue(codes.get(i).getKey() == 400);
                //assertEquals(codes.get(i).getValue(), messageError);
            }
        }


    }
}
