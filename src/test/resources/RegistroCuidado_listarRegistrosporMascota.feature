# language: en
# encoding: iso-8859-1

Feature: Listar todos los cuidados de mi mascota
  Como usuario quiero listar todos los cuidados de mi mascota para observar estar informado de cuándo le toca un cuidado.

  Scenario: El usuario lista todos los cuidados de su mascota
    Given que ingreso al API "http://localhost:8080"
    And me ubico en la ruta "/api/registroCuidado/mostrarListaMascota/"
    And teniendo como codigo de mascota "1"
    And mediante el metodo "GET"
    When envio mi peticion
    Then obtuve la lista de todos los cuidados de mi mascota