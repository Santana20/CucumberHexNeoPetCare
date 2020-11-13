# language: en
# encoding: iso-8859-1

Feature: Editar agenda
  Como dueño de mascota registrado Quiero actualizar el estado de los registros de cuidado de mi mascota Para tener saber qué cuidados ya he realizado.

  Scenario: EL usuario quiere actualizar un registro de cuidado de su mascota
    Given que ingreso al API "http://localhost:8080" para registrar
    And me ubico en la ruta "/api/registroCuidado/actualizar/" para registrar
    And teniendo como codigo de registro "1" para registrar
    And mediante el metodo "PUT" para registrar
    When envio la peticion para registrar
    Then actualice el estado del registro de un cuidado