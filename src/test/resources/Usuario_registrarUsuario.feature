# language: en
# encoding: iso-8859-1
@onlythis
Feature: Registro de usuario
  Como usuario Quiero registrarme en la aplicación Para utilizar las herramientas que me ofrece.

  Scenario: Registro Satisfactorio
    Given que ingreso al API "http://localhost:8080" para registrarme
    And me ubico en la ruta "/api/usuario/registrarUsuario" para registrarme
    And mediante el metodo "POST" para registrarme
    And tengo los siguientes datos como usuario
      | nombre    | apellido  | direccion        | correo               | celular   | username  | password |
      | Sebastian | Contreras | Jr. Ayacucho 458 | sebastian@prueba.com | 999999999 | sebastian | 123456   |
    When envio la peticion para registrarme
    Then me registre como usuario

  Scenario: No se ingreso todos los datos solicitados
    Given que ingreso al API "http://localhost:8080" para registrarme
    And me ubico en la ruta "/api/usuario/registrarUsuario" para registrarme
    And mediante el metodo "POST" para registrarme
    And tengo los siguientes datos como usuario
      | nombre | apellido  | direccion        | correo               | celular | username  | password |
      |        | Contreras | Jr. Ayacucho 458 | sebastian@prueba.com |         | sebastian | 123456   |
    When envio la peticion para registrarme
    Then recibo un mensaje de error de registro "No se pudo registrar al usuario."