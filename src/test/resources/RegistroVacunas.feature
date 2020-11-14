# language: en
# encoding: iso-8859-1
@onlythis1
Feature: Registro de Vacunas a mis mascotas
  como dueño de mascota quiero tener un registro de vacunas de mi mascota para estar al día con sus vacunas correspondientes.

  Scenario: Regsitro exitoso
    Given que ingreso al API "http://localhost:8080" para registrar vacuna a mascota
    And me ubico en la ruta "/api/vacunamascota/registrarVacunaMascota/" para registrar vacuna a mascota
    And teniendo como codigo de mi mascota "3" para registrar vacuna a mascota
    And mediante el metodo "POST" para registrar vacuna a mascota
    And tengo la siguiente lista de vacunas para registrar
      | fechaRegistro | idVacuna |
      | 2020-09-11  | 7        |
      | 2020-09-13  | 8        |
    When envio la peticion para registrar vacuna a mascota
    Then se insertaron las vacunas para mi mascota

  Scenario: Registro fallido sin fecha
    Given que ingreso al API "http://localhost:8080" para registrar vacuna a mascota
    And me ubico en la ruta "/api/vacunamascota/registrarVacunaMascota/" para registrar vacuna a mascota
    And teniendo como codigo de mi mascota "3" para registrar vacuna a mascota
    And mediante el metodo "POST" para registrar vacuna a mascota
    And tengo la siguiente lista de vacunas para registrar
      | fechaRegistro | idVacuna |
      |  | 7        |
    When envio la peticion para registrar vacuna a mascota
    Then recibo un mensaje de error por registrar vacuna a mascota "No se pudo registrar la vacuna de la mascota."