# language: en
# encoding: iso-8859-1
@onlythis
Feature: Login de usuario
  Como usuario Quiero loguearme en la aplicación Para utilizar las herramientas que me ofrece.

  Scenario: Login Satisfactorio
    Given que ingreso al API "http://localhost:8080" para registrarme
    And me ubico en la ruta "/api/usuario/login" para loguearme
    And mediante el metodo "POST" para loguearme
    And tengo los siguientes datos
      | correo               | password |
      | sebastian@prueba.com | 123456   |
    When envio la peticion para loguearme
    Then hice login como usuario

  Scenario: No se ingresaron los datos correctos
    Given que ingreso al API "http://localhost:8080" para loguearme
    And me ubico en la ruta "/api/usuario/login" para loguearme
    And mediante el metodo "POST" para loguearme
    And tengo los siguientes datos como usuario
      | correo               | password |
      | sebastian@prueba.com |  222222  |
    When envio la peticion para loguearme
    Then recibo un mensaje de error de login "No se pudo iniciar sesión, ingrese datos correctos."